public void processOrder(Order order) {
    // Müşteri bilgilerini doğrula
    if (order.getCustomer() == null || order.getCustomer().getName().isEmpty()) {
        throw new IllegalArgumentException("Müşteri bilgisi eksik.");
    }
    
    // Sipariş toplamını hesapla
    double total = 0;
    for (Item item : order.getItems()) {
        total += item.getPrice() * item.getQuantity();
    }
    
    // İndirim uygula
    if (order.getCustomer().isVIP()) {
        total *= 0.9; // %10 indirim
    }
    
    // Vergi ekle
    total += total * 0.18; // %18 KDV
    
    // Siparişi kaydet
    Database.saveOrder(order);
    
    // E-posta bildirimi gönder
    String message = "Sayın " + order.getCustomer().getName() + ", siparişiniz alındı. Toplam: " + total;
    EmailService.sendEmail(order.getCustomer().getEmail(), "Sipariş Onayı", message);
}