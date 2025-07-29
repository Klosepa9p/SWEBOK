class Visitor {
public:
    virtual void visit(class Book* book) = 0;
    virtual void visit(class Electronics* elec) = 0;
    virtual ~Visitor() = default;
};

// Element arayüzü
class Item {
public:
    virtual void accept(Visitor* visitor) = 0;
    virtual ~Item() = default;
};

// ConcreteElement: Book
class Book : public Item {
public:
    Book(double p) : price(p) {}
    double getPrice() const { return price; }
    void accept(Visitor* visitor) override {
        visitor->visit(this);
    }
private:
    double price;
};

// ConcreteElement: Electronics
class Electronics : public Item {
public:
    Electronics(double p) : price(p) {}
    double getPrice() const { return price; }
    void accept(Visitor* visitor) override {
        visitor->visit(this);
    }
private:
    double price;
};

// ConcreteVisitor: Toplam fiyat hesaplayan ziyaretçi
class PriceCalculator : public Visitor {
public:
    void visit(Book* book) override {
        total += book->getPrice();
    }
    void visit(Electronics* elec) override {
        total += elec->getPrice();
    }
    double getTotal() const { return total; }
private:
    double total = 0.0;
};

int main() {
    // Ürünleri oluştur
    std::vector<std::unique_ptr<Item>> cart;
    cart.emplace_back(std::make_unique<Book>(30.0));
    cart.emplace_back(std::make_unique<Electronics>(200.0));
    cart.emplace_back(std::make_unique<Book>(45.0));

    // Ziyaretçi oluştur
    PriceCalculator calculator;

    // Her ürünü ziyaret et
    for (auto& item : cart) {
        item->accept(&calculator);
    }

    std::cout << "Toplam fiyat: " << calculator.getTotal() << " TL\n";

    return 0;
}