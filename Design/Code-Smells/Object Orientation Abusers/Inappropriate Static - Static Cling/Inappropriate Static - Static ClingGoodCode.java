public class PaymentService {
    private final double taxRate;
    private final Database database;
    private final UserValidator userValidator;

    // Bağımlılık enjeksiyonu ile esneklik
    public PaymentService(double taxRate, Database database, UserValidator userValidator) {
        this.taxRate = taxRate;
        this.database = database;
        this.userValidator = userValidator;
    }

    public void processPayment(String userId, double amount) {
        validateUserId(userId);
        double finalAmount = calculateFinalAmount(userId, amount);
        database.savePayment(userId, finalAmount);
    }

    private void validateUserId(String userId) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz kullanıcı kimliği");
        }
    }

    private double calculateFinalAmount(String userId, double amount) {
        double finalAmount = amount;
        if (userValidator.isPremiumUser(userId)) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * taxRate; // Vergi ekleme
        return finalAmount;
    }
}

public interface UserValidator {
    boolean isPremiumUser(String userId);
}

public class DefaultUserValidator implements UserValidator {
    @Override
    public boolean isPremiumUser(String userId) {
        return userId.contains("PREMIUM");
    }
}

public class Database {
    public void savePayment(String userId, double amount) {
        System.out.println("Ödeme kaydedildi: Kullanıcı=" + userId + ", Tutar=" + amount);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        UserValidator validator = new DefaultUserValidator();
        PaymentService paymentService = new PaymentService(0.18, database, validator);

        paymentService.processPayment("PREMIUM123", 1000);
    }
}

/*

Açıklama: Düzeltilmiş kodda, Inappropriate Static / Static Cling sorunu şu şekilde giderildi:

Statik Değişkenlerin Kaldırılması: taxRate ve database, statik olmaktan çıkarıldı ve PaymentService sınıfının
örnek değişkenleri olarak tanımlandı.

Bağımlılık Enjeksiyonu: Database ve UserValidator, constructor aracılığıyla enjekte edilerek statik bağımlılıklar kaldırıldı.

Arayüz Kullanımı: UserValidator, bir arayüz olarak tanımlandı ve DefaultUserValidator bu arayüzü uyguladı.
Bu, polimorfizmi destekler ve test için mock nesneler oluşturmayı kolaylaştırır.

Statik Metodun Dönüşümü: processPayment metodu, statik olmaktan çıkarıldı ve örnek metodu olarak yeniden düzenlendi,
böylece sınıfın durumu ve bağımlılıkları kontrol edilebilir hale geldi.

Modülerlik: Kod, daha modüler ve test edilebilir bir yapıya kavuştu. Yeni bir UserValidator veya Database implementasyonu
eklendiğinde, PaymentService sınıfını değiştirmeden kullanılabilir.

Bu değişiklikler, kodun esnekliğini, test edilebilirliğini ve bakım kolaylığını artırdı. Statik bağımlılıklar kaldırılarak
Inappropriate Static / Static Cling code smell'i ortadan kaldırıldı.

*/