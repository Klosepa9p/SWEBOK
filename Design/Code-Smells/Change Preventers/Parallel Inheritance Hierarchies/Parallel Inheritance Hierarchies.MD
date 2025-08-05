# Parallel Inheritance Hierarchies

## Bu Sorun Açıklaması

**Parallel Inheritance Hierarchies (Paralel Kalıtım Hiyerarşileri)**, bir sınıf hiyerarşisindeki değişikliklerin başka bir sınıf hiyerarşisinde paralel olarak değişiklik yapılmasını gerektirdiği durumdur. Bu, genellikle iki veya daha fazla sınıf hiyerarşisinin birbirine sıkı sıkıya bağlı olması ve bir hiyerarşiye yeni bir alt sınıf eklendiğinde diğer hiyerarşide de eşdeğer bir alt sınıf eklenmesi gerekmesiyle ortaya çıkar. Bu *code smell*, genellikle **Divergent Change** veya **Shotgun Surgery** gibi diğer sorunlarla ilişkilidir ve kodun bakımını zorlaştırır.

## Bu Sorun Neye Sebep Olabilir

- **Bakım Zorluğu**: Bir hiyerarşide yapılan değişiklik, diğer hiyerarşide de paralel değişiklikler gerektirir, bu da kod tabanını güncellemeyi karmaşık hale getirir.

- **Hata Olasılığı**: Paralel hiyerarşiler arasında senkronizasyon unutulursa, eksik veya yanlış implementasyonlar nedeniyle hatalar oluşabilir.

- **Kod Tekrarı**: Benzer mantık, farklı hiyerarşilerde tekrarlanabilir, bu da DRY (Don't Repeat Yourself) ilkesine aykırıdır.

- **Bağımlılık Artışı**: Hiyerarşiler arasındaki sıkı bağ, kodun modülerliğini ve yeniden kullanılabilirliğini azaltır.

- **Esneklik Eksikliği**: Yeni bir alt sınıf eklemek, birden fazla hiyerarşide değişiklik yapılmasını gerektirir, bu da Open/Closed Principle'a aykırıdır.

## Çözümü Nedir

- **Sınıf Birleştirme (Collapse Hierarchy)**: Paralel hiyerarşileri tek bir hiyerarşiye birleştirerek bağımlılıkları azaltın.

- **Kompozisyon Kullanımı**: Kalıtım yerine kompozisyon kullanarak davranışları ayrı sınıflara veya bileşenlere taşıyın.

- **Tasarım Desenleri**: Strateji, Köprü (Bridge) veya Dekoratör gibi desenler kullanarak paralel bağımlılıkları ortadan kaldırın.

- **Arayüz Kullanımı**: Ortak bir arayüz tanımlayarak hiyerarşiler arasındaki bağımlılığı soyutlayın.

- **Yeniden Düzenleme (Refactoring)**: Paralel hiyerarşileri tespit ederek, davranışları tek bir sınıf veya modül içinde birleştirin.

- **Sorumlulukları Ayır**: Single Responsibility Principle'ı uygulayarak her sınıfın tek bir sorumluluğa odaklanmasını sağlayın.
