# Tramp Data

## Bu Sorun Açıklaması

**Tramp Data (Geçici Veri)**, bir fonksiyonun yalnızca başka bir fonksiyona iletmek için veri alması ve bu veriyi kendisi kullanmaması durumudur. Bu, genellikle bir metodun başka bir metodun ihtiyaç duyduğu veriyi taşımak için gereksiz parametreler almasıyla ortaya çıkar. Tramp Data, kodun karmaşıklığını artırır ve genellikle `Message Chains`, `Long Parameter List` veya `Dubious Abstraction` gibi diğer code smell'lerle ilişkilidir. Bu durum, kodun tasarımında bir sorun olduğunu ve işlevselliğin yanlış dağıtıldığını gösterir.

---

## Bu Sorun Neye Sebep Olabilir

- **Kod Karmaşıklığı:** Gereksiz parametreler, metodların okunmasını ve anlaşılmasını zorlaştırır.  
- **Bakım Zorluğu:** Tramp Data, metodların imzasını şişirir ve kodun yeniden düzenlenmesini (refactoring) karmaşık hale getirir, çünkü çağrı zincirindeki her metodun parametreleri güncellenmelidir.  
- **Hata Olasılığı:** Gereksiz parametrelerin yanlış kullanımı veya unutulması, hatalara yol açabilir.  
- **Ad Alanı Kirliliği:** Tramp Data'nın tanımlanması için ek `import`'lar gerekebilir, bu da ad alanını kirletebilir.  
- **Esneklik Eksikliği:** Kodun farklı bağlamlarda veya alternatif implementasyonlarla kullanılması zorlaşır, çünkü gereksiz bağımlılıklar yaratılır.  

---

## Çözümü Nedir

- **Metodu Taşı (Move Method):** Tramp Data'nın kullanıldığı mantığı, veriyi gerçekten kullanan sınıfa veya metoda taşıyın.  
- **Veriyi Kapsülle (Encapsulate Data):** İlgili verileri bir nesne veya veri yapısı içinde birleştirerek parametre sayısını azaltın.  
- **Sorumlulukları Ayır:** *Single Responsibility Principle*’ı uygulayarak her metodun yalnızca kendi işlevselliğine odaklanmasını sağlayın.  
- **Tasarım Desenleri:** *Strategy* veya *Composition* gibi desenler kullanarak verinin geçtiği zinciri sadeleştirin.  
- **Yeniden Düzenleme (Refactoring):** Tramp Data'yı tespit ederek, gereksiz parametreleri kaldırın ve veriyi yalnızca ihtiyaç duyulan yerde işleyin.  
- **Anlamlı İsimlendirme:** Parametre isimlerini, verinin amacını açıkça ifade edecek şekilde tutarlı hale getirin.  
