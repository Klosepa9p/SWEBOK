# Rebellious Hierarchy

## 🔍 Nedir?

**Rebellious Hierarchy**, nesne yönelimli tasarımda alt sınıfların üst sınıflarının kurallarını, sözleşmelerini veya beklenen davranışlarını ihlal etmesi durumudur.  
Bu alt sınıflar, üst sınıfın sunduğu işlevselliği ya değiştirmez ya da beklenmeyen şekillerde değiştirerek hiyerarşide tutarsızlık yaratır.

---

## 🚫 Neden Kötüdür?

- ❌ **Liskov Substitution Principle** (LSP) ihlal edilir: Alt sınıf, üst sınıfın yerine geçememektedir.
- 🔄 **Polimorfizm bozulur**: Üst sınıf referansları alt sınıflarla düzgün çalışmaz.
- 🧩 **Kodun davranışı öngörülemez hale gelir**: Hiyerarşide beklenen davranışların garantisi yoktur.
- 🐛 **Hatalar ve beklenmedik yan etkiler artar**: Sistem kararsız ve güvenilmez olur.
- 🔧 **Bakımı zorlaşır**: Hiyerarşideki alt sınıfların davranışlarını takip etmek güçleşir.

---

## ✅ Çözüm Yaklaşımı

- Alt sınıfların üst sınıfın sözleşmelerine ve davranışlarına tam uymasını sağla.
- Tasarım aşamasında **Liskov Substitution Principle**’a dikkat et.
- İhtiyaç varsa üst sınıf veya arayüzde gerekli değişiklikleri yaparak alt sınıfların uyumunu sağla.
- Testlerle hiyerarşideki davranış tutarlılığını doğrula.

---

## 📚 Gerçek Hayattan Analoji

Bir şirket yöneticisinin verdiği kararları çalışanların tamamen görmezden gelmesi veya kendi kurallarını uygulaması gibidir.  
Bu durum, şirket içinde kargaşa yaratır ve işlerin tutarsız yürütülmesine neden olur.

Benzer şekilde, alt sınıflar üst sınıfın kurallarına karşı gelirse yazılım sistemi güvenilirliğini kaybeder.
