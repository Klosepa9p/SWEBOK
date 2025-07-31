

price = 100

def send():
    print(f"Sending invoice for total: {total}")

def isSpecialDeal():
    # Logic to determine if it's a special deal
    return True  # Placeholder for actual logic


#Before refactoring

if isSpecialDeal():
    total = price * 0.95
    send()
else:
    total = price * 0.98
    send()


#Consolidated Duplicate Conditional Fragments

if isSpecialDeal():
    total = price * 0.95
else:
    total = price * 0.98
send()

