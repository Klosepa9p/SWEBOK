public class OrderService {
    private final OrderRepository orderRepository;
    private final EmailNotifier emailNotifier;

    public OrderService(OrderRepository orderRepository, EmailNotifier emailNotifier) {
        this.orderRepository = orderRepository;
        this.emailNotifier = emailNotifier;
    }

    public void processOrder(String orderId, double amount, String customerEmail) {
        validateOrder(orderId);
        double finalAmount = applyDiscount(amount, customerEmail);
        orderRepository.saveOrder(orderId, finalAmount);
        emailNotifier.sendOrderConfirmation(customerEmail, finalAmount);
    }

    private void validateOrder(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }
    }

    private double applyDiscount(double amount, String customerEmail) {
        if (customerEmail.contains("VIP")) {
            return amount * 0.9; // %10 indirim
        }
        return amount;
    }
}

public interface OrderRepository {
    void saveOrder(String orderId, double amount);
}

public class DatabaseOrderRepository implements OrderRepository {
    @Override
    public void saveOrder(String orderId, double amount) {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "pass");
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO orders (id, amount) VALUES (?, ?)");
        stmt.setString(1, orderId);
        stmt.setDouble(2, amount);
        stmt.executeUpdate();
        conn.close();
    }
}

public interface EmailNotifier {
    void sendOrderConfirmation(String customerEmail, double amount);
}

public class SmtpEmailNotifier implements EmailNotifier {
    @Override
    public void sendOrderConfirmation(String customerEmail, double amount) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.example.com");
        Session session = Session.getInstance(props);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("no-reply@example.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customerEmail));
        message.setSubject("Sipariş Onayı");
        message.setText("Siparişiniz işlendi. Toplam: " + amount);
        Transport.send(message);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        OrderRepository repository = new DatabaseOrderRepository();
        EmailNotifier notifier = new SmtpEmailNotifier();
        OrderService service = new OrderService(repository, notifier);

        service.processOrder("123", 1000, "vip@example.com");
    }
}

/*
Açıklama: Düzeltilmiş kodda, Inconsistent Abstraction Levels sorunu şu şekilde giderildi:

- Sorumluluk Ayrımı: Yüksek seviyeli iş mantığı (OrderService) düşük seviyeli detaylardan (DatabaseOrderRepository,
  SmtpEmailNotifier) ayrıldı.
- Arayüz Kullanımı: OrderRepository ve EmailNotifier arayüzleri tanımlanarak düşük seviyeli detaylar soyutlandı.
  Bu, farklı veritabanı veya e-posta implementasyonlarının kolayca değiştirilmesini sağlıyor.
- Metod Bölme: processOrder metodu, yüksek seviyeli işlemleri (validateOrder, applyDiscount) ayrı metodlara bölerek
  soyutlama seviyesini tutarlı hale getirdi.
- Bağımlılık Enjeksiyonu: OrderRepository ve EmailNotifier, constructor aracılığıyla enjekte edilerek OrderService
  sınıfının düşük seviyeli detaylara bağımlılığı kaldırıldı.
- Anlamlı İsimlendirme: Sınıf ve metod isimleri (örneğin, saveOrder, sendOrderConfirmation), soyutlama seviyesini
  yansıtacak şekilde seçildi.

Bu değişiklikler, kodun okunabilirliğini, bakım kolaylığını ve test edilebilirliğini artırdı. Yüksek ve düşük seviyeli
mantıklar ayrılarak Inconsistent Abstraction Levels code smell'i ortadan kaldırıldı.
*/