public class Order {
    public String id; // Özel alan public
    public double amount; // Özel alan public
    public Customer customer; // Özel alan public

    public Order(String id, double amount, Customer customer) {
        this.id = id;
        this.amount = amount;
        this.customer = customer;
    }
}

public class Customer {
    public String name; // Özel alan public
    public boolean isVIP; // Özel alan public

    public Customer(String name, boolean isVIP) {
        this.name = name;
        this.isVIP = isVIP;
    }
}

public class OrderProcessor {
    public void processOrder(Order order) {
        // Order ve Customer'ın iç detaylarına doğrudan erişim
        if (order.id == null || order.id.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }

        // Customer'ın iç detaylarına erişim
        if (order.customer.isVIP) {
            order.amount *= 0.9; // %10 indirim
        }

        order.amount += order.amount * 0.18; // %18 KDV

        // Veritabanı işlemi
        Database.saveOrder(order.id, order.amount);

        // E-posta gönderimi, Customer'ın iç detaylarına erişim
        String message = "Sayın " + order.customer.name + ", siparişiniz işlendi. Toplam: " + order.amount;
        EmailService.sendEmail(order.customer.name, "Sipariş Onayı", message);
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
Sorun: Yukarıdaki kodda, OrderProcessor sınıfı, Order ve Customer sınıflarının iç detaylarına (örneğin, order.id, order.customer.isVIP, order.customer.name) doğrudan erişiyor. Bu, Inappropriate Intimacy kokusuna neden oluyor:

- Order ve Customer sınıflarının alanları public, bu da kapsülleme ihlaline yol açıyor.
- OrderProcessor, Order ve Customer sınıflarının özel verilerine aşırı derecede bağımlı, bu da sıkı bağlanmaya neden oluyor.
- Customer sınıfının iç detaylarına erişim (örneğin, name ve isVIP), OrderProcessor'ın bu sınıfın yapısını bilmesini gerektiriyor.
*/