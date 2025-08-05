public class OrderService {
    public void processOrder(String orderId, double amount, String customerEmail) {
        // Yüksek seviyeli iş mantığı: Sipariş doğrulama
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }

        // Düşük seviyeli detay: Veritabanı bağlantısı
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "pass");
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO orders (id, amount) VALUES (?, ?)");
        stmt.setString(1, orderId);
        stmt.setDouble(2, amount);
        stmt.executeUpdate();
        conn.close();

        // Yüksek seviyeli iş mantığı: İndirim uygulama
        double finalAmount = amount;
        if (customerEmail.contains("VIP")) {
            finalAmount *= 0.9; // %10 indirim
        }

        // Düşük seviyeli detay: E-posta gönderme
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.example.com");
        Session session = Session.getInstance(props);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("no-reply@example.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customerEmail));
        message.setSubject("Sipariş Onayı");
        message.setText("Siparişiniz işlendi. Toplam: " + finalAmount);
        Transport.send(message);
    }
}

/*

Sorun: Yukarıdaki OrderService sınıfındaki processOrder metodu, farklı soyutlama seviyelerini karıştırıyor:

- Yüksek seviyeli iş mantığı: Sipariş doğrulama ve indirim uygulama.
- Düşük seviyeli detaylar: Veritabanı bağlantısı (DriverManager, PreparedStatement) ve e-posta gönderme
  (MimeMessage, Transport).

Bu, Inconsistent Abstraction Levels kokusuna neden oluyor. Kodun okunması zor, bakım karmaşık ve test edilmesi güç,
çünkü yüksek seviyeli mantık düşük seviyeli detaylarla iç içe.

*/