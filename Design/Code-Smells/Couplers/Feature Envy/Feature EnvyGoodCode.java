public class Customer {
    private final String id;
    private final String name;
    private final boolean isVIP;

    public Customer(String id, String name, boolean isVIP) {
        this.id = id;
        this.name = name;
        this.isVIP = isVIP;
    }

    public void validate() {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz müşteri kimliği");
        }
    }

    public double applyDiscount(double amount) {
        if (isVIP) {
            return amount * 0.9; // %10 indirim
        }
        return amount;
    }

    public String createOrderConfirmationMessage(double amount) {
        return "Sayın " + name + ", siparişiniz işlendi. Toplam: " + amount;
    }

    public String getId() { return id; }
}

public class OrderProcessor {
    private final Database database;
    private final EmailService emailService;

    public OrderProcessor(Database database, EmailService emailService) {
        this.database = database;
        this.emailService = emailService;
    }

    public double processOrder(Customer customer, double amount) {
        customer.validate();
        double finalAmount = customer.applyDiscount(amount);
        finalAmount += finalAmount * 0.18; // %18 KDV
        database.saveOrder(customer.getId(), finalAmount);
        String message = customer.createOrderConfirmationMessage(finalAmount);
        emailService.sendEmail(customer.getId(), "Sipariş Onayı", message);
        return finalAmount;
    }
}

class Database {
    public static void saveOrder(String customerId, double amount) {
        System.out.println("Sipariş kaydedildi: Müşteri ID=" + customerId + ", Tutar=" + amount);
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
        
        Customer customer = new Customer("VIP123", "Ahmet", true);
        processor.processOrder(customer, 1000);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Feature Envy sorunu şu şekilde giderildi:

- Metodu Taşı: Customer sınıfının verilerine (id, isVIP, name) bağlı mantık (doğrulama, indirim uygulama, bildirim mesajı oluşturma), Customer sınıfına taşındı (validate, applyDiscount, createOrderConfirmationMessage).
- Sorumluluk Ayrımı: Customer sınıfı, kendi verileriyle ilgili işlemleri üstlendi, böylece OrderProcessor yalnızca yüksek seviyeli iş akışını koordine ediyor.
- Law of Demeter: OrderProcessor, Customer sınıfının iç detaylarına (örneğin, id veya name alanlarına) doğrudan erişmek yerine, Customer sınıfının metodlarını kullanıyor.
- Bağımlılık Enjeksiyonu: OrderProcessor, Database ve EmailService bağımlılıklarını constructor aracılığıyla alıyor, bu da esnekliği koruyor.
- Modülerlik: Her sınıf, kendi sorumluluğuna odaklanıyor: Customer veri ve mantığını yönetiyor, OrderProcessor iş akışını koordine ediyor.

Bu değişiklikler, kodun modülerliğini, okunabilirliğini ve bakım kolaylığını artırdı. OrderProcessor'ın Customer sınıfının verilerine olan kıskançlığı kaldırılarak Feature Envy code smell'i ortadan kaldırıldı.
*/