# Iceberg Class Anti-Pattern

## Tanım
Iceberg Class, bir yazılım sınıfının gereğinden fazla sorumluluk üstlenmesi ve büyük, karmaşık bir yapıya dönüşmesi durumunu ifade eden bir anti-patterndir. Adını, buzdağının sadece küçük bir kısmının görünür olmasından alır; sınıfın yüzeyde basit görünse de altında karmaşık ve yönetilmesi zor bir yapı barındırır.

## Özellikleri
- **Aşırı Sorumluluk**: Tek bir sınıfın çok fazla işlev ve veri içermesi.
- **Karmaşıklık**: Kodun okunması, anlaşılması ve bakımı zorlaşır.
- **Sıkı Bağlılık**: Sınıfın diğer sistem bileşenleriyle aşırı bağımlılığı.
- **Bakım Zorluğu**: Değişikliklerin beklenmedik yan etkilere yol açması.
- **Test Zorluğu**: Sınıfın büyüklüğü nedeniyle test edilmesi zorlaşır.

## Neden Oluşur
- Tek Sorumluluk İlkesi’ne (Single Responsibility Principle) uyulmaması.
- Kötü tasarım veya planlama eksikliği.
- Sınıfın zamanla yeni işlevlerle şişmesi (scope creep).
- Refactoring yapmaktan kaçınma veya teknik borç birikimi.
- Deneyimsiz geliştiricilerin modülerlikten uzak kod yazması.

## Çözüm Yolları
- **Refactoring**: Sınıfı daha küçük, tek sorumluluğa sahip sınıflara ayırma.
- **Single Responsibility Principle**: Her sınıfın tek bir amaç için tasarlanması.
- **Modüler Tasarım**: İşlevselliği mantıksal olarak ayrılmış modüllere dağıtma.
- **Kod İncelemesi**: Karmaşık sınıfları erken tespit etmek için düzenli incelemeler.
- **Test Yazma**: Testlerle sınıfın davranışını netleştirme ve yeniden yapılandırmayı kolaylaştırma.
- **Tasarım Desenleri**: Uygun desenler (ör. Strategy, Facade) kullanarak karmaşıklığı azaltma.