# Hidden Temporal Coupling

## Bu Sorun Açıklaması

**Hidden Temporal Coupling (Gizli Zamansal Bağımlılık)**, bir sınıfın veya metodun doğru çalışması için belirli bir sırayla çağrılması gereken işlemlerin, bu sırayı açıkça belirtmeden veya zorunlu kılmadan uygulanması durumudur. Bu, metodların veya işlemlerin birbirine zamansal olarak bağlı olduğu, ancak bu bağımlılığın kodda açıkça görünmediği veya belgelenmediği anlamına gelir. Bu *code smell*, genellikle kodun yanlış kullanımına yol açar ve **Hidden Dependencies** veya **Obscured Intent** gibi diğer sorunlarla ilişkilidir.

## Bu Sorun Neye Sebep Olabilir

- **Hata Olasılığı**: Metodlar yanlış sırayla çağrıldığında, beklenmedik davranışlar veya hatalar ortaya çıkabilir, çünkü bağımlılıklar açıkça belirtilmemiştir.

- **Okunabilirlik Sorunları**: Zamansal bağımlılıklar gizli olduğunda, geliştiriciler kodun doğru kullanım sırasını anlamak için ek çaba harcamak zorunda kalır.

- **Bakım Zorluğu**: Kodun değiştirilmesi veya yeniden düzenlenmesi, gizli zamansal bağımlılıklar nedeniyle karmaşık hale gelir.

- **Test Zorluğu**: Testler, doğru sırayı varsaymadan yazılmalıdır, ancak gizli bağımlılıklar bunu zorlaştırabilir ve testlerin kırılganlığına yol açabilir.

- **Kullanıcı Hataları**: Kodun kullanıcıları (örneğin, diğer geliştiriciler), sırayı yanlış anlayarak hatalı kullanım yapabilir.

## Çözümü Nedir

- **Zamansal Bağımlılığı Açık Hale Getir**: Metodların çağrılma sırasını zorunlu kılacak bir yapı (örneğin, bir akış sınıfı veya durum makinesi) kullanın.

- **Sorumlulukları Birleştir**: Zamansal bağımlılıkları olan işlemleri tek bir metod veya sınıfta toplayarak sırayı kontrol edin.

- **Fluent Arayüz (Fluent Interface)**: Metod zincirleme (method chaining) kullanarak doğru sırayı zorunlu hale getirin.

- **Durum Yönetimi (State Management)**: Sınıfın durumunu izleyerek yalnızca doğru durumlarda belirli metodların çağrılmasını sağlayın.

- **Dokümantasyon**: Zamansal bağımlılıkları açıkça belgeleyin ve metodların doğru kullanım sırasını belirtin.

- **Yeniden Düzenleme (Refactoring)**: Gizli zamansal bağımlılıkları tespit ederek, sırayı zorunlu kılan veya bağımlılıkları kaldıran bir tasarıma geçin.
