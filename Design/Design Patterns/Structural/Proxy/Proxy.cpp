#include <iostream>
#include <string>
using namespace std;

// Subject Interface
class IBanka {
public:
    virtual bool OdemeYap(double tutar) = 0;
    virtual ~IBanka() = default;
};

// Real Subject
class Banka : public IBanka {
public:
    bool OdemeYap(double tutar) override {
        if (tutar < 100) {
            cout << "Ödeyeceğiniz tutar 100 TL'den az olamaz. Fark -> " << (100 - tutar) << endl;
        }
        else if (tutar > 100) {
            cout << "Ödeyeceğiniz tutar 100 TL'den fazla olamaz. Fark -> " << (tutar - 100) << endl;
        }
        else {
            cout << "Ödeme başarıyla gerçekleştirildi. -> " << tutar << endl;
            return true;
        }
        return false;
    }
};

// Proxy
class ProxyBanka : public IBanka {
private:
    Banka* banka = nullptr;
    bool login = false;
    string kullaniciAdi, sifre;

    bool GirisYap() {
        if (kullaniciAdi == "gncy" && sifre == "1234") {
            banka = new Banka();
            login = true;
            cout << "Hesaba giriş yapıldı." << endl;
            return true;
        }
        else {
            cout << "Lütfen kullanıcı adı ve şifreinizi doğru girdiğinize emin olunuz." << endl;
            login = false;
            return false;
        }
    }

public:
    ProxyBanka(const string& kullaniciAdi, const string& sifre)
        : kullaniciAdi(kullaniciAdi), sifre(sifre) {}

    ~ProxyBanka() {
        delete banka;
    }

    bool OdemeYap(double tutar) override {
        GirisYap();
        if (!login) {
            cout << "Hesaba giriş yapılmadığından dolayı ödeme alamıyoruz." << endl;
            return false;
        }
        banka->OdemeYap(tutar);
        return true;
    }
};

// Client
int main() {
    string kullaniciAdi, sifre;
    double tutar = 0;

    while (true) {
        cout << "Lütfen kullanıcı adınızı giriniz." << endl;
        getline(cin, kullaniciAdi);

        cout << "Lütfen şifrenizi giriniz." << endl;
        getline(cin, sifre);

        cout << "Lütfen ödenecek miktarı giriniz." << endl;
        cin >> tutar;
        cin.ignore(); // Buffer temizle

        IBanka* banka = new ProxyBanka(kullaniciAdi, sifre);
        banka->OdemeYap(tutar);

        delete banka;

        cout << "************" << endl;
    }

    return 0;
}


//Protection Proxy Örneği