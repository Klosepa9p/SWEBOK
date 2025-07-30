## ✂️ Split Temporary Variable Yöntemi

### 🐞 Problem

- Bir geçici değişken, birden fazla farklı amaç için kullanılıyorsa; kodun okunabilirliği ve anlaşılırlığı azalır.
- Aynı değişkenin farklı değerlerle tekrar atanması, hata riskini artırır ve kodun amacını belirsizleştirir.

---

### ✅ Çözüm

Her farklı amaç için ayrı bir geçici değişken oluşturarak,  
her değişkenin tek bir sorumluluğu olmasını sağlamak. Böylece kod daha net ve güvenli hale gelir.

---

### 🌱 Faydaları

- Kodun okunabilirliği ve anlaşılırlığı artar.
- Değişkenlerin amacı açıkça belirtilir, hata riski azalır.
- Kod bakımı ve hata ayıklama kolaylaşır.

---

### 🛠️ Nasıl Uygulanır

1. Geçici değişkenin birden fazla amaç için kullanıldığını tespit edin.
2. Her farklı kullanım için yeni bir geçici değişken tanımlayın ve anlamlı isimler verin.
3. Değişkenin her atamasını, ilgili yeni değişkenle değiştirin.
4. Kodun doğru çalıştığından emin olmak için test et.
