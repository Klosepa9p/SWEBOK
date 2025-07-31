## 🧩 Consolidate Duplicate Conditional Fragments Yöntemi

### 🐞 Problem

Birden fazla koşullu dal (`if`, `else if`, `else`) içinde aynı kod parçaları tekrar ediyorsa, bu durum:
- Kod tekrarı (**duplication**) oluşturur.
- Bakım ve güncelleme süreçlerini zorlaştırır.
- Hata riskini artırır.

---

### ✅ Çözüm

Tekrar eden kod parçalarını, koşullu ifadelerin **dışına taşıyın**.  
Böylece kod yalnızca bir kez yazılır ve tüm dallar tarafından paylaşılır.

---

### 🌱 Faydaları

- Kod tekrarı azalır, kod daha sade ve okunabilir olur.
- Bakım kolaylaşır; değişiklikler tek bir yerde yapılır.
- Hata riski düşer; çünkü tekrar eden kod tek noktada toplanır.

---

### 🛠️ Nasıl Uygulanır

1. Koşullu ifadelerdeki tekrar eden kod parçalarını belirleyin.
2. Tekrar eden kodu, koşullu ifadelerin **öncesine veya sonrasına** taşıyın.
3. Koşullu mantığı, yalnızca **farklılıkları** işleyecek şekilde sadeleştirin.
4. Kodu test edin.

