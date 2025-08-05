# Law of Demeter Violations

## Bu Sorun Açıklaması

**Law of Demeter Violations** (Demeter Yasası İhlalleri), bir sınıfın veya metodun başka bir sınıfın iç yapısına veya diğer sınıfların iç detaylarına aşırı derecede erişmesi durumudur.  
**Law of Demeter (LoD)**, bir nesnenin yalnızca doğrudan ilişkili olduğu nesnelerin (örneğin, kendi alanları, metod parametreleri veya kendi oluşturduğu nesneler) metodlarına erişmesi gerektiğini belirtir.

Bu kuralın ihlali, genellikle bir sınıfın zincirleme şekilde başka sınıfların iç detaylarına (örneğin, `object.getX().getY().doSomething()`) erişmesiyle ortaya çıkar.  
Bu **code smell**, `Inappropriate Intimacy`, `Feature Envy` veya `Indecent Exposure` gibi diğer sorunlarla ilişkilidir ve kapsülleme (encapsulation) prensibini ihlal eder.

---

## Bu Sorun Neye Sebep Olabilir

- **Bağımlılık Artışı**: Bir sınıfın başka sınıfların iç yapısına bağımlı olması, sıkı bağlanmaya (tight coupling) neden olur ve modülerliği azaltır.
- **Bakım Zorluğu**: Bağımlı sınıfların iç yapısında yapılan değişiklikler, bağımlı olan sınıfı etkileyebilir, bu da bakım sürecini karmaşıklaştırır.
- **Hata Olasılığı**: İç detaylara yanlış veya kontrolsüz erişim, beklenmedik hatalara yol açabilir.
- **Okunabilirlik Sorunları**: Zincirleme metod çağrıları, kodun ne yaptığını anlamayı zorlaştırır ve bağlamın kaybolmasına neden olabilir.
- **Test Zorluğu**: İç detaylara bağımlı kod, birim testlerinde izolasyonu zorlaştırır ve mock/stub kullanımını karmaşık hale getirir.

---

## Çözümü Nedir

- **Kapsüllemeyi Güçlendir**: Sınıfların iç detaylarını gizleyin ve yalnızca gerekli arayüzleri (public metodlar) açığa çıkarın.
- **Metodu Taşı (Move Method)**: Başka bir sınıfın iç detaylarına erişen mantığı, ilgili sınıfa taşıyın.
- **Sınıf Oluştur (Extract Class)**: İlgili veriler ve davranışlar bir grup oluşturuyorsa, bunları yeni bir sınıfa ayırın.
- **Tasarım Desenleri**: `Facade`, `Mediator` veya `Adapter` gibi desenler kullanarak sınıflar arasındaki doğrudan erişimi soyutlayın.
- **Law of Demeter Uygulaması**: Bir sınıfın yalnızca doğrudan ilişkili nesnelerin metodlarına erişmesini sağlayın (örneğin, zincirleme çağrılardan kaçının).
- **Yeniden Düzenleme (Refactoring)**: Zincirleme metod çağrılarını tespit ederek, bağımlılıkları azaltacak şekilde kodu yeniden düzenleyin.
