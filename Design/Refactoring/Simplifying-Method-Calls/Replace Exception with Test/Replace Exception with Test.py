
values = [10, 20, 30, 40]

#Before refactoring
def getValueForPeriod(periodNumber):
    try:
        return values[periodNumber]
    except IndexError:
        return 0


#Replace Exception with Test
def getValueForPeriod(self, periodNumber):
    if periodNumber >= len(self.values):
        return 0
    return self.values[periodNumber]


