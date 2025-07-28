// Soyut Handler sınıfı

#include <iostream>

class Handler {
protected:
    Handler* next;  // Zincirdeki bir sonraki işleyici
public:
    Handler() : next(nullptr) {}
    void setNext(Handler* handler) { next = handler; }

    virtual void handleRequest(int level) {
        if (next != nullptr) {
            next->handleRequest(level);
        } else {
            std::cout << "Request could not be handled.\n";
        }
    }
};

// ConcreteHandlerA
class ConcreteHandlerA : public Handler {
public:
    void handleRequest(int level) override {
        if (level == 1) {
            std::cout << "ConcreteHandlerA handled request with level 1\n";
        } else {
            std::cout << "ConcreteHandlerA passed request to next\n";
            Handler::handleRequest(level);
        }
    }
};

// ConcreteHandlerB
class ConcreteHandlerB : public Handler {
public:
    void handleRequest(int level) override {
        if (level == 2) {
            std::cout << "ConcreteHandlerB handled request with level 2\n";
        } else {
            std::cout << "ConcreteHandlerB passed request to next\n";
            Handler::handleRequest(level);
        }
    }
};

int main() {
    // Zinciri kur
    ConcreteHandlerA handlerA;
    ConcreteHandlerB handlerB;

    handlerA.setNext(&handlerB);

    std::cout << "Sending request with level 1:\n";
    handlerA.handleRequest(1);

    std::cout << "\nSending request with level 2:\n";
    handlerA.handleRequest(2);

    std::cout << "\nSending request with level 3:\n";
    handlerA.handleRequest(3);

    return 0;
}

/*
Zincirde her işleyici (handler), isteği ya kendisi işler ya da zincirdeki bir sonraki işleyiciye iletir.

Bu sayede sistem, esnek, genişletilebilir ve düşük bağlılığa sahip olur.
*/