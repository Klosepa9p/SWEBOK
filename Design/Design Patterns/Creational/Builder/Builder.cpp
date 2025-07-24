#include <iostream>
#include <string>

class Person {
private:
    std::string identityNumber;
    std::string name;
    std::string surname;
    int age;
    int gender;

    // private constructor
    Person(const std::string& identityNumber, const std::string& name,
           const std::string& surname, int age, int gender)
        : identityNumber(identityNumber), name(name),
          surname(surname), age(age), gender(gender) {}

public:
    // Nested Builder class
    class Builder {
    private:
        std::string identityNumber;
        std::string name;
        std::string surname;
        int age = 0;
        int gender = 0;

    public:
        Builder() = default;

        Builder& setIdentityNumber(const std::string& id) {
            identityNumber = id;
            return *this;
        }

        Builder& setName(const std::string& n) {
            name = n;
            return *this;
        }

        Builder& setSurname(const std::string& s) {
            surname = s;
            return *this;
        }

        Builder& setAge(int a) {
            age = a;
            return *this;
        }

        Builder& setGender(int g) {
            gender = g;
            return *this;
        }

        Person build() {
            return Person(identityNumber, name, surname, age, gender);
        }
    };

    // toString benzeri bir metot
    void print() const {
        std::cout << "Person{identityNumber='" << identityNumber
                  << "', name='" << name
                  << "', surname='" << surname
                  << "', age=" << age
                  << ", gender=" << gender
                  << "}" << std::endl;
    }
};

int main() {
    Person person = Person::Builder()
                        .setIdentityNumber("12345678901")
                        .setName("Ahmet")
                        .setSurname("Yılmaz")
                        .setAge(30)
                        .setGender(1)
                        .build();

    person.print();
    return 0;
}
