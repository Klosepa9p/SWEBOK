## 🔒 Encapsulate Field Yöntemi

### 🐞 Problem

- Bir sınıfın alanı (field) doğrudan erişilebilir durumdaysa (örneğin, `public`), istemciler bu alana sınırsız erişim sağlayabilir.
- Bu durum veri bütünlüğünü riske atar.
- Alanın nasıl kullanıldığını veya değiştirildiğini kontrol etmek zorlaşır, bu da hatalara ve bakım sorunlarına yol açabilir.

---

### ✅ Çözüm

- Alanı `private` yaparak doğrudan erişimi engelleyin.
- Getter/setter metotları aracılığıyla kontrollü erişim sağlayın.
- Böylece alanın kullanımı sınıf tarafından yönetilir.

---

### 🌱 Faydaları

- Veri kapsüllemesi (encapsulation) artar, alanın kontrolü sınıf içinde kalır.
- Getter/setter metotlarına doğrulama veya ek mantık eklenebilir.
- Kodun bakımı ve güvenliği iyileşir.

---

### 🛠️ Nasıl Uygulanır

1. Doğrudan erişilen `public` alanı belirleyin.
2. Alanı `private` yapın.
3. Alana erişim için getter, gerekirse setter metotları oluşturun.
4. İstemci kodlarını, doğrudan alan erişimi yerine getter/setter metotlarını kullanacak şekilde güncelleyin.
5. Kodu test edin.



