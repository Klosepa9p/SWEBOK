#include <iostream>


using namespace std;

class A {

    public:
        int pub_var;
    protected:
        int pro_var;
    private:
        int pri_var;
};



// B, A'dan private kalıtım alıyor:
// A'dan gelen public ve protected üyeler, B içinde private olur.
class B : private A {
public:
    int getPubVar() {
        return pub_var; // pub_var B içinde private olmuştur ama erişilir
    }
    int getProVar() {
        return pro_var; // pro_var da private olmuştur, erişilir
    }
    int getPriVar() {
        // return pri_var; // HATA! private üye alt sınıflardan erişilemez
        return -1; // Örnek amaçlı, normalde pri_var'a erişemezsin
    }
};

// C, A'dan protected kalıtım alıyor:
// A'dan gelen public ve protected üyeler, C içinde protected olur.
class C : protected A {
public:
    int getPubVar() {
        return pub_var; // pub_var protected oldu, erişilir
    }
    int getProVar() {
        return pro_var; // pro_var zaten protected idi, erişilir
    }
    int getPriVar() {
        // return pri_var; // HATA! private üye alt sınıflardan erişilemez
        return -1; // Örnek amaçlı
    }
};

// D, A'dan public kalıtım alıyor:
// A'dan gelen public üye public, protected üye protected kalır.
class D : public A {
public:
    int getPubVar() {
        return pub_var; // public olarak kalır, erişilir
    }
    int getProVar() {
        return pro_var; // protected olarak kalır, erişilir
    }
    int getPriVar() {
        // return pri_var; // HATA! private üye alt sınıflardan erişilemez
        return -1; // Örnek amaçlı
    }
};

//Private üyeler doğrudan yalnızca tanımlandıkları sınıfın içinde erişilebilir.


