# Copy Paste Programming Anti-Pattern

## Tanım
**Copy Paste Programming**, geliştiricilerin kod parçalarını düşünmeden kopyalayıp yapıştırarak kullandığı bir **anti-pattern**’dir.  
Bu, kodun tekrarlanmasına, bakım zorluklarına ve hataların yayılmasına neden olur.  
**Calendar Coder** ile benzerlik gösterir, ancak daha çok koddaki tekrarlayan bölümlere odaklanır.

---

## Özellikleri
- **Kod Tekrarı**: Aynı veya benzer kod bloklarının birden çok yerde bulunması.  
- **Bakım Zorluğu**: Bir hata düzeltildiğinde tüm kopyalarda ayrı ayrı güncelleme gerekliliği.  
- **Hata Yayılımı**: Kopyalanan kodda bulunan hataların projenin farklı yerlerine yayılması.  
- **Şişkin Kod Tabanı**: Gereksiz yere büyüyen ve karmaşıklaşan kod.  
- **Okunabilirlik Sorunları**: Kodun mantığının ve amacının anlaşılmasının zorlaşması.  

---

## Neden Oluşur
- Hızlı çözüm arayışı veya teslim tarihine yetişme baskısı.  
- Kod yeniden kullanımı (*reuse*) prensiplerine hakim olmama.  
- Fonksiyon veya modül yazmak yerine kopyalamayı tercih etme.  
- Deneyimsizlik veya tembellik.  
- Mevcut kodu anlamadan kopyalama alışkanlığı.  

---

## Çözüm Yolları
- **DRY Prensibi**: *Don't Repeat Yourself* ilkesine uyarak kodu modüler hale getirme.  
- **Fonksiyon ve Modül Kullanımı**: Tekrar eden kodları fonksiyonlar veya sınıflarla birleştirme.  
- **Kod İncelemesi**: Kopyalanmış kodları tespit etmek için düzenli incelemeler yapma.  
- **Refactoring**: Tekrar eden kodları tek bir noktada birleştirme.  
- **Kütüphane Kullanımı**: Ortak işlevler için mevcut kütüphaneleri veya çerçeveleri kullanma.  
- **Eğitim**: Geliştiricilere kod yeniden kullanımı ve iyi tasarım prensipleri konusunda eğitim verme.  
