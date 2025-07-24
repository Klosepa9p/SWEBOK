## 🛠️ **Builder Design Pattern Nedir?**

- Karmaşık nesnelerin (çok sayıda alanı/değişkeni olan) adım adım, kontrollü ve okunabilir şekilde oluşturulmasını sağlar.
- Büyük ve karmaşık constructor'lar yerine, nesne oluşturma işlemini **küçük, mantıklı parçalara** böler.
- Her alan (property) için ayrı metotlar tanımlanır; sonunda `build()` metodu ile nesne üretilir.

---

## ✏️ **Neden Kullanılır?**
- **Çok sayıda parametreye** sahip constructor'lar **okunması ve yönetilmesi zor** hale gelir.
- Parametrelerin sırası yanlış verilebilir; bu da hatalara yol açar.
- Builder ile:
  - Kod okunabilirliği ve bakım kolaylığı sağlanır.
  - Daha esnek ve adım adım nesne oluşturma imkanı sunulur.
  - Gereksiz constructor aşırı yüklemeler (overloading) azaltılır.

---