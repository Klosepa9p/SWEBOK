## Conditional Complexity

### Bu Sorun Açıklaması

**Conditional Complexity** (Koşullu Karmaşıklık), kodda çok sayıda veya iç içe geçmiş koşullu ifadelerin (`if-else`, `switch-case`) kullanılmasıyla ortaya çıkan karmaşıklık durumudur. Bu, genellikle bir metodun birden fazla durumu kontrol etmek için uzun ve karmaşık koşullu yapılar içermesiyle oluşur. Bu *code smell*, kodun anlaşılmasını ve bakımını zorlaştırır ve genellikle **Long Method**, **Combinatorial Explosion** veya **Switch Statements** gibi diğer sorunlarla ilişkilidir.

---

### Bu Sorun Neye Sebep Olabilir

- **Okunabilirlik Sorunları**: İç içe geçmiş veya uzun koşullu ifadeler, kodun mantığını takip etmeyi zorlaştırır.
- **Hata Olasılığı**: Karmaşık koşullu yapılar, mantıksal hatalara yol açabilir.
- **Bakım Zorluğu**: Yeni durumlar eklenirken mevcut yapı karmaşık hale gelir.
- **Test Zorluğu**: Her koşul kombinasyonu için ayrı test senaryosu gerektirir.
- **Esneklik Eksikliği**: Yeni durumlara kolay uyum sağlayamaz; *Open/Closed Principle* ihlal edilir.

---

### Çözümü Nedir

- **Polimorfizm Kullan**: Koşullu ifadeleri nesneler arası davranış farklılıklarıyla değiştir.
- **Strateji Deseni (Strategy Pattern)**: Her durumu farklı bir sınıf olarak uygula.
- **Erken Dönüş (Early Return)**: Derin iç içe koşulları azaltmak için erken çıkışlar kullan.
- **Metodları Böl (Extract Method)**: Uzun koşulları daha küçük, anlamlı metodlara ayır.
- **Durum Nesneleri (State Objects)**: Koşulları nesnelerle temsil ederek if/switch kullanımını azalt.
- **Tablo veya Harita Kullanımı**: Koşul mantığını kod yerine veri yapısına taşı.

