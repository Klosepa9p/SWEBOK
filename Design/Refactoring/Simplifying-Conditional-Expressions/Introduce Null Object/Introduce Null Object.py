
class Customer:
    def getPlan(self):
        # Returns the billing plan for the customer.
        pass
class Order:
    def __init__(self):
        self.customer = None  # This could be None if no customer is associated.
class BillingPlan:
    @staticmethod
    def basic():
        # Returns a basic billing plan.
        return "Basic Plan"
    
order = Order()
customer = order.customer


#Before refactoring

if customer is None:
    plan = BillingPlan.basic()
else:
    plan = customer.getPlan()



#Introduce Null Object
class NullCustomer(Customer):

    def isNull(self):
        return True

    def getPlan(self):
        return self.NullPlan()

    # Some other NULL functionality.

# Replace null values with Null-object.
customer = order.customer or NullCustomer()

# Use Null-object as if it's normal subclass.
plan = customer.getPlan()