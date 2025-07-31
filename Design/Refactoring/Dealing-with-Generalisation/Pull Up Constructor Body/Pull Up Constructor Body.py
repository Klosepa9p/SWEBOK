
class Employee:
    def __init__(self, name, id):
        self.name = name
        self.id = id


## Before refactoring

class Manager(Employee):
    def __init__(self, name, id, grade):
        self.name = name
        self.id = id
        self.grade = grade
    # ...



#Pull Up Constructor Body

class Manager(Employee):
    def __init__(self, name, id, grade):
        Employee.__init__(name, id)
        self.grade = grade
    # ...

