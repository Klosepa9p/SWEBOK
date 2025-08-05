public class Customer {
    private final String id;

    public Customer(String id) {
        this.id = id;
    }

    public String getId() { return id; }
}

public class OrderService {
    public void createOrder(String customerId, double amount) {
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz müşteri kimliği");
        }
        double finalAmount = amount;
        if (customerId.contains("VIP")) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * 0.18; // %18 KDV
        Database.saveOrder(customerId, finalAmount);
    }
}

class Database {
    public static void saveOrder(String customerId, double amount) {
        System.out.println("Sipariş kaydedildi: Müşteri ID=" + customerId + ", Tutar=" + amount);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        Customer customer = new Customer("VIP123");
        orderService.createOrder(customer.getId(), 1000);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Middle Man sorunu şu şekilde giderildi:

- Aracıyı Kaldır: Customer sınıfındaki placeOrder metodu ve OrderManager bağımlılığı kaldırıldı. İstemci, doğrudan OrderService ile iletişim kuruyor.
- Sorumluluk Netleştirme: Customer sınıfı, yalnızca müşteri bilgilerini (id) tutma sorumluluğunu üstleniyor; sipariş oluşturma mantığı OrderService sınıfına taşındı.
- Basitleştirme: Gereksiz yönlendirme katmanı kaldırılarak kod sadeleştirildi ve okunabilirlik artırıldı.
- Kapsülleme: Customer sınıfı, yalnızca gerekli arayüzü (getId) açığa çıkarıyor, böylece kapsülleme korunuyor.
- Modülerlik: OrderService, sipariş oluşturma mantığını tamamen kapsüller ve istemciler için net bir arayüz sunar.

Bu değişiklikler, kodun okunabilirliğini, bakım kolaylığını ve modülerliğini artırdı. Gereksiz aracı katmanı kaldırılarak Middle Man code smell'i ortadan kaldırıldı.
*/