### Poorly Written Tests

---

#### 🔍 Bu Sorun Açıklaması

**Poorly Written Tests (Kötü Yazılmış Testler)**, test kodlarının okunabilirlik, bakım kolaylığı, güvenilirlik veya etkinlik açısından yetersiz olması durumudur. Bu *code smell*, testlerin belirsiz isimlendirmeler, karmaşık mantık, gereksiz bağımlılıklar, zayıf yapı veya eksik kapsam gibi sorunlar içermesiyle ortaya çıkar.

Kötü yazılmış testler, kodun doğruluğunu doğrulama amacını yerine getiremez ve genellikle üretim kodundaki sorunları gizleyebilir. Bu durum, genellikle `Inconsistent Abstraction Levels`, `Poor Names` veya `Long Method` gibi diğer code smell’lerle ilişkilidir.

---

#### ⚠️ Bu Sorun Neye Sebep Olabilir

- **Okunabilirlik Sorunları**: Belirsiz veya karmaşık testler, testin neyi doğruladığını anlamayı zorlaştırır.
- **Bakım Zorluğu**: Üretim kodundaki değişikliklere uyum sağlamakta zorlanır, sürekli güncellenmesi gerekebilir.
- **Hata Tespit Edememe**: Testler hataları yakalayamaz ya da yanlış pozitif/negatif sonuçlar üretebilir.
- **Test Kırılganlığı**: Sert kodlanmış veriler veya dış bağımlılıklar küçük değişikliklerde bile testin bozulmasına neden olur.
- **Düşük Test Kapsamı**: Kritik senaryolar test edilmeden kalabilir, bu da güvenilirliği azaltır.

---

#### ✅ Çözümü Nedir

- **Anlamlı İsimlendirme**: Test metodlarına, neyi test ettiklerini açıkça ifade eden anlamlı isimler verin  
  *(örneğin: `shouldCalculateDiscountForVIPCustomer`)*
- **Testleri Böl (Extract Method)**: Karmaşık testleri, küçük ve odaklanmış metotlara ayırın.
- **AAA Deseni (Arrange-Act-Assert)**: Testlerin yapılandırılmasını kolaylaştırmak için bu deseni kullanın.
- **Bağımlılıkları İzole Et**: Dış sistemlerden bağımsız hale getirmek için mocking/stubbing gibi teknikler kullanın.
- **Tek Sorumluluk İlkesi**: Her test, sadece bir davranışı veya senaryoyu test etmelidir.
- **Test Verilerini Sadeleştir**: Anlamlı, sade ve minimal test veri setleri kullanın.
- **Yeniden Düzenleme (Refactoring)**: Test kodlarını düzenli olarak sadeleştirin ve bakımını yapın.
