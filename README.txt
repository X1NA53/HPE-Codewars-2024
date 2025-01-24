Welcome to CodeWars 2024!

This ZIP file includes:

- README.txt:
    - This file.

- codewars-*-problems-*.pdf:
    - Instruction sheet and Problem Statements

- student_datasets:
    - Directory with test data for every problem.
    - Use each input to test your program, and compare with each expected output.

- checkProb.py:
    - A python script like the one the Judges will use to test your programs.

    NOTES:
      1. It REQUIRES python3 to run.

      2. It ASSUMES that python, java, javac, gcc and g++ are available on your
         system path.
           - If you are not using one (or more) of these languages, that's OK!
           - Only those languages that you are using MUST be installed.

      3. It works with File input (reading from 'input.txt') and Keyboard input. The
         script automatically loads each data set into 'input.txt' and then runs your
         program. It also provides the data set as Keyboard input at the same time.

           - Your program should use either File input or Keyboard input. For more
             information see the Contest Instructions in the PDF file.

    ONE TIME SETUP:
      1. If your system path DOES NOT INCLUDE the executables for a language that you are
         using, then you MUST EDIT checkProb.py to set the path:

           - Java requires 'java' and 'javac':
               - Set 'JDK_PATH' to the bin directory of your Java JDK.
               - Example: JDK_PATH = r"C:\Program Files\Java\jdk-21.0.2\bin"

           - Python requires 'python':
               - Set 'PY3_PATH' to the python executable
               - Example: PY3_PATH = r"C:\Python312\python.exe"

           - C requires 'gcc':
               - Set 'GCC_PATH' to the gcc executable
               - Example: GCC_PATH = r"C:\msys64\mingw64\bin\gcc.exe"

           - C++ requires 'g++':
               - Set 'GPP_PATH' to the g++ executable
               - Example: GPP_PATH = r"C:\msys64\mingw64\bin\g++.exe"

        2. Copy this script into your working directory

    HOW TO USE:
      1. COPY only one program "probXX.zz" into your working directory.
           - For example, "prob10.py"

      2. Open a Command or Terminal Window
           - Change directories to your working directory.

      3. Type "python checkProb.py" to test your program against all datasets in the 'student_datasets' directory.
           - Use "python checkProb.py --show-input" to also show the input dataset (before running your program).


REMINDERS:

  1. Using checkProb.py is OPTIONAL.
      - We provide it as an example of how we will be testing your programs, but you do not need to use it.

  2. You must test your program against ALL input files.

  3. The Judges will test against modified input files, and your programs must correctly solve all of them to pass.

  4. See an explanation of how to test manually on the Contest Instructions in the PDF file.
