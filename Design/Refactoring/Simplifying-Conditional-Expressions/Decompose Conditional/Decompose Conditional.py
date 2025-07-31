
quantity = 10
winterRate = 1.5
summerRate = 2.0
winterServiceCharge = 5.0
summerServiceCharge = 10.0
date = "2023-07-01"  # Example date, replace with actual date

def isSummer(date):
    # Logic to determine if the date is in summer
    return True  # Placeholder for actual logic

def summerCharge(quantity):
    return quantity * summerRate + summerServiceCharge
def winterCharge(quantity):
    return quantity * winterRate + winterServiceCharge

SUMMER_START = "2023-06-01"  # Example start date for summer
SUMMER_END = "2023-08-31"    # Example end date for summer


#Before refactoring

if date.before(SUMMER_START) or date.after(SUMMER_END):
    charge = quantity * winterRate + winterServiceCharge
else:
    charge = quantity * summerRate


#Decomposed conditional

if isSummer(date):
    charge = summerCharge(quantity)
else:
    charge = winterCharge(quantity)

