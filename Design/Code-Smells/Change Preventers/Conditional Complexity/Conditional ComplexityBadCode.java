public class DiscountCalculator {
    public double calculateDiscount(String customerType, boolean isWeekend, boolean isHoliday, double amount) {
        double discount = 0;

        // Karmaşık koşullu ifadeler
        if (customerType.equals("REGULAR")) {
            if (isWeekend) {
                if (isHoliday) {
                    discount = amount * 0.15; // Tatilde %15 indirim
                } else {
                    discount = amount * 0.10; // Hafta sonu %10 indirim
                }
            } else {
                discount = amount * 0.05; // Normal günlerde %5 indirim
            }
        } else if (customerType.equals("VIP")) {
            if (isWeekend) {
                if (isHoliday) {
                    discount = amount * 0.25; // Tatilde %25 indirim
                } else {
                    discount = amount * 0.20; // Hafta sonu %20 indirim
                }
            } else {
                discount = amount * 0.15; // Normal günlerde %15 indirim
            }
        } else if (customerType.equals("NEW")) {
            if (isHoliday) {
                discount = amount * 0.10; // Tatilde %10 indirim
            } else {
                discount = amount * 0.02; // Diğer günlerde %2 indirim
            }
        } else {
            throw new IllegalArgumentException("Geçersiz müşteri türü: " + customerType);
        }

        return discount;
    }


/*

Sorun: Yukarıdaki kodda, calculateDiscount metodu iç içe geçmiş çok sayıda koşullu ifade içeriyor.
Bu, aşağıdaki sorunlara yol açıyor:

- Kodun okunması ve anlaşılması zor, çünkü birden fazla durum (müşteri türü, hafta sonu, tatil) iç içe kontrol ediliyor.
- Yeni bir müşteri türü veya durum eklendiğinde, metodun değiştirilmesi gerekiyor, bu da Open/Closed Principle'ı ihlal ediyor.
- Her durum kombinasyonu için ayrı test yazılması gerekiyor, bu da test karmaşıklığını artırıyor.
- Koşullu ifadeler, kod tekrarına ve bakım zorluğuna neden oluyor.
*/