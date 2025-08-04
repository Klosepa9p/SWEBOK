public class OrderProcessor {
    // #region Müşteri Doğrulama
    public void processOrder(Order order) {
        if (order.getCustomer() == null || order.getCustomer().getName().isEmpty()) {
            throw new IllegalArgumentException("Müşteri bilgisi eksik.");
        }
        // ... müşteri doğrulama mantığı ...
        // #endregion

        // #region Toplam Hesaplama
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        // #endregion

        // #region İndirim Uygulama
        if (order.getCustomer().isVIP()) {
            total *= 0.9; // %10 indirim
        }
        // #endregion

        // #region Vergi Ekleme
        total += total * 0.18; // %18 KDV
        // #endregion

        // #region Siparişi Kaydet
        Database.saveOrder(order);
        // #endregion

        // #region Bildirim Gönderme
        String message = "Sayın " + order.getCustomer().getName() + ", siparişiniz alındı. Toplam: " + total;
        EmailService.sendEmail(order.getCustomer().getEmail(), "Sipariş Onayı", message);
        // #endregion
    }
}

/*

Sorun: OrderProcessor sınıfındaki processOrder metodu, birden fazla sorumluluğu (doğrulama, hesaplama, indirim,
vergi, kaydetme, bildirim) tek bir metodda birleştiriyor ve #region yorumlarıyla ayrılıyor.
Bu, Long Method kokusunun bir göstergesi ve regions, temel karmaşıklık sorununu gizliyor.

*/
