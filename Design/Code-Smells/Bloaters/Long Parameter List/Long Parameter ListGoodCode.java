public class OrderProcessor {
    public void processOrder(Customer customer, Order order) {
        // Müşteri bilgilerini doğrula
        customer.validate();

        // Adres oluştur
        String fullAddress = customer.getAddress().format();

        // Sipariş toplamını hesapla
        double finalTotal = order.calculateFinalTotal(customer.isVIP());

        // Siparişi kaydet
        System.out.println("Sipariş kaydedildi: " + order.getProductId() + " için " + customer.getName() + ", Adres: " + fullAddress + ", Toplam: " + finalTotal);
    }
}

class Customer {
    private final String name;
    private final String email;
    private final Address address;
    private final boolean isVIP;

    public Customer(String name, String email, Address address, boolean isVIP) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isVIP = isVIP;
    }

    public void validate() {
        if (name == null || email == null) {
            throw new IllegalArgumentException("Müşteri bilgileri eksik");
        }
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isVIP() {
        return isVIP;
    }
}

class Address {
    private final String street;
    private final String city;
    private final String postalCode;

    public Address(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String format() {
        return street + ", " + city + " " + postalCode;
    }
}

class Order {
    private final double orderTotal;
    private final String productId;

    public Order(double orderTotal, String productId) {
        this.orderTotal = orderTotal;
        this.productId = productId;
    }

    public double calculateFinalTotal(boolean isVIP) {
        double finalTotal = orderTotal;
        if (isVIP) {
            finalTotal *= 0.9; // %10 indirim
        }
        return finalTotal;
    }

    public String getProductId() {
        return productId;
    }
}

//Açıklama: Düzeltilmiş kodda, processOrder metodunun parametre sayısı azaltıldı. İlgili veriler Customer, Address ve Order sınıflarında birleştirildi. Bu sınıflar, kendi doğrulama ve davranışlarını kapsülleyerek kodun okunabilirliğini, yeniden kullanılabilirliğini ve bakımını kolaylaştırdı. processOrder metodu artık daha az parametreyle daha temiz ve anlaşılır bir şekilde çalışıyor.