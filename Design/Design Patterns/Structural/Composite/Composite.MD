# 🧩 Composite Design Pattern (Bileşik Tasarım Deseni)

## 📌 Tanım
**Composite Pattern**, nesneleri bir **ağaç yapısında** organize ederek;
tekil nesneler (*Leaf*) ile bu nesneleri gruplayan bileşik nesnelerin (*Composite*) **aynı arayüzü kullanmasını sağlar**.  

Bu sayede istemci (client) kodu, nesnenin tekil mi yoksa bileşik mi olduğunu düşünmeden **aynı işlemleri** yapabilir.

---

## 🎯 Amaç
- Tekil ve bileşik nesneleri aynı arayüz ile yönetmek.
- **Hiyerarşik yapıları** (dosya sistemi, organizasyon şeması, menü vs.) daha okunabilir ve sürdürülebilir hale getirmek.
- Kodun **esnekliğini ve genişletilebilirliğini** artırmak.

---

## ⚙ Yapısı
Composite pattern genellikle şu bileşenlerden oluşur:

- **Component (Soyut Sınıf veya Arayüz)**  
  Ortak davranışı tanımlar.  
  Örn: `Movie`

- **Leaf (Yaprak)**  
  Gerçek işi yapan, alt elemanı olmayan nesne.  
  Örn: `Thriller`, `Horror`

- **Composite (Bileşik)**  
  İçinde birden fazla `Component` tutan, yine aynı arayüzü kullanan nesne.  
  Örn: `MovieContainer`

---

## ✅ Avantajları
- **Tekil** ve **bileşik** nesnelerle aynı şekilde işlem yapabilme kolaylığı.
- Karmaşık hiyerarşik yapıları **basitleştirir ve yönetilebilir hale getirir**.
- Yeni Leaf veya Composite eklemek kolaydır.

---

## ⚠ Dezavantajları
- Küçük ve basit yapılarda gereksiz soyutlama ve karmaşıklık oluşturabilir.
- Çok büyük yapılarda ağaç yapısının yönetimi zorlaşabilir.

---

## 🛠 Özet
Composite Design Pattern:
- Karmaşık ağaç yapılarında, **tekil** ve **bileşik** nesnelerin aynı arayüzü paylaşmasını sağlar.
- Kullanıcı açısından, nesnelerin “tek mi, bileşik mi” olduğu fark etmez; **hepsiyle aynı şekilde etkileşime girilir**.

---
