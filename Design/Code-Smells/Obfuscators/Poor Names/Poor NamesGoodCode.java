public class InvoiceCalculator {
    public double calculateInvoiceTotal(String customerId, int quantity, double unitPrice) {
        validateCustomerId(customerId);
        double totalPrice = calculateBaseTotal(quantity, unitPrice);
        totalPrice = applySpecialDiscount(customerId, totalPrice);
        saveInvoice(customerId, totalPrice);
        return totalPrice;
    }

    private void validateCustomerId(String customerId) {
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Müşteri kimliği eksik.");
        }
    }

    private double calculateBaseTotal(int quantity, double unitPrice) {
        return quantity * unitPrice;
    }

    private double applySpecialDiscount(String customerId, double totalPrice) {
        if (customerId.contains("SP")) {
            return totalPrice * 0.85; // %15 özel indirim
        }
        return totalPrice;
    }

    private void saveInvoice(String customerId, double totalPrice) {
        Database.saveInvoice(customerId, totalPrice);
    }
}

class Database {
    public static void saveInvoice(String customerId, double totalPrice) {
        System.out.println("Fatura kaydedildi: Müşteri ID=" + customerId + ", Toplam=" + totalPrice);
    }
}


/*
Açıklama: Düzeltilmiş kodda, Poor Names sorunu şu şekilde giderildi:

Anlamlı İsimlendirme: Sınıf ismi Calc yerine InvoiceCalculator oldu, metod ismi fn yerine calculateInvoiceTotal olarak
değiştirildi. Değişkenler s, n, d, x yerine customerId, quantity, unitPrice, totalPrice gibi açıklayıcı isimlerle güncellendi.

Bağlama Uygunluk: İsimler, fatura hesaplama bağlamına uygun hale getirildi (örneğin, saveInvoice yerine save).

Metod Bölme: Kod, tek sorumluluğa sahip metodlara ayrıldı (validateCustomerId, calculateBaseTotal, applySpecialDiscount,
saveInvoice), bu da niyeti netleştirdi.

Yorum Azaltma: Yalnızca iş kuralını açıklayan bir yorum kullanıldı (%15 özel indirim), diğer gereksiz yorumlar kaldırıldı.

Tutarlılık: Tüm isimler camelCase kuralına uygun ve tutarlı bir şekilde düzenlendi.

*/
