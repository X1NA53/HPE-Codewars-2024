import re

class ChaseInformation():
    def __init__(self,speed,aspeed,apos,hlength,exitdistance,flashlight = None,sdoor = None):
        self.speed = speed
        self.aspeed = aspeed
        self.apos = apos
        self.hlength = hlength
        self.exitdistance = exitdistance
        self.flashlight = float(flashlight) if flashlight != None else -1
        self.sdoor = float(sdoor) if sdoor != None else -1

        self.ablinded = 0
        self.ablocked = 0
        self.time = 0
        self.pos = 0.0
        self.escaped = False
        self.caught = False

    def doInterval(self):
        self.time += 1 #increment secounds
        self.pos += self.speed #move us
        if self.ablinded > 0:
            self.ablinded -= 1
        if self.ablocked > 0:
            self.ablocked -= 0
        if self.ablinded == 0 and self.ablocked == 0: #as long as we arnt blinded or blocked, move animatronic
            self.apos += self.aspeed
        if self.flashlight > self.pos - self.speed and self.flashlight <= self.pos: #check if moved by flashlight this turn
            if self.sdoor > self.apos and self.sdoor < self.pos: #check if door inbetween us
                pass
            else:
                self.ablinded = 2 #set blinded condition to 2
        if self.sdoor > self.apos - self.aspeed and self.sdoor <= self.apos: #check if door passed by ani
            self.ablocked = 3
        if self.pos <= self.apos:
            self.caught = True
        if self.pos >= self.exitdistance:
            self.escaped = True
        return [self.str_of_hero_interval(),self.str_of_animatronic_interval()]


    def str_of_hero_interval(self):
        if self.time > 9:
            return "Time-"+str(self.time)+": "+str(self.pos-self.speed)+"->"+str(self.pos)
        else:
            return "Time-0"+str(self.time)+": "+str(self.pos-self.speed)+"->"+str(self.pos)

    def str_of_animatronic_interval(self):
        if self.time > 9:
            return "Time-"+str(self.time)+": "+str(self.apos-self.aspeed)+"->"+str(self.apos)
        else:
            return "Time-0"+str(self.time)+": "+str(self.apos-self.aspeed)+"->"+str(self.apos)


def getInput():
    with open("input.txt","r") as file:
        line = file.readline()
        speed         = re.findall(r'(?<=Run:)\d+\.\d+',line)[0]
        aspeed        = re.findall(r'(?<=Chase:)\d+\.\d+',line)[0]
        apos          = re.findall(r'(?<=Start:-)\d+\.\d+',line)[0]
        hlength       = re.findall(r'(?<=Length:)\d+\.\d+',line)[0]
        exitdistance = re.findall(r'(?<=Exit:)\d+\.\d+',line)[0]
        if len(re.findall(r'(?<=Flashlight:)\d+\.\d+',line)) == 1:
            flashlight = re.findall(r'(?<=Flashlight:)\d+\.\d+',line)[0]
        else:
            flashlight = None
        if len(re.findall(r'(?<=Door:)\d+\.\d+',line)) == 1:
            sdoor = re.findall(r'(?<=Door:)\d+\.\d+',line)[0]
        else:
            sdoor = None
        CI = ChaseInformation(float(speed),float(aspeed),float(apos),float(hlength),float(exitdistance),flashlight,sdoor)
    return CI

CI = getInput()

while (CI.caught != True and CI.escaped != True):
    print("turn")
    for x in CI.doInterval():
        print(x)
