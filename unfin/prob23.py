def getInput():
    with open("input.txt","r") as file:
        lines = file.readlines()
    inpt = []
    for line in lines:
        if line.startswith("END"):
            break
        inpt.append(line)
    return inpt

#grid is a 2d array that represents the data
def getPoints(grid):
    points = []
    for y in range(grid.length):
        for x in range(grid[y].length):
            if grid[y][x] == "#":
                points.append((x,y))
    return points

#points is a list of tuple cordinates
def isTriangle(points):
    if points.length() == 3:
        firstpoint = points[0]
        #if all x are the same or all y are the same return false
        if all(point.x == points[0].x for point in points) or all(point.y == points[0].y for point in points):
            return False
        return True
    return False