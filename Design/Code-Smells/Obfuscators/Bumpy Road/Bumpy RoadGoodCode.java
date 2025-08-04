public class OrderProcessor {
    public void processOrder(Order order) {
        validateOrder(order);
        double total = calculateTotal(order);
        total = applyDiscount(order, total);
        total = addTax(total);
        saveOrder(order);
    }

    private void validateOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Sipariş null");
        }
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Müşteri bilgisi eksik");
        }
        if (order.getCustomer().getName().isEmpty()) {
            throw new IllegalArgumentException("Müşteri adı eksik");
        }
    }

    private double calculateTotal(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            if (item != null && item.getPrice() > 0) {
                total += item.getPrice() * item.getQuantity();
            }
        }
        return total;
    }

    private double applyDiscount(Order order, double total) {
        return order.getCustomer().isVIP() && total > 0 ? total * 0.9 : total; // %10 VIP indirimi
    }

    private double addTax(double total) {
        return total > 0 ? total + (total * 0.18) : total; // %18 KDV
    }

    private void saveOrder(Order order) {
        Database.saveOrder(order);
    }
}

class Database {
    public static void saveOrder(Order order) {
        System.out.println("Sipariş kaydedildi: " + order);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Bumpy Road sorunu şu şekilde giderildi:

Metod Bölme: processOrder metodu, tek sorumluluğa sahip küçük metodlara ayrıldı (validateOrder, calculateTotal,
applyDiscount, addTax, saveOrder), bu da kodun akışını düzgünleştirdi.

Erken Dönüş: Doğrulama mantığı, erken hata fırlatma ile sadeleştirildi, böylece iç içe if blokları azaltıldı.

Kontrol Akışını Sadeleştirme: Gereksiz koşullu ifadeler, ternary operatörler kullanılarak basitleştirildi
(örneğin, applyDiscount ve addTax metodlarında).

Anlamlı İsimlendirme: Metod isimleri, her bir adımın amacını net bir şekilde ifade ediyor (örneğin, validateOrder,
applyDiscount).

Yorumlar: Yalnızca iş kurallarını açıklamak için sınırlı yorumlar kullanıldı (örneğin, %10 VIP indirimi).

Bu değişiklikler, kodun akışını akıcı hale getirdi, okunabilirliği ve bakım kolaylığını artırdı ve "engebeleri"
ortadan kaldırarak Bumpy Road sorununu çözdü.
*/