#include <iostream>

class Rectangle {
public:
    int width, height;

    Rectangle(int w, int h) : width(w), height(h) {}

    void printArea() {
        std::cout << "Area: " << width * height << std::endl;
    }
};

class Square {
public:
    int side;

    Square(int s) : side(s) {}

    void printArea() {
        std::cout << "Area: " << side * side << std::endl;
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
Rectangle ve Square sınıflarında alan hesaplama ve yazdırma işlemi ayrı ayrı yazılmış.

Kod tekrarı var → DRY ihlali.
*/