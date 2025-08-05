## Message Chains

### Bu Sorun Açıklaması

**Message Chains (Mesaj Zincirleri)**, bir sınıfın veya metodun, başka bir sınıfın içindeki nesnelere veya onların içindeki diğer nesnelere zincirleme şekilde erişmesi durumudur. Bu, genellikle uzun bir metod çağrı zinciri (örneğin, `object.getA().getB().getC().doSomething()`) şeklinde ortaya çıkar ve **Law of Demeter (Demeter Yasası)** ihlaline neden olur.

Message Chains, sınıflar arasında **sıkı bağlanmaya (tight coupling)** yol açar ve genellikle `Inappropriate Intimacy`, `Feature Envy` veya `Law of Demeter Violations` gibi diğer code smell'lerle ilişkilidir.

---

### Bu Sorun Neye Sebep Olabilir

- **Bağımlılık Artışı:** Zincirleme çağrılar, bir sınıfın diğer sınıfların iç yapısına bağımlı olmasına neden olur, bu da modülerliği azaltır.
- **Bakım Zorluğu:** Zincirdeki bir nesnenin yapısı değiştiğinde (örneğin, bir metod kaldırıldığında), zinciri kullanan tüm kod etkilenir.
- **Hata Olasılığı:** Uzun zincirler, `null` referans hataları (örneğin, `NullPointerException`) gibi sorunlara yol açabilir.
- **Okunabilirlik Sorunları:** Uzun metod çağrı zincirleri, kodun ne yaptığını anlamayı zorlaştırır ve bağlamı belirsizleştirir.
- **Test Zorluğu:** Zincirleme bağımlılıklar, birim testlerinde nesneleri izole etmeyi ve mock oluşturmayı karmaşık hale getirir.

---

### Çözümü Nedir

- **Kapsüllemeyi Güçlendir:** Sınıfların iç detaylarını gizleyin ve yalnızca gerekli arayüzleri açığa çıkarın.
- **Metodu Taşı (Move Method):** Zincirleme çağrılarla erişilen mantığı, ilgili sınıfa taşıyın.
- **Sınıf Oluştur (Extract Class):** Zincirdeki nesneler bir grup oluşturuyorsa, bu mantığı yeni bir sınıfa ayırın.
- **Tasarım Desenleri:** `Facade`, `Mediator` veya `Adapter` gibi desenler kullanarak zincirleme erişimi soyutlayın.
- **Law of Demeter Uygulaması:** Bir sınıfın yalnızca doğrudan ilişkili nesnelerin metodlarına erişmesini sağlayın ve zincirleme çağrılardan kaçının.
- **Yeniden Düzenleme (Refactoring):** Zincirleme metod çağrılarını tespit ederek, bağımlılıkları azaltacak şekilde kodu yeniden düzenleyin.
