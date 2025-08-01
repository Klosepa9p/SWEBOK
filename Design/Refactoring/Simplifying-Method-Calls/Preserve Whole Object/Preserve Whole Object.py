
class Plan:
    def __init__(self, temperature_range):
        self.temperature_range = temperature_range

    def getTemperatureRange(self):
        return self.temperature_range

    def withinRange(self, low, high):
        return self.temperature_range.getLow() <= low and self.temperature_range.getHigh() >= high
    def withinRange(self, temperature_range):
        return self.temperature_range.getLow() <= temperature_range.getLow() and \
               self.temperature_range.getHigh() >= temperature_range.getHigh()


plan = Plan()
daysTempRange = plan.getTemperatureRange()

#Before refactoring

low = daysTempRange.getLow()
high = daysTempRange.getHigh()
withinPlan = plan.withinRange(low, high)

#Preserve Whole Object

withinPlan = plan.withinRange(daysTempRange)

