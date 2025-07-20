#include <iostream>
#include <string>
using namespace std;

class Engine {
public:
    Engine(int horsePower) : horsePower(horsePower) {}

    void start() {
        cout << "Engine started with " << horsePower << " HP." << endl;
    }

private:
    int horsePower;
};

class Car {
public:
    Car(string brand, int horsePower) 
        : brand(brand), engine(horsePower) {} // Engine nesnesi burada oluşturuluyor

    void startCar() {
        cout << brand << " is starting..." << endl;
        engine.start(); // Engine fonksiyonunu çağırıyoruz
    }

private:
    string brand;
    Engine engine; // Composition: Car içinde Engine nesnesi
};

int main() {
    Car myCar("Toyota", 150);
    myCar.startCar();
    return 0;
}