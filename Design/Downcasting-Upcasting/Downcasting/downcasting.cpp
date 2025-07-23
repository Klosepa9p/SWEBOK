#include <iostream>
using namespace std;

class Father {
public:
    virtual void run() const { cout << "Father running..." << endl; }
};

class Child : public Father {
public:
    void run() const override { cout << "Child running..." << endl; }
    void play() const { cout << "Child playing..." << endl; }
};

int main() {
    Father *f1 = nullptr;
    Child *c1 = dynamic_cast<Child*>(f1); // nullptr → c1 de nullptr

    Father *f2 = new Father();
    Child *c2 = dynamic_cast<Child*>(f2); // başarısız, c2 = nullptr

    Father *f3 = new Child();
    Child *c3 = dynamic_cast<Child*>(f3); // başarılı, c3 geçerli

    Father *f4 = new Father();
    Child *c4 = static_cast<Child*>(f4); // compile edilir ama tehlikeli, undefined behavior kontrolü yok. Riskli

    // Kontrol örnekleri
    if (c1) c1->play(); else cout << "Downcast failed (f1)" << endl;
    if (c2) c2->play(); else cout << "Downcast failed (f2)" << endl;
    if (c3) c3->play(); else cout << "Downcast failed (f3)" << endl;
    if (c4) c4->run(); else cout << "Static cast c4 görünüyor" << endl; //Father running

    delete f2;
    delete f3;
    delete f4;
    return 0;
}


/*
static_cast ile yapılan Neden undefined behavior?

    c4 üzerinden Child’a özgü metodlar çağrılırsa,

    Nesne gerçekte Child olmadığından, bellek yapısı, sanal tablo (vtable), veri üyeleri vb. uyuşmaz.

    run fonksiyonu ortak. normalde override edilmiş ama Father nesnesi olduğu için Father'ın run fonksiyonu
    çağrılır. dynamic_cast ile yapılsaydı null döndürürdü! static_cast derleme zamanında statik şekilde kontrol
    yapıyor.

    Program beklenmeyen sonuçlar verebilir: çökme, veri bozulması, rastgele davranış.

*/