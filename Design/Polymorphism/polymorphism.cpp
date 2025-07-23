#include <iostream>

using namespace std;

class Base {
public:
    int static_add(int a) {
        static int d = 0;  // static değişken, her çağrıda değer korunur
        d += a;
        return d;
    }

    virtual int dynamic_add(int a) {
        static int d = 0;
        d += a;
        return d;
    }
};

class Derived : public Base {
public:
    // Overloading: parametre sayısı farklı
    int static_add(int a, unsigned int c) {
        int d = 0;
        while (c--)
            d += a;
        return d;
    }

    // Override
    int dynamic_add(int a) override {
        static int d = 0;
        d += a * 2;
        return d;
    }
};

int main() {
    Base b;
    Derived d;

    // Static polymorphism: overload
    cout << "Base static_add(5): " << b.static_add(5) << endl;
    cout << "Derived static_add(5, 3): " << d.static_add(5, 3) << endl;

    // Dynamic polymorphism: override
    Base* ptr = &d;
    cout << "Base pointer dynamic_add(5): " << ptr->dynamic_add(5) << endl;
    cout << "Derived dynamic_add(5): " << d.dynamic_add(5) << endl;

    return 0;
}
