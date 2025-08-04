```markdown
## Sorun

**Comments (Yorumlar)** code smell'i; gereksiz, aşırı, eski veya yanıltıcı yorumların kodda yer almasıdır.  
Genellikle kodun kendini açıklayamadığı durumlarda yorumlar devreye girer.  
Bariz olanı tekrar eden (`// Sayacı artır`) veya kodla senkronize olmayan eski yorumlar bu duruma örnektir.

---

## Sonuçları

- **Okunabilirlik Sorunu**: Gereksiz yorumlar, asıl mantığı gölgede bırakır.
- **Bakım Zorluğu**: Kod değişince güncellenmeyen yorumlar yanıltıcı olur.
- **Kod Tekrarı**: Kötü veya karmaşık kodu açıklamak için yorum yazmak, kodun sadeleştirilmesini engeller.
- **Gereksiz Gürültü**: Bariz yorumlar dikkat dağıtır ve kodu uzatır.
- **Kötü Tasarımı Gizler**: Yorumlar, aslında düzeltilmesi gereken tasarım problemlerini maskeleyebilir.

---

## Çözüm

- **Kendi Kendini Açıklayan Kod**: Anlamlı isimlendirme ile yorum ihtiyacını azaltın.
- **Metodu Böl**: Karmaşık blokları, küçük ve tek sorumluluğa sahip metodlara ayırın.
- **Yorumları Sınırlı Kullan**: Sadece “neden” sorusunu cevaplayan, iş kuralı veya karmaşık algoritmaları açıklayan yorumlar yazın.
- **Dokümantasyon Araçları**: JavaDoc gibi araçlarla genel açıklamaları yönetin.
- **Refactoring**: Yorum yerine kodu sadeleştirin ve yeniden düzenleyin.
- **Eski Yorumları Sil**: Güncelliğini yitirmiş, gereksiz yorumları kaldırın.
```
