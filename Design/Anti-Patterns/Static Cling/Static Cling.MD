# Static Cling Anti-Pattern

## Tanım
**Static Cling**, yazılımda gereğinden fazla ve yanlış kullanım sonucu statik (static) değişkenler, metotlar veya sınıfların yaygın olarak kullanılmasıyla ortaya çıkan bir **anti-pattern**’dir.  
Bu durum, kodun esnekliğini ve test edilebilirliğini azaltır, global durum yönetimi sorunlarına ve yan etkilerin kontrolünün zorlaşmasına neden olur.

---

## Özellikleri
- **Aşırı Statik Kullanımı**: Çok sayıda statik değişken ve metot kullanımı.  
- **Global Durum Yönetimi**: Statik yapılar nedeniyle global state’lerin yaygınlaşması.  
- **Test Zorlukları**: Statik yapılar mock veya stub ile kolayca değiştirilemez.  
- **Bağımlılıkların Gizlenmesi**: Bağımlılıkların sınıf yapısı içinde açıkça görünmemesi.  
- **Yan Etkilerin Artması**: Global durum nedeniyle beklenmedik yan etkiler ve hata oluşumu.  

---

## Neden Oluşur
- Kolaylık ve hızlı erişim amacıyla statik yapılara yönelme.  
- Nesne yönelimli prensiplerin yanlış anlaşılması veya bilinmemesi.  
- Test yazma kültürünün zayıf olması.  
- Küçük çaplı uygulamalarda hızlı çözümler geliştirme isteği.  
- Bağımlılık enjeksiyonu gibi daha karmaşık yöntemlerden kaçınma.  

---

## Çözüm Yolları
- **Bağımlılık Enjeksiyonu (Dependency Injection)**: Gereksinim duyulan nesneleri açıkça enjekte ederek statik kullanımı azaltma.  
- **Global Durumun Sınırlandırılması**: Statik değişken ve metotların kullanımını minimuma indirme.  
- **Soyutlama ve Arayüz Kullanımı**: Bağımlılıkları arayüzler veya soyut sınıflar üzerinden yönetme.  
- **Test Dostu Tasarım**: Testlerde kolayca taklit (mock) edilebilen kod yapıları oluşturma.  
- **Kod İncelemeleri ve Standartlar**: Statik kullanımını sınırlandıran kurallar koyma ve kod gözden geçirme süreçleri uygulama.  
