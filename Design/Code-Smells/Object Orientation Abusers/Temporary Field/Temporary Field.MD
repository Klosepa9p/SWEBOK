## Sorun

**Temporary Field**, bir sınıfın yalnızca belirli bir metod veya işlem sırasında geçici olarak ihtiyaç duyduğu verileri alan (field) olarak tutmasıdır.  
Bu alanlar, sınıfın genel durumunda anlamlı bir rol oynamaz; sadece lokal bir hesaplama için kullanılır.  
Bu durum, genellikle sınıf tasarımının zayıf olduğunu ve gereksiz durum (state) taşıdığını gösterir.

---

## Sonuçları

- **Okunabilirlik Sorunları**: Sınıfın gerçek amacını ve önemli alanları ayırt etmeyi zorlaştırır.
- **Hata Riski**: Geçici alanlar yanlışlıkla başka metodlar tarafından kullanılabilir.
- **Bakım Zorluğu**: Alanların yönetimi sınıfı karmaşık hâle getirir.
- **Kapsülleme İhlali**: Sınıfın durumu, aslında sınıfa ait olmayan geçici verilerle şişer.
- **Kod Karmaşıklığı**: Gereksiz alanlar bağımlılıkları ve karmaşıklığı artırır.

---

## Çözüm

- **Yerel Değişken Kullan**: Geçici verileri metod içindeki lokal değişkenlerde tut.
- **Metodları Böl (Extract Method)**: Geçici alanları kullanan uzun metodları küçük ve tek sorumluluğa sahip metodlara ayır.
- **Yeni Sınıf Oluştur (Extract Class)**: Geçici alanlar belirli bir iş mantığıyla ilişkiliyse, onları yeni bir sınıfa taşı.
- **Kapsülleme**: Geçici verilerin yalnızca ihtiyaç duyulan yerde kullanılmasını sağla.
- **Refactoring**: Geçici alanları kaldırarak, sınıfta sadece kalıcı ve anlamlı durumu tut.
- **Anlamlı İsimlendirme**: Kullanılması kaçınılmaz geçici alanlar varsa, adlandırmada geçici olduklarını açıkça belirt.

---

> 📌 **Not:** Temporary Field, genellikle **Long Method** veya **Poor Names** gibi diğer kokularla birlikte ortaya çıkar; asıl sebep karmaşık ve dağınık tasarımdır.
