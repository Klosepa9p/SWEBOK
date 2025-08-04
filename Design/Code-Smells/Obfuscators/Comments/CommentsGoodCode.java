public class PaymentProcessor {
    public void processPayment(String transactionId, double amount, boolean isDiscountEligible) {
        validateTransactionId(transactionId);
        double finalAmount = calculateFinalAmount(amount, isDiscountEligible);
        savePayment(transactionId, finalAmount);
        logPayment(transactionId);
    }

    private void validateTransactionId(String transactionId) {
        if (transactionId == null || transactionId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz işlem kimliği");
        }
    }

    private double calculateFinalAmount(double amount, boolean isDiscountEligible) {
        double finalAmount = amount;
        if (isDiscountEligible) {
            finalAmount *= 0.8; // %20 indirim
        }
        finalAmount += finalAmount * 0.1; // %10 vergi
        return finalAmount;
    }

    private void savePayment(String transactionId, double finalAmount) {
        Database.savePayment(transactionId, finalAmount);
    }

    private void logPayment(String transactionId) {
        System.out.println("Ödeme işlendi: " + transactionId);
    }
}

class Database {
    public static void savePayment(String transactionId, double amount) {
        System.out.println("Ödeme kaydedildi: ID=" + transactionId + ", Tutar=" + amount);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Comments code smell'i şu şekilde giderildi:

Anlamlı İsimlendirme: Metod ismi proc yerine processPayment, değişken isimleri id, amt, flag, finalAmt yerine
transactionId, amount, isDiscountEligible, finalAmount olarak değiştirildi. Bu, kodun amacını netleştirdi ve
yorum ihtiyacını azalttı.

Metod Bölme: Kod, tek sorumluluğa sahip metodlara ayrıldı (validateTransactionId, calculateFinalAmount, savePayment,
logPayment), bu da okunabilirliği artırdı.

Sınırlı Yorum Kullanımı: Yorumlar yalnızca iş kurallarını açıklamak için kullanıldı (örneğin, %20 indirim ve %10 vergi),
gereksiz yorumlar kaldırıldı.

Kendi Kendini Açıklayan Kod: Anlamlı isimler ve modüler yapı sayesinde kod, ne yaptığını açıkça ifade ediyor.

Bu değişiklikler, kodun okunabilirliğini, bakım kolaylığını ve anlaşılırlığını artırdı. Yorumlara olan bağımlılık azaldı
ve kod, kendi kendini açıklayan bir yapıya kavuştu.
*/
