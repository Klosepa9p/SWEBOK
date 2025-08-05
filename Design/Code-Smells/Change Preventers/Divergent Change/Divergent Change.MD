# Divergent Change

## Sorunun Tanımı

**Divergent Change** (Farklılaşan Değişim), bir sınıfın farklı nedenlerle sık sık değiştirilmesi gerektiği durumdur. Bu, genellikle bir sınıfın birden fazla sorumluluğu üstlenmesi ve farklı türde değişiklikler (örneğin, yeni bir özellik ekleme, mevcut bir özelliği değiştirme veya hata düzeltme) için aynı sınıfın sürekli güncellenmesiyle ortaya çıkar. Bu *code smell*, **Single Responsibility Principle** (Tek Sorumluluk İlkesi) ihlaliyle ilişkilidir ve genellikle *Large Class* veya *God Object* gibi diğer sorunlarla bağlantılıdır.

---

## Neden Sorun Oluşturur?

- **Bakım Zorluğu**: Sınıfın farklı nedenlerle sık sık değiştirilmesi, kodu karmaşık hale getirir ve hata riskini artırır.
- **Okunabilirlik Sorunları**: Sınıfın birden fazla sorumluluğu olması, kodun amacını anlamayı zorlaştırır.
- **Hata Olasılığı**: Bir sorumluluk için yapılan değişiklik, diğer sorumlulukları etkileyebilir ve beklenmedik hatalara yol açabilir.
- **Kod Tekrarı**: Farklı sorumluluklar, aynı sınıf içinde tekrar eden mantıklara neden olabilir (DRY ilkesine aykırıdır).
- **Test Zorluğu**: Sınıfın birden fazla sorumluluğu olması, test senaryolarını karmaşıklaştırır ve daha fazla test gerektirir.

---

## Çözüm Yolları

- **Sınıfı Böl (Extract Class)**: Sınıfın farklı sorumluluklarını ayrı sınıflara ayırarak her birinin tek bir sorumluluğu olmasını sağlayın.
- **Sorumlulukları Ayır**: *Single Responsibility Principle*'ı uygulayarak her sınıfın yalnızca bir değişim nedenine sahip olmasını sağlayın.
- **Tasarım Desenleri**: Strategy, Facade veya Kompozisyon gibi desenler kullanarak sorumlulukları modüler bir şekilde organize edin.
- **Yeniden Düzenleme (Refactoring)**: Sınıfın farklı parçalarını, ilgili işlevselliğe göre ayrı sınıflara veya modüllere taşıyın.
- **Anlamlı İsimlendirme**: Yeni sınıfların isimlerini, taşıdıkları sorumluluğu açıkça ifade edecek şekilde seçin.
- **Kod İncelemesi**: Kod incelemeleri sırasında birden fazla sorumluluğu olan sınıfları tespit edin ve ayırın.
