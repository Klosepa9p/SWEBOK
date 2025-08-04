public class InvoiceGenerator {
    public void generateInvoice(Invoice invoice) {
        validateInvoice(invoice);
        double total = calculateTotal(invoice);
        total = applyDiscount(invoice, total);
        String invoiceDetails = createInvoiceDetails(invoice, total);
        saveInvoice(invoice, total, invoiceDetails);
    }

    private void validateInvoice(Invoice invoice) {
        boolean isValid = invoice.getCustomer() != null && !invoice.getCustomer().getName().isEmpty();
        if (!isValid) {
            throw new IllegalArgumentException("Geçersiz müşteri bilgisi.");
        }
    }

    private double calculateTotal(Invoice invoice) {
        double total = 0;
        for (Item item : invoice.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    private double applyDiscount(Invoice invoice, double total) {
        if (invoice.getCustomer().isPremium()) {
            total *= 0.95; // %5 indirim
        }
        return total;
    }

    private String createInvoiceDetails(Invoice invoice, double total) {
        String customerName = invoice.getCustomer().getName();
        return "Fatura: " + customerName + ", Toplam: " + total;
    }

    private void saveInvoice(Invoice invoice, double total, String invoiceDetails) {
        Database.saveInvoice(invoice, total, invoiceDetails);
    }
}

class Database {
    public static void saveInvoice(Invoice invoice, double total, String details) {
        System.out.println("Fatura kaydedildi: " + details);
    }
}


/*

Açıklama: Düzeltilmiş kodda, Vertical Separation sorunu şu şekilde giderildi:

Değişkenleri Yakın Tanımlama: total, customerName ve invoiceDetails gibi değişkenler, kullanıldıkları yere yakın tanımlandı
(örneğin, customerName sadece createInvoiceDetails içinde tanımlı).

Metod Bölme: generateInvoice metodu, tek sorumluluğa sahip küçük metodlara ayrıldı (validateInvoice, calculateTotal,
applyDiscount, createInvoiceDetails, saveInvoice), bu da kodun organizasyonunu iyileştirdi.

Yerel Değişkenler: Geniş kapsamlı değişkenler yerine, her metodda yalnızca gerekli yerel değişkenler kullanıldı.

Anlamlı İsimlendirme: Metod isimleri (örneğin, createInvoiceDetails, applyDiscount), kodun amacını net bir şekilde ifade ediyor.

Yorumlar: Yalnızca iş kuralını açıklamak için sınırlı bir yorum kullanıldı (%5 indirim).

Bu değişiklikler, kodun okunabilirliğini, bakım kolaylığını ve akışını iyileştirdi. Değişken ve metod tanımları,
kullanıldıkları yere yakın hale getirilerek Vertical Separation sorunu ortadan kaldırıldı.

*/
