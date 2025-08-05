public abstract class Vehicle {
    public abstract double calculateSpeed();
}

public class Car extends Vehicle {
    @Override
    public double calculateSpeed() {
        return 100.0; // Örnek hız
    }
}

public class Truck extends Vehicle {
    @Override
    public double calculateSpeed() {
        return 80.0; // Örnek hız
    }
}

public abstract class VehicleRenderer {
    public abstract String render();
}

public class CarRenderer extends VehicleRenderer {
    @Override
    public String render() {
        return "Araba render edildi";
    }
}

public class TruckRenderer extends VehicleRenderer {
    @Override
    public String render() {
        return "Kamyon render edildi";
    }
}

public class VehicleManager {
    public void displayVehicle(Vehicle vehicle, VehicleRenderer renderer) {
        if (vehicle instanceof Car && renderer instanceof CarRenderer) {
            System.out.println("Araç: " + vehicle.calculateSpeed() + ", Render: " + renderer.render());
        } else if (vehicle instanceof Truck && renderer instanceof TruckRenderer) {
            System.out.println("Araç: " + vehicle.calculateSpeed() + ", Render: " + renderer.render());
        } else {
            throw new IllegalArgumentException("Uyumsuz araç ve renderer");
        }
    }
}

/*
Sorun: Yukarıdaki kodda, iki paralel kalıtım hiyerarşisi var: Vehicle (Car, Truck) ve VehicleRenderer (CarRenderer, TruckRenderer).
Her yeni araç türü eklendiğinde (örneğin, Motorcycle), paralel olarak VehicleRenderer hiyerarşisine de bir MotorcycleRenderer
eklenmesi gerekiyor. Bu, Parallel Inheritance Hierarchies kokusuna neden oluyor:

- Vehicle ve VehicleRenderer hiyerarşileri birbirine sıkı sıkıya bağlı.
- VehicleManager, instanceof kontrolleriyle bu bağımlılığı yönetiyor, bu da kodu karmaşık ve kırılgan hale getiriyor.
- Yeni bir araç türü eklendiğinde, her iki hiyerarşide de değişiklik yapılması gerekiyor, bu da bakım zorluğuna yol açıyor.
*/