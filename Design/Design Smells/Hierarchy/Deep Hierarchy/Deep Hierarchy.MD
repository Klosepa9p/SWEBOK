# Deep Hierarchy

## 🔍 Nedir?

**Deep Hierarchy**, nesne yönelimli tasarımda kalıtım (inheritance) yapısının çok katmanlı ve derin olmasıdır.  
Yani sınıflar arası miras zinciri gereğinden uzun, çok sayıda alt-üst sınıf ilişkisi içerir.

---

## 🚫 Neden Kötüdür?

- 🔍 **Anlaşılması zorlaşır**: Derin yapılar, hangi sınıfın hangi davranışı sağladığını takip etmeyi güçleştirir.
- 🧩 **Bakımı güçleşir**: En üstte yapılan bir değişiklik alt sınıflara beklenmedik etkiler yapabilir.
- 🐛 **Hata ayıklama zorlaşır**: Davranışların nereden geldiğini anlamak zorlaşır.
- 🔄 **Polimorfizmin karmaşıklığı artar**: Çok fazla katman polimorfik davranışların tahmin edilmesini güçleştirir.
- 🛠️ **Refactoring zorlaşır**: Yapıyı sadeleştirmek zahmetlidir.

---

## ✅ Çözüm Yaklaşımı

- Kalıtım zincirlerini mümkün olduğunca **kısa tut**.
- Derin hiyerarşiler yerine **kompozisyon** (composition) ve diğer tasarım desenlerini kullan.
- Sınıfların sorumluluklarını iyi tanımla ve tek bir sorumluluk prensibine (SRP) uygun yap.
- Gerekirse hiyerarşiyi parçalara bölerek modülerleştir.

---

## 📚 Gerçek Hayattan Analoji

Bir şirkette “CEO > Genel Müdür > Müdür > Müdür Yardımcısı > Takım Lideri > Kıdemli Uzman > Uzman” gibi çok derin ve uzun bir hiyerarşi varsa,  
- Kararların iletilmesi gecikir,  
- İletişim karmaşıklaşır,  
- Sorumluluklar bulanıklaşır.

Daha verimli olan, daha düz ve net hiyerarşiler veya görev dağılımlarıdır.

---
