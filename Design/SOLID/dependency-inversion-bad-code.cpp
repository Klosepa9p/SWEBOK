#include <iostream>
#include <string>

// Somut sınıf
class Gmail {
public:
    void Send(const std::string& mail) {
        std::cout << "Gmail ile mail gönderildi: " << mail << std::endl;
    }
};

class Yandex {
public:
    void SendMail(const std::string& mail, const std::string& to) {
        std::cout << "Yandex ile mail gönderildi, Alıcı: " << to << ", İçerik: " << mail << std::endl;
    }
};

class Hotmail {
public:
    void Send(const std::string& mail) {
        std::cout << "Hotmail ile mail gönderildi: " << mail << std::endl;
    }
};

// MailService somut sınıfa bağımlı (DIP ihlali)
class MailService {
public:
    void SendMail(Gmail& gmail) {
        gmail.Send("Merhaba, bu bir test mailidir.");
    }
};

int main() {
    Gmail gmail;
    MailService service;
    service.SendMail(gmail);

    // Diğer sağlayıcıları kullanmak için MailService'i değiştirmek gerekir.
    return 0;
}

// ✅ Açıklama:

//     MailService → doğrudan Gmail nesnesine bağımlı.

//     Eğer başka bir sağlayıcı (Yandex, Hotmail) kullanmak istersek, MailService kodunu değiştirmek zorundayız.

//     Bu durum Dependency Inversion Principle’a (DIP) aykırıdır.