## 🔄 Change Unidirectional Association to Bidirectional Yöntemi

### 🐞 Problem

- Bir sınıf, başka bir sınıfa **tek yönlü ilişki (unidirectional association)** ile bağlıysa;  
  - Ancak diğer sınıfın da bu ilişkiye erişmesi gerekiyorsa, mevcut yapı yetersiz kalır.
- Tek yönlü ilişki, ilgili sınıfların birbirine erişimini kısıtlar ve kodun **esnekliğini azaltır**.

---

### ✅ Çözüm

Tek yönlü ilişkiyi **çift yönlü (bidirectional)** hale getirin:  
Her iki sınıf da birbirine referans tutar ve ilişkiyi senkronize eden yardımcı metotlar eklenir.

---

### 🌱 Faydaları

- Sınıflar arasında daha **esnek ve doğal** bir ilişki kurulur.
- Her iki sınıf da diğerine **kolayca erişebilir**, kod daha sezgisel hale gelir.
- İlişkisel verilerin **erişimi ve yönetimi kolaylaşır**.

---

### 🛠️ Nasıl Uygulanır

1. Tek yönlü ilişkinin mevcut olduğu sınıfları ve ilgili alanları belirleyin.
2. Karşı sınıfa, ters yönde bir **referans alanı** (ör. `otherClass`, `List<OtherClass>` gibi) ekleyin.
3. **Setter** veya yardımcı metotlarda, ilişkiyi iki tarafta da güncel tutacak **senkronizasyon mantığı** ekleyin.
4. İstemci kodlarını, yeni **çift yönlü ilişkiyi** kullanacak şekilde düzenleyin.
5. Kodu test edin.

