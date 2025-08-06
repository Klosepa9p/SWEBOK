# Missing Encapsulation

## 🔍 Nedir?

**Missing Encapsulation**, bir sınıf ya da modülün verilerini veya iç işleyişini dışarıya gereğinden fazla açık etmesi durumudur.  
Veri üyelerinin veya içsel davranışların doğrudan dışarıdan erişilebilir olması, kapsülleme ilkesinin ihlali anlamına gelir.

Bu durum çoğunlukla:
- public alanlar (fields) kullanılması,
- setter/getter metodlarının gereksiz ve kontrolsüz kullanımı,
- sınıfın iç işleyişini doğrudan açığa çıkaran tasarımlar ile ortaya çıkar.

---

## 🚫 Neden Kötüdür?

- 🔓 **Veri güvenliği azalır**: Nesne içindeki veri dış etkilere karşı korunmaz.
- 🔁 **Değişiklik maliyeti artar**: Verinin dışa bağımlılığı arttığı için, değişikliklerin etkisi büyür.
- 🧩 **Modülerlik bozulur**: Bileşenler arası sınırlar silikleşir.
- 🔧 **Davranış ve durum kontrolü zorlaşır**: Nesnenin geçerli durumda olup olmadığını kontrol etmek zorlaşır.

---

## ✅ Çözüm Yaklaşımı

- 🔒 Alanları (fields) `private` veya `protected` hale getir.
- 🚪 Dış erişim için kontrollü metodlar (örneğin validation içeren getter/setter) kullan.
- 🔍 Yalnızca dış dünya ile etkileşimde gerekli olan bilgileri paylaş.
- 🧱 Nesne içi mantığı soyutla ve dışa yalnızca ihtiyaç duyulan API'leri sun.

---

## 📚 Gerçek Hayattan Analoji

Bir banka kasasının şifresinin herkes tarafından bilinmesi, kasanın var olmasının bir anlamını ortadan kaldırır.  
Kapsülleme, veriyi kilitleyip sadece güvenli kapıdan geçişe izin vermektir.

**Missing Encapsulation** ise kasanın kapağını açık bırakmaktır:  
herkes içeri müdahale edebilir, zarar verebilir, hatta tüm sistemin güvenliğini tehdit eder.
