public class Customer {
    private final String name;
    private final Address address;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }

    public void validateAddress() {
        if (!address.isValid()) {
            throw new IllegalArgumentException("Geçersiz adres bilgisi");
        }
    }

    public String getShippingAddress() {
        return address.getFormattedAddress();
    }
}

public class Address {
    private final String street;
    private final String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public boolean isValid() {
        return street != null && city != null;
    }

    public String getFormattedAddress() {
        return street + ", " + city;
    }
}

public class OrderProcessor {
    private final Database database;
    private final EmailService emailService;

    public OrderProcessor(Database database, EmailService emailService) {
        this.database = database;
        this.emailService = emailService;
    }

    public void processOrder(Customer customer, double amount) {
        customer.validateAddress();
        double finalAmount = amount * 1.18; // %18 KDV
        String message = "Sayın " + customer.getName() + ", siparişiniz işlendi. Adres: " 
            + customer.getShippingAddress() + ", Toplam: " + finalAmount;
        
        emailService.sendEmail(customer.getName(), "Sipariş Onayı", message);
        database.saveOrder(customer.getName(), finalAmount);
    }
}

class EmailService {
    public static void sendEmail(String recipient, String subject, String message) {
        System.out.println("E-posta gönderildi: " + recipient + ", Konu: " + subject + ", Mesaj: " + message);
    }
}

class Database {
    public static void saveOrder(String customerName, double amount) {
        System.out.println("Sipariş kaydedildi: Müşteri=" + customerName + ", Tutar=" + amount);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        EmailService emailService = new EmailService();
        OrderProcessor processor = new OrderProcessor(database, emailService);
        
        Address address = new Address("Ana Cadde", "İstanbul");
        Customer customer = new Customer("Ahmet", address);
        processor.processOrder(customer, 1000);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Law of Demeter Violations sorunu şu şekilde giderildi:

- Kapsülleme: Customer ve Address sınıflarının alanları private yapıldı ve yalnızca gerekli arayüzler (getName, validateAddress, getShippingAddress, isValid, getFormattedAddress) açığa çıkarıldı.
- Metodu Taşı: Adres doğrulama ve formatlama mantığı, Address sınıfına (isValid, getFormattedAddress) ve Customer sınıfına (validateAddress, getShippingAddress) taşındı.
- Law of Demeter: OrderProcessor, Customer sınıfının içindeki Address nesnesinin detaylarına (street, city) doğrudan erişmek yerine, Customer sınıfının metodlarını (validateAddress, getShippingAddress) kullanıyor.
- Bağımlılık Enjeksiyonu: OrderProcessor, Database ve EmailService bağımlılıklarını constructor aracılığıyla alıyor, bu da esnekliği koruyor.
- Sorumluluk Ayrımı: Customer ve Address sınıfları, kendi verileriyle ilgili mantığı kapsülleyerek sorumluluklarını netleştiriyor.

Bu değişiklikler, kodun modülerliğini, kapsüllemesini ve bakım kolaylığını artırdı. Zincirleme metod çağrıları kaldırılarak ve sınıfların iç detaylarına doğrudan erişim engellenerek Law of Demeter Violations code smell'i ortadan kaldırıldı.
*/