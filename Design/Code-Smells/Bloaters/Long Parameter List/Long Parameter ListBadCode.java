public class OrderProcessor {
    public void processOrder(String customerName, String customerEmail, String street, String city, String postalCode, double orderTotal, boolean isVIP, String productId) {
        // Müşteri bilgilerini doğrula
        if (customerName == null || customerEmail == null) {
            throw new IllegalArgumentException("Müşteri bilgileri eksik");
        }

        // Adres oluştur
        String fullAddress = street + ", " + city + " " + postalCode;

        // Sipariş toplamını hesapla
        double finalTotal = orderTotal;
        if (isVIP) {
            finalTotal *= 0.9; // %10 indirim
        }

        // Siparişi kaydet
        System.out.println("Sipariş kaydedildi: " + productId + " için " + customerName + ", Adres: " + fullAddress + ", Toplam: " + finalTotal);
    }
}