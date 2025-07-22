#include <iostream>
#include <string>
#include <stdexcept>

// Ortak arayüz: IBanka
class IBanka {
public:
    virtual bool ParaTransferi(int tutar, const std::string& hesapNo) = 0;
    virtual ~IBanka() = default;
};

// Garanti bankası
class Garanti : public IBanka {
private:
    std::string HesapNo;

public:
    void ParaGonder(int tutar) {
        // ...
        std::cout << "Garanti: " << tutar << " TL gönderildi." << std::endl;
    }

    bool ParaTransferi(int tutar, const std::string& hesapNo) override {
        try {
            HesapNo = hesapNo;
            ParaGonder(tutar);
            return true;
        } catch (...) {
            return false;
        }
    }
};

// Halkbank
class Halkbank : public IBanka {
private:
    std::string _hesapNo;

public:
    void GonderilecekHesapNo(const std::string& hesapNo) {
        _hesapNo = hesapNo;
        // ...
    }

    void Gonder(int tutar) {
        // ...
        std::cout << "Halkbank: " << tutar << " TL gönderildi." << std::endl;
    }

    bool ParaTransferi(int tutar, const std::string& hesapNo) override {
        try {
            GonderilecekHesapNo(hesapNo);
            Gonder(tutar);
            return true;
        } catch (...) {
            return false;
        }
    }
};


// ParaGonderici
class ParaGonderici {
public:
    bool Gonder(IBanka* banka, int tutar, const std::string& hesapNo) {
        return banka->ParaTransferi(tutar, hesapNo);
    }
};

// Örnek kullanım
int main() {
    ParaGonderici gonderici;

    Garanti garanti;
    Halkbank halkbank;

    gonderici.Gonder(&garanti, 1000, "GARANTI_HESAP_NO");
    gonderici.Gonder(&halkbank, 500, "HALKBANK_HESAP_NO");


}