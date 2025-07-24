class Shape {
public:
    virtual void draw() = 0;
};

class Circle : public Shape {
public:
    void draw() override { cout << "Drawing Circle"; }
};

class Square : public Shape {
public:
    void draw() override { cout << "Drawing Square"; }
};

class ShapeFactory {
public:
    static Shape* createShape(string type) {
        if (type == "circle")
            return new Circle();
        else if (type == "square")
            return new Square();
        else
            return nullptr;
    }
};





/*
- Shape somut sınıfından türeyen somut sınıfların sayısı fazla artarsa if/else blokları sayısı artar.
- if else blok sorunu Abstract Factory Design'da çözülür. 
*/