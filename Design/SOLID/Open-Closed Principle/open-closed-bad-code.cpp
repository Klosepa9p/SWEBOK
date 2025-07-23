#include <iostream>
#include <string>

class Garanti {
public:
    std::string HesapNo;

    void ParaGonder(int tutar) {
        // ...
        std::cout << "Garanti bankasından " << tutar << " TL gönderildi." << std::endl;
    }
};

class Halkbank {
private:
    std::string _hesapNo;

public:
    void GonderilecekHesapNo(const std::string& hesapNo) {
        _hesapNo = hesapNo;
        // ...
    }

    void Gonder(int tutar) {
        // ...
        std::cout << "Halkban bankasından " << tutar << " TL gönderildi." << std::endl;
    }
};

class ParaGonderici {
public:
    void Gonder(int tutar) {
        // Garanti garanti;
        // garanti.HesapNo = "...";
        // garanti.ParaGonder(tutar);

        // Bankayı değiştirsek maliyetli oluyor bu hali ile.
        Halkban halkban;
        halkban.GonderilecekHesapNo("123");
        halkban.Gonder(tutar);
    }
};

int main() {
    ParaGonderici gonderici;
    gonderici.Gonder(500);
    return 0;
}
