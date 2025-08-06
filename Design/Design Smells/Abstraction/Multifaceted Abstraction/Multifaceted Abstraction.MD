# Multifaceted Abstraction

## 🔍 Nedir?

**Multifaceted Abstraction**, bir sınıfın veya yapının **birden fazla sorumluluğu** (işlevi) aynı anda taşıması durumudur.  
Bu soyutlama, tek bir kavram yerine birden çok bağımsız veya zayıf ilişkili kavramı temsil eder.  
Yani bir sınıfın içinde hem kullanıcı yönetimi yapılırken hem dosya işlemleri hem de ağ bağlantıları gibi farklı görevler bir araya getirilmiş olabilir.

Bu durum, **Single Responsibility Principle (SRP)** ilkesine aykırıdır.

---

## 🚫 Neden Kötüdür?

- 🧱 **Bakım zorlaşır**: Bir değişiklik birden fazla işlevi etkileyebilir.
- 🔍 **Anlam karmaşası olur**: Sınıfın veya yapının ne yaptığı tam olarak anlaşılamaz.
- 🔄 **Yeniden kullanım azalır**: Başka yerlerde sadece bir yönü kullanılmak istendiğinde, tüm yapının taşınması gerekir.
- 🧪 **Test edilmesi zorlaşır**: Her işlevin birbiriyle bağlantılı olması test izolasyonunu zorlaştırır.
- 🔧 **Değişiklik maliyeti artar**: Tek bir sorunun çözümü, tüm yapıyı etkileyecek şekilde yayılabilir.

---

## ✅ Çözüm Yaklaşımı

- Yapının taşıdığı sorumlulukları **tek tek analiz et**.
- Her sorumluluğu ayrı sınıf, fonksiyon veya modül haline getir.
- İhtiyaç durumunda bu küçük yapıları **composition** (bileşim) veya **dependency injection** gibi tekniklerle birleştir.
- **Tek sorumluluk ilkesi**ni (SRP) baz alarak soyutlamayı sadeleştir.

---

## 📚 Gerçek Hayattan Analoji

Bir çalışana şirkette hem resepsiyon görevi, hem muhasebe, hem de yazılım geliştirme işi verilmiş.

Bu durumda:

- Ne zaman hangi işle uğraştığı belli olmaz,
- Hiçbir işe tam odaklanamaz,
- Bir işi geliştirmeye çalışırken diğerlerini ihmal eder,
- İş yükü arttıkça hata yapma olasılığı artar.

**Doğru çözüm:** Her işi, o işle ilgilenen uzman bir kişiye vermek; böylece işler net, odaklı ve sürdürülebilir olur.
