#include <iostream>
#include <memory>

// Implementer (interface)
class Workshop {
public:
    virtual void work() = 0;
    virtual ~Workshop() = default;
};

// Concrete Implementer 1
class Produce : public Workshop {
public:
    void work() override {
        std::cout << "Produced";
    }
};

// Concrete Implementer 2
class Assemble : public Workshop {
public:
    void work() override {
        std::cout << " And Assembled." << std::endl;
    }
};

// Abstraction
class Vehicle {
protected:
    std::shared_ptr<Workshop> workShop1;
    std::shared_ptr<Workshop> workShop2;
public:
    Vehicle(std::shared_ptr<Workshop> ws1, std::shared_ptr<Workshop> ws2)
        : workShop1(ws1), workShop2(ws2) {}

    virtual void manufacture() = 0;
    virtual ~Vehicle() = default;
};

// Refined Abstraction 1
class Car : public Vehicle {
public:
    Car(std::shared_ptr<Workshop> ws1, std::shared_ptr<Workshop> ws2)
        : Vehicle(ws1, ws2) {}

    void manufacture() override {
        std::cout << "Car ";
        workShop1->work();
        workShop2->work();
    }
};

// Refined Abstraction 2
class Bike : public Vehicle {
public:
    Bike(std::shared_ptr<Workshop> ws1, std::shared_ptr<Workshop> ws2)
        : Vehicle(ws1, ws2) {}

    void manufacture() override {
        std::cout << "Bike ";
        workShop1->work();
        workShop2->work();
    }
};

// Client / Demo
int main() {
    auto produce = std::make_shared<Produce>();
    auto assemble = std::make_shared<Assemble>();

    std::shared_ptr<Vehicle> car = std::make_shared<Car>(produce, assemble);
    car->manufacture();

    std::shared_ptr<Vehicle> bike = std::make_shared<Bike>(produce, assemble);
    bike->manufacture();

    return 0;
}
