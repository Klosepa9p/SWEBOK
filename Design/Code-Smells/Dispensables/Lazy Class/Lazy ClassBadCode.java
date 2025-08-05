public class Order {
    private final String id;
    private final double amount;

    public Order(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
}

// Lazy Class: Yalnızca doğrulama yapan gereksiz bir sınıf
public class OrderValidator {
    public boolean isValid(Order order) {
        return order.getId() != null && !order.getId().isEmpty();
    }
}

public class OrderProcessor {
    private final Database database;
    private final OrderValidator validator;

    public OrderProcessor(Database database, OrderValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public void processOrder(Order order, boolean isVIP) {
        // OrderValidator yalnızca doğrulama için kullanılıyor
        if (!validator.isValid(order)) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }

        double finalAmount = order.getAmount();
        if (isVIP) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * 0.18; // %18 KDV

        database.saveOrder(order.getId(), finalAmount);
    }
}

class Database {
    public static void saveOrder(String orderId, double amount) {
        System.out.println("Sipariş kaydedildi: ID=" + orderId + ", Tutar=" + amount);
    }
}

/*
Sorun: Yukarıdaki kodda, OrderValidator sınıfı bir Lazy Class örneğidir:

- OrderValidator, yalnızca tek bir metod (isValid) içeriyor ve bu metod basit bir doğrulama yapıyor.
- Bu işlevsellik, kolayca Order veya OrderProcessor sınıfına taşınabilir, ancak ayrı bir sınıf olarak tutulması kod tabanını gereksiz yere karmaşıklaştırıyor.
- OrderValidator sınıfı, anlamlı bir sorumluluk taşımıyor ve bakım yükü ekliyor.
*/