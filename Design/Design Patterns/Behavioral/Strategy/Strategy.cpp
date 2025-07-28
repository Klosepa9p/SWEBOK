#include <iostream>
#include <memory>

// Strategy arayüzü
class Strategy {
public:
    virtual void execute() = 0;
    virtual ~Strategy() = default;
};

// ConcreteStrategyA
class ConcreteStrategyA : public Strategy {
public:
    void execute() override {
        std::cout << "Using Strategy A: Quick algorithm.\n";
    }
};

// ConcreteStrategyB
class ConcreteStrategyB : public Strategy {
public:
    void execute() override {
        std::cout << "Using Strategy B: Safe algorithm.\n";
    }
};

// Context
class Context {
private:
    std::unique_ptr<Strategy> strategy;
public:
    void setStrategy(std::unique_ptr<Strategy> s) {
        strategy = std::move(s);
    }
    void executeStrategy() {
        if (strategy) {
            strategy->execute();
        } else {
            std::cout << "No strategy selected.\n";
        }
    }
};

int main() {
    Context context;

    // Strategy A'yı seç
    context.setStrategy(std::make_unique<ConcreteStrategyA>());
    context.executeStrategy();

    // Strategy B'yi seç
    context.setStrategy(std::make_unique<ConcreteStrategyB>());
    context.executeStrategy();

    return 0;
}