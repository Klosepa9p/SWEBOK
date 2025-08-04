public class Customer {
    private String name;
    private String phoneNumber; // Telefon numarası sadece String olarak tutuluyor
    private String addressStreet; // Adres bilgileri ilkel tiplerle temsil ediliyor
    private String addressCity;
    private String addressPostalCode;

    public Customer(String name, String phoneNumber, String addressStreet, String addressCity, String addressPostalCode) {
        this.name = name;
        this.phoneNumber = phoneNumber; // Doğrulama yok, geçersiz veri girebilir
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressPostalCode = addressPostalCode;
    }

    public void validatePhoneNumber() {
        if (!phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Geçersiz telefon numarası");
        }
    }

    public String formatAddress() {
        return addressStreet + ", " + addressCity + " " + addressPostalCode;
    }
}