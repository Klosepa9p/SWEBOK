

seniority = 3
monthsDisabled = 0
isPartTime = False
def isNotEligibleForDisability():
    if seniority < 2:
        return True
    if monthsDisabled > 12:
        return True
    if isPartTime:
        return True
    return False



#Before refactoring

def disabilityAmount():
    if seniority < 2:
        return 0
    if monthsDisabled > 12:
        return 0
    if isPartTime:
        return 0
    # Compute the disability amount.
    # ...


#Consolidated conditional expression
def disabilityAmount():
    if isNotEligibleForDisability():
        return 0
    # Compute the disability amount.
    # ...

