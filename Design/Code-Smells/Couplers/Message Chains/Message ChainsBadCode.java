public class Customer {
    private Address address;

    public Customer(Address address) {
        this.address = address;
    }

    public Address getAddress() { return address; }
}

public class Address {
    private City city;

    public Address(City city) {
        this.city = city;
    }

    public City getCity() { return city; }
}

public class City {
    private String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}

public class OrderProcessor {
    public void processOrder(Customer customer, double amount) {
        // Message Chain: customer.getAddress().getCity().getName()
        String cityName = customer.getAddress().getCity().getName();
        if (cityName == null || cityName.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz şehir bilgisi");
        }

        double finalAmount = amount;
        if (cityName.equals("Istanbul")) {
            finalAmount *= 0.95; // İstanbul'da %5 indirim
        }

        Database.saveOrder(cityName, finalAmount);
        EmailService.sendEmail("customer@example.com", "Sipariş Onayı", 
            "Siparişiniz işlendi. Şehir: " + cityName + ", Toplam: " + finalAmount);
    }
}

class Database {
    public static void saveOrder(String cityName, double amount) {
        System.out.println("Sipariş kaydedildi: Şehir=" + cityName + ", Tutar=" + amount);
    }
}

class EmailService {
    public static void sendEmail(String recipient, String subject, String message) {
        System.out.println("E-posta gönderildi: " + recipient + ", Konu: " + subject + ", Mesaj: " + message);
    }
}

/*
Sorun: Yukarıdaki kodda, OrderProcessor sınıfı bir mesaj zinciri içeriyor:

- customer.getAddress().getCity().getName() zinciri, Customer sınıfından başlayarak Address ve City sınıflarının iç detaylarına erişiyor.
- Bu, Law of Demeter ihlaline neden oluyor ve OrderProcessor'ın Address ve City sınıflarının iç yapısına bağımlı olmasına yol açıyor.
- Eğer Address veya City sınıflarının yapısı değişirse (örneğin, getCity() kaldırılsa), OrderProcessor bozulur.
- Zincir, null referans hatalarına (NullPointerException) yatkın ve kodu okunması zor hale getiriyor.
*/

