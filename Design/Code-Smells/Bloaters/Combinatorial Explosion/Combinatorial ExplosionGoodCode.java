public class DiscountCalculator {
    public double calculateDiscount(Customer customer, OrderContext context, double orderTotal) {
        DiscountStrategy strategy = customer.getDiscountStrategy();
        return strategy.calculateDiscount(orderTotal, context);
    }
}

interface DiscountStrategy {
    double calculateDiscount(double orderTotal, OrderContext context);
}

class RegularCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double orderTotal, OrderContext context) {
        if (context.isHoliday()) {
            return orderTotal * 0.10; // %10 indirim
        } else if (context.isWeekend()) {
            return orderTotal * 0.05; // %5 indirim
        }
        return orderTotal * 0.03; // %3 indirim
    }
}

class VIPCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double orderTotal, OrderContext context) {
        if (context.isHoliday()) {
            return orderTotal * 0.20; // %20 indirim
        } else if (context.isWeekend()) {
            return orderTotal * 0.15; // %15 indirim
        }
        return orderTotal * 0.12; // %12 indirim
    }
}

class NewCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double orderTotal, OrderContext context) {
        if (context.isHoliday()) {
            return orderTotal * 0.08; // %8 indirim
        } else if (context.isWeekend()) {
            return orderTotal * 0.02; // %2 indirim
        }
        return orderTotal * 0.01; // %1 indirim
    }
}

class Customer {
    private final String type;
    private final DiscountStrategy discountStrategy;

    public Customer(String type) {
        this.type = type;
        this.discountStrategy = assignDiscountStrategy(type);
    }

    private DiscountStrategy assignDiscountStrategy(String type) {
        switch (type) {
            case "Regular":
                return new RegularCustomerDiscount();
            case "VIP":
                return new VIPCustomerDiscount();
            case "New":
                return new NewCustomerDiscount();
            default:
                throw new IllegalArgumentException("Geçersiz müşteri tipi");
        }
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }
}

class OrderContext {
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

/*
Açıklama: Düzeltilmiş kodda, DiscountCalculator sınıfındaki koşullu ifadeler kaldırılarak Strateji Deseni kullanıldı.
Her müşteri tipi için ayrı bir DiscountStrategy sınıfı oluşturuldu ve indirim hesaplamaları bu sınıflara taşındı.
Customer sınıfı, uygun stratejiyi seçer ve OrderContext sınıfı, zamanla ilgili bilgileri (hafta sonu veya tatil)
kapsüller. Bu yaklaşım, yeni müşteri tipleri veya durumlar eklendiğinde kodun kolayca genişletilmesini sağlar ve
kombinasyon patlamasını önler. Kod daha okunabilir, bakımı kolay ve esnek hale geldi.
*/
