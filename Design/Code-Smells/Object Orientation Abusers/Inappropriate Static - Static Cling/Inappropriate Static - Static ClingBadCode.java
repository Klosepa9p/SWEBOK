public class PaymentService {
    // Statik değişken, global durum
    private static double taxRate = 0.18;
    private static Database database = new Database();

    // Statik metod, doğrudan veritabanına erişiyor
    public static void processPayment(String userId, double amount) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz kullanıcı kimliği");
        }

        // Sabit indirim
        double finalAmount = amount;
        if (UserValidator.isPremiumUser(userId)) {
            finalAmount *= 0.9; // %10 indirim
        }

        // Vergi ekleme
        finalAmount += finalAmount * taxRate;

        // Veritabanına kaydet
        database.savePayment(userId, finalAmount);
    }
}

class UserValidator {
    // Statik metod, kullanıcı durumunu kontrol ediyor
    public static boolean isPremiumUser(String userId) {
        // Sabit bir kontrol, gerçek bir veritabanı yerine
        return userId.contains("PREMIUM");
    }
}

class Database {
    public void savePayment(String userId, double amount) {
        System.out.println("Ödeme kaydedildi: Kullanıcı=" + userId + ", Tutar=" + amount);
    }
}

/*
Sorun: Yukarıdaki kodda, Inappropriate Static / Static Cling sorunu şu şekilde görülüyor:

PaymentService sınıfı, statik değişkenler (taxRate, database) ve statik metod (processPayment) kullanıyor,
bu da sınıfın global duruma bağımlı olmasına neden oluyor.

UserValidator sınıfındaki isPremiumUser metodu statik, bu da test etmeyi zorlaştırıyor ve polimorfizmi engelliyor.

Statik bağımlılıklar (database ve UserValidator), kodun modülerliğini ve test edilebilirliğini azaltıyor.

Global durum (taxRate), beklenmedik yan etkilere yol açabilir ve farklı ödeme türleri için özelleştirmeyi zorlaştırır.
*/