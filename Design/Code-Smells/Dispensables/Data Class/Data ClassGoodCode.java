public class Order {
    private final String id;
    private double amount;
    private final boolean isVIP;

    public Order(String id, double amount, boolean isVIP) {
        this.id = id;
        this.amount = amount;
        this.isVIP = isVIP;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }

    public void validate() {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }
    }

    public void applyDiscount() {
        if (isVIP) {
            amount *= 0.9; // %10 indirim
        }
    }

    public void applyTax() {
        amount += amount * 0.18; // %18 KDV
    }
}

public class OrderProcessor {
    private final Database database;
    private final EmailService emailService;

    public OrderProcessor(Database database, EmailService emailService) {
        this.database = database;
        this.emailService = emailService;
    }

    public void processOrder(Order order) {
        order.validate();
        order.applyDiscount();
        order.applyTax();
        database.saveOrder(order.getId(), order.getAmount());
        emailService.sendEmail("customer@example.com", "Sipariş Onayı", 
            "Siparişiniz işlendi: ID=" + order.getId() + ", Toplam=" + order.getAmount());
    }
}

class Database {
    public static void saveOrder(String orderId, double amount) {
        System.out.println("Sipariş kaydedildi: ID=" + orderId + ", Tutar=" + amount);
    }
}

class EmailService {
    public static void sendEmail(String recipient, String subject, String message) {
        System.out.println("E-posta gönderildi: " + recipient + ", Konu: " + subject + ", Mesaj: " + message);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        EmailService emailService = new EmailService();
        OrderProcessor processor = new OrderProcessor(database, emailService);
        
        Order order = new Order("123", 1000, true);
        processor.processOrder(order);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Data Class sorunu şu şekilde giderildi:

- Davranış Ekle: Order sınıfına, veriyle ilgili iş mantığı eklendi (validate, applyDiscount, applyTax). Böylece sınıf, yalnızca veri tutmaktan öteye geçti ve anlamlı bir sorumluluk üstlendi.
- Kapsülleme: id, amount ve isVIP alanları private yapıldı ve setter metodları kaldırılarak kontrolsüz erişim önlendi.
- Metodu Taşı: Doğrulama, indirim ve vergi hesaplama mantığı, OrderProcessor'dan Order sınıfına taşındı, böylece Order sınıfı kendi verileriyle ilgili işlemleri yönetiyor.
- Sorumluluk Ayrımı: Order sınıfı, kendi verileriyle ilgili mantığı kapsüllerken, OrderProcessor yüksek seviyeli iş akışını koordine ediyor.
- Bağımlılık Enjeksiyonu: OrderProcessor, Database ve EmailService bağımlılıklarını constructor aracılığıyla alıyor, bu da esnekliği koruyor.

Bu değişiklikler, kodun kapsüllemesini, modülerliğini ve bakım kolaylığını artırdı. Order sınıfının yalnızca veri tutma rolünden kurtularak anlamlı bir işlevsellik kazanmasıyla Data Class code smell'i ortadan kaldırıldı.
*/
