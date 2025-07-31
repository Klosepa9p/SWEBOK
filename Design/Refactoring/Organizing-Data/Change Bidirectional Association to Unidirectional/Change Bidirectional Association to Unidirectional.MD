## 🔄 Change Bidirectional Association to Unidirectional Yöntemi

### 🐞 Problem

- İki sınıf arasında **çift yönlü bir ilişki (bidirectional association)** varsa,  
  ancak gerçekte yalnızca bir sınıfın diğerine erişmesi yeterliyse:
  - Gereksiz karmaşıklık oluşur.
  - Sıkı bağımlılık (**tight coupling**) ortaya çıkar.
- Çift yönlü ilişkiyi yönetmek için eklenen **senkronizasyon metotları**, bakım sürecini zorlaştırır.

---

### ✅ Çözüm

Çift yönlü ilişkiyi **tek yönlü (unidirectional)** hale getirin:  
Gereksiz olan ters yönlü referansı ve senkronizasyon mantığını kaldırarak, yalnızca bir sınıfın diğerine referans tutmasını sağlayın.

---

### 🌱 Faydaları

- Kod daha **sade** ve **daha az bağımlı** hale gelir.
- İlişki yönetimi basitleşir, **senkronizasyon yükü azalır**.
- Kodun **bakımı** ve **test edilmesi** kolaylaşır.

---

### 🛠️ Nasıl Uygulanır

1. Çift yönlü ilişkinin **hangi yönünün gereksiz olduğunu** tespit edin.
2. Gereksiz ters yönlü referansı (ör. `List<OtherClass>` veya tekil `otherClass` alanı) kaldırın.
3. Bu referansı yönetmek için kullanılan **senkronizasyon metotlarını** ve mantığı temizleyin.
4. İstemci kodlarını, artık **tek yönlü ilişkiyi** kullanacak şekilde güncelleyin.
5. İlişkinin **tutarlılığını** korumak için gerekli kontrolleri yapın.
6. Kodu test edin.

