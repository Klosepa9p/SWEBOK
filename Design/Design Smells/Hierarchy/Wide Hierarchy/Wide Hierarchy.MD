# Wide Hierarchy

## 🔍 Nedir?

**Wide Hierarchy**, nesne yönelimli tasarımda bir üst sınıfın çok sayıda doğrudan alt sınıfa sahip olduğu, yani hiyerarşinin yatayda çok genişlediği durumu ifade eder.  
Bu durum, üst sınıfın birçok farklı alt sınıf tarafından miras alınmasıyla ortaya çıkar.

---

## 🚫 Neden Kötüdür?

- 🧩 **Sorumluluk dağılımı karmaşıklaşır**: Çok sayıda alt sınıfın yönetimi zorlaşır.
- 🔍 **Anlaşılması zorlaşır**: Alt sınıflar arasında ilişki ve farklar takip edilemez hale gelebilir.
- 🛠️ **Bakım zorlaşır**: Üst sınıfta yapılacak değişikliklerin etkisi büyük olur.
- 📉 **Yeniden kullanım ve genişletilebilirlik kısıtlanabilir**: Çok fazla alt sınıf yönetmek güçlük yaratır.
- ⚠️ **Tasarım prensipleri (örneğin SRP)** ihlal edilebilir.

---

## ✅ Çözüm Yaklaşımı

- Üst sınıfın sorumluluklarını gözden geçirerek **modüler ve küçük sınıflar** tasarla.
- Alt sınıfları anlamlı gruplara bölerek **ara soyutlamalar** ekle.
- Gerektiğinde kompozisyon (composition) kullanarak sorumlulukları dağıt.
- Hiyerarşi yapısını sadeleştirmek için **design pattern**’lerden yararlan.

---

## 📚 Gerçek Hayattan Analoji

Bir şirketin bir müdürünün doğrudan yüzlerce çalışana yönetici olmaya çalışması gibidir.  
Bu durumda yönetim zorlaşır, iletişim kopuklukları ve verimsizlikler ortaya çıkar.

İyi bir organizasyonda, yöneticiler kademelere ayrılır ve sorumluluklar paylaşılır.

---
