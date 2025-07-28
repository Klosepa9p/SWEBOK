# 🧩 Template Method Design Pattern

## 📌 Nedir?
**Template Method**, bir algoritmanın genel **iskeletini** üst sınıfta tanımlayan; bazı adımlarının alt sınıflar tarafından **özelleştirilmesine** izin veren bir *davranışsal tasarım deseni*dir.

Bu sayede:
- Algoritmanın genel yapısı değişmez.
- Değişken olan kısımlar alt sınıflarda esnek şekilde uygulanır.

---

## 🎯 Amaç
- Ortak bir algoritma akışını merkezi bir yerde tanımlamak.
- Sadece özelleştirilmesi gereken kısımları alt sınıflara bırakmak.
- Kod tekrarını azaltmak ve bakımı kolaylaştırmak.

---

## 🛠 Nasıl Çalışır?
1. Üst sınıfta bir **template method** (şablon metot) tanımlanır.
2. Bu metot, algoritmanın adımlarını belirler. Bazı adımlar soyut (*abstract*) metotlardır.
3. Alt sınıflar bu soyut metotları kendilerine uygun şekilde **override** eder.

---

## ✅ Avantajları
- Kod tekrarını azaltır.
- Ortak akış merkezi olarak yönetilir.
- Değişken ve değişmez kısımlar net bir şekilde ayrılır.

## ⚠ Dezavantajları
- Sıkı kalıtım bağı oluşur.
- Çok fazla alt sınıf oluşabilir, karmaşıklık artabilir.


