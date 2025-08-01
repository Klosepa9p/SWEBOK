

values = [10, 20, 30, 40]

def getValueForPeriod(periodNumber):
    try:
        return values[periodNumber]
    except IndexError:
        return 0

def getValueForPeriod(self, periodNumber):
    if periodNumber >= len(self.values):
        return 0
    return self.values[periodNumber]

