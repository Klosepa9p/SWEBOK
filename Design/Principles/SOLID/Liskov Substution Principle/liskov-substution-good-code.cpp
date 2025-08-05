#include <iostream>

// Soyut (abstract) sınıf: sadece MachineLearning
class Cloud {
public:
    virtual void MachineLearning() = 0;
    virtual ~Cloud() = default;
};

// "Interface" gibi davranan saf sanal sınıf
class ITranslatable {
public:
    virtual void Translate() = 0;
    virtual ~ITranslatable() = default;
};

// AWS: Cloud + ITranslatable
class AWS : public Cloud, public ITranslatable {
public:
    void Translate() override {
        std::cout << "AWS Translate" << std::endl;
    }
    void MachineLearning() override {
        std::cout << "AWS Machine Learning" << std::endl;
    }
};

// Azure: sadece Cloud
class Azure : public Cloud {
public:
    void MachineLearning() override {
        std::cout << "Azure Machine Learning" << std::endl;
    }
};

// Google: Cloud + ITranslatable
class Google : public Cloud, public ITranslatable {
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

    aws.MachineLearning();
    aws.Translate();

    azure.MachineLearning();

    google.MachineLearning();
    google.Translate();

    return 0;
}
