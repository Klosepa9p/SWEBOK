# Copy Folder Versioning Anti-Pattern

## Tanım
Copy Folder Versioning, kaynak kodun güncellenmesi için kodun bulunduğu klasörün kopyalarının oluşturulduğu bir yazılım geliştirme anti-pattern'idir. Bu, hangi kopyanın en güncel olduğunu anlamayı zorlaştıran, sürüm geçmişi olmayan ve değişikliklerin takibini imkansız kılan karmaşık bir klasör yığınına yol açar.

## Özellikleri
- **Klasör Yığınları**: Aynı kodun birden çok kopyasının farklı klasörlerde bulunması.
- **Sürüm Geçmişi Eksikliği**: Değişikliklerin ne zaman veya neden yapıldığının izlenememesi.
- **Kafa Karışıklığı**: En güncel veya doğru sürümün hangisi olduğunun belirsizliği.
- **Bakım Zorluğu**: Hataları düzeltmek veya güncellemeleri birleştirmek için kopyalar arasında manuel karşılaştırma yapılması.
- **Kaynak İsrafı**: Aynı kodun birden çok kopyasının depolanması.

## Neden Oluşur
- Versiyon kontrol sistemlerinin (VCS) kullanılmaması veya bilinmemesi.
- Hızlı ve geçici çözümler arayan geliştiricilerin klasör kopyalama alışkanlığı.
- Ekipte uygun sürüm kontrol süreçlerinin eksikliği.
- Eski alışkanlıkların veya deneyimsizliğin etkisi.
- Değişikliklerden korkarak orijinal kodu "koruma" isteği.

## Çözüm Yolları
- **Versiyon Kontrol Sistemleri**: Git, SVN gibi araçlarla kodun sürümlerini yönetme.
- **Dal (Branch) Kullanımı**: Yeni özellikler veya değişiklikler için ayrı dallar oluşturma.
- **Otomasyon**: CI/CD süreçleriyle sürüm yönetimini standardize etme.
- **Eğitim**: Ekip üyelerine versiyon kontrol sistemleri konusunda eğitim verme.
- **Dokümantasyon**: Değişikliklerin amacını ve hangi sürümde yapıldığını kaydetme.
- **Temizleme**: Gereksiz klasör kopyalarını silerek codebase'i sadeleştirme.