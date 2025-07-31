## 🛡️ Self Encapsulate Field Yöntemi

### 🐞 Problem

- Bir sınıfın alanlarına (**fields**) doğrudan erişim, sınıf içinde veya dışında veri bütünlüğünü riske atabilir veya gelecekteki değişiklikleri zorlaştırabilir.
- Alanın kullanım mantığını değiştirmek (örneğin, doğrulama eklemek) gerektiğinde, tüm doğrudan erişimleri güncellemek zahmetli olur.

---

### ✅ Çözüm

Alana doğrudan erişimi kaldırın ve bunun yerine **getter** ve **setter** metotları kullanarak alanı kapsülleyin (**encapsulate**).  
Sınıf içindeki doğrudan erişimleri de bu metotlarla değiştirin.

---

### 🌱 Faydaları

- Veri kapsüllemesi artar, alanın kontrolü sınıf içinde kalır.
- Alanın kullanımına doğrulama veya ek mantık eklenebilir.
- Kodun bakımı ve genişletilmesi kolaylaşır.

---

### 🛠️ Nasıl Uygulanır

1. Alana doğrudan erişilen yerleri belirleyin.
2. Alana erişim için **getter** ve gerekirse **setter** metotları oluşturun.
3. Sınıf içindeki ve dışındaki tüm doğrudan alan erişimlerini getter/setter çağrılarıyla değiştirin.
4. Alanı `private` yaparak doğrudan erişimi kısıtlayın.
5. Kodu test edin.
