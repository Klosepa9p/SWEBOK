public abstract class Vehicle {
    public abstract double getFuelConsumption();
    public abstract double getFuelCostPerLiter();

    public double calculateFuelCost(double distance) {
        return distance * getFuelConsumption() * getFuelCostPerLiter();
    }
}

public class Car extends Vehicle {
    private final double fuelConsumption;

    public Car(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public double getFuelCostPerLiter() {
        return 0.05; // Araba için litre başına 0.05 birim
    }
}

public class Truck extends Vehicle {
    private final double fuelConsumption;

    public Truck(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public double getFuelCostPerLiter() {
        return 0.08; // Kamyon için litre başına 0.08 birim
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car(10.0); // 10 litre/100km
        Vehicle truck = new Truck(20.0); // 20 litre/100km

        System.out.println("Araba yakıt maliyeti: " + car.calculateFuelCost(100));
        System.out.println("Kamyon yakıt maliyeti: " + truck.calculateFuelCost(100));
    }
}

/*

Açıklama: Düzeltilmiş kodda, Class Depends on Subclass sorunu şu şekilde giderildi:

Soyutlama: Vehicle sınıfı, soyut bir sınıf olarak yeniden düzenlendi ve alt sınıfların uygulaması gereken
getFuelConsumption ve getFuelCostPerLiter metodlarını tanımladı.

Polimorfizm: calculateFuelCost metodu, alt sınıfların detaylarını bilmeden polimorfizm aracılığıyla çalışır,
böylece instanceof kontrolleri kaldırıldı.

Bağımlılığı Tersine Çevirme: Üst sınıf, alt sınıfların spesifik türlerine bağımlı olmaktan çıktı;
bunun yerine soyut metodlara dayanıyor.

Open/Closed Principle: Yeni bir araç tipi eklendiğinde (örneğin, Motorcycle), sadece yeni bir alt sınıf yazmak yeterli;
Vehicle sınıfını değiştirmeye gerek yok.

Tutarlılık: Her alt sınıf, aynı arayüzü uygulayarak tutarlı bir davranış sergiler, bu da Liskov Substitution Principle'ı destekler.

Bu değişiklikler, kodun esnekliğini, bakım kolaylığını ve okunabilirliğini artırdı. Üst sınıfın alt sınıflara bağımlılığı
kaldırılarak Class Depends on Subclass code smell'i ortadan kaldırıldı.

*/

