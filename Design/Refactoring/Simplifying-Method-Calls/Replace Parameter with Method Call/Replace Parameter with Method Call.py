


class DiscountPlan:
    def getSeasonalDiscount(self):
        # Calculate seasonal discount.
        return 0.1
    def getFees(self):
        # Calculate fees.
        return 2.0
    def discountedPrice(self, basePrice, seasonalDiscount=0, fees=0):
        return basePrice * (1 - seasonalDiscount) + fees
    
self = DiscountPlan()

quantity = 5
itemPrice = 20.0

#Before refactoring
basePrice = quantity * itemPrice
seasonalDiscount = self.getSeasonalDiscount()
fees = self.getFees()
finalPrice = self.discountedPrice(basePrice, seasonalDiscount, fees)


#Replace Parameter with Explicit Methods
basePrice = quantity * itemPrice
finalPrice = self.discountedPrice(basePrice)

