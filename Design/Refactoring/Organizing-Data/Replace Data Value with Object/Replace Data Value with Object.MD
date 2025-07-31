## 🧩 Replace Data Value with Object Yöntemi

### 🐞 Problem

- Bir veri değeri (örneğin, bir ilkel tür veya basit bir veri yapısı), karmaşık davranışlar veya ek özellikler gerektiriyorsa, bu değerin yalnızca bir veri olarak kalması yetersiz olur.
- Basit bir veri türü, ilişkili mantığı veya doğrulama kurallarını kapsülleyemez, bu da kodun dağınıklığına ve bakım zorluklarına neden olabilir.

---

### ✅ Çözüm

İlkel veri değerini bir **sınıfa** dönüştürün ve bu sınıfa ilgili davranışları veya metotları ekleyerek, veri ve mantığı birlikte kapsülleyin.

---

### 🌱 Faydaları

- Veri ve ilgili davranışlar tek bir sınıfta toplanır, kod daha organize olur.
- **Enkapsülasyon** artar; veri doğrulama, formatlama veya iş mantığı kolayca eklenebilir.
- Kodun okunabilirliği ve bakımı iyileşir.

---

### 🛠️ Nasıl Uygulanır

1. İlkel veri değerini belirleyin ve kullanım yerlerini analiz edin.
2. Bu veri için yeni bir **sınıf** oluşturun ve değeri bir alan olarak tanımlayın.
3. İlgili davranışları veya metotları yeni sınıfa ekleyin.
4. Orijinal kodda ilkel değeri, yeni sınıfın örneğiyle değiştirin.
5. Kodu test edin.


