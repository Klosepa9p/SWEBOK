#include <iostream>
#include <memory>

// Soyut ifade
class Expression {
public:
    virtual int interpret() const = 0;
    virtual ~Expression() = default;
};

// Terminal ifade: sabit sayı
class NumberExpression : public Expression {
private:
    int number;
public:
    NumberExpression(int num) : number(num) {}
    int interpret() const override {
        return number;
    }
};

// Non-terminal ifade: toplama
class AddExpression : public Expression {
private:
    std::unique_ptr<Expression> left;
    std::unique_ptr<Expression> right;
public:
    AddExpression(std::unique_ptr<Expression> l, std::unique_ptr<Expression> r)
        : left(std::move(l)), right(std::move(r)) {}
    int interpret() const override {
        return left->interpret() + right->interpret();
    }
};

int main() {
    // 5 + 10 + 20 ifadesini modelleyelim:
    // Önce (5 + 10)
    auto part1 = std::make_unique<AddExpression>(
        std::make_unique<NumberExpression>(5),
        std::make_unique<NumberExpression>(10)
    );

    // Sonra ((5 + 10) + 20)
    auto expression = std::make_unique<AddExpression>(
        std::move(part1),
        std::make_unique<NumberExpression>(20)
    );

    std::cout << "Sonuç: " << expression->interpret() << "\n";

    return 0;
}