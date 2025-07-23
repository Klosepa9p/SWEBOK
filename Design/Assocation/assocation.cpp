#include <iostream>
#include <string>
using namespace std;

class Student {
public:
    Student(string name) : name(name) {}

    void show() {
        cout << "Student name: " << name << endl;
    }

    string name;
};

class Teacher {
public:
    Teacher(string name) : name(name) {}

    void giveGrade(Student& s, int grade) {
        cout << "Teacher " << name << " gives grade " << grade 
             << " to student " << s.name << endl;
    }

    string name;
};

int main() {
    Student student1("Alice");
    Teacher teacher1("Mr. Smith");

    student1.show();
    teacher1.giveGrade(student1, 95);

    return 0;
}


/*
Teacher sınıfı, Student nesnesine bir fonksiyon aracılığıyla erişir.

Teacher ve Student birbirinden bağımsızdır; biri yok olsa bile diğeri varlığını sürdürebilir.

Bu, nesneler arasında düşük bağımlılıkla kurulan basit bir birlikteliktir (association).
*/