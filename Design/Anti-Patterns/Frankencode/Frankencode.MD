# Frankencode Anti-Pattern

## Tanım
Frankencode, farklı kaynaklardan (ör. eski projeler, internet, kütüphaneler) alınan kod parçalarının bir araya getirilerek, uyumsuz ve düzensiz bir şekilde birleştirilmesiyle oluşan bir anti-patterndir. Adını Frankenstein’ın canavarından alır; çünkü kod, farklı parçaların özensizce birleştirilmesiyle karmakarışık bir yapıya dönüşür.

## Özellikleri
- **Uyumsuz Kod Parçaları**: Farklı kaynaklardan alınan kodların birbiriyle uyumsuz olması.
- **Karmaşıklık**: Kodun düzensiz, anlaşılması zor ve tutarsız bir yapıya sahip olması.
- **Bakım Zorluğu**: Hataları bulmak veya değişiklik yapmak için kodun çözülmesi gerekliliği.
- **Hata Eğilimi**: Uyumsuz parçaların beklenmedik hatalara yol açması.
- **Dokümantasyon Eksikliği**: Kodun kaynağının veya mantığının belgelenmemesi.

## Neden Oluşur
- Hızlı teslim baskısı nedeniyle mevcut kodların düşünmeden birleştirilmesi.
- Kod yeniden kullanımı (reuse) prensiplerine hakim olmama.
- İnternetten veya eski projelerden kod kopyalama alışkanlığı.
- Teknik bilgi eksikliği veya bağlam analizi yapmama.
- Kod incelemesi veya test süreçlerinin yetersizliği.

## Çözüm Yolları
- **Modüler Tasarım**: Kodun yeniden kullanılabilir ve uyumlu modüllerle yazılması.
- **Kod İncelemesi**: Birleştirilen kodların uyumluluğunu ve kalitesini kontrol etme.
- **Test Odaklı Geliştirme**: Entegre edilen kodun testlerle doğrulanması.
- **Dokümantasyon**: Kullanılan kod parçalarının kaynağını ve amacını belgeye kaydetme.
- **Refactoring**: Karmaşık veya uyumsuz kodları sadeleştirme ve standartlaştırma.
- **Eğitim**: Geliştiricilere iyi tasarım prensipleri ve kod entegrasyonu öğretme.