
#Before refactoring

def discount(inputVal, quantity):
    if quantity > 50:
        inputVal -= 2
    # ...



#Remove assignments to parameters Method

def discount(inputVal, quantity):
    result = inputVal
    if quantity > 50:
        result -= 2
    # ...

