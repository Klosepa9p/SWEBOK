public class OrderProcessor {
    public void process(Order order) {
        // İlk kontrol
        if (order != null) {
            // Müşteri kontrolü
            if (order.getCustomer() != null) {
                // İsim kontrolü
                if (!order.getCustomer().getName().isEmpty()) {
                    double total = 0;
                    // Ürünler için döngü
                    for (Item item : order.getItems()) {
                        if (item != null) {
                            if (item.getPrice() > 0) {
                                total += item.getPrice() * item.getQuantity();
                            }
                        }
                    }
                    // VIP indirimi
                    if (order.getCustomer().isVIP()) {
                        if (total > 0) {
                            total = total * 0.9;
                        }
                    }
                    // Vergi ekleme
                    if (total > 0) {
                        total += total * 0.18;
                    }
                    // Sipariş kaydetme
                    if (total > 0) {
                        Database.saveOrder(order);
                    }
                } else {
                    throw new IllegalArgumentException("Müşteri adı eksik");
                }
            } else {
                throw new IllegalArgumentException("Müşteri bilgisi eksik");
            }
        } else {
            throw new IllegalArgumentException("Sipariş null");
        }
    }
}

/*
Açıklama: Yukarıdaki kod, iç içe geçmiş çok sayıda koşullu ifade içeriyor ve bu, kodun akışını kesintiye uğratıyor.
Her adımda gereksiz kontroller (örneğin, if (order != null), if (item != null)) ve derin iç içe yapılar, kodun okunmasını
ve takibini zorlaştırıyor. Bu, "Bumpy Road" kokusuna neden oluyor; geliştirici, kodun her adımında küçük engellerle
karşılaşıyor.
*/