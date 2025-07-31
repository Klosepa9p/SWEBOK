## 🔢 Replace Magic Number with Symbolic Constant Yöntemi

### 🐞 Problem

- Kodda sabit sayılar (magic numbers) kullanılıyorsa, bu sayıların anlamı belirsiz olabilir ve kodun okunabilirliği azalır.
- Aynı sabit sayı birden fazla yerde kullanılıyorsa, değişiklik gerektiğinde her yerde güncelleme yapmak hata riskini artırır.

---

### ✅ Çözüm

- Magic number’ı anlamlı bir isimle tanımlanmış bir sabit (constant) ile değiştirin.
- Bu sabit, genellikle bir `static final` değişken olarak tanımlanır ve kodun anlamını netleştirir.

---

### 🌱 Faydaları

- Kod daha okunabilir ve anlaşılır olur, çünkü sabitin adı sayının anlamını ifade eder.
- Değişiklikler tek bir yerde yapılır, bakım kolaylaşır.
- Hata riski azalır, çünkü sabit bir kez tanımlanır ve tekrar kullanılır.

---

### 🛠️ Nasıl Uygulanır

1. Kodda tekrar eden veya anlamı belirsiz sabit sayıları belirleyin.
2. Bu sayılar için anlamlı isimlere sahip sabitler (`static final`) tanımlayın.
3. Kodda magic number’ları bu sabitlerle değiştirin.
4. Kodu test edin.


