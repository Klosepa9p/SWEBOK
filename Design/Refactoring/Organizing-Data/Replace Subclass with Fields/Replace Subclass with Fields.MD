## 🔄 Replace Subclass with Fields Yöntemi

### 🐞 Problem

- Bir sınıf hiyerarşisi, yalnızca birkaç farklı özelliği temsil eden alt sınıflardan (subclass) oluşuyorsa ve bu farklılıklar basit veri değişiklikleriyle ifade edilebiliyorsa, hiyerarşi gereksiz karmaşıklık yaratır.
- Alt sınıflar, davranış yerine yalnızca veri farklılıkları içeriyorsa, bu yapı kodun bakımını zorlaştırabilir.

---

### ✅ Çözüm

- Alt sınıfları kaldırın ve onların temsil ettiği farklılıkları ana sınıfta alanlar (fields) olarak tanımlayın.
- Alt sınıf seçimini, bu alanların değerlerine göre koşullu mantıkla yönetin.

---

### 🌱 Faydaları

- Kod daha sade ve az sınıflı olur, hiyerarşi karmaşıklığı azalır.
- Bakım kolaylaşır, çünkü tüm mantık tek bir sınıfta toplanır.
- Performans küçük ölçüde iyileşebilir, çünkü alt sınıf oluşturma maliyeti kalkar.

---

### 🛠️ Nasıl Uygulanır

1. Alt sınıfların yalnızca veri farklılıkları sunduğunu doğrulayın.
2. Ana sınıfta, alt sınıfların farklılıklarını temsil eden alanlar ekleyin (örneğin, bir tür veya durum alanı).
3. Alt sınıflardaki metotları ana sınıfa taşıyın ve koşullu mantıkla (örneğin, `if` veya `switch`) farklılıkları yönetin.
4. Alt sınıfları kaldırın ve istemcileri ana sınıfı kullanacak şekilde güncelleyin.
5. Kodu test edin.