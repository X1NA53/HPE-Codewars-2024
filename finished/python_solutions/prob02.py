#opens the file in read only mode, stores file in var called file
with open("input.txt","r") as file:
    #readline returns a string
    #readlines() is normally used to give us a list of strings
    line = file.readline()

#splits string into a list, using " " as delimiter, stores first value in x
x = int(line.split(" ")[0])
y = int(line.split(" ")[1])

#prints computation
print(x / y * (y + y))