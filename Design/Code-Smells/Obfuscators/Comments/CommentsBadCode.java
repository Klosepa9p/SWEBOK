public class PaymentProcessor {
    // Ödemeyi işlemek için metod
    public void proc(String id, double amt, boolean flag) {
        // ID kontrolü yap
        if (id == null || id.isEmpty()) {
            // Hata fırlat
            throw new IllegalArgumentException("ID eksik");
        }

        // Tutarı hesapla
        double finalAmt = amt;

        // İndirim kontrolü
        if (flag) {
            // %20 indirim
            finalAmt = finalAmt * 0.8;
        }

        // Vergi ekle
        finalAmt = finalAmt + finalAmt * 0.1; // %10 vergi

        // Ödemeyi kaydet
        DB.save(id, finalAmt); // Veritabanına kaydet

        // Log yaz
        System.out.println("Ödeme işlendi: " + id); // İşlem logu
    }
}

/*
Sorun: Yukarıdaki kod, gereksiz ve bariz yorumlarla dolu. Örneğin, // ID kontrolü yap veya // %20 indirim gibi yorumlar,
kodun zaten açıkça ifade ettiği şeyleri tekrarlıyor. Ayrıca, metod ismi (proc) ve değişken isimleri (id, amt, flag, finalAmt)
belirsiz, bu da yorumlara olan bağımlılığı artırıyor. Yorumlar, Poor Names ve Obscured Intent gibi diğer sorunları maskeliyor.
*/