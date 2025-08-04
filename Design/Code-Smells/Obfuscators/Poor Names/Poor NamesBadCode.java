public class Calc {
    // Hesaplama için metod
    public double fn(String s, int n, double d) {
        // Kontrol
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Hata: veri eksik");
        }

        // İşlem
        double x = d * n;

        // Durum kontrolü
        if (s.contains("SP")) {
            x = x * 0.85; // indirim
        }

        // Sonuç kaydet
        DB.write(s, x);

        return x;
    }
}

class DB {
    public static void save(String s, double x) {
        // Veritabanına kaydet
        System.out.println("Kaydedildi: " + s + ", " + x);
    }
}

/*
Sorun: Yukarıdaki kodda, isimlendirme ciddi şekilde yetersiz:

Sınıf ismi Calc belirsiz ve neyi hesapladığını ifade etmiyor.

Metod ismi fn anlamsız ve metodun amacını açıklamıyor.

Değişken isimleri s, n, d, x hiçbir bağlam sağlamıyor.

DB sınıfı ve save metodu, ne tür bir veri kaydedildiğini belirtmiyor. Bu belirsiz isimler, kodun anlaşılmasını zorlaştırıyor
ve yorumlara bağımlılığı artırıyor.
*/

