## Sorun

**Alternative Class with Different Interfaces** (Farklı Arayüzlere Sahip Alternatif Sınıf),  
aynı veya benzer işlevi yerine getiren birden fazla sınıfın;  
- farklı metod isimleri,
- farklı parametre yapıları,
- veya farklı davranışlar  

kullanarak aynı problemi çözmesidir.  

Bu durum genellikle proje büyüdükçe **tutarsızlık**, **kod tekrarı** ve **bakım zorluğu** yaratır.  
Oddball Solution ve Inconsistency gibi diğer **code smell**'lerle de yakından ilişkilidir.

---

## Neye Sebep Olur?

- **Okunabilirlik Sorunları**:  
  Her sınıfın arayüzünü ayrı öğrenmek gerekir; kodun ne yaptığı net anlaşılmaz.

- **Bakım Zorluğu**:  
  Benzer işlevselliği sağlayan ama farklı imzalara sahip sınıfların bakımı zordur.

- **Hata Olasılığı**:  
  Yanlış metod çağrısı veya yanlış sınıf seçimi hatalara yol açabilir.

- **Kod Tekrarı**:  
  Aynı mantık farklı yerlerde tekrarlanır; DRY (Don't Repeat Yourself) ilkesine aykırıdır.

- **Entegrasyon Zorluğu**:  
  Sınıfların birlikte kullanılmasını veya değiştirilmesini zorlaştırır.

---

## Çözüm

✅ **Ortak Arayüz veya Soyut Sınıf Oluştur**  
- Tüm sınıflar ortak bir `interface` veya `abstract class` uygulasın.  

✅ **Refactoring (Yeniden Düzenleme)**  
- Tutarsız imzalara sahip metodları, ortak arayüze uygun hale getir.  

✅ **Tasarım Desenleri Kullan**  
- Strateji, Fabrika veya Şablon Metod desenleri ile tutarlı bir yapı kur.  

✅ **Tutarlı İsimlendirme**  
- Metod ve parametre isimlerini standartlaştır; işlevi anlatacak şekilde seç.  

✅ **Kod İncelemesi**  
- Kod review sırasında farklı arayüzleri tespit et ve ortaklaştır.  

✅ **Dokümantasyon**  
- Ortak arayüzün ve kullanım şeklinin ekiple net olarak paylaşılması.

---

> 📌 **Not:**  
> Bu smell, projede farklı ekiplerin veya geliştiricilerin benzer işi farklı şekilde çözmesinden kaynaklanabilir.  
> Çözümde temel amaç: **Tutarlılık, okunabilirlik ve bakım kolaylığı** sağlamaktır.
