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
}

class Database {
    public void saveOrder(String orderId, double amount) {
        System.out.println("Sipariş kaydedildi: ID=" + orderId + ", Tutar=" + amount);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        OrderProcessor processor = new OrderProcessor(database);
        
        processor.processOrder("123", 1000, true);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Dead Code sorunu şu şekilde giderildi:

- Ölü Kodu Kaldır: calculateOldDiscount metodu, OLD_TAX_RATE sabiti ve logOrder metodu kod tabanından tamamen silindi, çünkü hiçbir yerde kullanılmıyorlardı.
- Sadeleştirme: Kod tabanı, yalnızca aktif iş mantığını içerecek şekilde sadeleştirildi, bu da okunabilirliği artırdı.
- Kapsülleme Korundu: Aktif kod, mevcut kapsülleme ve sorumluluk dağılımını korudu.
- Bakım Kolaylığı: Ölü kodun kaldırılması, kod tabanının boyutunu küçülttü ve gelecekteki bakım süreçlerini kolaylaştırdı.
- Test Kapsamı: Ölü kod için yazılmış olası testler de kaldırılabilir, böylece test süreci daha verimli hale gelir.

Bu değişiklikler, kodun okunabilirliğini, bakım kolaylığını ve verimliliğini artırdı. Kullanılmayan kod parçaları kaldırılarak Dead Code code smell'i ortadan kaldırıldı.
*/