# Indecent Exposure (Uygunsuz Açığa Çıkarma)

## Bu Sorun Açıklaması

**Indecent Exposure**, bir sınıfın özel (private) olması gereken iç detaylarını (alanlar, metodlar veya veri yapıları) gereksiz yere genel (public) veya korumasız bir şekilde açığa çıkarması durumudur. Bu durum kapsülleme (encapsulation) prensibinin ihlal edilmesine neden olur ve sınıfın iç durumunun dışarıdan manipüle edilmesine olanak tanır.

Bu code smell genellikle şu problemlerle ilişkilidir:

- Inappropriate Intimacy
- Feature Envy
- Hidden Dependencies

Kodun güvenilirliğini ve bakımını zorlaştırır.

---

## Bu Sorun Neye Sebep Olabilir

- **Kapsülleme İhlali**: İç detayların dışarıya açılması, sınıfın durumunun kontrolsüz bir şekilde değiştirilmesine olanak tanır, bu da beklenmedik davranışlara yol açabilir.
- **Hata Olasılığı**: Dışarıdan erişilen alanlar veya metodlar yanlış kullanıldığında hatalar ortaya çıkabilir.
- **Bağımlılık Artışı**: Açığa çıkan iç detaylar, diğer sınıfların bu detaylara bağımlı hale gelmesine neden olur, bu da sıkı bağlanmaya (tight coupling) yol açar.
- **Bakım Zorluğu**: İç yapının değiştirilmesi, bağımlı sınıfları etkileyebilir ve bu da kodu güncellemeyi karmaşık hale getirir.
- **Test Zorluğu**: Açığa çıkan iç detaylar, testlerin sınıfın iç durumuna bağımlı olmasına neden olabilir, bu da testlerin kırılganlığını artırır.

---

## Çözümü Nedir

- **Kapsüllemeyi Güçlendir**: Özel alanları ve metodları `private` veya `protected` yaparak yalnızca gerekli arayüzleri `public` olarak açığa çıkarın.
- **Getter/Setter Kullanımı**: Alanlara doğrudan erişim yerine kontrollü erişim için getter ve setter metodları kullanın.
- **Metodu Taşı (Move Method)**: Açığa çıkan metodlar başka bir sınıfın sorumluluğuna aitse, ilgili sınıfa taşıyın.
- **Sınıf Oluştur (Extract Class)**: İç detaylar bir grup oluşturuyorsa, bunları yeni bir sınıfa ayırın ve uygun şekilde kapsülleyin.
- **Tasarım Desenleri**: `Facade` veya `Adapter` gibi desenler kullanarak iç detayları soyutlayın ve yalnızca gerekli arayüzleri sunun.
- **Yeniden Düzenleme (Refactoring)**: Açığa çıkan iç detayları tespit ederek bunları gizleyin ve yalnızca gerekli işlevselliği açığa çıkarın.
