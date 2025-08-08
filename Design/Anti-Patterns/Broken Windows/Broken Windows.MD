# Broken Windows Anti-Pattern

## Tanım
**Broken Windows (Kırık Pencereler)**, yazılım projelerinde küçük sorunların, hataların veya kötü uygulamaların göz ardı edilmesinin, zamanla daha büyük problemlere yol açtığı bir **anti-pattern**’dir.  
Bu terim, küçük ihmallerin genel kaliteyi düşürdüğü ve projeyi kaosa sürüklediği fikrine dayanır.

---

## Özellikleri
- **Küçük Sorunların Birikmesi**: Kodda küçük hatalar, kötü yazılmış bölümler veya geçici çözümlerin düzeltilmeden bırakılması.  
- **Kalite Düşüşü**: İlk baştaki düşük kaliteli uygulamaların, daha fazla kötü pratiği teşvik etmesi.  
- **Bakım Zorluğu**: Düzensiz kod veya dokümantasyon eksikliği nedeniyle bakımın zorlaşması.  
- **Ekip Motivasyon Kaybı**: Kalitesiz bir codebase ile çalışmanın ekip morale zarar vermesi.  
- **Teknik Borç Artışı**: Hızlı çözümlerin birikmesiyle teknik borcun büyümesi.  

---

## Neden Oluşur
- Teslim tarihine yetişme baskısı nedeniyle kaliteye önem verilmemesi.  
- Küçük sorunların *"sonra düzeltilir"* düşüncesiyle ihmal edilmesi.  
- Ekipte standart eksikliği veya kod incelemesi yapılmaması.  
- Deneyimsiz geliştiricilerin kötü uygulamalarının gözden kaçması.  
- Proje yönetiminde uzun vadeli kaliteye odaklanılmaması.  

---

## Çözüm Yolları
- **Kod İncelemeleri**: Düzenli kod incelemeleriyle kaliteyi koruma.  
- **Refactoring**: Küçük sorunları hemen düzelterek teknik borcu azaltma.  
- **Kod Standartları**: Ekip için net kodlama standartları ve rehberler oluşturma.  
- **Otomasyon**: Linting, formatlama ve test araçlarıyla kaliteyi otomatik kontrol etme.  
- **Sürekli İyileştirme**: Agile prensipleriyle düzenli geri bildirim ve iyileştirme döngüleri.  
- **Kültürel Değişim**: Ekipte kalite odaklı bir zihniyet oluşturma.  
