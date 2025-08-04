public class ReportGenerator {
    public void generateReport(Order order) {
        double total = calculateTotal(order);
        String reportHeader = createReportHeader(order);
        String report = reportHeader + "\nToplam: " + total;
        System.out.println(report);
    }

    private double calculateTotal(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        if (order.getCustomer().isVIP()) {
            total *= 0.9; // %10 indirim
        }
        return total;
    }

    private String createReportHeader(Order order) {
        return "Rapor: " + order.getId();
    }
}


/*
Açıklama: Düzeltilmiş kodda, Temporary Field sorunu şu şekilde giderildi:

Yerel Değişken Kullanımı: tempTotal ve tempReportHeader sınıf alanları olmaktan çıkarıldı ve yalnızca
generateReport metodu içinde yerel değişkenler (total ve reportHeader) olarak tanımlandı.

Metod Bölme: Hesaplama ve başlık oluşturma mantığı, ayrı metodlara (calculateTotal ve createReportHeader)
bölündü, bu da kodu daha modüler ve okunabilir hale getirdi.

Kapsülleme: Sınıfın durumu, yalnızca kalıcı ve anlamlı verilerle sınırlı tutuldu, böylece gereksiz alanlar kaldırıldı.

Anlamlı İsimlendirme: Değişken ve metod isimleri, amacını net bir şekilde ifade edecek şekilde seçildi
(örneğin, calculateTotal yerine tempTotal).

Basitleştirme: Geçici alanların sıfırlanması gibi gereksiz işlemler ortadan kaldırıldı, bu da hata olasılığını azalttı.

Bu değişiklikler, kodun okunabilirliğini, bakım kolaylığını ve tasarım kalitesini artırdı. Geçici alanlar kaldırılarak
Temporary Field code smell'i ortadan kaldırıldı ve sınıfın yalnızca anlamlı bir durumu tutması sağlandı.
*/