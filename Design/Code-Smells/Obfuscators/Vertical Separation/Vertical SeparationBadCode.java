public class InvoiceGenerator {
    public void generateInvoice(Invoice invoice) {
        // Değişkenler metodun başında tanımlanıyor
        double total = 0;
        String customerName;
        String invoiceDetails;
        boolean isValid;

        // ... birkaç satır boşluk veya başka kod ...

        // Doğrulama (uzak bir noktada)
        isValid = invoice.getCustomer() != null && !invoice.getCustomer().getName().isEmpty();
        if (!isValid) {
            throw new IllegalArgumentException("Geçersiz müşteri bilgisi.");
        }

        // ... daha fazla kod ...

        // Toplam hesaplama
        for (Item item : invoice.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }

        // ... başka işlemler ...

        // İndirim uygulama
        if (invoice.getCustomer().isPremium()) {
            total *= 0.95; // %5 indirim
        }

        // ... daha fazla kod ...

        // Müşteri adı ve detaylar
        customerName = invoice.getCustomer().getName();
        invoiceDetails = "Fatura: " + customerName + ", Toplam: " + total;

        // ... başka işlemler ...

        // Faturayı kaydet
        Database.saveInvoice(invoice, total, invoiceDetails);
    }
}

/*
Sorun: Yukarıdaki kodda, total, customerName, invoiceDetails ve isValid değişkenleri metodun başında tanımlanıyor,
ancak kullanımları çok aşağıda gerçekleşiyor. Bu, Vertical Separation sorununa yol açıyor ve kodun takibini zorlaştırıyor.
Ayrıca, metodun kendisi çok uzun (Long Method), bu da sorunu daha belirgin hale getiriyor.
*/