#include <iostream>
#include <stdexcept>

// Soyut (abstract) sınıf
class Cloud {
public:
    virtual void Translate() = 0;
    virtual void MachineLearning() = 0;
    virtual ~Cloud() = default;
};

// AWS sınıfı
class AWS : public Cloud {
public:
    void Translate() override {
        std::cout << "AWS Translate" << std::endl;
    }
    void MachineLearning() override {
        std::cout << "AWS Machine Learning" << std::endl;
    }
};

// Azure sınıfı
class Azure : public Cloud {
public:
    void Translate() override {
        throw std::logic_error("Not implemented yet!");
    }
    void MachineLearning() override {
        std::cout << "Azure Machine Learning" << std::endl;
    }
};

// Google sınıfı
class Google : public Cloud {
public:
    void Translate() override {
        std::cout << "Google Translate" << std::endl;
    }
    void MachineLearning() override {
        std::cout << "Google Machine Learning" << std::endl;
    }
};

// Örnek kullanım
int main() {
    AWS aws;
    Azure azure;
    Google google;

    aws.Translate();
    aws.MachineLearning();

    try {
        azure.Translate();  // Bu satır exception fırlatacak
    } catch (const std::logic_error& ex) {
        std::cout << "Azure Translate: Exception: " << ex.what() << std::endl;
    }

    azure.MachineLearning();

    google.Translate();
    google.MachineLearning();

    return 0;
}
