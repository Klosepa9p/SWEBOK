## 🔧 Replace Parameter with Explicit Methods Yöntemi

### 🐞 Problem
- Bir metot, bir **parametreye bağlı olarak farklı davranışlar** sergiliyorsa, bu durum kodun anlaşılmasını zorlaştırır.
- Metot içinde **koşullu mantık** (örneğin, `if` veya `switch`) oluşur.
- Parametreye dayalı koşullu mantık, metotun **sorumluluğunu artırır** ve esnekliği azaltır.

---

### ✅ Çözüm
Parametreye bağlı koşullu mantığı kaldır.
- Her davranış için **ayrı ve açıklayıcı bir isimde** metot oluştur.
- Böylece istemciler, **parametre geçmek yerine** doğrudan ilgili metodu çağırır.

---

### 🌱 Faydaları
- Kod daha açık ve okunabilir hale gelir; metot adları davranışları netleştirir.
- Koşullu mantık azalır; her metot **tek bir sorumluluğa** sahip olur.
- Kodun bakımı ve test edilmesi kolaylaşır.

---

### 🛠️ Nasıl Uygulanır
1. Parametrenin farklı değerlerine bağlı olarak değişen davranışları belirle.
2. Her farklı davranış için **ayrı bir metot** oluştur ve anlamlı isimler ver.
3. Orijinal metottaki **koşullu mantığı kaldır**.
4. İstemci kodlarını, yeni oluşturduğun metotları çağıracak şekilde güncelle.
5. Orijinal metodu kaldır veya gerekiyorsa geriye dönük uyumluluk için bir yönlendirme metodu (delegation) olarak tut.
6. Kodu test et.

---

> 💡 **İpucu:**  
> Bu yöntem, metot çağrısını daha açık hale getirir ve istemcinin hangi davranışı istediğini **metot adından** anlamasını sağlar.  
> Çok sık değişen davranışlar için, bu yöntem yerine *Strategy* gibi desenler tercih edilebilir.
