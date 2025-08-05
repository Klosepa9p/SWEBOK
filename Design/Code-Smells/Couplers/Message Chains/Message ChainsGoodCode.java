public class Customer {
    private final Address address;

    public Customer(Address address) {
        this.address = address;
    }

    public String getCityName() {
        return address.getCityName();
    }

    public void validateCity() {
        address.validateCity();
    }
}

public class Address {
    private final City city;

    public Address(City city) {
        this.city = city;
    }

    public String getCityName() {
        return city.getName();
    }

    public void validateCity() {
        if (city.getName() == null || city.getName().isEmpty()) {
            throw new IllegalArgumentException("Geçersiz şehir bilgisi");
        }
    }
}

public class City {
    private final String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}

public class OrderProcessor {
    private final Database database;
    private final EmailService emailService;

    public OrderProcessor(Database database, EmailService emailService) {
        this.database = database;
        this.emailService = emailService;
    }

    public void processOrder(Customer customer, double amount) {
        customer.validateCity();
        String cityName = customer.getCityName();
        double finalAmount = amount;
        if (cityName.equals("Istanbul")) {
            finalAmount *= 0.95; // İstanbul'da %5 indirim
        }

        database.saveOrder(cityName, finalAmount);
        emailService.sendEmail("customer@example.com", "Sipariş Onayı", 
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

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        EmailService emailService = new EmailService();
        OrderProcessor processor = new OrderProcessor(database, emailService);
        
        City city = new City("Istanbul");
        Address address = new Address(city);
        Customer customer = new Customer(address);
        processor.processOrder(customer, 1000);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Message Chains sorunu şu şekilde giderildi:

- Kapsülleme: Customer ve Address sınıfları, iç detaylarını gizledi ve yalnızca gerekli arayüzleri (getCityName, validateCity) açığa çıkardı.
- Metodu Taşı: Şehir adı alma ve doğrulama mantığı, Customer ve Address sınıflarına taşındı (getCityName, validateCity), böylece OrderProcessor zincirleme çağrılara ihtiyaç duymuyor.
- Law of Demeter: OrderProcessor, Customer sınıfının içindeki Address veya City sınıflarına doğrudan erişmek yerine, yalnızca Customer sınıfının metodlarını kullanıyor.
- Bağımlılık Enjeksiyonu: OrderProcessor, Database ve EmailService bağımlılıklarını constructor aracılığıyla alıyor, bu da esnekliği koruyor.
- Null Güvenliği: Doğrulama mantığı Address ve Customer sınıflarına taşındığı için null referans hataları riski azaldı.

Bu değişiklikler, kodun modülerliğini, okunabilirliğini ve bakım kolaylığını artırdı. Zincirleme metod çağrıları kaldırılarak Message Chains code smell'i ortadan kaldırıldı.
*/