## 🧩 Bridge Design Pattern

Bridge Pattern, **uygulama (Abstraction)** ile **uygulamanın implementasyonu (Implementation)** kısmını birbirinden ayıran bir tasarım desenidir.  
Bu iki katman, ayrı **arayüzler (interface veya abstract class)** ile tanımlanır ve bir **köprü (bridge)** aracılığıyla birbirine bağlanır.  

---

### 🎯 **Amacı**
- Uygulama (Abstraction) ile implementasyonu (Implementation) birbirinden ayırmak.
- Client'ın, uygulama kısmından bağımsız olarak implementasyonu kullanabilmesini sağlamak.
- Kodun genişlemesini kolaylaştırmak ve **Open/Closed Principle**'a (Açık/Kapalı Prensibi) uygun hale getirmek.

---

### ✅ **Nasıl çalışır?**
- Hem uygulama kısmı (Abstraction) hem de implementasyon kısmı (Implementation) için ayrı iki arayüz/soyut sınıf oluşturulur.
- Uygulama katmanı, implementasyon arayüzüne bağımlı olur; detayları bilmez.
- İkisi arasındaki bağı **köprü (bridge)** kurar.
- Client, sadece Abstraction üzerinden işlem yapar.

---

### ⚙️ **Avantajları**
- Uygulama ve implementasyonu birbirinden bağımsız geliştirme imkânı sağlar.
- Yeni implementasyonlar eklemek kolaydır.
- Büyük sistemlerde **class explosion** (çarpan şekilde sınıf türemesi) riskini azaltır.
- Kodun okunabilirliğini ve esnekliğini artırır.

---

> Özetle:  
> - **Bridge**, implementasyon ile uygulamayı ayırarak, daha modüler ve esnek bir yapı kurar.  
> - Client, köprü sayesinde sadece uygulama kısmını kullanır, implementasyon detaylarını görmez.
