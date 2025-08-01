
#Before refactoring
def output(self, name):
    if name == "banner":
        # Print the banner.
        # ...
        pass
    if name == "info":
        # Print the info.
        # ...
        pass


#Replace Parameter with Explicit Methods

def outputBanner(self):
    # Print the banner.
    # ...
    pass

def outputInfo(self):
    # Print the info.
    # ...
    pass

