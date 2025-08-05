public class Order {
    private final String orderId;
    private double amount;
    private final boolean isVIP;

    public Order(String orderId, double amount, boolean isVIP) {
        this.orderId = orderId;
        this.amount = amount;
        this.isVIP = isVIP;
    }

    public String getOrderId() { return orderId; }
    public double getAmount() { return amount; }
    public boolean isVIP() { return isVIP; }

    public void applyDiscount() {
        if (isVIP) {
            amount *= 0.9; // %10 indirim
        }
    }

    public void applyTax() {
        amount += amount * 0.18; // %18 KDV
    }
}

public class OrderService {
    private final Database database;
    private final EmailService emailService;

    public OrderService(Database database, EmailService emailService) {
        this.database = database;
        this.emailService = emailService;
    }

    public void processOrder(Order order) {
        order.applyDiscount();
        order.applyTax();
        database.saveOrder(order.getOrderId(), order.getAmount());
        String message = "Siparişiniz işlendi: ID=" + order.getOrderId() + ", Toplam=" + order.getAmount();
        emailService.sendEmail("customer@example.com", "Sipariş Onayı", message);
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
        OrderService orderService = new OrderService(database, emailService);

        Order order = new Order("123", 1000, true);
        orderService.processOrder(order);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Shotgun Surgery sorunu şu şekilde giderildi:

- Sorumluluk Birleştirme: Sipariş işleme mantığı (applyDiscount, applyTax), Order sınıfına taşındı, böylece indirim ve vergi gibi işlemler tek bir yerde toplandı.
- Sınıf Konsolidasyonu: OrderProcessor, TaxCalculator, OrderSaver ve EmailNotifier sınıfları kaldırılarak tüm sipariş işleme mantığı OrderService sınıfında birleştirildi. Bu, ilgili iş mantığını tek bir yerde tutuyor.
- Single Responsibility Principle: Order sınıfı, siparişin durumunu yönetiyor; OrderService ise iş akışını koordine ediyor. Her sınıf tek bir sorumluluğa odaklanıyor.
- Bağımlılık Enjeksiyonu: OrderService, Database ve EmailService bağımlılıklarını constructor aracılığıyla alarak esnekliği koruyor.
- Modülerlik: İndirim veya vergi kuralı değiştiğinde, yalnızca Order sınıfındaki ilgili metod güncelleniyor, diğer sınıflar etkilenmiyor.

Bu değişiklikler, kodun bakım kolaylığını, okunabilirliğini ve tutarlılığını artırdı. Tek bir değişikliğin çok sayıda yerde yapılmasını gerektiren durum ortadan kaldırılarak Shotgun Surgery code smell'i giderildi.
*/