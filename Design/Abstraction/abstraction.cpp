#include <iostream>
#include <memory>

// Soyut sınıf (abstract class)
class PaymentMethod {
public:
    // Saf sanal fonksiyon → alt sınıflar mutlaka override etmeli
    virtual void Pay(int amount) = 0;

    virtual ~PaymentMethod() = default;
};

// Somut sınıf: Kredi kartı ile ödeme
class CreditCard : public PaymentMethod {
public:
    void Pay(int amount) override {
        std::cout << amount << " TL kredi kartı ile ödendi." << std::endl;
    }
};

// Somut sınıf: Nakit ödeme
class Cash : public PaymentMethod {
public:
    void Pay(int amount) override {
        std::cout << amount << " TL nakit olarak ödendi." << std::endl;
    }
};

// Somut sınıf: Kripto ile ödeme
class Crypto : public PaymentMethod {
public:
    void Pay(int amount) override {
        std::cout << amount << " TL kripto para ile ödendi." << std::endl;
    }
};

int main() {
    // Kullanıcı (client) sadece PaymentMethod arayüzünü bilir
    std::unique_ptr<PaymentMethod> payment;

    // Kullanıcı ödeme tipini seçti: kredi kartı
    payment = std::make_unique<CreditCard>();
    payment->Pay(100);

    // Sonra nakit ödeme yapmak istedi
    payment = std::make_unique<Cash>();
    payment->Pay(50);

    // Ve kripto ile ödeme
    payment = std::make_unique<Crypto>();
    payment->Pay(200);

    return 0;
}


/*
✅ Açıklama:

    Kullanıcı (client) CreditCard, Cash veya Crypto sınıflarının iç detaylarını bilmez.

    Sadece PaymentMethod arayüzünü kullanır ve Pay() fonksiyonunu çağırır.

    İşin nasıl yapıldığı gizlidir, sadece ne yaptığı görünür.
*/