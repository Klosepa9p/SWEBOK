# 🧳 Visitor Design Pattern

## 📌 Nedir?
**Visitor Design Pattern**, bir nesne yapısının elemanlarına **yeni işlemler** eklemek istediğimizde;  
bu işlemleri nesnelerin kendisine eklemek yerine, **ayrı bir “ziyaretçi” sınıfı** içinde tanımlamamıza olanak tanır.

Bu sayede:
- Sık değişen işlemler, nesne sınıflarına dokunmadan eklenir.
- Nesne yapısı ile işlemler (algoritmalar) birbirinden **ayrılır**.

---

## 🎯 Amaç
- Var olan nesne yapısını **değiştirmeden**, o yapının elemanları üzerinde yeni işlemler tanımlamak.
- **Açık/kapalı prensibi (Open/Closed Principle)**: Nesneler kapalı, yeni işlemler için açık.

---

## 🛠 Nasıl Çalışır?
1. **Visitor (Arayüz)**: Ziyaret edilecek her eleman için `visit()` metodunu tanımlar.
2. **ConcreteVisitor**: Belirli işlemleri gerçekleştiren ziyaretçi.
3. **Element (Arayüz)**: `accept()` metodu ile bir ziyaretçiyi kabul eder.
4. **ConcreteElement**: Gerçek nesne; `accept()` metodunda, `visitor.visit(this)` çağrısı yapar.

> Böylece Visitor, nesnenin iç yapısına erişir ve yeni işlemleri uygular.

---

## ✈ Gerçek Hayattan Örnek
Bir alışveriş sepeti düşün:
- Sepette farklı ürün türleri var: Kitap, Elektronik, Giysi.
- Farklı Visitor’lar olabilir:
  - **Vergi hesaplayan Visitor**
  - **İndirim hesaplayan Visitor**
  - **Fiyat raporu oluşturan Visitor**

Her yeni işlem için `Product` sınıfını değiştirmek yerine, yeni bir Visitor ekleriz.

---

## ✅ Avantajları
- Var olan nesne hiyerarşisine **dokunmadan** yeni işlemler eklenebilir.
- İş mantığı (algoritmalar) nesne yapısından **ayrı tutulur**.
- Kod daha okunur ve bakım kolay olur.

---

## ⚠ Dezavantajları
- Nesne hiyerarşisine yeni bir eleman eklemek **zor** olabilir; çünkü Visitor arayüzüne de yeni bir `visit` metodu eklemek gerekir.
- İlk tasarımı ve kavramsal yapıyı anlamak, küçük projeler için **karmaşık** olabilir.

---

## ✏ Özet
> Visitor Design Pattern, nesne yapısına dokunmadan, o yapı üzerinde **yeni işlemler tanımlamayı** sağlar.
> Böylece işlemler (Visitor) ile nesne yapısı (Element) birbirinden ayrılır.

---