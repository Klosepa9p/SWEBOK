public class OrderProcessor {
    public void processDomesticOrder(String orderId, double amount, boolean isVIP) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }

        // Tekrar eden kod: İndirim ve vergi hesaplama
        double finalAmount = amount;
        if (isVIP) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * 0.18; // %18 KDV

        Database.saveOrder(orderId, finalAmount);
        EmailService.sendEmail("customer@example.com", "Sipariş Onayı", 
            "Siparişiniz işlendi: ID=" + orderId + ", Toplam=" + finalAmount);
    }

    public void processInternationalOrder(String orderId, double amount, boolean isVIP) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }

        // Tekrar eden kod: İndirim ve vergi hesaplama
        double finalAmount = amount;
        if (isVIP) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * 0.18; // %18 KDV

        // Uluslararası sipariş için ek gümrük ücreti
        finalAmount += 50.0;

        Database.saveOrder(orderId, finalAmount);
        EmailService.sendEmail("customer@example.com", "Sipariş Onayı", 
            "Siparişiniz işlendi: ID=" + orderId + ", Toplam=" + finalAmount);
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

/*
Sorun: Yukarıdaki kodda, OrderProcessor sınıfında Duplicate Code mevcut:

- processDomesticOrder ve processInternationalOrder metodları, doğrulama, indirim, vergi hesaplama ve e-posta gönderme mantığını tekrar ediyor.
- Tek fark, processInternationalOrder metodunun ek bir gümrük ücreti eklemesi.
- Bu tekrar, kodu şişiriyor ve bir değişiklik gerektiğinde (örneğin, indirim oranı değiştiğinde) her iki metodu ayrı ayrı güncelleme gerektiriyor.
*/