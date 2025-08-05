#include <iostream>

// Küçük, spesifik arayüzler (saf sanal sınıflar)
class IPrint {
public:
    virtual void Print() = 0;
    virtual ~IPrint() = default;
};

class IScan {
public:
    virtual void Scan() = 0;
    virtual ~IScan() = default;
};

class IFax {
public:
    virtual void Fax() = 0;
    virtual ~IFax() = default;
};

class IPrintDuplex {
public:
    virtual void PrintDuplex() = 0;
    virtual ~IPrintDuplex() = default;
};

// HPPrinter: tüm yeteneklere sahip
class HPPrinter : public IPrint, public IScan, public IFax, public IPrintDuplex {
public:
    void Print() override {
        std::cout << "HP Print işlemleri..." << std::endl;
    }

    void Scan() override {
        std::cout << "HP Scan işlemleri..." << std::endl;
    }

    void Fax() override {
        std::cout << "HP Fax işlemleri..." << std::endl;
    }

    void PrintDuplex() override {
        std::cout << "HP Print Duplex işlemleri..." << std::endl;
    }
};

// SamsungPrinter: sadece Print ve Fax yetenekleri var
class SamsungPrinter : public IPrint, public IFax {
public:
    void Print() override {
        std::cout << "Samsung Print işlemleri..." << std::endl;
    }

    void Fax() override {
        std::cout << "Samsung Fax işlemleri..." << std::endl;
    }
};

// LexmarkPrinter: Print, Scan ve Fax yetenekleri var
class LexmarkPrinter : public IPrint, public IScan, public IFax {
public:
    void Print() override {
        std::cout << "Lexmark Print işlemleri..." << std::endl;
    }

    void Scan() override {
        std::cout << "Lexmark Scan işlemleri..." << std::endl;
    }

    void Fax() override {
        std::cout << "Lexmark Fax işlemleri..." << std::endl;
    }
};

// Örnek kullanım
int main() {
    HPPrinter hp;
    SamsungPrinter samsung;
    LexmarkPrinter lexmark;

    hp.Print();
    hp.Scan();
    hp.Fax();
    hp.PrintDuplex();

    samsung.Print();
    samsung.Fax();

    lexmark.Print();
    lexmark.Scan();
    lexmark.Fax();

    return 0;
}

/*

✅ Açıklama:

    Büyük tek bir arayüz yerine küçük ve spesifik arayüzler tanımladık.

    Her sınıf yalnızca ihtiyaç duyduğu arayüz(ler)i implement etti.

    Bu sayede:

        Alt sınıflar kullanmadıkları metotları almak zorunda kalmaz.

        Kod daha okunaklı, bakımı ve genişletilmesi kolay olur.

    Tam olarak Interface Segregation Principle (ISP) uygulanmış oldu.
    
*/