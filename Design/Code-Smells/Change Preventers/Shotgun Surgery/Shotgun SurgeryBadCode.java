public class Order {
    private String orderId;
    private double amount;
    private boolean isVIP;

    public Order(String orderId, double amount, boolean isVIP) {
        this.orderId = orderId;
        this.amount = amount;
        this.isVIP = isVIP;
    }

    public String getOrderId() { return orderId; }
    public double getAmount() { return amount; }
    public boolean isVIP() { return isVIP; }
}

public class OrderProcessor {
    public void applyDiscount(Order order) {
        if (order.isVIP()) {
            order.amount *= 0.9; // %10 indirim
        }
    }
}

public class TaxCalculator {
    public void applyTax(Order order) {
        order.amount += order.getAmount() * 0.18; // %18 KDV
    }
}

public class OrderSaver {
    public void saveOrder(Order order) {
        Database.saveOrder(order.getOrderId(), order.getAmount());
    }
}

public class EmailNotifier {
    public void sendConfirmation(Order order) {
        String message = "Siparişiniz işlendi: ID=" + order.getOrderId() + ", Toplam=" + order.getAmount();
        EmailService.sendEmail("customer@example.com", "Sipariş Onayı", message);
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
Sorun: Yukarıdaki kodda, bir siparişin işlenmesiyle ilgili mantık (applyDiscount, applyTax, saveOrder, sendConfirmation)
farklı sınıflara dağılmış durumda. Örneğin, VIP indirimi kuralını değiştirmek istediğinizde, OrderProcessor sınıfını
güncellemeniz gerekir, ancak bu değişiklik diğer sınıfları da etkileyebilir (örneğin, TaxCalculator veya EmailNotifier).
Bu, Shotgun Surgery kokusuna neden oluyor, çünkü tek bir iş mantığı değişikliği (örneğin, indirim oranı) birden fazla
sınıfta küçük değişiklikler yapılmasını gerektiriyor.
*/