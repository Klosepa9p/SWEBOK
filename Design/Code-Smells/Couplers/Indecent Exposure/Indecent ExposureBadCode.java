public class Order {
    private String id; // Genel alan
    private double amount; // Genel alan
    private boolean isProcessed; // Genel alan

    public Order(String id, double amount) {
        this.id = id;
        this.amount = amount;
        this.isProcessed = false;
    }

    // Genel metod, iç mantığı açığa çıkarıyor
    void applyDiscount(boolean isVIP) {
        if (isVIP) {
            amount *= 0.9; // %10 indirim
        }
    }

    // Genel metod, iç mantığı açığa çıkarıyor
    void applyTax() {
        amount += amount * 0.18; // %18 KDV
    }

    // Order bilgilerini dışarıya kapalı tutmak için getter metodları
    String getId() {
        return id;
    }

    double getAmount() {
        return amount;
    }

    boolean isProcessed() {
        return isProcessed;
    }
}

public class OrderProcessor {
    public void processOrder(Order order, boolean isVIP) {
        // Order'ın iç detaylarına doğrudan erişim
        if (order.getId() == null || order.getId().isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }

        order.applyDiscount(isVIP);
        order.applyTax();
        // isProcessed alanına doğrudan erişim yerine, Order sınıfında bir metod ile güncelleme yapılabilir
        // order.isProcessed = true; 

        Database.saveOrder(order.getId(), order.getAmount());
        EmailService.sendEmail("customer@example.com", "Sipariş Onayı", 
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

/*
Sorun: Yukarıdaki kodda, Order sınıfı Indecent Exposure kokusuna sahip:

- id, amount ve isProcessed alanları public, bu da dışarıdan doğrudan erişime ve manipülasyona izin veriyor.
- applyDiscount ve applyTax metodları public, ancak bu metodlar sınıfın iç mantığını (indirim ve vergi hesaplama) açığa çıkarıyor ve dışarıdan çağrılmasına gerek yok.
- OrderProcessor, Order sınıfının iç detaylarına (id, amount, isProcessed) doğrudan erişiyor ve hatta isProcessed alanını doğrudan değiştiriyor, bu da kapsülleme ihlaline neden oluyor.
*/