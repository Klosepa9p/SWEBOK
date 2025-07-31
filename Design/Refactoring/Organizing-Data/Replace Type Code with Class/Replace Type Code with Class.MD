## 🔄 Replace Type Code with Class Yöntemi

### 🐞 Problem

- Bir sınıf, tür veya durum bilgisini temsil etmek için ilkel bir veri türü (örneğin, `int` veya `String`) kullanıyorsa, bu tür kodu anlamı belirsiz ve hata yapmaya açık hale gelir.
- Tür kodu, ilgili davranışları veya doğrulama mantığını kapsülleyemez, bu da kodun bakımını zorlaştırır.

---

### ✅ Çözüm

- Tür kodunu, her türü temsil eden bir sınıf ile değiştirin.
- Yeni sınıf, türle ilgili davranışları ve doğrulamaları kapsülleyebilir, böylece kod daha güvenli ve okunabilir olur.

---

### 🌱 Faydaları

- Tür bilgisi daha anlamlı ve kapsüllenmiş hale gelir.
- Hatalı tür atamaları önlenir, doğrulama kolaylaşır.
- Kodun okunabilirliği ve bakımı iyileşir.

---

### 🛠️ Nasıl Uygulanır

1. Tür kodunun kullanıldığı yerleri belirleyin.
2. Her tür için yeni bir sınıf oluşturun ve türle ilgili sabitleri veya davranışları bu sınıfa taşıyın.
3. Orijinal sınıfta tür kodu yerine yeni sınıfın örneğini kullanın.
4. İstemci kodlarını yeni sınıf ile çalışacak şekilde güncelleyin.
5. Kodu test edin.
