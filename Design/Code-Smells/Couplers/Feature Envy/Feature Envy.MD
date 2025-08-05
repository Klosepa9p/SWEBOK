# Feature Envy

## Bu Sorun Açıklaması

**Feature Envy (Özellik Kıskançlığı)**, bir sınıfın veya metodun, kendi verilerinden veya sorumluluklarından çok başka bir sınıfın verilerine veya metodlarına erişmeye çalışması durumudur. Bu, genellikle bir metodun başka bir sınıfın alanlarına veya metodlarına sık sık erişmesi, kendi sınıfının verilerini ise nadiren kullanmasıyla ortaya çıkar. Bu *code smell*, genellikle sınıfların sorumluluklarının yanlış dağıtıldığını gösterir ve **Single Responsibility Principle (Tek Sorumluluk İlkesi)** ile **Law of Demeter (Demeter Yasası)** ihlallerine işaret eder. Feature Envy, **Divergent Change** veya **Shotgun Surgery** gibi diğer sorunlarla ilişkilidir.

## Bu Sorun Neye Sebep Olabilir

- **Bağımlılık Artışı**: Bir sınıfın başka bir sınıfın iç detaylarına fazla bağımlı olması, sıkı bağlanmaya (tight coupling) neden olur ve modülerliği azaltır.

- **Bakım Zorluğu**: Başka bir sınıfın verilerine veya metodlarına bağımlı olan kod, o sınıfta yapılan değişikliklerden kolayca etkilenir, bu da bakımı zorlaştırır.

- **Hata Olasılığı**: Başka bir sınıfın iç yapısını yanlış anlamak veya yanlış kullanmak, hatalara yol açabilir.

- **Kod Tekrarı**: Aynı mantık, farklı sınıflarda tekrarlanabilir, bu da DRY (Don't Repeat Yourself) ilkesine aykırıdır.

- **Okunabilirlik Sorunları**: Bir metodun başka bir sınıfın verilerine aşırı erişimi, kodun hangi sınıfın hangi sorumluluğu üstlendiğini anlamayı zorlaştırır.

## Çözümü Nedir

- **Metodu Taşı (Move Method)**: Feature Envy gösteren metodu, eriştiği verilerin bulunduğu sınıfa taşıyın.

- **Sorumlulukları Ayır**: Sınıfların sorumluluklarını netleştirerek her sınıfın kendi verileriyle çalışmasını sağlayın.

- **Sınıf Oluştur (Extract Class)**: İlgili veriler ve metodlar bir grup oluşturuyorsa, bunları yeni bir sınıfa ayırın.

- **Tasarım Desenleri**: Strateji, Facade veya Kompozisyon gibi desenler kullanarak bağımlılıkları azaltın ve sorumlulukları organize edin.

- **Law of Demeter**: Bir sınıfın yalnızca doğrudan ilişkili olduğu sınıfların metodlarına erişmesini sağlayın.

- **Yeniden Düzenleme (Refactoring)**: Başka bir sınıfın verilerine aşırı erişen kod parçalarını, doğru sınıfa taşıyarak bağımlılıkları azaltın.
