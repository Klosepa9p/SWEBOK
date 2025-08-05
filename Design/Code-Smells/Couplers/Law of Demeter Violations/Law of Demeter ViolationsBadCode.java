public class Customer {
    public Address address; // Genel alan
    public String name;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

public class Address {
    public String street; // Genel alan
    public String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
}

public class OrderProcessor {
    public void processOrder(Customer customer, double amount) {
        // Law of Demeter ihlali: Customer -> Address -> street/city
        if (customer.address.street == null || customer.address.city == null) {
            throw new IllegalArgumentException("Geçersiz adres bilgisi");
        }

        // İş mantığı
        double finalAmount = amount * 1.18; // %18 KDV
        String message = "Sayın " + customer.name + ", siparişiniz işlendi. Adres: " 
            + customer.address.street + ", " + customer.address.city + ", Toplam: " + finalAmount;
        
        EmailService.sendEmail(customer.name, "Sipariş Onayı", message);
        Database.saveOrder(customer.name, finalAmount);
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

/*
Sorun: Yukarıdaki kodda, OrderProcessor sınıfı Law of Demeter'ı ihlal ediyor:

- customer.address.street ve customer.address.city gibi zincirleme erişimler, Customer sınıfının içindeki Address nesnesinin detaylarına doğrudan erişiyor.
- Customer ve Address sınıflarının public alanları, kapsülleme ihlaline neden oluyor ve OrderProcessor'ın bu iç detaylara bağımlı olmasına yol açıyor.
- Bu, Address sınıfının yapısında yapılacak bir değişikliğin (örneğin, street alanının kaldırılması) OrderProcessor'ı doğrudan etkilemesine neden olur.
*/