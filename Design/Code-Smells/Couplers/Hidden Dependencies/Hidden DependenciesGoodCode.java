public interface OrderRepository {
    void saveOrder(String orderId, double amount);
}

public interface EmailNotifier {
    void sendEmail(String recipient, String subject, String message);
}

public class OrderProcessor {
    private final OrderRepository orderRepository;
    private final EmailNotifier emailNotifier;

    // Bağımlılık enjeksiyonu
    public OrderProcessor(OrderRepository orderRepository, EmailNotifier emailNotifier) {
        this.orderRepository = orderRepository;
        this.emailNotifier = emailNotifier;
    }

    public double processOrder(String orderId, double amount, boolean isVIP) {
        validateOrder(orderId);
        double finalAmount = calculateFinalAmount(amount, isVIP);
        orderRepository.saveOrder(orderId, finalAmount);
        emailNotifier.sendEmail("customer@example.com", "Sipariş Onayı", 
            "Siparişiniz işlendi: ID=" + orderId + ", Toplam=" + finalAmount);
        return finalAmount;
    }

    private void validateOrder(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }
    }

    private double calculateFinalAmount(double amount, boolean isVIP) {
        double finalAmount = amount;
        if (isVIP) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * 0.18; // %18 KDV
        return finalAmount;
    }
}

public class DatabaseOrderRepository implements OrderRepository {
    @Override
    public void saveOrder(String orderId, double amount) {
        System.out.println("Sipariş kaydedildi: ID=" + orderId + ", Tutar=" + amount);
    }
}

public class SmtpEmailNotifier implements EmailNotifier {
    @Override
    public void sendEmail(String recipient, String subject, String message) {
        System.out.println("E-posta gönderildi: " + recipient + ", Konu: " + subject + ", Mesaj: " + message);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        OrderRepository repository = new DatabaseOrderRepository();
        EmailNotifier notifier = new SmtpEmailNotifier();
        OrderProcessor processor = new OrderProcessor(repository, notifier);
        
        processor.processOrder("123", 1000, true);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Hidden Dependencies sorunu şu şekilde giderildi:

- Bağımlılık Enjeksiyonu: Database ve EmailService bağımlılıkları, OrderProcessor sınıfına constructor aracılığıyla enjekte edildi, böylece bağımlılıklar açık hale geldi.
- Arayüz Kullanımı: OrderRepository ve EmailNotifier arayüzleri tanımlanarak somut sınıflara (DatabaseOrderRepository, SmtpEmailNotifier) bağımlılık soyutlandı.
- Modülerlik: Bağımlılıklar açıkça belirtildiği için, farklı bir veritabanı veya e-posta servisi implementasyonu kolayca kullanılabilir.
- Test Kolaylığı: Arayüzler sayesinde, testlerde OrderRepository ve EmailNotifier için mock nesneler oluşturulabilir, bu da birim testlerini kolaylaştırır.
- Anlamlı İsimlendirme: Sınıf ve arayüz isimleri, bağımlılıkların amacını açıkça ifade ediyor (örneğin, OrderRepository yerine Database).

Bu değişiklikler, kodun test edilebilirliğini, modülerliğini ve bakım kolaylığını artırdı. Gizli bağımlılıklar açık hale getirilerek Hidden Dependencies code smell'i ortadan kaldırıldı.
*/