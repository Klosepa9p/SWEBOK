#include <iostream>
#include <memory>
#include <string>

// Soyut Sınıf (ICar)
class ICar {
public:
    virtual std::string getColor() const = 0;
    virtual double getPrice() const = 0;
    virtual ~ICar() = default;
};

// AudiCar
class AudiCar : public ICar {
    std::string color;
    double price;
public:
    AudiCar(const std::string& color, double price) : color(color), price(price) {}
    std::string getColor() const override { return color; }
    double getPrice() const override { return price; }
};

// BMWCar
class BMWCar : public ICar {
    std::string color;
    double price;
public:
    BMWCar(const std::string& color, double price) : color(color), price(price) {}
    std::string getColor() const override { return color; }
    double getPrice() const override { return price; }
};

// Soyut Sınıf (IMotorCycle)
class IMotorCycle {
public:
    virtual std::string getType() const = 0;
    virtual double getPrice() const = 0;
    virtual ~IMotorCycle() = default;
};

// AudiMotorcycle
class AudiMotorcycle : public IMotorCycle {
    std::string type;
    double price;
public:
    AudiMotorcycle(const std::string& type, double price) : type(type), price(price) {}
    std::string getType() const override { return type; }
    double getPrice() const override { return price; }
};

// BMWMotorcycle
class BMWMotorcycle : public IMotorCycle {
    std::string type;
    double price;
public:
    BMWMotorcycle(const std::string& type, double price) : type(type), price(price) {}
    std::string getType() const override { return type; }
    double getPrice() const override { return price; }
};

// Soyut Factory
class IAbstractFactory {
public:
    virtual std::unique_ptr<ICar> createCar(const std::string& color, double price) = 0;
    virtual std::unique_ptr<IMotorCycle> createMotorCycle(const std::string& type, double price) = 0;
    virtual ~IAbstractFactory() = default;
};

// AudiFactory
class AudiFactory : public IAbstractFactory {
public:
    std::unique_ptr<ICar> createCar(const std::string& color, double price) override {
        return std::make_unique<AudiCar>(color, price);
    }
    std::unique_ptr<IMotorCycle> createMotorCycle(const std::string& type, double price) override {
        return std::make_unique<AudiMotorcycle>(type, price);
    }
};

// BMWFactory
class BMWFactory : public IAbstractFactory {
public:
    std::unique_ptr<ICar> createCar(const std::string& color, double price) override {
        return std::make_unique<BMWCar>(color, price);
    }
    std::unique_ptr<IMotorCycle> createMotorCycle(const std::string& type, double price) override {
        return std::make_unique<BMWMotorcycle>(type, price);
    }
};

// main
int main() {
    AudiFactory audiFactory;
    BMWFactory bmwFactory;

    auto audiCar = audiFactory.createCar("Beyaz", 500000);
    auto bmwCar  = bmwFactory.createCar("Siyah", 420000);

    auto audiMotorcycle = audiFactory.createMotorCycle("Yarış Motoru", 125000);
    auto bmwMotorcycle  = bmwFactory.createMotorCycle("Cadde Motoru", 24000);

    std::cout << "Audi Car: " << audiCar->getColor() << ", Fiyat: " << audiCar->getPrice() << "\n";
    std::cout << "BMW Car: " << bmwCar->getColor() << ", Fiyat: " << bmwCar->getPrice() << "\n";

    std::cout << "Audi Motorcycle: " << audiMotorcycle->getType() << ", Fiyat: " << audiMotorcycle->getPrice() << "\n";
    std::cout << "BMW Motorcycle: " << bmwMotorcycle->getType() << ", Fiyat: " << bmwMotorcycle->getPrice() << "\n";

    return 0;
}


/*

Görüldüğü gibi Audi ve BMW fabrikalarını oluşturduk. 
Daha sonrasında ICar tipinde referanslar ile bu fabrikalardan nesne üretme işlemlerini gerçekleştirebildik.
Aynı şekilde motosiklet üretimi de soyutlanarak gerçekleştirildi. 
Böylece, nesne üretme sırasında new anahtarının kullanımına gerek kalınmadı ve üretilen nesne ile istemci arasındaki bağımlılık 
ortadan kaldırıldı.
*/