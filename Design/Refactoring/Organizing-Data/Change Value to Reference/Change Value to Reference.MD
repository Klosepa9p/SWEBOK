## 🔄 Change Value to Reference Yöntemi

### 🐞 Problem

- Bir sınıf, aynı verinin birden çok kopyasını (**değer olarak**) tutuyorsa, bu kopyalar arasında tutarsızlık oluşabilir.
- Aynı nesnenin farklı yerlerde bağımsız kopyalar olarak kullanılması, güncellemeleri zorlaştırır ve hata riskini artırır.

---

### ✅ Çözüm

Değer nesnesini (**value object**) bir **referans nesnesine** (**reference object**) dönüştürün.  
Böylece tüm istemciler aynı nesneye referans verir.  
Bu genellikle bir nesne havuzu (**object pool**) veya tekil bir nesne yönetimi ile yapılır.

---

### 🌱 Faydaları

- **Veri tutarlılığı** artar, çünkü tüm istemciler aynı nesneyi paylaşır.
- Güncellemeler tek bir yerde yapılır, bakım kolaylaşır.
- Bellek kullanımı optimize edilebilir.

---

### 🛠️ Nasıl Uygulanır

1. Değer nesnesinin birden çok kopya olarak kullanıldığını belirleyin.
2. Nesneyi bir **referans nesnesi** haline getirmek için bir fabrika metodu veya havuz oluşturun.
3. Nesneyi benzersiz şekilde tanımlayan bir **anahtar** (örn. ID) ekleyin.
4. İstemcileri, kopyalar yerine referans nesnesini kullanacak şekilde güncelleyin.
5. Kodu test edin.
