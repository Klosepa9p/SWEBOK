## 🏭 **Factory Design Pattern Nedir?**

Factory Pattern, bir **yaratıcı (creational)** tasarım desenidir.

**Temel amacı:**
✅ Nesne oluşturma (**instantiation**) sürecini merkezi bir noktada toplamak,  
✅ Uygulamanın geri kalanının `new` anahtar sözcüğünü veya somut sınıf detaylarını bilmeden nesne üretebilmesini sağlamak.

---

## ⭐ **Bu sayede:**
- Kodda bağımlılığı (**coupling**) azaltır.
- Genişlemeyi kolaylaştırır (örneğin, yeni bir sınıf eklendiğinde eski kod değişmez).
- Bakım ve test edilebilirliği artırır.

---

## 🧩 **Amacı nedir?** (Kısa ve net)
- Bir sınıfın **hangi alt sınıftan** nesne üreteceğine karar verme işini merkezi bir **Factory**’ye devretmek.
- Kodun “*ne* üretileceğini” değil, *nasıl* üretileceğini düşünmesine gerek bırakmamak.
- Alt sınıfların detayını gizleyerek **soyutlama (abstraction)** sağlamak.


