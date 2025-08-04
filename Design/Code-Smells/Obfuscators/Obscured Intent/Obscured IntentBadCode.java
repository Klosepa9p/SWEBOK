public class Handler {
    public double calc(String a, int b, boolean c) {
        // İşlem yap
        double r = 0;
        if (a != null) {
            for (int i = 0; i < b; i++) {
                r += 100; // Sabit ekleme
            }
            if (c) {
                r = r * 0.75; // Özel durum
            }
            r = r + r * 0.2; // Ek hesaplama
        }
        // Sonucu kaydet
        Storage.write(a, r);
        return r;
    }
}

class Storage {
    public static void write(String key, double value) {
        System.out.println("Kaydedildi: " + key + ", Değer: " + value);
    }
}

/*
Sorun: Yukarıdaki kodda, niyet belirsiz:

Sınıf ismi Handler ve metod ismi calc, ne yaptıkları hakkında bilgi vermiyor.

Değişken isimleri a, b, c, r anlamsız ve bağlam sağlamıyor.

İşlemlerin amacı (örneğin, 100 eklenmesi, %75 çarpımı veya %20 ek hesaplama) net değil.

Yorumlar (// İşlem yap, // Özel durum) kodu açıklamıyor, sadece gürültü yaratıyor. Bu, Obscured Intent kokusuna yol açarak
kodun anlaşılmasını zorlaştırıyor.
*/