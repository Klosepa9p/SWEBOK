#include <stdexcept>
#include <iostream>

using namespace std;


class Encapsulation{

    private:
        int data;

    public:
        Encapsulation(int data){setData(data);}

        int  getData() const{return data;}

        void setData(int data)
        {
            if(data > 0)
                this->data = data;
            else
                throw invalid_argument("Data must be bigger than 0 ...");
        }

        void UseData(Encapsulation &encap)
        {
            int result = encap.getData() + this->getData();
            cout << result << endl;
        }

};

int main()
{
    Encapsulation encap1;
    encap1.setData(5);
    Encapsulation encap2;
    encap2.setData(-1);

    encap1.UseData(encap2);

    cout << encap1.getData() << endl;
    cout << encap2.getData() << endl;
}