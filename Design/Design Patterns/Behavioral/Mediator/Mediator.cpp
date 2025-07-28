#include <iostream>
#include <string>

// Soyut Mediator
class Mediator {
public:
    virtual void notify(class Component* sender, const std::string& message) = 0;
};

// Temel Component
class Component {
protected:
    Mediator* mediator;
public:
    Component(Mediator* m) : mediator(m) {}
    virtual void send(const std::string& message) = 0;
    virtual void receive(const std::string& message) = 0;
};

// ComponentA
class ComponentA : public Component {
public:
    ComponentA(Mediator* m) : Component(m) {}
    void send(const std::string& message) override {
        std::cout << "[ComponentA] sends: " << message << std::endl;
        mediator->notify(this, message);
    }
    void receive(const std::string& message) override {
        std::cout << "[ComponentA] receives: " << message << std::endl;
    }
};

// ComponentB
class ComponentB : public Component {
public:
    ComponentB(Mediator* m) : Component(m) {}
    void send(const std::string& message) override {
        std::cout << "[ComponentB] sends: " << message << std::endl;
        mediator->notify(this, message);
    }
    void receive(const std::string& message) override {
        std::cout << "[ComponentB] receives: " << message << std::endl;
    }
};

// ConcreteMediator
class ConcreteMediator : public Mediator {
private:
    ComponentA* componentA;
    ComponentB* componentB;
public:
    void setComponentA(ComponentA* a) { componentA = a; }
    void setComponentB(ComponentB* b) { componentB = b; }

    void notify(Component* sender, const std::string& message) override {
        if (sender == componentA) {
            componentB->receive(message);
        } else if (sender == componentB) {
            componentA->receive(message);
        }
    }
};

int main() {
    ConcreteMediator* mediator = new ConcreteMediator();

    ComponentA* compA = new ComponentA(mediator);
    ComponentB* compB = new ComponentB(mediator);

    mediator->setComponentA(compA);
    mediator->setComponentB(compB);

    compA->send("Hello from A!");
    compB->send("Hi, this is B!");

    delete compA;
    delete compB;
    delete mediator;

    return 0;
}