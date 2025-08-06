# Missing Hierarchy

## 🔍 Nedir?

**Missing Hierarchy**, bir yazılım tasarımında uygun bir sınıf hiyerarşisi oluşturulmaması durumudur.  
Yani, benzer ya da ortak özelliklere sahip sınıflar arasında ortak bir üst sınıf veya soyutlama yapılmamış; böylece tekrar eden kod veya davranışlar çoğalmıştır.

---

## 🚫 Neden Kötüdür?

- 🔁 **Kod tekrarı artar**: Ortak özellikler tekrar tekrar yazılır.
- 📉 **Bakımı zorlaştırır**: Değişiklik yapılması gereken yer çok sayıda olabilir.
- 🧩 **Kodun anlaşılması zorlaşır**: Yapısal düzen eksik olduğu için kod karmaşık görünür.
- ❌ **Polimorfizm ve yeniden kullanım kısıtlanır**: Ortak üst yapı olmadığı için çok biçimlilikten yararlanılamaz.
- 🛠️ **Genişletilebilirlik azalır**: Yeni tür eklemek zorlaşır.

---

## ✅ Çözüm Yaklaşımı

- Benzer sınıflar için ortak üst sınıflar veya arayüzler oluştur.
- Ortak özellik ve davranışları soyut sınıflarda topla.
- Sınıf hiyerarşisini anlamlı ve mantıklı şekilde planla.
- SOLID prensiplerinden özellikle **Open/Closed** ve **Liskov Substitution** ilkelerine dikkat et.

---

## 📚 Gerçek Hayattan Analoji

Farklı türden arabalar için ayrı ayrı hiçbir ortak kategori olmadan bağımsız kayıtlar tutmak gibidir.  
Oysa tüm arabaların ortak özellikleri (motor, tekerlek, direksiyon vb.) ve davranışları (hareket etme, durma) vardır.  

Ortak bir “Araç” kavramı olmadan, her araba için ayrı ayrı her özelliği yazmak gerekecektir; bu da işleri zorlaştırır.

---
