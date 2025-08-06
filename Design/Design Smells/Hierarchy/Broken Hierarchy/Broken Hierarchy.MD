# Broken Hierarchy

## 🔍 Nedir?

**Broken Hierarchy**, nesne yönelimli tasarımda hiyerarşik yapıların, özellikle sınıf kalıtımında (inheritance) doğru şekilde kurulmamış olmasıdır.  
Bu durum, alt sınıfların üst sınıfların beklentilerini karşılamaması, sorumlulukların doğru dağıtılmaması veya miras alınan davranışların tutarsız olmasıyla ortaya çıkar.  
Sonuç olarak, hiyerarşi bozulur ve sistem karmaşıklaşır.

---

## 🚫 Neden Kötüdür?

- 🔄 **Polimorfizm etkisizleşir**: Üst sınıf referansları alt sınıfların doğru davranışlarını sağlayamaz.
- 🧩 **Kod tekrarına yol açar**: Çünkü kalıtımın sağladığı paylaşım bozulur.
- 🔧 **Bakımı zorlaşır**: Hiyerarşideki bir değişiklik beklenmedik yan etkilere neden olur.
- ❌ **Tasarım ilkelerine (Liskov Substitution Principle vb.) aykırıdır**: Alt sınıflar üst sınıfın yerine geçemeyebilir.
- 🤯 **Anlaşılması zor kod ortaya çıkar**: Hiyerarşi içinde hangi sınıfın hangi davranışı üstlendiği belirsizleşir.

---

## ✅ Çözüm Yaklaşımı

- Kalıtım hiyerarşisini, **sadece "is-a" (bir türdür)** ilişkisi kurulduğunda kullan.
- Alt sınıfların üst sınıfın davranışlarını tam olarak desteklediğinden emin ol.
- **Liskov Substitution Principle** gibi SOLID prensiplerini uygula.
- Gerektiğinde kalıtım yerine **kompozisyon (composition)** tercih et.
- Hiyerarşi tasarımını basit ve anlaşılır tut.

---

## 📚 Gerçek Hayattan Analoji

Bir otomobil fabrikasında “Araç” temel sınıfı ve “Araba”, “Kamyon”, “Motosiklet” alt sınıfları olsun.  
Eğer “Motosiklet” alt sınıfı, “Araç”ın temel özelliklerini doğru uygulamıyor, örneğin dört teker yerine iki tekerli olmasını gözardı ediyorsa veya “Kamyon”un işlevleri farklı şekilde tanımlanıyorsa, bu hiyerarşi bozulmuş olur.

Bu, fabrikadaki üretim sürecinin düzensiz ve tutarsız hale gelmesine benzer.

---

