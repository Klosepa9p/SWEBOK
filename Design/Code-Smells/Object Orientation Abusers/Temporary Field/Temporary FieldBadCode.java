public class ReportGenerator {
    private double tempTotal; // Geçici alan
    private String tempReportHeader; // Geçici alan

    public void generateReport(Order order) {
        // Geçici alanları başlat
        tempTotal = 0;
        tempReportHeader = "Rapor: " + order.getId();

        // Toplam hesaplama
        for (Item item : order.getItems()) {
            tempTotal += item.getPrice() * item.getQuantity();
        }

        // İndirim uygulama
        if (order.getCustomer().isVIP()) {
            tempTotal *= 0.9; // %10 indirim
        }

        // Rapor oluştur
        String report = tempReportHeader + "\nToplam: " + tempTotal;
        System.out.println(report);

        // Geçici alanları sıfırla (gereksiz karmaşıklık)
        tempTotal = 0;
        tempReportHeader = null;
    }
}


/*

Sorun: Yukarıdaki kodda, tempTotal ve tempReportHeader alanları yalnızca generateReport metodu için kullanılıyor
ve sınıfın genel durumunda anlamlı bir rol oynamıyor. Bu, Temporary Field kokusuna neden oluyor. Alanların sıfırlanması
gerekliliği ve sınıf düzeyinde tutulmaları, kodu karmaşıklaştırıyor ve hata riskini artırıyor (örneğin, başka bir metod
yanlışlıkla tempTotal'ı kullanabilir).

*/