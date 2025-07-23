#include <iostream>
#include <stdexcept>

// Büyük, hepsini kapsayan interface
class IPrinter {
public:
    virtual void Print() = 0;
    virtual void Scan() = 0;
    virtual void Fax() = 0;
    virtual void PrintDuplex() = 0;
    virtual ~IPrinter() = default;
};

// HPPrinter: tüm özellikleri destekliyor
class HPPrinter : public IPrinter {
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

// SamsungPrinter: bazı özellikleri desteklemiyor
class SamsungPrinter : public IPrinter {
public:
    void Print() override {
        std::cout << "Samsung Print işlemleri..." << std::endl;
    }

    void Scan() override {
        throw std::logic_error("Scan özelliği desteklenmiyor!");
    }

    void Fax() override {
        std::cout << "Samsung Fax işlemleri..." << std::endl;
    }

    void PrintDuplex() override {
        throw std::logic_error("PrintDuplex özelliği desteklenmiyor!");
    }
};

// LexmarkPrinter: yine bazı özellikleri desteklemiyor
class LexmarkPrinter : public IPrinter {
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

    void PrintDuplex() override {
        throw std::logic_error("PrintDuplex özelliği desteklenmiyor!");
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
    try {
        samsung.Scan();
    } catch (const std::logic_error& ex) {
        std::cout << "Samsung Scan: Exception: " << ex.what() << std::endl;
    }

    try {
        samsung.PrintDuplex();
    } catch (const std::logic_error& ex) {
        std::cout << "Samsung PrintDuplex: Exception: " << ex.what() << std::endl;
    }

    lexmark.Print();
    lexmark.Scan();
    lexmark.Fax();
    try {
        lexmark.PrintDuplex();
    } catch (const std::logic_error& ex) {
        std::cout << "Lexmark PrintDuplex: Exception: " << ex.what() << std::endl;
    }

    return 0;
}


/*

✅ Açıklama:

    IPrinter arayüzü çok büyük → hepsini implement etmek zorunda kalıyorlar.

    Bazı yazıcılar (Samsung, Lexmark) Scan veya PrintDuplex gibi özellikleri desteklemediği hâlde, boş implementasyon veya exception atarak geçmek zorunda kalıyor.

    Bu, Interface Segregation Principle’a aykırı.
*/