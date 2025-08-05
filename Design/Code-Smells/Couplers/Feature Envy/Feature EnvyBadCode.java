public class Customer {
    private String id;
    private String name;
    private boolean isVIP;

    public Customer(String id, String name, boolean isVIP) {
        this.id = id;
        this.name = name;
        this.isVIP = isVIP;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public boolean isVIP() { return isVIP; }
}

public class OrderProcessor {
    public double processOrder(Customer customer, double amount) {
        // Customer sınıfının verilerine aşırı erişim
        if (customer.getId() == null || customer.getId().isEmpty()) {
            throw new IllegalArgumentException("Geçersiz müşteri kimliği");
        }

        double finalAmount = amount;
        if (customer.isVIP()) {
            finalAmount *= 0.9; // %10 indirim
        }

        finalAmount += finalAmount * 0.18; // %18 KDV

        // Customer bilgisiyle veritabanı işlemi
        Database.saveOrder(customer.getId(), finalAmount);

        // Customer bilgisiyle e-posta gönderimi
        String message = "Sayın " + customer.getName() + ", siparişiniz işlendi. Toplam: " + finalAmount;
        EmailService.sendEmail(customer.getId(), "Sipariş Onayı", message);

        return finalAmount;
    }
}

class Database {
    public static void saveOrder(String customerId, double amount) {
        System.out.println("Sipariş kaydedildi: Müşteri ID=" + customerId + ", Tutar=" + amount);
    }
}

class EmailService {
    public static void sendEmail(String recipient, String subject, String message) {
        System.out.println("E-posta gönderildi: " + recipient + ", Konu: " + subject + ", Mesaj: " + message);
    }
}

/*
Sorun: Yukarıdaki kodda, OrderProcessor sınıfındaki processOrder metodu, Customer sınıfının verilerine (getId, isVIP, getName) aşırı derecede erişiyor ve bu verilerle mantık yürütüyor. Bu, Feature Envy kokusuna neden oluyor:

- OrderProcessor, Customer sınıfının iç detaylarına (örneğin, id, name, isVIP) bağımlı ve bu verilerle işlemler yapıyor.
- Sipariş işleme mantığı, müşteri bilgilerine sıkı sıkıya bağlı, bu da Customer sınıfında yapılacak bir değişikliğin OrderProcessor'ı etkilemesine neden oluyor.
- Kod, Customer sınıfının sorumluluklarını (doğrulama, indirim uygulama, bildirim oluşturma) üstleniyor, bu da sınıfların sorumluluklarının karışmasına yol açıyor.
*/