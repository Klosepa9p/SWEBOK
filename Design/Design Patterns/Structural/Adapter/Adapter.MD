# 🧩 Adapter Design Pattern

Adapter Pattern, bir **structural (yapısal)** tasarım desenidir.  
Uyumsuz arayüzlerin birlikte çalışmasını sağlar.  
Yani mevcut bir sınıfın arayüzünü, **client’ın beklediği arayüze uyarlayarak** köprü görevi görür.

---

## ✅ Temel Amacı
- Uyumsuz arayüzleri **uyumlu hale getirmek**.
- Var olan sınıfları değiştirmeden, **client'ın istediği biçimde kullanabilmek**.
- Kod tekrarını ve karmaşık kalıtımı azaltmak.

---

## 🔧 Nasıl Çalışır?
1. Bir **Target (hedef) arayüz** tanımlanır.
2. Uyarlamak istediğimiz mevcut sınıf (**Adaptee**) bu arayüze doğrudan uymaz.
3. **Adapter** sınıfı, `Target` arayüzünü uygular.
4. Adapter, client tarafından çağrılan metodları, **Adaptee**’nin metodlarına dönüştürerek çağırır.
5. Böylece client, sadece `Target` arayüzünü görür ve adaptee'nin detaylarından bağımsız çalışır.

---

## 📦 Avantajları
- Mevcut kodu **yeniden yazmadan** kullanabilmeyi sağlar.
- Farklı sistemler veya **eski (legacy) kodlarla** entegrasyonu kolaylaştırır.
- Kodun **bakımını ve genişletilmesini** kolaylaştırır.
- Kodun **yeniden kullanılabilirliğini** artırır.

---

## ⚠️ Dezavantajları
- Kodda **ek bir soyutlama katmanı** oluşturduğu için yapıyı biraz karmaşıklaştırabilir.
- Çok fazla adapter sınıfı kullanıldığında bakım maliyeti artabilir.

---

## 🧰 Özet
Adapter Pattern, eski kodu atmadan veya değiştirmeden, **yeni kodla birlikte uyumlu** hale getirir.  
Yani yeni sisteme “eski bir fişi yeni prize uyduran adaptör” gibi davranır.

