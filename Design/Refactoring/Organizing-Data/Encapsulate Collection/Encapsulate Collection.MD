## 📦 Encapsulate Collection Yöntemi

### 🐞 Problem

- Bir sınıf, bir koleksiyonu (örneğin, liste veya küme) doğrudan bir alan olarak açığa vuruyorsa, istemciler bu koleksiyonu doğrudan değiştirebilir.
- Bu durum, **veri bütünlüğünü riske atar**.
- Koleksiyonun nasıl değiştirileceği veya erişileceği konusunda kontrol eksikliği, **beklenmedik yan etkilere** neden olabilir.

---

### ✅ Çözüm

- Koleksiyonu **kapsülleyin (encapsulate)** ve doğrudan erişimi engelleyin.
- Koleksiyona erişim ve değişiklik için özel metotlar (getter/setter veya ekleme/çıkarma metotları) sağlayarak sınıfın kontrolünü artırın.

---

### 🌱 Faydaları

- Koleksiyonun **veri bütünlüğü korunur**, istemciler yalnızca tanımlı metotlar üzerinden erişebilir.
- Koleksiyonun nasıl değiştirileceği sınıf tarafından **kontrol edilir**, doğrulama veya ek mantık eklenebilir.
- Kodun **bakımı ve güvenliği artar**.

---

### 🛠️ Nasıl Uygulanır

1. Koleksiyon alanını `private` yapın ve doğrudan erişimi kaldırın.
2. Koleksiyona erişim için:
   - Bir kopyasını döndüren bir getter metodu oluşturun, veya
   - Değiştirilemez bir görünüm sunun.
3. Koleksiyona eleman ekleme/çıkarma için özel metotlar ekleyin.
4. İstemci kodlarını, yeni metotları kullanacak şekilde güncelleyin.
5. Kodu test edin.
