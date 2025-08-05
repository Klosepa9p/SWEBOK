import org.junit.Test;
import static org.junit.Assert.*;

public class OrderProcessorTest {
    @Test
    public void test1() {
        // Test verileri
        Order order = new Order();
        order.setId("123");
        order.setAmount(1000);
        order.setCustomer(new Customer("VIP123", true));
        Database db = new Database();
        
        // İşlem
        OrderProcessor processor = new OrderProcessor(db);
        double result = processor.processOrder(order.getId(), order.getAmount(), order.getCustomer().isVIP());
        
        // Doğrulama
        assertEquals(1080, result, 0.01); // VIP indirimi ve vergi sonrası
        assertTrue(db.isOrderSaved("123"));
    }
}

class Order {
    private String id;
    private double amount;
    private Customer customer;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}

class Customer {
    private String id;
    private boolean isVIP;

    public Customer(String id, boolean isVIP) {
        this.id = id;
        this.isVIP = isVIP;
    }

    public boolean isVIP() { return isVIP; }
}

class Database {
    public void saveOrder(String orderId, double amount) {
        // Simüle edilmiş veritabanı
    }

    public boolean isOrderSaved(String orderId) {
        return true; // Simüle edilmiş kontrol
    }
}

class OrderProcessor {
    private final Database database;

    public OrderProcessor(Database database) {
        this.database = database;
    }

    public double processOrder(String orderId, double amount, boolean isVIP) {
        if (orderId == null) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }
        double finalAmount = amount;
        if (isVIP) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * 0.18; // %18 KDV
        database.saveOrder(orderId, finalAmount);
        return finalAmount;
    }
}

/*
Sorun: Yukarıdaki test kodu, Poorly Written Tests kokusuna sahip:

- Belirsiz İsimlendirme: test1 ismi, testin neyi doğruladığını ifade etmiyor.
- Karmaşık Yapı: Test, birden fazla davranışı (indirim, vergi, veritabanı kaydı) tek bir testte doğruluyor, bu da tek sorumluluk ilkesine aykırı.
- Bağımlılıklar: Gerçek Database sınıfına bağımlı, bu da testin kırılganlığına ve yavaşlığına neden olabilir.
- Sihirli Sayılar: 1080 gibi sert kodlanmış değerler, testin mantığını belirsizleştiriyor.
- Yapısızlık: Test, AAA (Arrange-Act-Assert) desenine uygun değil ve okunması zor.
*/