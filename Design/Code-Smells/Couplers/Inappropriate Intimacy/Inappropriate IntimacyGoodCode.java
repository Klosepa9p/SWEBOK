public class Order {
    private final String id;
    private double amount;
    private final Customer customer;

    public Order(String id, double amount, Customer customer) {
        this.id = id;
        this.amount = amount;
        this.customer = customer;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }

    public void applyDiscount() {
        if (customer.isVIP()) {
            amount *= 0.9; // %10 indirim
        }
    }

    public void applyTax() {
        amount += amount * 0.18; // %18 KDV
    }

    public String createConfirmationMessage() {
        return customer.createConfirmationMessage(amount);
    }
}

public class Customer {
    private final String name;
    private final boolean isVIP;

    public Customer(String name, boolean isVIP) {
        this.name = name;
        this.isVIP = isVIP;
    }

    public boolean isVIP() { return isVIP; }

    public String createConfirmationMessage(double amount) {
        return "Sayın " + name + ", siparişiniz işlendi. Toplam: " + amount;
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
        if (order.getId() == null || order.getId().isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }

        order.applyDiscount();
        order.applyTax();
        database.saveOrder(order.getId(), order.getAmount());
        emailService.sendEmail("customer@example.com", "Sipariş Onayı", order.createConfirmationMessage());
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
        
        Customer customer = new Customer("Ahmet", true);
        Order order = new Order("123", 1000, customer);
        processor.processOrder(order);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Inappropriate Intimacy sorunu şu şekilde giderildi:

- Kapsülleme: Order ve Customer sınıflarının alanları private yapıldı ve yalnızca gerekli public metodlar (örneğin, getId, isVIP) açığa çıkarıldı.
- Metodu Taşı: Customer ve Order sınıflarının verilerine bağımlı mantık (indirim uygulama, bildirim mesajı oluşturma), ilgili sınıflara taşındı (applyDiscount, createConfirmationMessage).
- Law of Demeter: OrderProcessor, Customer sınıfının iç detaylarına (name, isVIP) doğrudan erişmek yerine, Order sınıfının metodlarını kullanıyor.
- Sorumluluk Ayrımı: Order sınıfı, indirim ve vergi gibi kendi mantığını yönetiyor; Customer sınıfı, bildirim mesajı oluşturmayı üstleniyor.
- Bağımlılık Enjeksiyonu: OrderProcessor, Database ve EmailService bağımlılıklarını constructor aracılığıyla alıyor, bu da esnekliği koruyor.

Bu değişiklikler, kodun modülerliğini, kapsüllemesini ve bakım kolaylığını artırdı. Sınıflar arasındaki uygunsuz yakınlık kaldırılarak Inappropriate Intimacy code smell'i ortadan kaldırıldı.
*/

