# Data Class

## Bu Sorun Açıklaması

**Data Class (Veri Sınıfı)**, yalnızca veri tutan (örneğin, alanlar ve getter/setter metodları) ve anlamlı bir iş mantığı veya davranışı olmayan sınıfların varlığıdır.  
Bu sınıflar, genellikle yalnızca veri saklama ve erişim için kullanılır ve iş mantığını başka sınıflara bırakır.

Bu *code smell*, nesne yönelimli programlamanın temel prensiplerinden biri olan kapsülleme ve sorumluluk dağılımının ihlal edildiğini gösterir.  
Data Class, genellikle **Feature Envy**, **Inappropriate Intimacy** veya **Lazy Class** gibi diğer code smell'lerle ilişkilidir.

---

## Bu Sorun Neye Sebep Olabilir

- **Sorumluluk Eksikliği**:  
  Data Class'lar yalnızca veri saklar ve iş mantığını başka sınıflara yükler.  
  Bu da diğer sınıfların bu verilere aşırı bağımlı olmasına neden olur.

- **Bağımlılık Artışı**:  
  Diğer sınıflar, Data Class'ın iç detaylarına (örneğin, alanlarına) doğrudan erişerek **sıkı bağlanmaya (tight coupling)** yol açar.

- **Bakım Zorluğu**:  
  İş mantığı başka sınıflara dağıldığında, bu mantığı değiştirmek veya hata ayıklamak karmaşık hale gelir.

- **Hata Olasılığı**:  
  Data Class'ın alanlarına kontrolsüz erişim, veri tutarsızlıklarına veya beklenmedik davranışlara neden olabilir.

- **Kod Tekrarı**:  
  İş mantığı, farklı sınıflarda tekrarlanabilir.  
  Bu da **DRY (Don't Repeat Yourself)** ilkesine aykırıdır.

---

## Çözümü Nedir

- **Davranış Ekle (Encapsulate Behavior)**:  
  Data Class'a, veriyle ilgili iş mantığını (örneğin, doğrulama, hesaplama) ekleyerek sınıfı daha anlamlı hale getirin.

- **Metodu Taşı (Move Method)**:  
  Data Class'ın verilerini kullanan mantığı, bu sınıfa taşıyın.

- **Sınıf Oluştur (Extract Class)**:  
  Eğer Data Class çok fazla veri içeriyorsa, verileri ve ilgili mantığı daha küçük, anlamlı sınıflara ayırın.

- **Kapsüllemeyi Güçlendir**:  
  Alanlara doğrudan erişimi kaldırarak getter/setter metodlarını veya daha anlamlı arayüzleri kullanın.

- **Tasarım Desenleri Kullan**:  
  Strategy veya Composition gibi desenlerle Data Class'ın sorumluluklarını dağıtın.

- **Yeniden Düzenleme (Refactoring)**:  
  Data Class'ları tespit ederek, yalnızca veri tutmaktan öteye geçen bir işlevsellik kazandırın.
