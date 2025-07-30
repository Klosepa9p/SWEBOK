## 🧱 Replace Method with Method Object Yöntemi

### 🐞 Problem

- Bir metot çok karmaşık, uzun veya çok sayıda yerel değişken içeriyorsa, refactoring işlemleri (örn. Extract Method) uygulamak zorlaşır.
- Yerel değişkenlerin yönetimi ve metot bölünmesi karmaşık hale gelir.

---

### ✅ Çözüm

Karmaşık metodu bir **nesneye** (method object) dönüştürün.  
Metodun mantığını bir sınıfa taşıyın, yerel değişkenleri sınıfın alanları (**fields**) haline getirin ve metodu daha küçük metotlara bölebilin.

---

### 🌱 Faydaları

- Kod daha modüler ve anlaşılır olur.
- Yerel değişkenler sınıf alanları olarak yönetildiği için **Extract Method** gibi refactoring işlemleri kolaylaşır.
- Karmaşık mantık, daha küçük ve yeniden kullanılabilir metotlara ayrılabilir.

---

### 🛠️ Nasıl Uygulanır

1. Yeni bir sınıf oluşturun ve orijinal metodun adıyla ilişkili bir isim verin.
2. Orijinal metodun yerel değişkenlerini bu sınıfın alanları (fields) olarak tanımlayın.
3. Metodun parametrelerini sınıfın yapıcı (**constructor**) parametreleri olarak taşıyın.
4. Orijinal metodun mantığını, yeni sınıfın bir metoduna (genellikle `compute()` gibi) taşıyın.
5. Orijinal metodu, yeni sınıfın örneğini oluşturup ilgili metodu çağıracak şekilde güncelleyin.
6. Kodun doğru çalıştığından emin olmak için test edin.

---