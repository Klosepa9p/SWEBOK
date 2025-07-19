#include <iostream>

class Father
{
    public:
        virtual void run() const
        {
            std::cout << "Father running..." << std::endl;
        }
};

class Child : public Father
{

    public:
        void run() const override 
        {
            std::cout << "Child running..." << std::endl;
        }

};

int main()
{
    Child c;
    Father f = (Child)c;//Child nesnesini Father nesnesine atadık. Father run() fonksiyonunu çalıştırdı.upcasting 

    f.run();
    c.run();
}





