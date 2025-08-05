# Inappropriate Intimacy

## Bu Sorun Açıklaması

**Inappropriate Intimacy (Uygunsuz Yakınlık)**, bir sınıfın başka bir sınıfın iç detaylarına (örneğin, özel alanlarına veya metodlarına) aşırı derecede erişmesi veya bağımlı olması durumudur. Bu, sınıflar arasında gereğinden fazla sıkı bir ilişki oluşmasına neden olur ve genellikle kapsülleme (encapsulation) prensibinin ihlaliyle sonuçlanır. Bu *code smell*, **Law of Demeter (Demeter Yasası)** ihlaliyle ilişkilidir ve **Feature Envy**, **Hidden Dependencies** veya **Artificial Coupling** gibi diğer sorunlarla bağlantılıdır.

## Bu Sorun Neye Sebep Olabilir

- **Bağımlılık Artışı**: Sınıfların birbirlerinin iç detaylarına bağımlı olması, sıkı bağlanmaya (tight coupling) yol açar ve modülerliği azaltır.

- **Bakım Zorluğu**: Bir sınıfın iç yapısında yapılan değişiklikler, bağımlı sınıfları etkileyebilir, bu da bakımı zorlaştırır.

- **Hata Olasılığı**: Başka bir sınıfın özel alanlarına veya metodlarına yanlış erişim, beklenmedik hatalara neden olabilir.

- **Kapsülleme İhlali**: Sınıfın özel detaylarının dışarıdan erişilebilir olması, nesne yönelimli tasarımın temel prensiplerine aykırıdır.

- **Test Zorluğu**: Sınıfların birbirine aşırı bağımlı olması, birim testlerinde izolasyonu zorlaştırır.

## Çözümü Nedir

- **Kapsüllemeyi Güçlendir**: Sınıfların özel alanlarını ve metodlarını koruyarak yalnızca gerekli arayüzleri (public metodlar) açığa çıkarın.

- **Metodu Taşı (Move Method)**: Başka bir sınıfın verilerine veya metodlarına aşırı erişen mantığı, ilgili sınıfa taşıyın.

- **Sınıf Oluştur (Extract Class)**: İlgili işlevselliği veya verileri yeni bir sınıfa ayırarak bağımlılıkları azaltın.

- **Tasarım Desenleri**: Facade, Mediator veya Adapter gibi desenler kullanarak sınıflar arasındaki doğrudan bağımlılıkları soyutlayın.

- **Law of Demeter**: Bir sınıfın yalnızca doğrudan ilişkili olduğu sınıfların metodlarına erişmesini sağlayın.

- **Yeniden Düzenleme (Refactoring)**: Sınıflar arasındaki uygunsuz yakınlıkları tespit ederek bağımlılıkları azaltın ve arayüzleri netleştirin.
