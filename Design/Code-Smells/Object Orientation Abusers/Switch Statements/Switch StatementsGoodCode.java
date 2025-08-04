public interface PaymentMethod {
    double calculateFee(double amount);
    String getType();
}

public class CreditCardPayment implements PaymentMethod {
    @Override
    public double calculateFee(double amount) {
        return amount + (amount * 0.02); // %2 işlem ücreti
    }

    @Override
    public String getType() {
        return "Kredi Kartı";
    }
}

public class DebitCardPayment implements PaymentMethod {
    @Override
    public double calculateFee(double amount) {
        return amount + (amount * 0.01); // %1 işlem ücreti
    }

    @Override
    public String getType() {
        return "Banka Kartı";
    }
}

public class CashPayment implements PaymentMethod {
    @Override
    public double calculateFee(double amount) {
        return amount; // Nakit ödemede ek ücret yok
    }

    @Override
    public String getType() {
        return "Nakit";
    }
}

public class PayPalPayment implements PaymentMethod {
    @Override
    public double calculateFee(double amount) {
        return amount + (amount * 0.03); // %3 işlem ücreti
    }

    @Override
    public String getType() {
        return "PayPal";
    }
}

public class PaymentProcessor {
    public double processPayment(PaymentMethod paymentMethod, double amount) {
        double finalAmount = paymentMethod.calculateFee(amount);
        System.out.println(paymentMethod.getType() + " ödemesi işlendi: " + finalAmount);
        Database.savePayment(paymentMethod.getType(), finalAmount);
        return finalAmount;
    }
}

class Database {
    public static void savePayment(String paymentType, double amount) {
        System.out.println("Ödeme kaydedildi: Tür=" + paymentType + ", Tutar=" + amount);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        
        PaymentMethod creditCard = new CreditCardPayment();
        PaymentMethod cash = new CashPayment();
        
        processor.processPayment(creditCard, 1000);
        processor.processPayment(cash, 500);
    }
}

/*

Açıklama: Düzeltilmiş kodda, Switch Statements code smell'i şu şekilde giderildi:

Polimorfizm: switch ifadesi yerine, PaymentMethod arayüzü tanımlandı ve her ödeme türü (CreditCardPayment,
DebitCardPayment, CashPayment, PayPalPayment) bu arayüzü uyguladı. Bu, her ödeme türünün kendi mantığını kapsüllemesini sağladı.

Open/Closed Principle: Yeni bir ödeme türü eklendiğinde (örneğin, CryptoPayment), sadece yeni bir sınıf yazmak yeterli;
PaymentProcessor sınıfını değiştirmeye gerek yok.

Tutarlılık: Tüm ödeme türleri aynı arayüzü (calculateFee ve getType) kullanarak tutarlı bir yapı sunuyor.

Kod Tekrarının Azaltılması: Her ödeme türünün mantığı kendi sınıfında kapsüllendi, böylece tekrar eden kod ortadan kaldırıldı.

Test Kolaylığı: Her PaymentMethod implementasyonu ayrı ayrı test edilebilir, bu da birim testlerini kolaylaştırır.

Bu değişiklikler, kodun esnekliğini, okunabilirliğini ve bakım kolaylığını artırdı. switch ifadeleri kaldırılarak
Switch Statements code smell'i ortadan kaldırıldı ve kod, nesne yönelimli prensiplere daha uygun hale getirildi.
*/
