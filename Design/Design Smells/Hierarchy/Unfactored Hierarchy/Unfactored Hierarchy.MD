# Unfactored Hierarchy

## 🔍 Nedir?

**Unfactored Hierarchy**, nesne yönelimli tasarımda ortak özelliklerin veya davranışların hiyerarşide uygun şekilde soyutlanmaması ve paylaşılmaması durumudur.  
Buna bağlı olarak, benzer kod parçaları farklı sınıflarda tekrar eder ve hiyerarşi yeterince “faktörize” edilmemiş olur.

---

## 🚫 Neden Kötüdür?

- 🔁 **Kod tekrarı artar**: Ortak işlevsellik her sınıfta ayrı ayrı bulunur.
- 📉 **Bakımı zorlaşır**: Değişiklik yaparken birçok sınıfta güncelleme gerekir.
- 🧩 **Kod karmaşıklaşır**: Tekrarlanan parçalar kodun okunabilirliğini ve sürdürülebilirliğini düşürür.
- ❌ **Yeniden kullanım azalır**: Ortak davranışların paylaşımı mümkün olmaz.
- 🛠️ **Hiyerarşi yapısı zayıf olur**: Sınıflar arasındaki ilişki ve sorumluluklar netleşmez.

---

## ✅ Çözüm Yaklaşımı

- Ortak özellik ve davranışları tespit et ve soyut üst sınıflarda topla.
- Hiyerarşiyi yeniden düzenleyerek kod tekrarı önle.
- SOLID prensiplerinden **DRY (Don't Repeat Yourself)** ve **Open/Closed Principle**'ı uygula.
- Gerektiğinde yardımcı sınıflar veya arayüzler kullan.

---

## 📚 Gerçek Hayattan Analoji

Bir müzik grubunda herkes farklı nota yazmak yerine, ortak bir nota kitabı kullanmalıdır.  
Eğer her müzisyen kendi notasını ayrı ayrı yazarsa, aynı parçalar tekrar tekrar yazılır ve çalışma verimsiz olur.

Benzer şekilde, yazılımda ortak davranışların tek bir yerde toplanması kodun verimliliğini artırır.
