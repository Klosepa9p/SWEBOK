public class OrderProcessor {
    public void processOrder(Order order) {
        validateCustomer(order);
        double total = calculateTotal(order);
        total = applyDiscount(order, total);
        total = addTax(total);
        saveOrder(order);
        sendConfirmationEmail(order, total);
    }

    private void validateCustomer(Order order) {
        if (order.getCustomer() == null || order.getCustomer().getName().isEmpty()) {
            throw new IllegalArgumentException("Müşteri bilgisi eksik.");
        }
    }

    private double calculateTotal(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    private double applyDiscount(Order order, double total) {
        if (order.getCustomer().isVIP()) {
            total *= 0.9; // %10 indirim
        }
        return total;
    }

    private double addTax(double total) {
        return total + (total * 0.18); // %18 KDV
    }

    private void saveOrder(Order order) {
        Database.saveOrder(order);
    }

    private void sendConfirmationEmail(Order order, double total) {
        String message = "Sayın " + order.getCustomer().getName() + ", siparişiniz alındı. Toplam: " + total;
        EmailService.sendEmail(order.getCustomer().getEmail(), "Sipariş Onayı", message);
    }
}

/*
Açıklama: Düzeltilmiş kodda, processOrder metodu daha küçük, tek sorumluluğa sahip metodlara ayrıldı.
Her metodun amacı açık ve regions kullanmaya gerek kalmadı. Kod kendi kendini açıklayacak şekilde düzenlendi ve
her bir işlem (doğrulama, hesaplama, indirim, vergi, kaydetme, bildirim) ayrı bir metodda kapsüllendi.
Bu, kodun okunabilirliğini, bakımını ve test edilebilirliğini artırdı. Regions yerine, anlamlı metod isimleri ve
modüler yapı kullanılarak kodun organizasyonu iyileştirildi.
*/