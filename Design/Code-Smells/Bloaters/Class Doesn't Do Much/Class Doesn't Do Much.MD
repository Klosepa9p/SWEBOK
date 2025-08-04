```markdown
## Sorun

**Class Doesn't Do Much**, bir sınıfın çok az iş yapması veya yalnızca veri tutucu olmasıdır.  
Genellikle birkaç basit getter/setter içerir ve iş mantığını başka sınıflara bırakır.  
Bu durum “Lazy Class” veya “Data Class” olarak da bilinir.

---

## Sonuçları

- **Gereksiz Karmaşıklık**: Az iş yapan sınıf, kodda fazladan katman oluşturur.
- **Bakım Zorluğu**: Küçük ve etkisiz sınıfların çoğalması, yönetimi zorlaştırır.
- **Kod Tekrarı**: Benzer işlevler başka yerlerde tekrar edebilir; DRY ilkesine aykırıdır.
- **Anlaşılırlık Sorunu**: Sınıfın amacı net olmadığı için anlaşılması güçleşir.
- **Performans Etkisi**: Çok sayıda küçük sınıf, büyük sistemlerde ek bellek ve performans yükü getirir.

---

## Çözüm

- **Sınıfı Kaldır (Inline Class)**: İçeriğini başka bir sınıfa taşıyıp sınıfı silin.
- **Sorumluluk Ekle**: Sınıfa iş mantığı ekleyerek daha anlamlı hâle getirin.
- **Sınıfları Birleştir**: Benzer sorumluluklara sahip başka sınıflarla birleştirin.
- **Değer Nesnesi**: Sadece veri tutuyorsa, Value Object hâline getirip ilgili davranışları ekleyin.
- **Kod İncelemesi**: Sınıfın gerçekten gerekli olup olmadığını gözden geçirin.
```
