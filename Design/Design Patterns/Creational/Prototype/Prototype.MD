## 🧩 Prototype Design Pattern

Bir nesnenin oluşturulması uzun sürüyor veya karmaşık ise  
ve çoğu özelliği önceki oluşturulan nesneler veya bir prototip nesne ile aynı ise,  
o nesneyi **kopyalayıp sadece farklı olan özelliğini değiştirerek** kullanırız.

✅ **Avantajları:**
- Zaman tasarrufu sağlar.
- Kaynak tüketimini azaltır.
- Kodun daha okunabilir ve yönetilebilir olmasına katkıda bulunur.

---

### 🧬 Deep Copy & Shallow Copy

Prototype pattern genellikle iki kopyalama yöntemiyle uygulanır:

- **Shallow Copy (Yüzeysel Kopya):**  
  Sadece nesnenin kendisini kopyalar, alt nesnelere referans verir.

- **Deep Copy (Derin Kopya):**  
  Nesne ile birlikte tüm alt nesneleri de kopyalar.

---

✨ **Sonuç:**  
Prototype Design Pattern, var olan nesneleri kopyalayarak yeni nesneler üretir;  
böylece hem **performans**, hem de **esneklik** sağlar.


## ✅ Prototype Design Pattern Avantajı

- **Karmaşık ya da pahalı (yüksek maliyetli) nesneleri** tekrar tekrar `new` ile oluşturmak yerine,
  var olan bir nesneden kopya çıkararak **daha hızlı** ve **daha az maliyetle** üretim sağlar.

- **Deep copy** yöntemi ile veri tutarlılığı korunur; kopyalanan nesneler birbirinden bağımsız olur.

- **Shallow copy** yöntemi ise daha hızlı ve hafif kopyalar oluşturarak performans avantajı sunar.


Ben Yaratımsal Tasarım Kalıpları (Creational Design Patterns) kategorisi altında yer alan desenlerden biriyim. Haliyle ben de bir nesne yaratılırken programcının karşısına çıkabilecek bir problemi çözmek üzere geliştirildim. Önce size problemi izah edeyim. Üretilip belleğe aktarılması zaman açısından maliyetli olan bir nesne olduğunu varsayalım. Ayrıca uygulamanızda, bu nesneden birkaç tane olacağını düşünelim. Bu durumda, her nesne için aynı üretim sürecini tekrar tekrar yaptığınızda, söz konusu maliyet daha fazla olacaktır. İşte bu maliyeti nasıl azaltabiliriz? Acaba söz konusu nesnelerin hepsini tek tek üretmek yerine sadece birini üretip diğerlerini ondan klonlasak daha iyi bir performans olmaz mı? İşte ben bunu yapan bir tasarım deseniyim.