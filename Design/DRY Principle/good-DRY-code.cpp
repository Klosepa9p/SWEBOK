class Shape {
public:
    virtual int area() const = 0;  // Saf sanal fonksiyon
    void printArea() const {
        std::cout << "Area: " << area() << std::endl;
    }
};

class Rectangle : public Shape {
public:
    int width, height;

    Rectangle(int w, int h) : width(w), height(h) {}

    int area() const override {
        return width * height;
    }
};

class Square : public Shape {
public:
    int side;

    Square(int s) : side(s) {}

    int area() const override {
        return side * side;
    }
};

int main() {
    Rectangle rect(5, 10);
    rect.printArea();  // Area: 50

    Square sq(7);
    sq.printArea();    // Area: 49

    return 0;
}

/*
printArea() fonksiyonu tek bir yerde Shape sınıfında tanımlandı.

Alan hesaplama işlemi alt sınıflarda farklılaştı, ama yazdırma ortak kullanıldı.

Kod tekrarı önlendi → DRY ilkesi uygulandı.
*/