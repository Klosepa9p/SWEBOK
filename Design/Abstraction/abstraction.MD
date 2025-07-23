## 🧩 Abstraction (Soyutlama)

**Abstraction**, yazılımın detaylarını dış dünyadan (client'tan) gizler.

---

### ✅ Neden önemlidir?

- Bir kullanıcı, bir uygulamayı kullanırken **o işin nasıl yapıldığını bilmek zorunda değildir**.
- Kullanıcı için önemli olan:
  - O işin **ne yaptığı**
  - Ve sonucunda **ne elde edeceği**dir.
- Bu sayede:
  - Karmaşıklık azaltılır
  - Kullanıcı, sistemin iç detaylarından bağımsız hareket edebilir
  - Polymorphism sıklıkla kullanılır. Çünkü oluşturulan soyut sınıfta oluşturulan   özellikler kendisinden türeyen sınıflarda override edilebilir ve değiştirilebilir.
  - Kullanıcı türeyen alt(somut) sınıflardaki detayları görmeyecek soyut sınıftaki özelliklerle ne yapmak istediğine karar verecek. 
---

### ⚙️ Nasıl sağlanır?

- **Soyut sınıflar** (abstract class)
- **Arayüzler** (interface)

Bu yapıların ortak amacı:  
Detayları gizleyerek sadece gerekli olan **kullanım sözleşmesini** sunmaktır.

---