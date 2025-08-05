public class OrderProcessor {
    private final Database database;

    public OrderProcessor(Database database) {
        this.database = database;
    }

    public void processOrder(String orderId, double amount, boolean isVIP) {
        validateOrder(orderId);
        double finalAmount = calculateFinalAmount(amount, isVIP);
        database.saveOrder(orderId, finalAmount);
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

public class ReportGenerator {
    public String generateReport(String orderId, double amount) {
        return "Sipariş Raporu: ID=" + orderId + ", Toplam=" + amount;
    }
}

public class EmailNotifier {
    private final EmailService emailService;

    public EmailNotifier(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendOrderConfirmation(String orderId, double amount) {
        String message = "Sayın müşteri, siparişiniz işlendi. Toplam: " + amount;
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
        
        OrderProcessor processor = new OrderProcessor(database);
        ReportGenerator reportGenerator = new ReportGenerator();
        EmailNotifier notifier = new EmailNotifier(emailService);

        String orderId = "123";
        double amount = 1000;
        boolean isVIP = true;

        processor.processOrder(orderId, amount, isVIP);
        String report = reportGenerator.generateReport(orderId, amount);
        System.out.println(report);
        notifier.sendOrderConfirmation(orderId, amount);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Divergent Change sorunu şu şekilde giderildi:

- Sorumluluk Ayrımı: OrderManager sınıfı üç ayrı sınıfa bölündü: OrderProcessor (sipariş işleme),
  ReportGenerator (rapor oluşturma) ve EmailNotifier (e-posta bildirimi). Her sınıf, tek bir sorumluluğa odaklanıyor.
- Single Responsibility Principle: Her sınıf, yalnızca bir değişim nedenine sahip (örneğin, indirim kuralları için
  sadece OrderProcessor değişir).
- Bağımlılık Enjeksiyonu: OrderProcessor ve EmailNotifier, bağımlılıklarını (Database ve EmailService)
  constructor aracılığıyla alıyor, bu da esnekliği artırıyor.
- Modülerlik: Sorumluluklar ayrıldığı için, bir değişiklik (örneğin, rapor formatı güncellemesi) yalnızca ilgili
  sınıfı (ReportGenerator) etkiliyor.
- Anlamlı İsimlendirme: Sınıf ve metod isimleri, her birinin amacını açıkça ifade ediyor (örneğin, processOrder, generateReport).

Bu değişiklikler, kodun okunabilirliğini, bakım kolaylığını ve esnekliğini artırdı. Sınıfın farklı nedenlerle
değiştirilmesi gerekliliği kaldırılarak Divergent Change code smell'i ortadan kaldırıldı.
*/