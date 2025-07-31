## 🧩 Decompose Conditional Yöntemi

### 🐞 Problem

- Bir koşullu ifade (`if-then-else`) karmaşık veya uzun bir mantık içeriyorsa, kodun okunabilirliği azalır ve anlaşılması zorlaşır.
- Koşulun neyi kontrol ettiği veya dalların ne yaptığı net değilse, bakım ve hata ayıklama süreçleri karmaşıklaşır.

---

### ✅ Çözüm

Karmaşık koşullu ifadeyi **daha küçük ve anlamlı metotlara** ayırın.  
Koşul mantığını ve her dalın davranışını ayrı metotlarda tanımlayarak kodu daha net ve modüler hâle getirin.

---

### 🌱 Faydaları

- Kod daha okunabilir ve anlaşılır olur; çünkü her metot tek bir sorumluluğa odaklanır.
- Bakım kolaylaşır; mantık parçalara bölünmüş olur.
- Test edilebilirlik artar; küçük metotlar ayrı ayrı test edilebilir.

---

### 🛠️ Nasıl Uygulanır

1. Karmaşık koşullu ifadeyi belirleyin.
2. Koşul mantığını bir metot olarak çıkarın ve açıklayıcı bir isim verin.
3. Her dalın (`then` / `else`) davranışını ayrı metotlara taşıyın.
4. Orijinal koşullu ifadeyi, yeni metot çağrılarıyla değiştirin.
5. Kodu test edin.
