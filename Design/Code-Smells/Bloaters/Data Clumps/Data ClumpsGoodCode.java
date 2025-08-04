public class Event {
    public void createEvent(String eventName, Address address, TimeRange timeRange) {
        // Adres ve zaman bilgilerini doğrula
        address.validate();
        timeRange.validate();

        // Adresi ve zamanı formatla
        String fullAddress = address.format();
        String eventTime = timeRange.format();

        // Etkinliği kaydet
        System.out.println("Etkinlik: " + eventName + ", Adres: " + fullAddress + ", Zaman: " + eventTime);
    }

    public void updateEventLocation(String eventName, Address address) {
        // Adres bilgilerini güncelle
        address.validate();
        String fullAddress = address.format();
        System.out.println("Etkinlik lokasyonu güncellendi: " + eventName + ", Yeni Adres: " + fullAddress);
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

    public void validate() {
        if (street == null || city == null || postalCode == null) {
            throw new IllegalArgumentException("Adres bilgileri eksik");
        }
    }

    public String format() {
        return street + ", " + city + " " + postalCode;
    }
}

class TimeRange {
    private final int startHour;
    private final int startMinute;
    private final int endHour;
    private final int endMinute;

    public TimeRange(int startHour, int startMinute, int endHour, int endMinute) {
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    public void validate() {
        if (startHour < 0 || startMinute < 0 || endHour < 0 || endMinute < 0) {
            throw new IllegalArgumentException("Geçersiz zaman bilgileri");
        }
    }

    public String format() {
        return String.format("%02d:%02d - %02d:%02d", startHour, startMinute, endHour, endMinute);
    }
}

//Açıklama: Düzeltilmiş kodda, adres bilgileri (street, city, postalCode) bir Address sınıfında ve zaman bilgileri (startHour, startMinute, endHour, endMinute) 
// bir TimeRange sınıfında birleştirildi. Bu sınıflar, kendi doğrulama ve formatlama mantıklarını içeriyor. 
// Böylece, createEvent ve updateEventLocation metodları daha az parametre alıyor ve kod daha okunabilir, yeniden kullanılabilir ve bakımı kolay hale geliyor.
//  Data Clumps ortadan kaldırılarak kodun modülerliği artırıldı.