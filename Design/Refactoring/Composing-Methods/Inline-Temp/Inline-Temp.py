
#Before Refactoring

def hasDiscount(order):
    basePrice = order.basePrice()
    return basePrice > 1000



#Inline Temp Example

def hasDiscount(order):
    return order.basePrice() > 1000

