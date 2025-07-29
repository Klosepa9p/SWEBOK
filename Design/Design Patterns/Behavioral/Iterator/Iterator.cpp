#include <iostream>
#include <vector>
#include <memory>
#include <string>

// Iterator arayüzü
class Iterator {
public:
    virtual bool hasNext() = 0;
    virtual std::string next() = 0;
    virtual ~Iterator() = default;
};

// Aggregate arayüzü
class BookCollection {
public:
    virtual std::unique_ptr<Iterator> createIterator() = 0;
    virtual ~BookCollection() = default;
};

// ConcreteAggregate: Kitap koleksiyonu
class ConcreteBookCollection : public BookCollection {
private:
    std::vector<std::string> books;
public:
    void addBook(const std::string& book) {
        books.push_back(book);
    }
    std::unique_ptr<Iterator> createIterator() override;

    // Iterator'ın koleksiyona erişebilmesi için friend yapabiliriz,
    // veya getBooks() gibi bir metod da ekleyebiliriz:
    const std::vector<std::string>& getBooks() const {
        return books;
    }
};

// ConcreteIterator
class BookIterator : public Iterator {
private:
    const std::vector<std::string>& books;
    size_t index = 0;
public:
    BookIterator(const std::vector<std::string>& b) : books(b) {}
    bool hasNext() override {
        return index < books.size();
    }
    std::string next() override {
        return books[index++];
    }
};

// Iterator'ı üret
std::unique_ptr<Iterator> ConcreteBookCollection::createIterator() {
    return std::make_unique<BookIterator>(books);
}

int main() {
    ConcreteBookCollection library;
    library.addBook("Design Patterns");
    library.addBook("Clean Code");
    library.addBook("Effective C++");

    auto it = library.createIterator();

    std::cout << "Kitaplar:\n";
    while (it->hasNext()) {
        std::cout << "- " << it->next() << "\n";
    }

    return 0;
}