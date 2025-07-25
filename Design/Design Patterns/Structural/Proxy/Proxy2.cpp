#include <iostream>
#include <string>
#include <thread>
#include <chrono>

using namespace std;

// Subject Interface
class IResim {
public:
    virtual void Goster(string& imagePath, const string& dizin) = 0;
    virtual ~IResim() = default;
};

// Real Subject
class Resim : public IResim {
public:
    void Goster(string& imagePath, const string& dizin) override {
        imagePath = dizin;
        cout << "[Resim] Resim yüklendi: " << dizin << endl;
    }
};

// Proxy
class ProxyResim : public IResim {
private:
    Resim* resim = nullptr;
    bool resimYuklendi = false;
    string dizin;
    string* pImagePath = nullptr;

    // Simulate image loading with delay
    void ResimYukle() {
        cout << "[ProxyResim] Resim yükleniyor... (2 sn)" << endl;
        this_thread::sleep_for(chrono::seconds(2));
        resim = new Resim();
        resim->Goster(*pImagePath, dizin);
        resimYuklendi = true;
    }

public:
    void Goster(string& imagePath, const string& dizin) override {
        this->pImagePath = &imagePath;
        this->dizin = dizin;

        if (!resim) {
            // Timer gibi: ayrı thread ile simüle ettik
            thread yuklemeThread(&ProxyResim::ResimYukle, this);
            yuklemeThread.detach();
        }

        if (!resimYuklendi) {
            imagePath = "Yukleniyor.gif";
            cout << "[ProxyResim] Geçici yükleniyor resmi gösteriliyor: Yukleniyor.gif" << endl;
        }
    }

    ~ProxyResim() {
        delete resim;
    }
};

// Client
int main() {
    string ekranGosterilecekResim;

    ProxyResim proxy;
    cout << "--- İlk gösterim ---" << endl;
    proxy.Goster(ekranGosterilecekResim, "D:\\gercek_resim.jpg");

    // İlk başta "Yukleniyor.gif" gösterilecek
    cout << "Ekranda görünen: " << ekranGosterilecekResim << endl;

    // Biraz bekleyip gerçek resmin yüklenmesini simüle edelim
    this_thread::sleep_for(chrono::seconds(3));
    cout << "--- 3 saniye sonra ---" << endl;
    cout << "Ekranda görünen: " << ekranGosterilecekResim << endl;

    return 0;
}


//https://www.gencayyildiz.com/blog/c-proxy-design-patternproxy-tasarim-deseni/