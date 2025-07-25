#include <iostream>
#include <string>
#include <unordered_map>

// Flyweight: Ortak özellikleri tutan sınıf
class CharacterFlyweight {
private:
    char symbol; // Ortak veri (intrinsic state)
    std::string font;
    int size;

public:
    CharacterFlyweight(char symbol, const std::string& font, int size)
        : symbol(symbol), font(font), size(size) {}

    void display(int positionX, int positionY) const {
        std::cout << "Karakter: " << symbol 
                  << ", Font: " << font 
                  << ", Boyut: " << size 
                  << ", Pozisyon: (" << positionX << "," << positionY << ")" 
                  << std::endl;
    }
};

// Flyweight Factory: Flyweight nesnelerini yönetir
class FlyweightFactory {
private:
    std::unordered_map<std::string, CharacterFlyweight*> flyweights;

    // Anahtar oluşturmak için yardımcı fonksiyon
    std::string createKey(char symbol, const std::string& font, int size) {
        return std::string(1, symbol) + "_" + font + "_" + std::to_string(size);
    }

public:
    ~FlyweightFactory() {
        for (auto& pair : flyweights) {
            delete pair.second;
        }
    }

    CharacterFlyweight* getFlyweight(char symbol, const std::string& font, int size) {
        std::string key = createKey(symbol, font, size);
        if (flyweights.find(key) == flyweights.end()) {
            flyweights[key] = new CharacterFlyweight(symbol, font, size);
        }
        return flyweights[key];
    }

    size_t getFlyweightCount() const {
        return flyweights.size();
    }
};

// Client: Metin editörü simülasyonu
class TextEditor {
private:
    FlyweightFactory flyweightFactory;

public:
    void addCharacter(char symbol, const std::string& font, int size, int x, int y) {
        CharacterFlyweight* flyweight = flyweightFactory.getFlyweight(symbol, font, size);
        flyweight->display(x, y);
    }

    size_t getFlyweightCount() const {
        return flyweightFactory.getFlyweightCount();
    }
};

int main() {
    TextEditor editor;

    // Aynı özelliklere sahip karakterler ekleniyor
    editor.addCharacter('A', "Arial", 12, 10, 20);
    editor.addCharacter('A', "Arial", 12, 15, 25); // Aynı Flyweight kullanılır
    editor.addCharacter('B', "Arial", 12, 20, 30);
    editor.addCharacter('A', "Times New Roman", 14, 25, 35); // Yeni Flyweight

    std::cout << "Toplam Flyweight sayısı: " << editor.getFlyweightCount() << std::endl;

    return 0;
}