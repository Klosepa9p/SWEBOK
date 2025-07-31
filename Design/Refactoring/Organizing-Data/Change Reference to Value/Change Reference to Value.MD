## 🔁 Change Reference to Value Yöntemi

### 🐞 Problem

- Bir nesne, **referans olarak** (örneğin, tekil bir nesne veya havuzdan alınarak) kullanılıyorsa; ancak bu nesne **değişmez (immutable)** veya her istemci için bağımsız bir kopya gerektiriyorsa, referans kullanımı gereksiz karmaşıklık yaratır.
- Referans nesneler, istemciler arasında paylaşım nedeniyle istenmeyen bağımlılıklara veya yan etkilere yol açabilir.

---

### ✅ Çözüm

Referans nesnesini bir **değer nesnesine** (**value object**) dönüştürün.  
Böylece her istemci kendi bağımsız kopyasını alır ve nesne paylaşımı ortadan kalkar; yan etkiler önlenir.

---

### 🌱 Faydaları

- Nesneler **bağımsız hale gelir**, yan etkiler azalır.
- Kod daha **basit** ve **öngörülebilir** olur.
- Değer nesneleri genellikle **değişmez (immutable)** olduğundan, veri tutarlılığı artar.

---

### 🛠️ Nasıl Uygulanır

1. Referans nesnesinin paylaşılıp paylaşılmadığını ve değişmez olup olmadığını doğrulayın.
2. Nesneyi **değer nesnesi** yapacak şekilde düzenleyin (örn. değişmez hale getirin).
3. Referans havuzunu veya fabrika metodunu kaldırın.
4. Her istemcinin kendi bağımsız kopyasını oluşturmasını sağlayın.
5. İstemci kodlarını, yeni kopyalarla çalışacak şekilde güncelleyin.
6. Kodu test edin.
