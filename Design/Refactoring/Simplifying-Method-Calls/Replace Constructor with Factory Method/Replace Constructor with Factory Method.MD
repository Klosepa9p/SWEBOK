## 🏭 Replace Constructor with Factory Method Yöntemi

### 🐞 Problem
- Bir sınıfın yapıcısı (*constructor*), nesne oluşturma mantığını yeterince esnek veya okunur şekilde ifade edemiyorsa; örneğin, farklı türde nesneler oluşturmak için koşullu mantık gerekiyorsa, bu durum kodun karmaşıklığını artırır.
- Yapıcılar, alt sınıfların veya özel yapılandırılmış nesnelerin oluşturulmasını kolayca özelleştirme konusunda sınırlı esneklik sağlar.

---

### ✅ Çözüm
- Yapıcıyı bir **fabrika metodu (factory method)** ile değiştirin.
- Fabrika metodu, nesne oluşturma mantığını kapsüller ve daha esnek bir şekilde farklı tür veya yapılandırmada nesnelerin oluşturulmasını sağlar.

---

### 🌱 Faydaları
- Nesne oluşturma mantığı tek bir yerde toplanır; kod daha **modüler** hale gelir.
- Alt sınıfların veya farklı yapılandırmaların oluşturulması kolaylaşır.
- Kodun **okunabilirliği** ve **esnekliği** artar.

---

### 🛠️ Nasıl Uygulanır
1. Yapıcının neden karmaşık olduğunu veya neden farklı nesne türlerini oluşturma ihtiyacınız olduğunu belirleyin.
2. Sınıfta (veya ayrı bir fabrika sınıfında) **statik bir fabrika metodu** tanımlayın.
3. Yapıcıyı `private` yaparak doğrudan nesne oluşturmayı engelleyin.
4. İstemci kodlarını, `new` ifadesi yerine fabrika metodunu çağıracak şekilde güncelleyin.
5. Kodu test edin.

---

> 📌 **Not:** Fabrika metodu genellikle, `create`, `newInstance`, `of`, `from` gibi açıklayıcı isimlerle adlandırılır. Bu, istemci kodun daha okunaklı olmasına katkı sağlar.

