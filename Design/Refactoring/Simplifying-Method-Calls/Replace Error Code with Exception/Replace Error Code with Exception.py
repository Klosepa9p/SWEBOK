
def BalanceException(Exception):    """Custom exception for insufficient balance."""



#Before refactoring
def withdraw(self, amount):
    if amount > self.balance:
        return -1
    else:
        self.balance -= amount
    return 0



#Replace Error Code with Exception
def withdraw(self, amount):
    if amount > self.balance:
        raise BalanceException()
    self.balance -= amount


