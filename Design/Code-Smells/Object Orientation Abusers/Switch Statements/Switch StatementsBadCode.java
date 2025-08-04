public class PaymentProcessor {
    public double processPayment(String paymentType, double amount) {
        double finalAmount = amount;

        // Switch ile ödeme türüne göre işlem
        switch (paymentType) {
            case "CREDIT_CARD":
                finalAmount += finalAmount * 0.02; // %2 işlem ücreti
                System.out.println("Kredi kartı ödemesi işlendi: " + finalAmount);
                break;
            case "DEBIT_CARD":
                finalAmount += finalAmount * 0.01; // %1 işlem ücreti
                System.out.println("Banka kartı ödemesi işlendi: " + finalAmount);
                break;
            case "CASH":
                // Nakit ödemede ek ücret yok
                System.out.println("Nakit ödeme işlendi: " + finalAmount);
                break;
            case "PAYPAL":
                finalAmount += finalAmount * 0.03; // %3 işlem ücreti
                System.out.println("PayPal ödemesi işlendi: " + finalAmount);
                break;
            default:
                throw new IllegalArgumentException("Geçersiz ödeme türü: " + paymentType);
        }

        Database.savePayment(paymentType, finalAmount);
        return finalAmount;
    }
}

class Database {
    public static void savePayment(String paymentType, double amount) {
        System.out.println("Ödeme kaydedildi: Tür=" + paymentType + ", Tutar=" + amount);
    }
}

/*
Sorun: Yukarıdaki kodda, processPayment metodu bir switch ifadesi kullanarak ödeme türlerine göre farklı işlemler gerçekleştiriyor.
Bu, aşağıdaki sorunlara yol açıyor:

Yeni bir ödeme türü eklendiğinde (örneğin, CRYPTO), switch bloğuna yeni bir case eklenmesi gerekiyor,
bu da Open/Closed Principle'ı ihlal ediyor.

Kod tekrarına neden oluyor; her case benzer bir mantık (ücret ekleme ve yazdırma) içeriyor.

switch bloğu karmaşık ve bakımı zor, özellikle daha fazla ödeme türü eklendiğinde.
*/
