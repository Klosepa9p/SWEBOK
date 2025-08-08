# Magic Strings Anti-Pattern

## Tanım
Magic Strings, yazılım kodunda sabit kodlanmış (hard-coded), anlamı veya amacı doğrudan anlaşılmayan metin dizilerinin (string) kullanılması durumunu ifade eden bir anti-patterndir. Bu diziler, kodun okunabilirliğini, bakımını ve yeniden kullanılabilirliğini zorlaştırır.

## Özellikleri
- **Sabit Kodlanmış Değerler**: Kod içinde bağlamı belirsiz metin dizilerinin bulunması.
- **Okunabilirlik Sorunu**: Kodun amacının anlaşılmasının zorlaşması.
- **Bakım Zorluğu**: Değişiklik gerektiğinde tüm magic string’lerin manuel güncellenmesi.
- **Hata Eğilimi**: Yazım hataları veya yanlış değerlerin gözden kaçması.
- **Yeniden Kullanım Eksikliği**: Aynı string’in farklı yerlerde tekrarlanması.

## Neden Oluşur
- Hızlı geliştirme veya geçici çözümler arayışı.
- Sabit değerleri merkezi bir yerde tanımlama alışkanlığının olmaması.
- Kodlama standartlarına uyulmaması.
- Deneyimsizlik veya tasarım prensiplerine hakim olmama.
- Teknik borç birikiminin göz ardı edilmesi.

## Çözüm Yolları
- **Sabit Tanımlama**: Magic string’leri sabit (constant) değişkenlerde veya yapılandırma dosyalarında tanımlama.
- **Anlamlı İsimlendirme**: Değişken isimlerinin string’in amacını açıkça ifade etmesi.
- **Konfigürasyon Yönetimi**: Değerleri merkezi bir konfigürasyon dosyasından çekme.
- **Kod İncelemesi**: Magic string’leri tespit etmek için düzenli incelemeler.
- **Refactoring**: Sabit kodlanmış dizileri merkezi ve yeniden kullanılabilir yapılara dönüştürme.
- **Dokümantasyon**: Kullanılan sabitlerin amacını belgeye kaydetme.