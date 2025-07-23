## 🧩 Interface Segregation Principle (ISP)

- Alt sınıf, üst sınıftan kalıtım aldığında **bir sözleşme imzalar**:
  Üst sınıfta tanımlı tüm özellik ve metotları **kendisine ekler**.

- Ancak bu durumda:
  Kullanmayacağı metotları da almak zorunda kalır; bu da gereksiz bağımlılığa ve karmaşıklığa yol açar.

---

### ⚠️ Problem

> Alt sınıfın, ihtiyacı olmayan metotları **boş (dummy)** bırakması veya sadece “kullanılmıyor” demesi,
> tasarımın kötü kokusudur ve bakım zorluklarına sebep olur.

---

### ✅ Çözüm

- **Büyük bir arayüz** (interface veya abstract class) yerine,
- Daha küçük, daha spesifik **birden fazla arayüz** tanımlarız.
- Alt sınıf, sadece ihtiyacı olan arayüz(ler)i implement eder.
- Böylece **kullanmayacağı özellikleri** almamış olur.

---

### 🔄 LSP ile ilişkisi

> ISP, Liskov Substitution Principle’a benzer:
> - Alt sınıflar, sadece kullanacakları sözleşmelere (arayüzlere) uyar.
> - Liskov ise alt sınıfların üst sınıfın yerine geçebilmesini ve tutarlı davranmasını garanti eder.

---

✅ **Kısa özet:**  
> Alt sınıflar **ihtiyaç duymadıkları metotlara** bağımlı olmamalıdır.  
> Bunun için büyük bir arayüz yerine, **küçük ve spesifik arayüzler** tanımlanmalıdır.

---