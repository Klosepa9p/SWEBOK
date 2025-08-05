public class OrderProcessor {
    private final Database database;
    private final EmailService emailService;

    public OrderProcessor(Database database, EmailService emailService) {
        this.database = database;
        this.emailService = emailService;
    }

    public void processDomesticOrder(String orderId, double amount, boolean isVIP) {
        processOrder(orderId, amount, isVIP, 0.0);
    }

    public void processInternationalOrder(String orderId, double amount, boolean isVIP) {
        processOrder(orderId, amount, isVIP, 50.0);
    }

    private void processOrder(String orderId, double amount, boolean isVIP, double customsFee) {
        validateOrder(orderId);
        double finalAmount = calculateFinalAmount(amount, isVIP, customsFee);
        database.saveOrder(orderId, finalAmount);
        emailService.sendEmail("customer@example.com", "Sipariş Onayı", 
            "Siparişiniz işlendi: ID=" + orderId + ", Toplam=" + finalAmount);
    }

    private void validateOrder(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }
    }

    private double calculateFinalAmount(double amount, boolean isVIP, double customsFee) {
        double finalAmount = amount;
        if (isVIP) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * 0.18; // %18 KDV
        finalAmount += customsFee;
        return finalAmount;
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
        
        processor.processDomesticOrder("123", 1000, true);
        processor.processInternationalOrder("456", 1000, true);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Duplicate Code sorunu şu şekilde giderildi:

- Metodu Çıkar: Tekrar eden mantık (doğrulama, indirim, vergi hesaplama, kaydetme, e-posta gönderme), ortak bir processOrder metoduna taşındı.
- Parametre ile Esneklik: customsFee parametresi eklenerek uluslararası siparişlerin ek ücreti işlendi, böylece kod tekrarı önlendi.
- Sorumluluk Ayrımı: validateOrder ve calculateFinalAmount metodları, doğrulama ve hesaplama mantığını ayırarak okunabilirliği artırdı.
- Bağımlılık Enjeksiyonu: OrderProcessor, Database ve EmailService bağımlılıklarını constructor aracılığıyla alarak esnekliği korudu.
- DRY İlkesi: Tekrar eden kod birleştirilerek, değişikliklerin yalnızca tek bir yerde yapılması sağlandı (örneğin, indirim oranı değiştiğinde sadece calculateFinalAmount güncellenir).

Bu değişiklikler, kodun okunabilirliğini, bakım kolaylığını ve esnekliğini artırdı. Tekrar eden kod birleştirilerek Duplicate Code code smell'i ortadan kaldırıldı.
*/