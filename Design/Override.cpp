#include <iostream>


using namespace std;

class BaseClass{


    public:
        virtual int func(int a)
        {
            return a+1;
        }

};



class DerivedClass : public BaseClass{

    public:
        int func(int a) override
        {
            return a - 1;
        }
};



int main()
{
    DerivedClass d;
    BaseClass b;
    cout << b.func(5) << endl;
    cout << d.func(5) << endl;
}


//Output 
// 6
// 4


