## 🧩 Decorator Design Pattern Nedir?

**Decorator**, yapısal (structural) tasarım desenlerinden biridir.  
Bir nesnenin sorumluluklarını (özellik veya davranışlarını) **dinamik olarak** ve **var olan sınıfı değiştirmeden** genişletmeye yarar.

---

### 🎨 Nasıl Çalışır?
- Bir **abstract base class** veya **interface** bulunur.
- Hem gerçek nesne (**ConcreteComponent**) hem de süsleyici sınıflar (**Decorator**) bu arayüzü uygular.
- Decorator, gerçek nesneyi (veya başka bir dekoratorü) **kompozisyon yoluyla** (içinde referans tutarak) sarar.
- İstemci (client) tarafında asıl nesne yerine decorator kullanılabilir ve yeni davranışlar eklenir.

---

### ✅ Avantajları
- Sınıfların **kaynak kodunu değiştirmeden** yeni özellikler eklenebilir.
- Farklı dekoratörler birbiriyle **kombine edilerek** esnek çözümler oluşturulur.
- **Open/Closed Principle** (Açık/Kapalı Prensibi): Kod değişime kapalı, genişlemeye açıktır.

---

### ⚠️ Dezavantajları
- Çok sayıda dekoratör kullanılırsa, **karmaşık bir yapı** oluşabilir.
- Takibi ve debug işlemleri zorlaşabilir.

---

### 🧰 Ne zaman kullanılır?
- Nesnelere **statik** değil, **dinamik olarak** yeni özellikler kazandırmak istendiğinde.
- Çok sayıda alt sınıf (subclass) oluşmasını engellemek için.
- Farklı özelliklerin bir arada kullanılmasının gerektiği durumlarda.

---

### 📝 Özet
> **Decorator**, bir nesneyi “süsleyerek” yeni özellikler ekler;  
> nesnenin kendisini değiştirmez, alt sınıf yaratmak yerine **kompozisyon** kullanır.






## ☕ Kullanım Örneği: Kahve Dükkanı Senaryosu

### 📦 Yapı

- **Component**  
  `Kahve` arayüzü  
  - `getAciklama()`
  - `getFiyat()`

- **Concrete Component**  
  `BasitKahve`  
  - Sade kahve

- **Decorator**  
  `KahveDecorator`  
  - Temel sarmalayıcı sınıf

- **Concrete Decorator**  
  - `Sut` → Kahveye süt ekler
  - `Seker` → Kahveye şeker ekler

---

### 🛠️ Kullanım

- **Başlangıç:**  
  Sadece `BasitKahve` var.
- **Sarma işlemi:**  
  `BasitKahve` → `Sut` ile sarılır → `Seker` ile tekrar sarılır.
- **Sonuç:**  
  Dinamik olarak sütlü ve şekerli kahve oluşturulur.

---

### ✅ Avantajı

- Kahve türlerini **alt sınıf oluşturmadan**, dinamik olarak farklı kombinasyonlarla üretiriz.
- Yeni eklemeler için **var olan kodu değiştirmeye gerek yoktur**.

> **Özet:** Decorator, sade bir kahveyi katman katman süsleyerek (örn: süt, şeker, krema) yeni çeşitler oluşturmayı sağlar.  
> Bu, *Open/Closed Principle*’a uygun şekilde yapılır: **değişime kapalı, genişlemeye açık**.

---
