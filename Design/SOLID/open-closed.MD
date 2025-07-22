## 🧩 Open/Closed Principle (Açık/Kapalı Prensibi)

- **Tanım:**  
  Mevcut bir kod, **yeni gereksinimlere karşı genişletilmeye açık**,  
  ancak **değiştirilmeye kapalı** olmalıdır.

- **Anlamı:**  
  Yeni özellik veya davranış eklemek gerektiğinde, var olan kodu **değiştirmeden**  
  (bozmadan), yeni sınıflar, alt sınıflar (child/derived) veya eklentiler ile genişletiriz.

---

### 🧪 Örnek (Kısa açıklama)

> Bir gereksinim ihtiyacı doğrultusunda yazdığımız mevcut bir sınıf,  
> ileride yeni gereksinimler çıktığında **ortak bir atadan türetilen child sınıflar** ile genişletilebilir.  
> Böylece mevcut kodun stabilitesi korunur, yeni davranışlar child sınıflarda tanımlanır.

---