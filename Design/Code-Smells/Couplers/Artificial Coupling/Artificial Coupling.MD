# Artificial Coupling

## Bu Sorun Açıklaması

**Artificial Coupling (Yapay Bağımlılık)**, sınıflar veya modüller arasında gereksiz veya zorlama bağımlılıkların oluşturulması durumudur. Bu, genellikle bir sınıfın başka bir sınıfa mantıksal olarak ihtiyaç duymadığı halde, tasarım veya implementasyon nedeniyle ona bağımlı olmasıyla ortaya çıkar. Bu *code smell*, genellikle kötü tasarım kararları, yanlış soyutlamalar veya gereksiz genelleştirme çabaları nedeniyle oluşur ve **Inappropriate Static**, **Feature Envy** veya **Inconsistent Abstraction Levels** gibi diğer sorunlarla ilişkilidir. Yapay bağımlılıklar, kodun esnekliğini azaltır ve bakımını zorlaştırır.

## Bu Sorun Neye Sebep Olabilir

- **Bağımlılık Artışı**: Gereksiz bağımlılıklar, sınıfların birbirine sıkı sıkıya bağlanmasına (tight coupling) neden olur, bu da modülerliği azaltır.

- **Bakım Zorluğu**: Yapay bağımlılıklar, bir sınıfın değiştirilmesinin diğer sınıfları etkilemesine yol açar, bu da hata ayıklamayı ve güncellemeyi zorlaştırır.

- **Esneklik Eksikliği**: Kod, yeni gereksinimlere veya değişikliklere kolayca uyarlanamaz, çünkü gereksiz bağımlılıklar sistemi kısıtlar.

- **Hata Olasılığı**: Bağımlı sınıfların yanlış kullanılması veya yanlış anlaşılması, beklenmedik hatalara neden olabilir.

- **Test Zorluğu**: Yapay bağımlılıklar, sınıfları izole etmeyi zorlaştırır ve birim testlerini karmaşık hale getirir.

## Çözümü Nedir

- **Bağımlılıkları Azalt**: Gereksiz bağımlılıkları tespit ederek sadece gerekli olanları koruyun.

- **Bağımlılık Enjeksiyonu**: Sınıfların bağımlılıklarını constructor veya metod parametreleri aracılığıyla enjekte ederek sıkı bağımlılıkları gevşetin.

- **Sorumlulukları Ayır**: Single Responsibility Principle'ı uygulayarak sınıfların yalnızca kendi işlevselliklerine odaklanmasını sağlayın.

- **Tasarım Desenleri**: Facade, Adapter veya Strateji gibi desenler kullanarak bağımlılıkları soyutlayın ve modülerliği artırın.

- **Yeniden Düzenleme (Refactoring)**: Yapay bağımlılıkları kaldırarak sınıfları daha bağımsız hale getirin.

- **Arayüz Kullanımı**: Somut sınıflara bağımlılık yerine soyut arayüzler veya sınıflar kullanın.
