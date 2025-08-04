public class Address {
    private String street;
    private String city;
    private String postalCode;

    public Address(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}

public class Customer {
    private String name;
    private Address address;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getFormattedAddress() {
        // Adres formatlama mantığı burada
        return address.getStreet() + ", " + address.getCity() + " " + address.getPostalCode();
    }
}

// Sorun: Address sınıfı yalnızca veri tutuyor ve hiçbir anlamlı davranışa sahip değil. Getter ve setter
// metodları dışında bir işlevi yok, bu da "Class Doesn't Do Much" kokusuna işaret ediyor. Adres formatlama
// gibi iş mantığı, Customer sınıfına yüklenmiş.