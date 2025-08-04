```markdown
## Sorun

**Primitive Obsession**, karmaşık veri yapıları veya kavramlar için aşırı şekilde ilkel tiplerin  
(ör. `int`, `String`, `double`) kullanılmasıdır.  
Örneğin, telefon numarasının sadece `String` ile temsil edilmesi bu kokuya örnektir.

---

## Sonuçları

- **Kod Tekrarı**: Doğrulama ve formatlama işlemleri tekrar tekrar yazılır; DRY ilkesine aykırıdır.
- **Hata Riski**: Doğrulama eksikliği, geçersiz verilerin sisteme girmesine yol açar.
- **Anlaşılırlık Sorunu**: İlkel tipler veriyle ilgili bağlamı taşımaz; kodun amacı belirsiz olur.
- **Bakım Zorluğu**: Değişiklik yapmak, kodun birçok yerinde güncelleme gerektirir.
- **Düşük Yeniden Kullanılabilirlik**: Kod modüler olmaz; başka yerlerde kullanılamaz.

---

## Çözüm

- **Kendi Sınıfını Oluştur**: İlkel tip yerine ilgili veriyi ve davranışı içeren sınıf yazın.
- **Değer Nesneleri (Value Objects)**: Telefon numarası, para birimi gibi kavramlar için özel sınıflar tanımlayın.
- **Doğrulama ve Davranış**: Sınıfa doğrulama ve ilgili işlemleri ekleyin.
- **Tip Güvenliği**: İlkel tip yerine sınıf kullanarak hataları derleme zamanında yakalayın.
- **Kapsülleme**: Veriyi ve işlemleri bir arada tutarak bakımı kolaylaştırın.
```
