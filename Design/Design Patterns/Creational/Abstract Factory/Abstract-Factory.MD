## 🏭 **Abstract Factory Pattern Nedir?**

**Abstract Factory**, bir **yaratıcı (creational)** tasarım desenidir.  
Temel amacı:
- İlgili nesnelerden oluşan **ailenin** (örneğin, farklı markaların arabaları ve motorları) **somut sınıfı (Concrete Class) ile doğrudan etkileşime girmeden** üretilmesini sağlar.
- Birbirine **bağlı** veya **ilişkili** nesneleri birlikte oluşturur.

---

## 🔧 **Factory Pattern ile farkı**
| Özellik | Factory Method | Abstract Factory |
|--------|----------------|-----------------|
| Amaç | Tek bir ürün oluşturur. | Birbiriyle ilişkili **birden fazla** ürün ailesi oluşturur. |
| Soyutlama | Ürün oluşturma işlemini bir alt sınıfa bırakır. | Ürün ailesi oluşturmak için bir arayüz sağlar. |
| Karmaşıklık | Daha basit. | Daha kapsamlı ve soyut. |
| Kullanım | Tek tip ürün üretimi | İlgili ürünlerden oluşan aileyi birlikte üretme |

---

## ✏️ **Örnek:**
Bir otomobil fabrikası düşün:
- **Factory Method** → Sadece bir `Araba` üretir.
- **Abstract Factory** → Hem `Araba` hem `Motosiklet` gibi ilgili ürünleri birlikte üretir.

---

## 🧩 **Avantajları**
- Ürün ailelerinin **tutarlı** bir şekilde oluşturulmasını sağlar.
- Somut sınıflardan bağımsızlık sunar; **kodun bağımlılığını azaltır**.
- Kolay genişletilebilirlik: Yeni ürün ailesi eklemek için yeni bir Concrete Factory yazılır.

---

## ⚠️ **Dezavantajları**
- Yapısı biraz **karmaşık** olabilir.
- Yeni ürün ailesi eklemek kolaydır; ancak mevcut ürün ailesine **yeni bir ürün türü eklemek zor** olabilir (çünkü tüm factory arayüzleri güncellenmelidir).

---

## ✅ **Kısaca:**
> Abstract Factory, **Factory Pattern’in gelişmiş hâli** gibi düşünülebilir;  
> çünkü birbiriyle **ilişkili birçok nesnenin** bir arada ve tutarlı bir biçimde üretilmesini sağlar.
