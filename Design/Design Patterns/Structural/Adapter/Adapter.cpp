#include <iostream>
#include <string>

using namespace std;

// Crypt interface
class Crypt {
public:
    virtual void encrypt(const string& text) = 0;
    virtual void decrypt(const string& text) = 0;
    virtual ~Crypt() = default;
};

// CryptA
class CryptA : public Crypt {
public:
    void encrypt(const string& text) override {
        cout << "#CryptA#encrypt()" << endl;
    }

    void decrypt(const string& text) override {
        cout << "#CryptA#decrypt()" << endl;
    }
};

// CryptB
class CryptB : public Crypt {
public:
    void encrypt(const string& text) override {
        cout << "#CryptB#encrypt()" << endl;
    }

    void decrypt(const string& text) override {
        cout << "#CryptB#decrypt()" << endl;
    }
};

// CodeX (Adaptee)
class CodeX {
public:
    void textToCode(const string& text) {
        cout << "#CodeX#textToCode()" << endl;
    }

    void codeToText(const string& text) {
        cout << "#CodeX#codeToText()" << endl;
    }
};

// CodeXAdapter
class CodeXAdapter : public Crypt {
private:
    CodeX* codeX;
public:
    CodeXAdapter(CodeX* codeX) : codeX(codeX) {}

    void encrypt(const string& text) override {
        codeX->textToCode(text);
    }

    void decrypt(const string& text) override {
        codeX->codeToText(text);
    }
};

int main() {
    Crypt* crypt;

    crypt = new CryptA();
    crypt->encrypt("Yusuf");
    crypt->decrypt("Metin");
    delete crypt;

    cout << "-------------" << endl;

    crypt = new CryptB();
    crypt->encrypt("Dilek");
    crypt->decrypt("Mehmet");
    delete crypt;

    cout << "-------------" << endl;

    CodeX* codeX = new CodeX();
    crypt = new CodeXAdapter(codeX);
    crypt->encrypt("Ahmet");
    crypt->decrypt("Acar");

    delete crypt;
    delete codeX;

    return 0;
}

/*
CodeXAdapter = Adapter sınıfı.

CodeX = Adaptee (mevcut sınıf).

CryptA ve CryptB = Normal concrete sınıflar

*/