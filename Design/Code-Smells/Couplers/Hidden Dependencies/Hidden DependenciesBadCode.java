public class OrderProcessor {
    public double processOrder(String orderId, double amount, boolean isVIP) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }

        // Gizli bağımlılık: Doğrudan Database nesnesi oluşturuluyor
        Database database = new Database();
        double finalAmount = amount;
        if (isVIP) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * 0.18; // %18 KDV

        // Gizli bağımlılık: Database sınıfına doğrudan erişim
        database.saveOrder(orderId, finalAmount);

        // Gizli bağımlılık: EmailService statik metodu
        EmailService.sendEmail("customer@example.com", "Sipariş Onayı", 
            "Siparişiniz işlendi: ID=" + orderId + ", Toplam=" + finalAmount);

        return finalAmount;
    }
}

class Database {
    public void saveOrder(String orderId, double amount) {
        System.out.println("Sipariş kaydedildi: ID=" + orderId + ", Tutar=" + amount);
    }
}

class EmailService {
    public static void sendEmail(String recipient, String subject, String message) {
        System.out.println("E-posta gönderildi: " + recipient + ", Konu: " + subject + ", Mesaj: " + message);
    }
}

/*
Sorun: Yukarıdaki kodda, OrderProcessor sınıfı gizli bağımlılıklar içeriyor:

- Database nesnesi, processOrder içinde doğrudan new anahtar kelimesiyle oluşturuluyor, bu da Database sınıfına sıkı bir bağımlılık yaratıyor.
- EmailService sınıfının statik sendEmail metoduna doğrudan erişiliyor, bu da başka bir gizli bağımlılık oluşturuyor.
- Bu bağımlılıklar, kodun test edilmesini zorlaştırıyor (örneğin, Database veya EmailService'i mock etmek mümkün değil).
- Bağımlılıklar açıkça belirtilmediği için, kodun hangi dış kaynaklara ihtiyaç duyduğu anlaşılmıyor.
*/