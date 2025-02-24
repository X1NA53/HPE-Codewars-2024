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

def isSquare(points):
    if points.length() == 4:
        if points[0].y != points[1].y or points[0].x != points[2].x:
            return False
        if points[1].x != points[3].x:
            return False
        if points[2].y != points[3].y:
            return False
        return True
    return False
        
def isPentagon(points):
    if points.length() == 5:
        #no p with same y as p0
        for i in range(points) - 1:
            #if any points are higher or equal to first point
            if points[i+1].y <= points[0].y:
                return False
        #p0.x must be >p3.x and <p4.x
        if points[0].x <= points[3].x or points[0].x >= points[4].x:
            return False
        # p1,p2 must have same y
        if points[1].y != points[2].y:
            return False
        # p3, p4 must have same y, p3.x greater than p1.x and <p0.x, p4.x greater than p0.x and <p2.x
        if points[3].y == points[4] and points[3].x > points[1].x and points[3].x < points[0].x and points[4].x > points[0].x and points[4].x < points[2].x:
            return True
    return False

def isHexagon(points):
    if points.length() == 6:
        #p0 must be lowest y
        for i in range(points) - 1:
            if points[i+1].y <= points[0].y:
                return False
        #p5 must be highest y
        for i in range(points) - 1:
            if points[i].y <= points[5].y:
                return False
        #p0 and p5 must be between p1, and p2
        if points[0].x <= points[1].x or points[0].x >= points[2]:
            return False
        if points[5].x <= points[1].x or points[5].x >= points[2]:
            return False
        #p1 and p2 must have same y
        if points[1].y != points[2].y:
            return False
        if points[3].y != points[4].y:
            return False
        #p3 and p1 same x
        if points[3].x != points[1].x:
            return False
        #p4 and p2 same x
        if points[4].x == points[2].x:
            return True
    return False