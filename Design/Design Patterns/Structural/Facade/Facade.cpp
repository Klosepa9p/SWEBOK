#include <iostream>
#include <string>

enum class Renkler {
    Kirmizi,
    Mavi,
    Mor,
    Yesil,
    Sari
};

// IskeletOlusturu sınıfı
class IskeletOlusturu {
public:
    int x;
    int y;
    bool z;
};

// MotorOlusturucu sınıfı
class MotorOlusturucu {
public:
    int x;
    int y;
    bool z;
};

// Araba sınıfı
class Araba {
public:
    Araba(const IskeletOlusturu& iskelet, const MotorOlusturucu& motor, Renkler renk) {
        std::cout << "Iskelet x = " << iskelet.x << std::endl;
        std::cout << "Iskelet y = " << iskelet.y << std::endl;
        std::cout << "Iskelet z = " << (iskelet.z ? "true" : "false") << std::endl;
        std::cout << "Motor x = " << motor.x << std::endl;
        std::cout << "Motor y = " << motor.y << std::endl;
        std::cout << "Motor z = " << (motor.z ? "true" : "false") << std::endl;
        std::cout << "Renk = " << RenkToString(renk) << std::endl;
    }

private:
    std::string RenkToString(Renkler renk) {
        switch (renk) {
            case Renkler::Kirmizi: return "Kirmizi";
            case Renkler::Mavi:    return "Mavi";
            case Renkler::Mor:     return "Mor";
            case Renkler::Yesil:   return "Yesil";
            case Renkler::Sari:    return "Sari";
            default: return "Bilinmeyen";
        }
    }
};

// ArabaOlusturucu sınıfı
class ArabaOlusturucu {
public:
    IskeletOlusturu iskelet;
    MotorOlusturucu motor;

    ArabaOlusturucu(const IskeletOlusturu& iskelet, const MotorOlusturucu& motor)
        : iskelet(iskelet), motor(motor) {}

    Araba Olustur(Renkler renk) {
        return Araba(iskelet, motor, renk);
    }
};

// FacadeUretici sınıfı
class FacadeUretici {
public:
    FacadeUretici() {
        iskelet.x = 3;
        iskelet.y = 5;
        iskelet.z = true;

        motor.x = 2;
        motor.y = 4;
        motor.z = false;

        olustur = new ArabaOlusturucu(iskelet, motor);
    }

    ~FacadeUretici() {
        delete olustur;
    }

    void ArabaUret() {
        Araba uretilenAraba = olustur->Olustur(Renkler::Kirmizi);
    }

private:
    IskeletOlusturu iskelet;
    MotorOlusturucu motor;
    ArabaOlusturucu* olustur;
};

int main() {
    FacadeUretici uretici;
    uretici.ArabaUret();
    return 0;
}
