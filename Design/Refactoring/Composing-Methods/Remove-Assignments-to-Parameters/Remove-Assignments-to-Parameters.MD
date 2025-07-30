## 🚫 Remove Assignments to Parameters Yöntemi

### 🐞 Problem

- Bir metoda geçirilen parametreye yeni bir değer atanması, kodun anlaşılmasını zorlaştırır ve beklenmedik yan etkilere neden olabilir.
- Parametrelerin değişmesi, metodun orijinal girdilerini değiştirebileceği için hata riskini artırır.

---

### ✅ Çözüm

Parametrelere atama yapmaktan kaçının.  
Bunun yerine, yeni bir yerel değişken oluşturun ve hesaplamaları bu değişken üzerinde gerçekleştirin.  
Böylece parametreler değişmez (**immutable**) kalır.

---

### 🌱 Faydaları

- Kod daha güvenli ve öngörülebilir olur.
- Parametrelerin orijinal değerleri korunur, yan etkiler azalır.
- Okunabilirlik ve bakım kolaylığı artar.

---

### 🛠️ Nasıl Uygulanır

1. Parametreye atama yapılan yerleri tespit edin.
2. Parametrenin yerine geçecek yeni bir yerel değişken tanımlayın.
3. Atamaları bu yeni değişken üzerinde yapın.
4. Parametre kullanımını yerel değişkenle değiştirin.
5. Kodun doğru çalıştığından emin olmak için test et.
