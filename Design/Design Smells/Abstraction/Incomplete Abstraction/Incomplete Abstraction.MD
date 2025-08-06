# Incomplete Abstraction

## 🔍 Nedir?

**Incomplete Abstraction (Eksik Soyutlama)**, bir sınıf ya da modülün, temsil etmeyi amaçladığı kavramı veya domain yapısını tam olarak kapsayamaması durumudur.  
Yani, sınıfın sorumluluğu gereği sahip olması gereken özelliklerin veya davranışların bir kısmı eksik bırakılmıştır.

Bu soyutlama, isminden beklenen işlemleri yerine getirmez ya da eksik sağlar.  
Sonuç olarak, sınıf ya başka sınıflara fazlasıyla bağımlı hale gelir ya da genişletilmek zorunda kalınır.

---

## 🚫 Neden Kötüdür?

- Sınıfın sorumlulukları belirsiz veya eksik olur; bu da **low cohesion (düşük uyum)** yaratır.
- Başka bileşenlerin bu eksikliği kapatmak için ek iş yapması gerekir, bu da **yüksek bağımlılık** yaratır.
- Soyutlamanın gerçek anlamda kapsayıcı olmaması, **kod tekrarına** ve **anlamsal tutarsızlığa** neden olabilir.
- Sınıfın yeniden kullanılabilirliği düşer, çünkü beklentileri karşılamaz.
- Geliştiriciler, sınıfın adından veya yapısından beklenen işlevselliği bulamadığında **güvensizlik** oluşur.

---

## ✅ Çözüm Yaklaşımı

- Sınıflar ve modüller tasarlanırken, temsil ettikleri kavramı tüm yönleriyle kapsayıp kapsamadığı sorgulanmalıdır.
- **Yüksek cohesive** yapılar hedeflenmeli; sınıfın tüm sorumlulukları eksiksiz şekilde tanımlanmalıdır.
- Eksik kalan işlevler varsa, bunlar mevcut sınıfa entegre edilmeli ya da uygun bir soyutlama düzeyi belirlenerek yeniden yapılandırılmalıdır.
- Sınıf isimleri ile içeriği tutarlı olmalıdır: sınıf ne yapıyorsa onu ifade etmeli; ne ifade ediyorsa onu yapmalıdır.

---

## 📚 Gerçek Hayattan Analoji

Bir şehirde “Toplu Taşıma” olarak tanıtılan bir sistem düşünün. Ancak bu sistem yalnızca otobüsleri kapsıyor.  
Trenler, metrolar ya da dolmuşlar bu kapsama dahil edilmemiş.

Bu sistem, adından bekleneni tam olarak karşılamıyor; çünkü “toplu taşıma” daha geniş bir kavramdır.

Bu eksik kapsama:

- Yolcuları yanıltır,
- Alternatifler göz ardı edilir,
- Diğer ulaşım sistemleriyle entegrasyon zorlaşır.

**Doğru soyutlama:** Tüm ulaşım türlerini kapsayan, anlamlı, tutarlı bir sistem tanımı yapılmalıdır.
