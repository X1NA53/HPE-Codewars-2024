#!/usr/bin/env python3
# (C) Copyright 2021-2024 Hewlett Packard Enterprise Development LP

"""CodeWars - Check Problem Script

Notes:
    * REQUIRES python3 to run
    * If Java, Python3, and/or GCC/G++ are not on your system PATH, then
      you must set the full paths below
    * Data sets are expected to be in a local subdirectory called `student_datasets`
    * Works with .java, .py, .c, .cpp programs
"""

__version__ = "2024.02.13.1"
__author__ = "Sebastian Schagerer"

import argparse
import glob
import os
import re
import subprocess

# Assume that java/javac, gcc/g++, and python are all available on the system PATH
# IF any of these are not available on the system PATH, then you must set the full path
JDK_PATH = r""
PY3_PATH = r""
GCC_PATH = r""
GPP_PATH = r""

# **DO NOT** edit these constants
STUDENT_DIR = "student_datasets"
INPUT_TEXT_FILE_NAME = "input.txt"
TERMINAL_WIDTH = 80
COMMON_HEADER_PREFIX = "Problem #{} - data set {}"
PROBLEM_OUTPUT_HEADER_TEMPLATE = COMMON_HEADER_PREFIX + " - Program output begins"
DATASET_HEADER_TEMPLATE = COMMON_HEADER_PREFIX + " - INPUT DATA"
EXPECTED_HEADER = "Compare to EXPECTED output below"


def get_wide_message(message, fill_char):
    """
    Get a message aligned to the terminal width using a fill char on the left and right
    Left padding is 4

    :param message: Message
    :param fill_char: Character to use as filler
    :return: Wide message string
    """
    left_padding = 4
    spaces = 2
    # Calculate the right padding based on the message length
    right_padding = TERMINAL_WIDTH - left_padding - len(message) - spaces

    # For long messages do not print any trailing filler
    if right_padding < 0:
        right_padding = 0

    return "{} {} {}".format(fill_char * left_padding, message, fill_char * right_padding)


def get_header(message, header_char='-', bar_char='-'):
    """
    Get a message with a nice header box using dashes and a blank line (unless newline is False)

    :param message: The message to display
    :param header_char: Character to use in the header
    :param bar_char: Character to use in the bar
    :return: Header message
    """
    bar = bar_char * TERMINAL_WIDTH
    return "{}\n{}\n{}\n".format(bar, get_wide_message(message, header_char), bar)


def display_error(message):
    """
    Display an error message

    :param message: Error message
    :return:
    """
    print(f"!! ERROR: {message}")


def verify_paths():
    """
    Verify that any provided paths for Java, Python, and GCC/GPP are valid
    An empty path is valid and implies that the path will not be used.

    :return: True if all paths are valid, false otherwise
    """
    valid = True

    # JDK path must be a directory (bin) so we can use javac and java
    if JDK_PATH and (not os.path.isdir(JDK_PATH) or os.path.basename(JDK_PATH) != "bin"):
        display_error(f"JDK_PATH was set to `{JDK_PATH}` which is NOT the 'bin' directory of the JDK.")
        valid = False

    for compiler, compiler_path in [("gcc", GCC_PATH), ("gpp", GPP_PATH), ("python", PY3_PATH)]:
        if compiler_path and not os.path.isfile(compiler_path):
            display_error(
                f"{compiler.upper()}_PATH was set to {compiler_path} which is NOT a file ({compiler} executable)"
            )
            valid = False

    if not os.path.isdir(STUDENT_DIR):
        display_error(f"{STUDENT_DIR} is missing! Where are the data sets?")
        valid = False

    return valid


def check(program_file_path, show_input):
    """
    Check a problem

    :param program_file_path: Filename for the program to be checked
    :param show_input: Show the input data file
    :return:
    """
    problem_number, file_type = determine_problem_number(program_file_path)

    if problem_number:
        print(get_header("Checking Problem {} ".format(problem_number), header_char='*', bar_char='='))

        run_command = pre_process_source(problem_number, file_type, program_file_path)
        if not run_command or len(run_command) == 0:
            display_error("Failed to pre-process source file!")
            return

        check_problem(problem_number, run_command, show_input)

        print(get_header("Checking COMPLETE", header_char='*', bar_char='='))
    else:
        display_error(f"Skipping {program_file_path} because it is not a valid program file.")


def determine_problem_number(program_file_path):
    """
    Check the local directory for a file matching probXY and return the problem number

    :param program_file_path: File name path for the program
    :return: problem number, suffix
    """
    problem_number = None
    file_type = None

    # Our pattern works on the base name of the file
    file_name = os.path.basename(program_file_path)
    pattern = r"prob(\d{2}).(java|py|c|cpp)$"

    match = re.match(pattern, file_name)
    if match:
        problem_number, file_type = match.group(1, 2)

    return problem_number, file_type


def pre_process_source(problem_number, file_type, filename):
    """
    Perform any necessary pre-process steps for this source file

    :param problem_number: Problem number
    :param file_type: Type of file
    :param filename: Filename path
    :return:
    """
    run_command = None

    if file_type == "java":
        javac_path = os.path.join(JDK_PATH, "javac") if JDK_PATH else "javac"
        if compile_from_source([javac_path, filename], problem_number, filename, file_type):
            java_command = os.path.join(JDK_PATH, "java") if JDK_PATH else "java"
            # Set the run command if the compile was a success
            run_command = [java_command, "-cp", ".", "prob{}".format(problem_number)]

    elif file_type == "py":
        python_path = PY3_PATH if PY3_PATH else "python"
        run_command = [python_path, filename]

    elif file_type in ["c", "cpp"]:
        # Select the correct compiler
        if file_type == "c":
            compiler_path = GCC_PATH if GCC_PATH else "gcc"
        else:
            compiler_path = GPP_PATH if GPP_PATH else "g++"

        problem_exe_name = f"prob{problem_number}.exe"
        compile_command = [compiler_path, "-o", problem_exe_name, filename, "-lm"]

        if compile_from_source(compile_command, problem_number, filename, file_type):
            # Set the run command if the compile was a success
            run_command = problem_exe_name

    return run_command


def compile_from_source(compile_command, problem_number, filename, file_type):
    """
    Compile the from source

    :param compile_command: Command used to compile the source file
    :param problem_number: Problem number
    :param filename: Filename path
    :param file_type: File type used for the message
    :return: True if the pre-processing succeeded
    """
    print(f"Compile {file_type} source file... ")
    result = subprocess.run(compile_command)

    if result.returncode != 0:
        display_error(f"The {file_type} source file {filename} did not compile for problem {problem_number}")
        return False

    print("Done")
    return True


def check_problem(problem_number, run_command, show_input_file):
    """
    Check the given problem against all data sets

    :param problem_number: Problem number
    :param run_command: Command to run the program
    :param show_input_file: Show the input data file
    :return:
    """
    # File name pattern
    file_pattern = r"prob{}-{}-{}.txt"

    # Track if we find any dataset files
    found_dataset = False

    for input_file in sorted(os.listdir(STUDENT_DIR)):
        # Pass the (\d) regex group pattern for the data set number
        match = re.match(file_pattern.format(problem_number, r"(\d)", "in"), input_file)
        if not match:
            continue

        found_dataset = True
        dataset_number = match.group(1)

        # Get the current data set file contents
        dataset_input_file = os.path.join(STUDENT_DIR, file_pattern.format(problem_number, dataset_number, "in"))
        with open(dataset_input_file, "r") as f:
            lines = f.readlines()

        if show_input_file:
            # Show the dataset input file
            print(get_header(DATASET_HEADER_TEMPLATE.format(problem_number, dataset_number)))
            print("".join(lines))

        # Write the current dataset to input.txt
        with open(INPUT_TEXT_FILE_NAME, "w") as out:
            out.writelines("".join(lines))

        print(get_header(PROBLEM_OUTPUT_HEADER_TEMPLATE.format(problem_number, dataset_number)))

        with open(INPUT_TEXT_FILE_NAME, 'r') as in_file:
            result = subprocess.run(run_command, stdin=in_file)

        if result and result.returncode != 0:
            display_error("Unable to run program, return code was: {}".format(result.returncode))

        print(get_header(EXPECTED_HEADER.format(problem_number, dataset_number)))
        # Show the expected dataset output file
        dataset_output_file = os.path.join(STUDENT_DIR, file_pattern.format(problem_number, dataset_number, "out"))
        with open(dataset_output_file, "r") as f:
            lines = f.readlines()
        print("".join(lines))

        # Prompt for next dataset
        prompt_text = "{} {} {}".format(
            '-' * 10,
            "Press ENTER to continue check next data set",
            '-' * 10
        )
        print()
        input(prompt_text)

    if not found_dataset:
        display_error("No dataset file found for problem {} !".format(problem_number))


def parse_arguments():
    """
    Define and parse the arguments to the script

    :return: args parsed by the argument parser
    """
    parser = argparse.ArgumentParser(
        description="Use this script to check your program! "
                    "The problem number is automatically determined from your program filename. "
                    "For more information see the README.txt file."
    )
    parser.add_argument(
        "-i", "--show-input",
        help="Show the input file before running your program",
        action="store_true",
        dest="show_input"
    )
    parser.add_argument(
        "--version",
        help="Program version",
        action="version",
        version=f"%(prog)s {__version__}"
    )

    return parser.parse_args()


def main():
    print(f"CodeWars Check Problem Script v{__version__}\n")

    args = parse_arguments()

    if not verify_paths():
        return

    glob_files = glob.glob(os.path.join('.', "prob*"))

    # Skip exe and class files
    program_files = [file_name for file_name in glob_files if 'exe' not in file_name and 'class' not in file_name]

    if not program_files or len(program_files) != 1:
        display_error("Ensure that EXACTLY one problem file is present in the current directory and try again.")
        return

    check(os.path.basename(program_files[0]), args.show_input)

    print()

    # Cleanup
    for local_file in sorted(os.listdir('.')):
        if re.match(r"prob.*.class", local_file) or re.match(r"prob.*.exe", local_file):
            print("Cleanup: Removing {}".format(local_file))
            os.remove(local_file)
        elif local_file == INPUT_TEXT_FILE_NAME:
            os.remove(local_file)


if __name__ == "__main__":
    main()
