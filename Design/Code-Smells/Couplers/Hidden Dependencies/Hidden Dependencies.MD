# Hidden Dependencies

## Bu Sorun Açıklaması

**Hidden Dependencies (Gizli Bağımlılıklar)**, bir sınıfın veya metodun, açıkça belirtilmeyen veya belgelenmeyen başka sınıflara, nesnelere veya dış kaynaklara bağımlı olması durumudur. Bu bağımlılıklar, genellikle kodun içinde doğrudan nesne oluşturulması (örneğin, `new` anahtar kelimesi), statik metod çağrıları veya global durumlara erişim yoluyla gizlenir. Bu *code smell*, genellikle **Inappropriate Static**, **Artificial Coupling** veya **Feature Envy** gibi diğer sorunlarla ilişkilidir ve kodun test edilebilirliğini, modülerliğini ve bakımını zorlaştırır.

## Bu Sorun Neye Sebep Olabilir

- **Test Zorluğu**: Gizli bağımlılıklar, birim testlerinde bağımlılıkları izole etmeyi zorlaştırır, çünkü mock veya stub kullanımı engellenir.

- **Bağımlılık Artışı**: Sınıflar, gizli bağımlılıklar nedeniyle sıkı sıkıya bağlanır (tight coupling), bu da modülerliği azaltır.

- **Bakım Zorluğu**: Gizli bağımlılıklar, kodun değiştirilmesini veya yeniden yapılandırılmasını zorlaştırır, çünkü bağımlılıklar açıkça görünmez.

- **Hata Olasılığı**: Bağımlı nesnelerin veya kaynakların yanlış yapılandırılması, beklenmedik hatalara neden olabilir.

- **Esneklik Eksikliği**: Gizli bağımlılıklar, kodun farklı bağlamlarda veya alternatif implementasyonlarla kullanılmasını zorlaştırır.

## Çözümü Nedir

- **Bağımlılık Enjeksiyonu**: Bağımlılıkları constructor, metod parametreleri veya setter metodları aracılığıyla açıkça enjekte edin.

- **Arayüz Kullanımı**: Somut sınıflara bağımlılık yerine soyut arayüzler veya sınıflar kullanın, böylece bağımlılıklar soyutlanır.

- **Fabrika Deseni**: Nesne oluşturmayı bir fabrika sınıfına devrederek gizli bağımlılıkları ortadan kaldırın.

- **Yeniden Düzenleme (Refactoring)**: Gizli bağımlılıkları tespit ederek açık bağımlılıklara dönüştürün.

- **Dokümantasyon**: Bağımlılıkları açıkça belgeleyin ve hangi sınıfların hangi kaynaklara ihtiyaç duyduğunu belirtin.

- **Test Kolaylığı**: Bağımlılıkları izole edilebilir hale getirerek birim testlerini kolaylaştırın (örneğin, mock nesneler kullanarak).
