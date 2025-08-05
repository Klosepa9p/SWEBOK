public class Order {
    private final String id;
    private final double amount;

    public Order(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }

    public void validate() {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }
    }
}

public class OrderProcessor {
    private final Database database;

    public OrderProcessor(Database database) {
        this.database = database;
    }

    public void processOrder(Order order, boolean isVIP) {
        order.validate();
        double finalAmount = order.getAmount();
        if (isVIP) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * 0.18; // %18 KDV
        database.saveOrder(order.getId(), finalAmount);
    }
}

class Database {
    public static void saveOrder(String orderId, double amount) {
        System.out.println("Sipariş kaydedildi: ID=" + orderId + ", Tutar=" + amount);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        OrderProcessor processor = new OrderProcessor(database);
        
        Order order = new Order("123", 1000);
        processor.processOrder(order, true);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Lazy Class sorunu şu şekilde giderildi:

- Sınıfı Kaldır: OrderValidator sınıfı tamamen kaldırıldı ve doğrulama mantığı Order sınıfına taşındı (validate metodu).
- Sorumluluk Birleştirme: Doğrulama işlemi, Order sınıfının kendi verileriyle ilgili bir sorumluluğu olarak tanımlandı, böylece ayrı bir sınıf gereksiz hale geldi.
- Sadeleştirme: Kod tabanı, gereksiz bir sınıfın kaldırılmasıyla küçültüldü ve okunabilirlik artırıldı.
- Kapsülleme: Order sınıfı, kendi doğrulama mantığını kapsülleyerek daha anlamlı bir sorumluluk üstlendi.
- Bağımlılık Azaltma: OrderProcessor, artık yalnızca Database bağımlılığına sahip, bu da bağımlılık yönetimini sadeleştirdi.

Bu değişiklikler, kodun okunabilirliğini, bakım kolaylığını ve modülerliğini artırdı. Gereksiz sınıf kaldırılarak Lazy Class code smell'i ortadan kaldırıldı.
*/