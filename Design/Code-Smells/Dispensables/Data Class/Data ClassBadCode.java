public class Order {
    public String id; // Genel alan
    public double amount; // Genel alan
    public boolean isVIP; // Genel alan

    public Order(String id, double amount, boolean isVIP) {
        this.id = id;
        this.amount = amount;
        this.isVIP = isVIP;
    }

    // Yalnızca getter/setter metodları
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public boolean isVIP() { return isVIP; }
    public void setVIP(boolean isVIP) { this.isVIP = isVIP; }
}

public class OrderProcessor {
    public void processOrder(Order order) {
        // Order sınıfının verilerine doğrudan erişim
        if (order.getId() == null || order.getId().isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }

        // İş mantığı OrderProcessor'da
        double finalAmount = order.getAmount();
        if (order.isVIP()) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * 0.18; // %18 KDV
        order.setAmount(finalAmount);

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
Sorun: Yukarıdaki kodda, Order sınıfı bir Data Class olarak davranıyor:

- Order sınıfı yalnızca veri (id, amount, isVIP) tutuyor ve anlamlı bir iş mantığı sunmuyor; sadece getter/setter metodları içeriyor.
- İş mantığı (doğrulama, indirim, vergi hesaplama), OrderProcessor sınıfında yer alıyor, bu da Order sınıfının verilerine bağımlı olmasına ve Feature Envy kokusuna yol açıyor.
- Order sınıfının public alanları ve setter metodları, kapsülleme ihlaline neden oluyor ve dışarıdan kontrolsüz değişikliklere izin veriyor.
*/