#include <iostream>
#include <vector>
#include <string>

class Person {
public:
    std::string Name;
    std::string Surname;
};

class Database {
private:
    std::string state;

public:
    void Connect() {
        // ...
        std::cout << "Veritabanı bağlantısı sağlanmıştır." << std::endl;
    }

    void Disconnect() {
        // ...
        std::cout << "Veritabanı bağlantısı kesilmiştir." << std::endl;
    }

    void setState(const std::string& newState) {
        state = newState;
    }

    std::string getState() const {
        return state;
    }

    std::vector<Person> GetPersons() {
        return {
            {"Hilmi", "Celayir"},
            {"Mustafa", "Yildiz"},
            {"Cafer", "Muiddinoğlu"}
        };
    }
};

int main() {
    Database db;
    db.Connect();

    std::vector<Person> persons = db.GetPersons();
    for(const auto& person : persons) {
        std::cout << person.Name << " " << person.Surname << std::endl;
    }

    db.Disconnect();

    return 0;
}
