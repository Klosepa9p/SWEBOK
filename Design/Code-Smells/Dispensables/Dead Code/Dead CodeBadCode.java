public class OrderProcessor {
    private final Database database;

    public OrderProcessor(Database database) {
        this.database = database;
    }

    public void processOrder(String orderId, double amount, boolean isVIP) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }

        double finalAmount = amount;
        if (isVIP) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * 0.18; // %18 KDV
        database.saveOrder(orderId, finalAmount);
    }

    /*
    Sorun: Yukarıdaki kodda, OrderProcessor sınıfı Dead Code içeriyor:

    - calculateOldDiscount metodu, eski bir indirim mantığını içeriyor ancak artık kullanılmıyor.
    - OLD_TAX_RATE sabiti, mevcut kodda hiçbir yerde referans alınmıyor.
    - logOrder metodu, hiçbir iş akışında çağrılmıyor. Bu ölü kodlar, kod tabanını şişiriyor, okunabilirliği azaltıyor ve bakım sürecini karmaşıklaştırıyor.
    */
}

class Database {
    public void saveOrder(String orderId, double amount) {
        System.out.println("Sipariş kaydedildi: ID=" + orderId + ", Tutar=" + amount);
    }
}