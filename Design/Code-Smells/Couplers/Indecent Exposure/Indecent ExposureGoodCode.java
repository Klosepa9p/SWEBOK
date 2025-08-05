public class Order {
    private final String id;
    private double amount;
    private boolean isProcessed;

    public Order(String id, double amount) {
        this.id = id;
        this.amount = amount;
        this.isProcessed = false;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
    public boolean isProcessed() { return isProcessed; }

    private void applyDiscount(boolean isVIP) {
        if (isVIP) {
            amount *= 0.9; // %10 indirim
        }
    }

    private void applyTax() {
        amount += amount * 0.18; // %18 KDV
    }

    public void process(boolean isVIP) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }
        applyDiscount(isVIP);
        applyTax();
        isProcessed = true;
    }
}

public class OrderProcessor {
    private final Database database;
    private final EmailService emailService;

    public OrderProcessor(Database database, EmailService emailService) {
        this.database = database;
        this.emailService = emailService;
    }

    public void processOrder(Order order, boolean isVIP) {
        order.process(isVIP);
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
        
        Order order = new Order("123", 1000);
        processor.processOrder(order, true);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Indecent Exposure sorunu şu şekilde giderildi:

- Kapsülleme: Order sınıfının id, amount ve isProcessed alanları private yapıldı, yalnızca gerekli getter metodları (getId, getAmount, isProcessed) açığa çıkarıldı.
- İç Metodları Gizleme: applyDiscount ve applyTax metodları private yapıldı, böylece bu iç mantık dışarıdan erişilemez hale geldi.
- Sorumluluk Konsolidasyonu: Sipariş işleme mantığı, Order sınıfında yeni bir process metoduyla birleştirildi, böylece iç detaylar kontrol altında tutuldu.
- Bağımlılık Enjeksiyonu: OrderProcessor, Database ve EmailService bağımlılıklarını constructor aracılığıyla alıyor, bu da esnekliği koruyor.
- Law of Demeter: OrderProcessor, Order sınıfının iç detaylarına (id, amount, isProcessed) doğrudan erişmek yerine, yalnızca gerekli arayüzleri (getId, getAmount, process) kullanıyor.

Bu değişiklikler, kodun kapsüllemesini, modülerliğini ve bakım kolaylığını artırdı. Sınıfın iç detaylarının gereksiz yere açığa çıkarılması önlenerek Indecent Exposure code smell'i ortadan kaldırıldı.
*/
