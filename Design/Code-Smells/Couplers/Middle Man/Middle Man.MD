## Middle Man

### Bu Sorun Açıklaması

**Middle Man (Aracı)**, bir sınıfın veya metodun yalnızca başka bir sınıfın veya metodun işlevselliğini yönlendirmesi (delegate etmesi) ve kendi içinde anlamlı bir işlevsellik sunmaması durumudur. 

Bu, genellikle bir sınıfın sadece bir aracı gibi davranarak başka bir sınıfın metodlarını çağırmasıyla ortaya çıkar. Middle Man, kodun gereksiz yere karmaşıklaşmasına neden olur ve genellikle `Inappropriate Intimacy`, `Feature Envy` veya `Hidden Dependencies` gibi diğer code smell'lerle ilişkilidir.

Bu durum, sınıfların sorumluluklarının yanlış dağıtıldığını ve gereksiz bir soyutlama katmanı eklendiğini gösterir.

---

### Bu Sorun Neye Sebep Olabilir

- **Kod Karmaşıklığı:** Gereksiz aracı sınıflar veya metodlar, kodun okunmasını ve anlaşılmasını zorlaştırır.
- **Bakım Zorluğu:** Ekstra katmanlar, kod tabanını büyütür ve değişiklik yapmayı daha karmaşık hale getirir.
- **Performans Etkisi:** Çok fazla yönlendirme, özellikle sık çağrılan sistemlerde, küçük de olsa performans kayıplarına yol açabilir.
- **Sorumluluk Belirsizliği:** Middle Man, bir sınıfın gerçek sorumluluğunun ne olduğunu belirsizleştirir ve kodun amacını anlamayı zorlaştırır.
- **Test Zorluğu:** Gereksiz aracı sınıflar, test yazımını karmaşık hale getirir, çünkü bu sınıfların test edilmesi genellikle anlamlı bir değer katmaz.

---

### Çözümü Nedir

- **Aracıyı Kaldır (Remove Middle Man):** Yönlendirme yapan sınıfı veya metodu kaldırarak istemcinin doğrudan hedef sınıfa veya metoda erişmesini sağlayın.
- **Metodu Taşı (Move Method):** Middle Man'in yönlendirdiği mantığı, istemcinin doğrudan kullanabileceği bir sınıfa taşıyın.
- **Sorumlulukları Netleştir:** Sınıfların ve metodların anlamlı bir işlevsellik sunmasını sağlayarak gereksiz yönlendirmeleri ortadan kaldırın.
- **Tasarım Desenleri:** `Facade` veya `Proxy` gibi desenler, yalnızca gerçekten gerekli olduğunda (örneğin, ek kontrol veya soyutlama için) kullanılmalıdır.
- **Yeniden Düzenleme (Refactoring):** Gereksiz aracı sınıfları veya metodları tespit ederek kodu sadeleştirin.
- **Kapsüllemeyi Koru:** Aracıyı kaldırırken, kapsülleme prensibini ihlal etmemeye dikkat edin; yalnızca gerekli arayüzler açığa çıkarılmalıdır.
