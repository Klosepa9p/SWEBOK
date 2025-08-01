
def deadAmount():
    return 0
def separatedAmount():
    return 1000
def retiredAmount():
    return 2000
def normalPayAmount():
    return 3000


#Before refactoring

def getPayAmount(self):
    if self.isDead:
        result = deadAmount()
    else:
        if self.isSeparated:
            result = separatedAmount()
        else:
            if self.isRetired:
                result = retiredAmount()
            else:
                result = normalPayAmount()
    return result


#Replace Nested Conditional with Guard Clauses

def getPayAmount(self):
    if self.isDead:
        return deadAmount()
    if self.isSeparated:
        return separatedAmount()
    if self.isRetired:
        return retiredAmount()
    return normalPayAmount()

