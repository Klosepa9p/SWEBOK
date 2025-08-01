## 🧩 Replace Conditional with Polymorphism Yöntemi

### 🐞 Problem
- Bir metot, tür veya duruma bağlı olarak **koşullu ifadeler** (`if` / `switch`) kullanıyorsa:
  - Kodun karmaşıklığı artar.
  - Yeni durumlar eklendikçe bakım zorlaşır.
- Koşullu mantık, kodun **esnekliğini ve genişletilebilirliğini** kısıtlar.

---

### ✅ Çözüm
Koşullu ifadeleri kaldırın ve davranışı **polimorfizm** aracılığıyla alt sınıflara veya bir arayüze taşıyın.  
Her durum, ayrı bir sınıf veya nesne tarafından temsil edilir ve davranış polimorfik olarak çağrılır.

---

### 🌱 Faydaları
- Kod daha **modüler ve esnek** hale gelir, yeni durumlar eklemek kolaylaşır.
- Koşullu mantık azalır, okunabilirlik ve bakım iyileşir.
- **Açık/Kapalı İlkesi (Open/Closed Principle)** ile uyum artar.

---

### 🛠️ Nasıl Uygulanır
1. Koşullu ifadelerin kontrol ettiği tür veya duruma bağlı davranışları belirleyin.
2. Her durum için bir **alt sınıf** veya **arayüz implementasyonu** oluşturun.
3. Koşullu mantığı, **polimorfik metot çağrılarıyla** değiştirin.
4. Ana sınıfta, uygun alt sınıfı veya nesneyi seçmek için bir **fabrika metodu** veya benzeri bir mekanizma kullanın.
5. Kodu test edin.

---

> 🎯 **Not:** Bu yöntem, özellikle sık sık güncellenen veya büyüyen koşullu mantıkları sadeleştirmek ve kodun uzun vadede **daha sürdürülebilir** olmasını sağlamak için güçlü bir tekniktir.

