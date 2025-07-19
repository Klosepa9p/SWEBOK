#include <stdexcept>
#include <iostream>


using namespace std;

class Grand{

    private:
        int data;

    public:
        
        int  getData() const
        {
            return data;
        }

        void setData(int data)
        {
            if(data > 0)
                this->data = data;
            else
                throw invalid_argument("Data must be bigger than 0 ...");
        }

        void UseData(const Grand &grand) // upcasting
        {
            int result = grand.getData() + this->getData();
            cout << result << endl;
        }

};

class Father: public Grand{

};

class Child : public Father{

};



int main()
{
    Grand gr;
    gr.setData(5);

    Father fa; 
    fa.setData(4);

    Child ch;
    ch.setData(5);

    ch.UseData(ch);
}