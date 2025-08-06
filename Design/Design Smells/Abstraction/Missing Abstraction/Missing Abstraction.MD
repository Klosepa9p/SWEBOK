# Missing Abstraction

## 🔍 Nedir?

**Missing Abstraction (Eksik Bırakılmış Soyutlama)**, kodun içinde tekrar eden, anlamlı bir kavram veya işlem grubunun ayrı bir yapı (sınıf, fonksiyon, arayüz vs.) altında soyutlanmamış olmasıdır.

Yani ortak bir davranış veya veri yapısı birden çok yerde benzer şekilde kullanılıyor ama bu kullanım için özel bir soyutlama yapılmamış.  
Bunun sonucunda aynı işlevsellik, farklı yerlerde tekrar tekrar tanımlanır.

---

## 🚫 Neden Kötüdür?

- 🔁 **Kod tekrarı** oluşur; aynı işlemler birçok yerde tekrar eder.
- 📉 **Bakımı zorlaştırır**: Değişiklik yapılması gerektiğinde birçok yeri güncellemek gerekir.
- ❌ **Anlam eksikliği vardır**: Ortak bir kavramı temsil eden yapı olmadığı için kodda kavramsal bütünlük zayıftır.
- 🤯 **Anlaşılması zorlaşır**: Geliştirici aynı yapının neden birçok yerde tekrarlandığını anlayamaz.
- 🧱 **Genişletilebilirliği düşürür**: Değişiklik yaparken her yerde ayrı ayrı müdahale gerekir.

---

## ✅ Çözüm Yaklaşımı

- Ortak veri yapıları, işlem grupları veya davranışları belirle ve soyutla.
- Bu tekrar eden yapıları **sınıf**, **metot**, **arayüz** ya da **modül** haline getir.
- Tek bir merkezden yönetilebilecek hale getirerek kodu **DRY (Don't Repeat Yourself)** ilkesine uygun hale getir.
- Domain modellemesi yapılırken, tekrarlanan yapılar domain kavramlarına göre soyutlanmalı.

---

## 📚 Gerçek Hayattan Analoji

Bir şirkette farklı departmanlar aynı formatta rapor hazırlıyor: finans, insan kaynakları, satış vs.  
Ancak herkes kendi şablonunu sıfırdan yazıyor ve benzer yapılar her belgede tekrar ediliyor.

Bu durumda:

- Herkes zaman kaybeder,
- Tutarlılık bozulur,
- Değişiklik yapıldığında tüm belgelerin elle güncellenmesi gerekir.

**Daha doğru çözüm:** Ortak bir rapor şablonu oluşturmak ve herkesin bunu kullanmasını sağlamaktır.  
Böylece hem zaman kazanılır hem de tutarlılık sağlanır.
