```markdown
## Sorun

**Long Parameter List**, bir metodun çok fazla parametre almasıdır.  
Genellikle 3–4’ten fazla parametre, metodun fazla sorumluluğu olduğunu veya parametrelerin  
daha iyi organize edilmesi gerektiğini gösterir.

---

## Sonuçları

- **Okunabilirlik Sorunu**: Çok sayıda parametre, metodun ne yaptığını anlamayı zorlaştırır.
- **Bakım Zorluğu**: Parametre sırasını hatırlamak veya değiştirmek hata riskini artırır.
- **Kod Tekrarı**: Benzer parametre grupları farklı metodlarda tekrar tekrar kullanılır.
- **Esnek Olmayan Yapı**: Parametre eklemek/değiştirmek, metodu kullanan tüm yerlerde değişiklik ister.
- **Test Güçlüğü**: Daha fazla parametre, daha fazla test senaryosu gerektirir.

---

## Çözüm

- **Parametre Nesnesi**: İlgili parametreleri bir sınıf veya veri yapısında toplayın.
- **Metodu Böl**: Metodun bazı kısımlarını ayrı metodlara çıkararak parametre sayısını azaltın.
- **Sorumluluğu Azalt**: Metodu tek bir sorumluluğa indirerek gereksiz parametrelerden kurtulun.
- **Varsayılan Değer / Builder**: Bazı parametreler için varsayılan değer veya Builder deseni kullanın.
- **Nesne Durumu**: Parametre olarak iletilen verileri nesne içindeki alanlarda (field) saklayın.
```
