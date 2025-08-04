public class Address {
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

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }
}

public class Customer {
    private final String name;
    private final Address address;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getFormattedAddress() {
        return address.format();
    }
}


//eklendi ve doğrulama mantığı sınıfın içine taşındı. Böylece Address sınıfı yalnızca 
//bir veri tutucu olmaktan çıktı ve kendi sorumluluğunu üstlendi. Ayrıca, alanlar final 
//yapılarak değişmez (immutable) hale getirildi, bu da sınıfın güvenilirliğini artırdı. 
//Eğer Address sınıfının başka bir işlevi olmayacaksa ve yalnızca veri tutacaksa, Customer 
//sınıfına doğrudan entegre edilerek tamamen kaldırılabilir (Inline Class):
//Açıklama: Düzeltilmiş kodda, Address sınıfına anlamlı bir davranış (format metodu) 
