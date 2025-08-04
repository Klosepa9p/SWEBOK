public class Vehicle {
    public double calculateFuelCost(Vehicle vehicle, double distance) {
        double fuelCost = 0;
        // Alt sınıflara bağımlı kontrol
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            fuelCost = distance * car.getFuelConsumption() * 0.05; // Araba için litre başına 0.05 birim
        } else if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle;
            fuelCost = distance * truck.getFuelConsumption() * 0.08; // Kamyon için litre başına 0.08 birim
        } else {
            throw new IllegalArgumentException("Bilinmeyen araç tipi");
        }
        return fuelCost;
    }
}

public class Car extends Vehicle {
    private double fuelConsumption;

    public Car(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
}

public class Truck extends Vehicle {
    private double fuelConsumption;

    public Truck(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
}

/*
Sorun: Yukarıdaki kodda, Vehicle üst sınıfı, alt sınıfları (Car ve Truck) doğrudan bilmekte ve onların spesifik
davranışlarına (getFuelConsumption) bağımlı. calculateFuelCost metodu, alt sınıfların türünü kontrol etmek için
instanceof kullanıyor ve her biri için farklı bir mantık uyguluyor. Bu, üst sınıfın alt sınıflara sıkı sıkıya bağlı
olmasına neden oluyor ve yeni bir araç tipi eklendiğinde Vehicle sınıfının değiştirilmesi gerekiyor. Bu, Open/Closed
Principle ve Liskov Substitution Principle ihlallerine yol açıyor.
*/