# Anemic Model Anti-Pattern

## Tanım
**Anemic Model**, nesne yönelimli tasarımda, iş mantığının (business logic) veri modellerinden ayrılarak genellikle servis veya başka katmanlarda tutulduğu,  
model sınıflarının ise sadece veri tutucu (getter/setter) olarak kaldığı bir tasarım anti-patternidir.  
Bu yaklaşım, nesnelerin gerçek anlamda davranış sahibi olmamasına ve uygulamanın kodunun dağınık, zor yönetilebilir hale gelmesine neden olur.

---

## Özellikleri
- **Davranışsız Veri Modelleri**: Model sınıfları sadece alanları ve basit getter/setter metotlarını içerir.  
- **İş Mantığının Ayrılması**: İş kuralları ve mantık genellikle servis, controller veya başka katmanlarda bulunur.  
- **Nesne Yönelimli Prensiplerden Sapma**: Nesneler kendi davranışlarını taşımaz, sadece veri konteyneri işlevi görür.  
- **Bakım Zorluğu**: İş mantığı farklı katmanlara dağıldığı için kodun takip edilmesi ve değiştirilmesi zorlaşır.  
- **Test Zorlukları**: İş mantığı ile veri modelinin ayrılması testlerde karmaşıklık yaratabilir.  

---

## Neden Oluşur
- İş mantığını modellerde tutmak yerine servis katmanına koyma alışkanlığı.  
- Nesne yönelimli prensiplerin (encapsulation, cohesion) yanlış anlaşılması.  
- Basit CRUD uygulamalarında modellerin davranışsız kalması.  
- Tasarım desenleri veya mimari yaklaşımların eksikliği.  
- Ekip içinde nesne yönelimli tasarım kültürünün gelişmemiş olması.  

---

## Çözüm Yolları
- **Rich Domain Model**: Model sınıflarına iş mantığını ve davranışları entegre etme.  
- **Encapsulation**: Veriyi ve ona ait işlemleri bir arada tutarak nesnenin gerçek anlamda davranış sahibi olmasını sağlama.  
- **Domain-Driven Design (DDD)**: İş mantığını domain modellerine yakın tutan yaklaşımlar kullanma.  
- **Kod Refactoring**: Ayrık iş mantığını modellerin içine taşıma çalışmaları yapma.  
- **Eğitim ve Farkındalık**: Nesne yönelimli prensipler ve DDD konularında ekip bilincini artırma.  
