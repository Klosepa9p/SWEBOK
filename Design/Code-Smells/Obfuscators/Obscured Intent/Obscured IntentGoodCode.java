public class SubscriptionCalculator {
    public double calculateSubscriptionFee(String planId, int months, boolean isPromotional) {
        validatePlanId(planId);
        double totalFee = calculateBaseFee(months);
        totalFee = applyPromotionalDiscount(totalFee, isPromotional);
        totalFee = addTax(totalFee);
        saveSubscription(planId, totalFee);
        return totalFee;
    }

    private void validatePlanId(String planId) {
        if (planId == null) {
            throw new IllegalArgumentException("Abonelik planı kimliği eksik.");
        }
    }

    private double calculateBaseFee(int months) {
        return months * 100; // Aylık 100 birim sabit ücret
    }

    private double applyPromotionalDiscount(double totalFee, boolean isPromotional) {
        if (isPromotional) {
            totalFee *= 0.75; // %25 promosyon indirimi
        }
        return totalFee;
    }

    private double addTax(double totalFee) {
        return totalFee + (totalFee * 0.2); // %20 vergi
    }

    private void saveSubscription(String planId, double totalFee) {
        Database.saveSubscription(planId, totalFee);
    }
}

class Database {
    public static void saveSubscription(String planId, double totalFee) {
        System.out.println("Abonelik kaydedildi: Plan ID=" + planId + ", Toplam Ücret=" + totalFee);
    }
}


/*
Açıklama: Düzeltilmiş kodda, Obscured Intent sorunu şu şekilde giderildi:

Anlamlı İsimlendirme: Sınıf ismi Handler yerine SubscriptionCalculator, metod ismi calc yerine calculateSubscriptionFee oldu.
Değişkenler a, b, c, r yerine planId, months, isPromotional, totalFee gibi açıklayıcı isimlerle değiştirildi.

Metod Bölme: Kod, tek sorumluluğa sahip metodlara ayrıldı (validatePlanId, calculateBaseFee, applyPromotionalDiscount,
addTax, saveSubscription), bu da her adımın amacını netleştirdi.

Yorumlar: Yalnızca iş kurallarını açıklamak için sınırlı yorumlar kullanıldı (örneğin, %25 promosyon indirimi, %20 vergi).

Basitleştirme: Kod, gereksiz karmaşıklıktan arındırıldı ve her işlem açıkça ifade edildi.

Bağlam: Kod, abonelik ücreti hesaplama bağlamına uygun hale getirildi, böylece niyet netleşti.

Bu değişiklikler, kodun okunabilirliğini, bakım kolaylığını ve anlaşılırlığını artırdı. Kod artık kendi kendini açıklayan
bir yapıya sahip ve Obscured Intent code smell'i ortadan kaldırıldı.
*/