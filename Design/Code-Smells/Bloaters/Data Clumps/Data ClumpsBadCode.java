public class Event {
    public void createEvent(String eventName, String street, String city, String postalCode, int startHour, int startMinute, int endHour, int endMinute) {
        // Adres ve zaman bilgilerini doğrula
        if (street == null || city == null || postalCode == null) {
            throw new IllegalArgumentException("Adres bilgileri eksik");
        }
        if (startHour < 0 || startMinute < 0 || endHour < 0 || endMinute < 0) {
            throw new IllegalArgumentException("Geçersiz zaman bilgileri");
        }

        // Adresi formatla
        String fullAddress = street + ", " + city + " " + postalCode;

        // Zamanı formatla
        String eventTime = String.format("%02d:%02d - %02d:%02d", startHour, startMinute, endHour, endMinute);

        // Etkinliği kaydet
        System.out.println("Etkinlik: " + eventName + ", Adres: " + fullAddress + ", Zaman: " + eventTime);
    }

    public void updateEventLocation(String eventName, String street, String city, String postalCode) {
        // Adres bilgilerini güncelle
        if (street == null || city == null || postalCode == null) {
            throw new IllegalArgumentException("Adres bilgileri eksik");
        }
        String fullAddress = street + ", " + city + " " + postalCode;
        System.out.println("Etkinlik lokasyonu güncellendi: " + eventName + ", Yeni Adres: " + fullAddress);
    }
}