```markdown
## Sorun

**Data Clumps**, birbiriyle ilişkili verilerin (ör. adres bilgileri, koordinatlar)  
ayrı ayrı parametre veya alanlar olarak tekrar tekrar birlikte kullanılmasıdır.  
Genellikle bir grup olarak anlamlıdır; ancak ilkel tipler hâlinde tutulur.

---

## Sonuçları

- **Kod Tekrarı**: Aynı veri grupları farklı yerlerde tekrar tanımlanır; DRY ilkesine aykırıdır.
- **Bakım Zorluğu**: Veri değiştiğinde, tüm geçtiği yerlerde güncelleme gerekir.
- **Hata Riski**: Verilerin tutarlılığı bozulabilir; sırası karışabilir veya eksik geçilebilir.
- **Anlaşılırlık Sorunu**: Verilerin ilişkisi açıkça görülmez; kodun amacı belirsiz olur.
- **Esnek Olmayan Yapı**: Yeni veri eklendiğinde birçok yerde değişiklik yapmak gerekir.

---

## Çözüm

- **Parametre Nesnesi**: İlgili verileri tek bir sınıf veya yapı içinde toplayın.
- **Kendi Sınıfını Tanımla**: Veri grubunu temsil eden ve doğrulama/davranış içeren sınıf yazın.
- **Kapsülleme**: Verileri ve işlemleri birlikte tutarak modülerliği artırın.
- **Metod İmzasını Sadeleştir**: Veri grubunu nesneyle değiştirerek parametre sayısını azaltın.
- **Değer Nesneleri**: Bir bütün anlamı taşıyan veriler için değer nesnesi (Value Object) tanımlayın.
```
