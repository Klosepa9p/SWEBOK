public interface Vehicle {
    double calculateSpeed();
    String render();
}

public class Car implements Vehicle {
    @Override
    public double calculateSpeed() {
        return 100.0; // Örnek hız
    }

    @Override
    public String render() {
        return "Araba render edildi";
    }
}

public class Truck implements Vehicle {
    @Override
    public double calculateSpeed() {
        return 80.0; // Örnek hız
    }

    @Override
    public String render() {
        return "Kamyon render edildi";
    }
}

public class VehicleManager {
    public void displayVehicle(Vehicle vehicle) {
        System.out.println("Araç: " + vehicle.calculateSpeed() + ", Render: " + vehicle.render());
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();
        
        Vehicle car = new Car();
        Vehicle truck = new Truck();
        
        manager.displayVehicle(car);
        manager.displayVehicle(truck);
    }
}

/*

Açıklama: Düzeltilmiş kodda, Parallel Inheritance Hierarchies sorunu şu şekilde giderildi:

- Sınıf Birleştirme: VehicleRenderer hiyerarşisi kaldırıldı ve render işlevselliği doğrudan Vehicle arayüzüne eklendi.
  Böylece, paralel hiyerarşilere gerek kalmadı.
- Sorumluluk Birleştirme: Her araç sınıfı (Car, Truck), hem hız hesaplama hem de render etme sorumluluğunu üstlendi,
  bu da bağımlılıkları azalttı.
- Polimorfizm: Vehicle arayüzü, tüm araçların ortak davranışlarını (calculateSpeed ve render) tanımladı, böylece
  VehicleManager herhangi bir instanceof kontrolüne ihtiyaç duymadan çalışabiliyor.
- Open/Closed Principle: Yeni bir araç türü (örneğin, Motorcycle) eklendiğinde, sadece yeni bir sınıf yazmak yeterli;
  VehicleManager veya başka bir hiyerarşi değiştirilmiyor.
- Basitleştirme: Kod, daha az sınıf ve daha az bağımlılıkla sadeleştirildi, bu da okunabilirliği ve bakım kolaylığını artırdı.

Bu değişiklikler, kodun modülerliğini, esnekliğini ve bakım kolaylığını artırdı. Paralel kalıtım hiyerarşileri kaldırılarak
Parallel Inheritance Hierarchies code smell'i ortadan kaldırıldı.

*/