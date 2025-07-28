
#include <iostream>
#include <algorithm>
#include <vector>
// Observer arayüzü
class Observer {
public:
    virtual void update(float temperature) = 0;
};

// Subject arayüzü
class Subject {
public:
    virtual void addObserver(Observer* o) = 0;
    virtual void removeObserver(Observer* o) = 0;
    virtual void notifyObservers() = 0;
};

// ConcreteSubject
class WeatherStation : public Subject {
private:
    std::vector<Observer*> observers;  // ✅ bu satır mutlaka olmalı
    float temperature;
public:
    void addObserver(Observer* o) override {
        observers.push_back(o);
    }
    void removeObserver(Observer* o) override {
        observers.erase(std::remove(observers.begin(), observers.end(), o), observers.end());
    }
    void setTemperature(float temp) {
        temperature = temp;
        notifyObservers();
    }
    void notifyObservers() override {
        for (Observer* o : observers) {
            o->update(temperature);
        }
    }
};

// ConcreteObserver
class Display : public Observer {
private:
    std::string name;
public:
    Display(const std::string& n) : name(n) {}
    void update(float temperature) override {
        std::cout << name << " displays temperature: " << temperature << "°C\n";
    }
};

int main() {
    WeatherStation station;

    Display display1("Phone");
    Display display2("Tablet");

    station.addObserver(&display1);
    station.addObserver(&display2);

    std::cout << "Temperature changed to 25°C:\n";
    station.setTemperature(25);

    std::cout << "\nTemperature changed to 30°C:\n";
    station.setTemperature(30);

    return 0;
}