/*
Bu örnekte:
- **Command**: Ortak arayüz.
- **ConcreteCommand**: Gerçek komut; alıcıya (Receiver) bir işlem yaptırır.
- **Receiver**: Komutu uygulayan sınıf (Televizyon).
- **Invoker**: Komutu çağıran sınıf (Kumanda).
*/

#include <iostream>
#include <memory>

// Command arayüzü
class Command {
public:
    virtual void execute() = 0;
    virtual ~Command() = default;
};

// Receiver: Gerçek işi yapan sınıf
class TV {
public:
    void turnOn() {
        std::cout << "TV turned ON.\n";
    }
    void turnOff() {
        std::cout << "TV turned OFF.\n";
    }
};

// ConcreteCommand: TV'yi aç
class TurnOnCommand : public Command {
private:
    TV* tv;
public:
    TurnOnCommand(TV* t) : tv(t) {}
    void execute() override {
        tv->turnOn();
    }
};

// ConcreteCommand: TV'yi kapat
class TurnOffCommand : public Command {
private:
    TV* tv;
public:
    TurnOffCommand(TV* t) : tv(t) {}
    void execute() override {
        tv->turnOff();
    }
};

// Invoker: Kumanda
class RemoteControl {
private:
    Command* command;
public:
    void setCommand(Command* c) {
        command = c;
    }
    void pressButton() {
        if (command) {
            command->execute();
        }
    }
};

int main() {
    TV tv;

    // Komutları oluştur
    TurnOnCommand turnOn(&tv);
    TurnOffCommand turnOff(&tv);

    RemoteControl remote;

    // TV'yi aç
    remote.setCommand(&turnOn);
    remote.pressButton();

    // TV'yi kapat
    remote.setCommand(&turnOff);
    remote.pressButton();

    return 0;
}
