public class OrderManager {
    // Sipariş işleme ve raporlama
    public void processOrder(String orderId, double amount, boolean isVIP) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }

        // İndirim uygulama
        double finalAmount = amount;
        if (isVIP) {
            finalAmount *= 0.9; // %10 indirim
        }

        // Vergi ekleme
        finalAmount += finalAmount * 0.18; // %18 KDV

        // Siparişi kaydet
        Database.saveOrder(orderId, finalAmount);

        // Rapor oluştur
        String report = "Sipariş Raporu: ID=" + orderId + ", Toplam=" + finalAmount;
        System.out.println(report);

        // E-posta bildirimi
        String emailMessage = "Sayın müşteri, siparişiniz işlendi. Toplam: " + finalAmount;
        EmailService.sendEmail("customer@example.com", "Sipariş Onayı", emailMessage);
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

Sorun: Yukarıdaki OrderManager sınıfı, birden fazla sorumluluğu üstleniyor:

- Sipariş işleme (doğrulama, indirim, vergi hesaplama, kaydetme).
- Rapor oluşturma.
- E-posta bildirimi gönderme.

Bu, Divergent Change kokusuna neden oluyor, çünkü sınıf, farklı nedenlerle (örneğin, yeni bir indirim kuralı,
rapor formatı değişikliği veya e-posta şablonu güncellemesi) sık sık değiştirilmek zorunda kalıyor.
Bu, bakım zorluğuna ve hata riskine yol açıyor.
*//*