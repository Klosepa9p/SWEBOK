public class Customer {
    private String name;
    private PhoneNumber phoneNumber;
    private Address address;

    public Customer(String name, PhoneNumber phoneNumber, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getFormattedAddress() {
        return address.format();
    }
}

class PhoneNumber {
    private final String number;

    public PhoneNumber(String number) {
        if (!number.matches("\\d{10}")) {
            throw new IllegalArgumentException("Geçersiz telefon numarası");
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number;
    }
}

class Address {
    private final String street;
    private final String city;
    private final String postalCode;

    public Address(String street, String city, String postalCode) {
        if (street == null || city == null || postalCode == null) {
            throw new IllegalArgumentException("Adres bilgileri eksik");
        }
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String format() {
        return street + ", " + city + " " + postalCode;
    }
}

/*
Açıklama: Düzeltilmiş kodda, PhoneNumber ve Address sınıfları oluşturularak ilkel tiplerin yerini aldı. Bu sınıflar,
veri doğrulama ve formatlama gibi davranışları kendi içlerinde barındırıyor. Böylece kod daha modüler, yeniden
kullanılabilir ve güvenli hale geldi. Customer sınıfı, bu yeni sınıfları kullanarak daha temiz ve anlaşılır bir yapıya
kavuştu.
*/
