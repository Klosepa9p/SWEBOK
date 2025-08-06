# Duplicate Abstraction

## 🔍 Nedir?

**Duplicate Abstraction (Yinelenen Soyutlama)**, yazılım içinde aynı veya çok benzer işlevleri gerçekleştiren **birden fazla sınıf, arayüz veya yapı** tanımlanmasıdır.

Bu soyutlamalar isim olarak farklı olsa da işlev olarak neredeyse aynıdır. Genellikle:

- Geliştiriciler aynı sorunu bağımsız olarak çözmeye çalıştığında,
- Veya projede yeterli koordinasyon olmadığında ortaya çıkar.

---

## 🚫 Neden Kötüdür?

- 🔁 **Kod tekrarı** oluşturur.
- 🧩 **Bakımı zorlaştırır**: Bir değişiklik tüm benzer yapılar için tekrar edilmelidir.
- 🐞 **Hata yapma olasılığı artar**: Bir yapı güncellenirken diğeri unutulabilir.
- 🧠 **Anlaşılırlığı azaltır**: Hangi sınıfın ne zaman kullanılacağı karışır.
- 📉 **Kod kalitesini ve okunabilirliği düşürür.**

---

## ✅ Çözüm Yaklaşımı

1. **Benzer yapıları tespit et:**
   - Aynı işleve sahip ama farklı isimli sınıf/arayüzleri belirle.

2. **Ortak bir soyutlama oluştur:**
   - Anlamlı, işlevi temsil eden tek bir yapı tasarla.

3. **Yinelenen yapıları kaldır:**
   - Gereksiz sınıf ve arayüzleri sil, bağlı kodları yeni yapıya yönlendir.

4. **Genişletilebilirlik gerekiyorsa:**
   - Arayüz (interface) veya soyut sınıf (abstract class) kullanarak esnek yapı kur.

---

## 📚 Gerçek Hayattan Analoji

Bir şirkette hem “Fatura Gönderici” hem de “Ödeme Bildirici” adında iki farklı çalışan var. Ancak ikisi de aslında müşterilere aynı e-postayı gönderiyor: “Ödemenizi aldık, teşekkür ederiz.”

İşlev aynı ama iki farklı isimle yapılmakta. Bu durum:

- Gereksiz iş gücüne,
- Karışıklığa,
- Ve süreçte gecikmeye neden olur.

Daha verimli çözüm: Tek bir görev tanımı altında birleştirip, herkesin aynı yapıdan faydalanmasını sağlamak.

---
