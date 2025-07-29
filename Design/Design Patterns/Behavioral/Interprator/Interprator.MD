# 🧾 Interpreter Design Pattern

## 📌 Nedir?
**Interpreter Design Pattern**, genellikle bir **dil**, **işaret dizisi** veya **basit bir grameri** yorumlamak (interpret etmek) için kullanılan bir davranışsal tasarım desenidir.  

Bu desen, belirli bir dilin gramerini nesnelerle temsil eder ve o dilde yazılmış ifadeleri çalıştırmak için bir **yorumlayıcı (interpreter)** oluşturur.

---

## 🎯 Amaç
- Bir dilin gramerini **nesne tabanlı** şekilde modellemek.
- Bu dildeki ifadeleri (expressions) **çalıştırabilmek veya değerlendirebilmek**.
- Özellikle basit, özel amaçlı diller (DSL – Domain Specific Language) veya komut yorumlama sistemlerinde kullanılır.

---

## 🛠 Nasıl Çalışır?
1. **AbstractExpression (Arayüz / soyut sınıf)**: `interpret()` metodunu tanımlar.
2. **TerminalExpression**: Gramerdeki terminal (son) sembollerini yorumlar.
3. **NonTerminalExpression**: Daha karmaşık ifadeleri (ör. mantıksal VE, VEYA vb.) yorumlar.
4. **Context**: İfade yorumlama sırasında gerekli verileri tutar.

> İfadeler (Expression nesneleri), `interpret()` metodunu çağırarak kendilerini çözümler ve sonuç üretir.

---

## ✈ Gerçek Hayattan Örnek
Bir arama motorunda şu tür bir arama sorgusu düşün:
**"Java" AND ("Design Patterns" OR "Clean Code")**

Bu ifade:
- Terminal ifadeler: `"Java"`, `"Design Patterns"`, `"Clean Code"`
- Non-terminal ifadeler: AND, OR

Interpreter deseninde, bu ifadeler nesneler olarak modellenir ve `interpret()` çağrısıyla sonuç üretilir.

---

## ✅ Avantajları
- Bir dilin veya gramerin yapısını **esnek ve nesne tabanlı** şekilde tanımlar.
- Basit diller veya kurallar için hızlıca yeni ifade türleri eklenebilir.

---

## ⚠ Dezavantajları
- Karmaşık dillerde, çok sayıda `Expression` sınıfı oluşur ve bakım zorlaşır.
- Büyük diller için performans düşebilir ve yapı karmaşık hale gelir.

---

## ✏ Özet
> Interpreter Design Pattern, bir dilin gramerini nesne tabanlı şekilde temsil eder;
> bu nesneler, kendilerini yorumlayarak (`interpret()`) bir anlam veya sonuç üretir.

---

