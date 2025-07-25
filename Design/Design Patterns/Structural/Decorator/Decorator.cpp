#include <iostream>
#include <string>

// Component arayüzü
class Kahve {
public:
    virtual std::string getAciklama() const = 0;
    virtual double getFiyat() const = 0;
    virtual ~Kahve() {}
};

// Concrete Component
class BasitKahve : public Kahve {
public:
    std::string getAciklama() const override {
        return "Basit Kahve";
    }

    double getFiyat() const override {
        return 5.0;
    }
};

// Abstract Decorator sınıfı
class KahveDecorator : public Kahve {
protected:
    Kahve* dekorEdilenKahve;

public:
    KahveDecorator(Kahve* kahve) : dekorEdilenKahve(kahve) {}
    
    std::string getAciklama() const override {
        return dekorEdilenKahve->getAciklama();
    }

    double getFiyat() const override {
        return dekorEdilenKahve->getFiyat();
    }

    ~KahveDecorator() {
        delete dekorEdilenKahve;
    }
};

// Concrete Decorator: Süt Ekleme
class Sut : public KahveDecorator {
public:
    Sut(Kahve* kahve) : KahveDecorator(kahve) {}

    std::string getAciklama() const override {
        return dekorEdilenKahve->getAciklama() + ", Süt";
    }

    double getFiyat() const override {
        return dekorEdilenKahve->getFiyat() + 2.0;
    }
};

// Concrete Decorator: Şeker Ekleme
class Seker : public KahveDecorator {
public:
    Seker(Kahve* kahve) : KahveDecorator(kahve) {}

    std::string getAciklama() const override {
        return dekorEdilenKahve->getAciklama() + ", Şeker";
    }

    double getFiyat() const override {
        return dekorEdilenKahve->getFiyat() + 1.0;
    }
};

// Test fonksiyonu
int main() {
    // Basit kahve
    Kahve* kahve = new BasitKahve();
    std::cout << kahve->getAciklama() << ": " << kahve->getFiyat() << " TL" << std::endl;

    // Süt eklenmiş kahve
    kahve = new Sut(kahve);
    std::cout << kahve->getAciklama() << ": " << kahve->getFiyat() << " TL" << std::endl;

    // Süt ve şeker eklenmiş kahve
    kahve = new Seker(kahve);
    std::cout << kahve->getAciklama() << ": " << kahve->getFiyat() << " TL" << std::endl;

    // Bellek temizliği
    delete kahve;
    return 0;
}