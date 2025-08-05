#include <iostream>
#include <string>

// Soyutlama (arayüz)
class IMailServer {
public:
    virtual void Send(const std::string& to, const std::string& body) = 0;
    virtual ~IMailServer() = default;
};

// Somut implementasyonlar
class Gmail : public IMailServer {
public:
    void Send(const std::string& to, const std::string& body) override {
        std::cout << "Gmail ile mail gönderildi. Alıcı: " << to << ", İçerik: " << body << std::endl;
    }
};

class Yandex : public IMailServer {
public:
    void Send(const std::string& to, const std::string& body) override {
        std::cout << "Yandex ile mail gönderildi. Alıcı: " << to << ", İçerik: " << body << std::endl;
    }
};

class Hotmail : public IMailServer {
public:
    void Send(const std::string& to, const std::string& body) override {
        std::cout << "Hotmail ile mail gönderildi. Alıcı: " << to << ", İçerik: " << body << std::endl;
    }
};

// MailService artık soyutlamaya bağımlı
class MailService {
public:
    void SendMail(IMailServer& mailServer, const std::string& to, const std::string& body) {
        mailServer.Send(to, body);
    }
};

int main() {
    Gmail gmail;
    Yandex yandex;
    Hotmail hotmail;

    MailService service;

    service.SendMail(gmail, "ali@example.com", "Merhaba Gmail");
    service.SendMail(yandex, "veli@example.com", "Merhaba Yandex");
    service.SendMail(hotmail, "ayse@example.com", "Merhaba Hotmail");

    return 0;
}

/*
 Açıklama:

    MailService artık IMailServer arayüzüne bağımlı → somut sınıflara değil.

    Yeni bir mail servisi eklemek (ör: ProtonMail) için:

        Sadece IMailServer’ı implement eden yeni bir sınıf yazılır.

        MailService’te hiçbir değişiklik yapılmaz.

Böylece:

    Yüksek seviyeli modül (MailService) ve düşük seviyeli modül (Gmail, Yandex, Hotmail) soyutlamaya bağımlı olur.

    Dependency Inversion Principle (DIP) tam anlamıyla uygulanmış olur.
*/