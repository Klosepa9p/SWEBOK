## 🧩 Singleton Pattern (Tasarım Deseni)

**Singleton**, bir sınıftan sadece **tek bir örneğin (instance)** oluşturulmasına izin veren tasarım desenidir.

---

### ✅ Ne işe yarar?
- Bir sınıfın **yalnızca bir nesnesi** olması gerektiğinde kullanılır. 
- Bu sayede:
  - Kaynak kullanımı kontrol altına alınır
  - Global bir erişim noktası sağlanır
  - Uygulamada tutarlılık korunur

---
## 🧩 Singleton Tasarım Deseni – Avantaj ve Dezavantajlar

| 📌 **Avantajlar** | ⚠️ **Dezavantajlar** |
|-------------------|----------------------|
| ✅ Sadece **bir tane nesne** olmasını garanti eder | ❗ Genellikle **global state** yaratarak bağımlılığı artırır |
| ✅ Global erişim sağlar, istediğin her yerden kolayca ulaşabilirsin | ❗ Test yazmayı zorlaştırır (Mocking / dependency injection ile uyumlu değildir) |
| ✅ Lazy initialization ile **kaynak kullanımını optimize eder** | ❗ Kodun birden çok yere dağılmış gibi görünmesine sebep olabilir |
| ✅ Modern C++ (Meyers’ Singleton) ile **thread-safe** ve basit | ❗ Birden çok thread'de karmaşık initialization ihtiyaçlarında esnekliği azalır |
| ✅ Konfigürasyon, Logger gibi tek nesne gereken durumlarda çok uygundur | ❗ Uygulamanın geri kalanına fazla “bağlanarak” bağımlılık zinciri oluşturabilir |

---

### 📚 **Özetle:**
- Singleton çok güçlü bir tasarım desenidir; tek örnek gerektiren yerlerde idealdir.
- Ancak yanlış veya fazla kullanıldığında **global değişken gibi** davranıp **bağımlılığı, test zorluğunu ve karmaşıklığı** artırabilir.

---