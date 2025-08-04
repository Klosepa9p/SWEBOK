# 🧩 Class Depends on Subclass

## 📌 Bu Sorun Açıklaması
**Class Depends on Subclass** (Türkçe: *Sınıf Alt Sınıfa Bağımlı*), bir üst sınıfın (**base class**) davranışının veya işlevselliğinin, alt sınıflara (**subclass**) bağımlı olması durumudur.  

Bu, üst sınıfın alt sınıfların:
- Spesifik davranışlarını,
- Özelliklerini  

bilmesi, kullanması veya onlara bağlı olması anlamına gelir.  

Bu durum:
- Nesne yönelimli programlamanın temel prensiplerinden biri olan **Open/Closed Principle** (Açık/Kapalı İlkesi)’ne aykırıdır.
- Genellikle **kötü tasarımın** bir göstergesidir.
- Ayrıca **Liskov Substitution Principle (LSP)** ihlaliyle de ilişkilidir; çünkü üst sınıf, alt sınıfların değiştirilebilirliğini varsayamaz.

---

## ⚠ Bu Sorun Neye Sebep Olabilir?

- **🔗 Bağımlılık Sorunları:**  
  Üst sınıf, alt sınıfların detaylarına bağlı olduğu için alt sınıflarda yapılan değişiklikler üst sınıfı bozabilir.

- **🛠 Bakım Zorluğu:**  
  Alt sınıflardaki değişiklikler, üst sınıfın davranışını etkileyebileceği için kodu korumak ve güncellemek zorlaşır.

- **🧱 Esneklik Eksikliği:**  
  Yeni alt sınıflar eklemek veya mevcut alt sınıfları değiştirmek, üst sınıfın yeniden düzenlenmesini gerektirebilir.

- **🐞 Hata Olasılığı:**  
  Üst sınıfın alt sınıfların spesifik davranışlarını yanlış anlaması veya yanlış kullanması hatalara yol açabilir.

- **♻ Kod Tekrarı:**  
  Üst sınıf, alt sınıfların işlevselliğini tekrar eden kod içerebilir, bu da **DRY (Don't Repeat Yourself)** ilkesine aykırıdır.

- **🧪 Test Zorluğu:**  
  Üst sınıfın alt sınıflara bağımlılığı, birim testlerini karmaşık hale getirir; her alt sınıf için ayrı test senaryoları gerekebilir.

---

## ✅ Çözümü Nedir?

- **Bağımlılığı Tersine Çevir (Dependency Inversion):**  
  Üst sınıfın alt sınıflara değil, soyut bir arayüze veya üst sınıfa bağımlı olmasını sağlayın.

- **Tasarım Desenleri:**  
  Strateji, Şablon Metod veya Fabrika desenlerini kullanarak bağımlılıkları soyutlayın.

- **Sorumlulukları Ayır:**  
  Üst sınıfın alt sınıflara özgü davranışları bilmesini veya kullanmasını önlemek için sorumlulukları netleştirin.

- **Polimorfizm Kullan:**  
  Alt sınıfların davranışlarını, üst sınıfın bilmesine gerek kalmadan polimorfizmle yönetin.

- **Yeniden Düzenleme (Refactoring):**  
  Üst sınıfın alt sınıflara bağımlı olduğu kod parçalarını, soyut bir arayüz veya metod aracılığıyla yeniden düzenleyin.

- **Liskov Substitution Principle (LSP):**  
  Alt sınıfların, üst sınıfın yerine geçebileceği şekilde tasarlandığından emin olun.
