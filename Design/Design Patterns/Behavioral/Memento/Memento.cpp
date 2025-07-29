#include <iostream>
#include <vector>
#include <memory>

// Memento: Editörün durumu
class Memento {
private:
    std::string state;
public:
    Memento(const std::string& s) : state(s) {}
    std::string getState() const { return state; }
};

// Originator: Editör
class Editor {
private:
    std::string text;
public:
    void write(const std::string& words) {
        text += words;
    }
    void show() const {
        std::cout << "Metin: " << text << "\n";
    }
    std::unique_ptr<Memento> save() const {
        return std::make_unique<Memento>(text);
    }
    void restore(const Memento* memento) {
        if (memento) {
            text = memento->getState();
        }
    }
};

// Caretaker: Undo geçmişini tutar
class History {
private:
    std::vector<std::unique_ptr<Memento>> mementos;
public:
    void push(std::unique_ptr<Memento> memento) {
        mementos.push_back(std::move(memento));
    }
    const Memento* pop() {
        if (mementos.empty()) return nullptr;
        const Memento* m = mementos.back().get();
        mementos.pop_back();
        return m;
    }
};

int main() {
    Editor editor;
    History history;

    editor.write("Merhaba ");
    history.push(editor.save());  // ilk kaydet

    editor.write("Dünya!");
    history.push(editor.save());  // ikinci kaydet

    editor.show(); // Merhaba Dünya!

    std::cout << "Undo işlemi yapılıyor...\n";
    editor.restore(history.pop());
    editor.show(); // Merhaba Dünya!

    std::cout << "Bir kez daha undo...\n";
    editor.restore(history.pop());
    editor.show(); // Merhaba 

    return 0;
}


/*

Bu örnekte:
- `Originator`: Editör; metni tutar ve memento oluşturur / geri yükler.
- `Memento`: Editörün kaydedilmiş durumunu temsil eder.
- `Caretaker`: Memento’ları yönetir ve geri yüklemesini sağlar.

*/