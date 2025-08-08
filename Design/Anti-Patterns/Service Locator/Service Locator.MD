# Service Locator Anti-Pattern

## Tanım
**Service Locator**, uygulamanın ihtiyaç duyduğu bağımlılıkları merkezi bir “servis bulucu” nesne üzerinden alması yaklaşımıdır.  
Başlangıçta bağımlılık yönetimini kolaylaştırmak amacıyla kullanılabilir, ancak zamanla **gizli bağımlılıklar**, **zor test edilebilirlik** ve **bağımlılıkların izlenmesinde zorluk** gibi problemlere yol açtığı için bir **anti-pattern** olarak kabul edilir.

---

## Özellikleri
- **Gizli Bağımlılıklar**: Sınıfın hangi servislere ihtiyaç duyduğunun dışarıdan açıkça anlaşılmaması.  
- **Merkezi Bağımlılık Yönetimi**: Tüm bağımlılıkların tek bir locator nesnesi üzerinden çözülmesi.  
- **Test Zorlukları**: Servis locator'ın test sırasında sahte (mock) nesnelerle değiştirilmesinin zor olması.  
- **Sıkı Bağımlılık**: Kodun locator’a bağımlı hale gelmesi.  
- **Bağımlılık İzleme Zorluğu**: Kodun hangi servislere eriştiğinin takip edilmesinin zorlaşması.  

---

## Neden Oluşur
- Bağımlılık enjeksiyonu (Dependency Injection) kavramının yanlış anlaşılması.  
- Kısa vadede bağımlılık yönetimini kolaylaştırma isteği.  
- Modüler yapı eksikliği.  
- Deneyimsizlik veya tasarım desenleri konusunda bilgi eksikliği.  
- Hızlı çözüm arayışı.  

---

## Çözüm Yolları
- **Dependency Injection (DI)**: Servisleri ihtiyaç duyan sınıflara yapıcı metod (constructor) veya metod parametresi ile sağlama.  
- **IoC Container Kullanımı**: Bağımlılıkların yönetimini otomatikleştiren çerçevelerden yararlanma.  
- **Açık Bağımlılık Bildirimi**: Sınıfların hangi servislere ihtiyaç duyduğunu açıkça belirten arayüzler veya yapıcı parametreler kullanma.  
- **Test Dostu Tasarım**: Mock veya stub gibi test bağımlılıklarının kolayca eklenebileceği tasarımlar uygulama.  
- **Modüler Mimari**: Servisleri, kullanıldığı alanlara göre mantıksal olarak ayırma.  
