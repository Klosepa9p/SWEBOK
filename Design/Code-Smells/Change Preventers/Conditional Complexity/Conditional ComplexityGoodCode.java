public interface DiscountStrategy {
    double calculateDiscount(double amount, OrderContext context);
}

public class RegularCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount, OrderContext context) {
        if (context.isHoliday()) {
            return amount * 0.15; // Tatilde %15 indirim
        }
        if (context.isWeekend()) {
            return amount * 0.10; // Hafta sonu %10 indirim
        }
        return amount * 0.05; // Normal günlerde %5 indirim
    }
}

public class VIPCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount, OrderContext context) {
        if (context.isHoliday()) {
            return amount * 0.25; // Tatilde %25 indirim
        }
        if (context.isWeekend()) {
            return amount * 0.20; // Hafta sonu %20 indirim
        }
        return amount * 0.15; // Normal günlerde %15 indirim
    }
}

public class NewCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount, OrderContext context) {
        if (context.isHoliday()) {
            return amount * 0.10; // Tatilde %10 indirim
        }
        return amount * 0.02; // Diğer günlerde %2 indirim
    }
}

public class OrderContext {
    private final boolean isWeekend;
    private final boolean isHoliday;

    public OrderContext(boolean isWeekend, boolean isHoliday) {
        this.isWeekend = isWeekend;
        this.isHoliday = isHoliday;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public boolean isHoliday() {
        return isHoliday;
    }
}

public class DiscountCalculator {
    private final DiscountStrategy strategy;

    public DiscountCalculator(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateDiscount(double amount, OrderContext context) {
        return strategy.calculateDiscount(amount, context);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        OrderContext context = new OrderContext(true, false); // Hafta sonu, tatil değil
        DiscountCalculator regularCalc = new DiscountCalculator(new RegularCustomerDiscount());
        DiscountCalculator vipCalc = new DiscountCalculator(new VIPCustomerDiscount());

        System.out.println("Normal müşteri indirimi: " + regularCalc.calculateDiscount(1000, context));
        System.out.println("VIP müşteri indirimi: " + vipCalc.calculateDiscount(1000, context));
    }
}


/*

Açıklama: Düzeltilmiş kodda, Conditional Complexity code smell'i şu şekilde giderildi:

- Polimorfizm ve Strateji Deseni: switch ve iç içe if-else ifadeleri yerine, DiscountStrategy arayüzü tanımlandı ve
  her müşteri türü için ayrı bir strateji sınıfı (RegularCustomerDiscount, VIPCustomerDiscount, NewCustomerDiscount) oluşturuldu.
- Sorumluluk Ayrımı: Koşullu ifadeler, her strateji sınıfına dağıtıldı, böylece her sınıf kendi indirim mantığını kapsülledi.
- Open/Closed Principle: Yeni bir müşteri türü eklendiğinde, sadece yeni bir DiscountStrategy implementasyonu yazmak yeterli;
  DiscountCalculator sınıfını değiştirmeye gerek yok.
- Erken Dönüş ve Basitleştirme: Koşullu ifadeler, her strateji sınıfında daha basit ve düz bir yapıya dönüştürüldü,
  bu da okunabilirliği artırdı.
- Modülerlik: OrderContext sınıfı, hafta sonu ve tatil gibi durumları kapsülleyerek koşullu mantığı daha düzenli hale getirdi.

Bu değişiklikler, kodun okunabilirliğini, bakım kolaylığını ve esnekliğini artırdı. İç içe koşullu ifadeler kaldırılarak
Conditional Complexity code smell'i ortadan kaldırıldı ve kod, nesne yönelimli prensiplere daha uygun hale getirildi.

*/