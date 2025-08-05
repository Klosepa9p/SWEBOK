## Inconsistent Abstraction Levels

### Bu Sorun Açıklaması

**Inconsistent Abstraction Levels (Tutarsız Soyutlama Seviyeleri)**, bir metodun veya sınıfın içinde farklı soyutlama seviyelerinde işlemlerin bir arada bulunması durumudur. Örneğin, yüksek seviyeli iş mantığı (örneğin bir siparişi işleme) ile düşük seviyeli detaylar (örneğin veritabanı bağlantısı veya dosya yazma) aynı metodda karıştırıldığında bu code smell ortaya çıkar. Bu durum, genellikle **Long Method** veya **Divergent Change** gibi diğer sorunlarla ilişkilidir.

---

### Bu Sorun Neye Sebep Olabilir

- **Okunabilirlik Sorunları:** Farklı soyutlama seviyelerinin bir arada olması, kodun anlaşılmasını zorlaştırır ve bağlamın kaybolmasına neden olur.
- **Bakım Zorluğu:** Yüksek ve düşük seviyeli mantıkların karışması, kodun değiştirilmesini veya hata ayıklanmasını karmaşık hale getirir.
- **Hata Olasılığı:** Düşük seviyeli detayların yanlış kullanımı, yüksek seviyeli mantığı etkileyebilir ve hatalara yol açabilir.
- **Kod Tekrarı:** Düşük seviyeli işlemler farklı yerlerde tekrar edebilir, bu da **DRY (Don't Repeat Yourself)** ilkesine aykırıdır.
- **Test Zorluğu:** Farklı soyutlama seviyeleri, testleri karmaşıklaştırır; çünkü hem yüksek seviyeli mantığı hem de düşük seviyeli detayları test etmek gerekir.

---

### Çözümü Nedir

- **Sorumlulukları Ayır:** Yüksek seviyeli iş mantığını, düşük seviyeli detaylardan ayırarak ayrı metodlara veya sınıflara taşıyın.
- **Metodları Böl (Extract Method):** Karmaşık metodları, soyutlama seviyelerine göre daha küçük metodlara bölün.
- **Sınıf Oluştur (Extract Class):** Düşük seviyeli işlemleri, soyutlamayı koruyacak şekilde ayrı sınıflara taşıyın.
- **Tasarım Desenleri Kullanın:** `Facade`, `Repository` veya `Service` gibi desenlerle düşük seviyeli detayları soyutlayın.
- **Anlamlı İsimlendirme:** Metod ve sınıf isimleri, soyutlama seviyesini açıkça yansıtmalı.
- **Yeniden Düzenleme (Refactoring):** Kodunuzu analiz ederek farklı soyutlama seviyelerini tespit edin ve bunları uygun şekilde ayırın.
