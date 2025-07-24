#include <iostream>

class Singleton {
public:
    // Singleton instance'ı döndüren static fonksiyon
    static Singleton* getInstance() {
        if (instance == nullptr) {
            instance = new Singleton();
        }
        return instance;
    }

    void IncrementCounter() {
        counter++;
    }

    int getCounter() const{
        return counter;
    }

private:
    // Private constructor
    Singleton() : counter(0) {}

    static Singleton* instance;
    int counter;
};

// Static değişkenin tanımı
Singleton* Singleton::instance = nullptr;

int main() {
    Singleton* s1 = Singleton::getInstance();
    Singleton* s2 = Singleton::getInstance();

    s1->IncrementCounter();
    s2->IncrementCounter();
    s2->IncrementCounter();

    std::cout << "Counter: " << s1->getCounter() << std::endl;
    std::cout << "Counter: " << s2->getCounter() << std::endl;

    // s1 ve s2 aynı instance'ı gösterir, counter ortak olur
    return 0;
}


/*


Neden statik tanımlanır?
✅ Çünkü:

    Singleton deseni bir sınıfın sadece tek bir örneğinin (instance) var olmasını garanti etmeyi amaçlar.

    Bu örneğin tüm program boyunca global olarak erişilebilir olması gerekir.

    Eğer instance değişkeni statik olmazsa, her Singleton nesnesi için ayrı bir instance olurdu.

    static ile sınıf seviyesine taşınır → tüm objeler ve kod blokları tarafından paylaşılan tek bir değişken hâline gelir.


*/
