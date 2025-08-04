public class DiscountCalculator {
    public double calculateDiscount(String customerType, boolean isWeekend, boolean isHoliday, double orderTotal) {
        double discount = 0;

        // Kombinasyon patlaması: Her durum için ayrı bir koşul
        if (customerType.equals("Regular") && isWeekend && !isHoliday) {
            discount = orderTotal * 0.05; // %5 indirim
        } else if (customerType.equals("Regular") && !isWeekend && !isHoliday) {
            discount = orderTotal * 0.03; // %3 indirim
        } else if (customerType.equals("Regular") && isHoliday) {
            discount = orderTotal * 0.10; // %10 indirim
        } else if (customerType.equals("VIP") && isWeekend && !isHoliday) {
            discount = orderTotal * 0.15; // %15 indirim
        } else if (customerType.equals("VIP") && !isWeekend && !isHoliday) {
            discount = orderTotal * 0.12; // %12 indirim
        } else if (customerType.equals("VIP") && isHoliday) {
            discount = orderTotal * 0.20; // %20 indirim
        } else if (customerType.equals("New") && isWeekend && !isHoliday) {
            discount = orderTotal * 0.02; // %2 indirim
        } else if (customerType.equals("New") && !isHoliday) {
            discount = orderTotal * 0.01; // %1 indirim
        } else if (customerType.equals("New") && isHoliday) {
            discount = orderTotal * 0.08; // %8 indirim
        }

        return discount;
    }
}