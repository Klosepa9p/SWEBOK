# Found on Internet Anti-Pattern

## Tanım
Found on Internet, geliştiricilerin internetten (ör. Stack Overflow, bloglar, forumlar) buldukları kod parçalarını anlamadan veya doğrulamadan projelerine kopyalayıp kullandığı bir anti-patterndir. Bu, Calendar Coder ve Copy Paste Programming ile benzerlik gösterir ve genellikle hatalı, güvensiz veya bağlama uygun olmayan kodların projeye eklenmesine yol açar.

## Özellikleri
- **Anlamadan Kopyalama**: Kodun nasıl veya neden çalıştığının anlaşılmadan kullanılması.
- **Hatalı Kod**: İnternetten alınan kodun hatalar içermesi veya bağlama uymaması.
- **Güvenlik Riskleri**: Doğrulanmamış kodun güvenlik açıklarına yol açması.
- **Bakım Zorluğu**: Kopyalanan kodun mantığının bilinmemesi nedeniyle hata ayıklamanın zorlaşması.
- **Teknik Borç**: Hızlı çözümlerin uzun vadede sorunlara neden olması.

## Neden Oluşur
- Hızlı çözüm bulma baskısı veya teslim tarihine yetişme kaygısı.
- Teknik bilgi eksikliği veya problem çözme becerisinin yetersizliği.
- İnternet kaynaklarına (özellikle popüler platformlara) aşırı güven.
- Kod incelemesi veya test süreçlerinin eksikliği.
- Eleştirel düşünme yerine kopyalamaya dayalı geliştirme alışkanlığı.

## Çözüm Yolları
- **Kodu Anlama**: İnternetten alınan kodun mantığını ve bağlamını öğrenme.
- **Doğrulama ve Test**: Kopyalanan kodu test ederek uygunluğunu ve güvenliğini kontrol etme.
- **Kod İncelemesi**: Ekip içinde kopyalanan kodun gözden geçirilmesi.
- **Dokümantasyon**: Kullanılan kodun amacını ve kaynağını belgeye kaydetme.
- **Yeniden Kullanım**: Ortak işlevler için kütüphaneler veya framework’ler kullanma.
- **Eğitim**: Geliştiricilere problem çözme ve iyi kod yazma prensipleri öğretme.