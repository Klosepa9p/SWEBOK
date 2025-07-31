## 🧩 Consolidate Conditional Expression Yöntemi

### 🐞 Problem
Birden fazla koşullu ifade (`if`, `else if` vb.) aynı veya benzer bir sonucu üretiyorsa, bu durum:
- Kodun karmaşıklığını artırır.
- Okunabilirliği azaltır.
- Kodun bakımını zorlaştırır ve kod tekrarı yaratabilir.

---

### ✅ Çözüm
Birden fazla koşullu ifadeyi **tek bir koşullu ifadede** birleştirin.  
Bunu:
- Mantıksal operatörler (`&&`, `||`) kullanarak,
- Veya ayrı bir açıklayıcı metot oluşturarak
yaparak, kodu daha sade ve anlaşılır hale getirin.

---

### 🌱 Faydaları
- Kod daha kısa ve okunabilir olur.
- Koşullu mantık tek bir yerde toplanır, bakım kolaylaşır.
- Kod tekrarı azalır, hata riski düşer.

---

### 🛠️ Nasıl Uygulanır
1. Aynı veya benzer sonuçları üreten koşullu ifadeleri belirleyin.
2. Koşulları mantıksal operatörlerle birleştirin veya açıklayıcı bir metot olarak çıkarın.
3. Birleştirilmiş koşulu tek bir `if` ifadesinde kullanın.
4. Gerekirse birleşik koşulu daha okunur kılmak için açıklayıcı bir metot ismine dönüştürün.
5. Kodu test edin.


