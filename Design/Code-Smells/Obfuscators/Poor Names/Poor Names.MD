```markdown
## Sorun

**Poor Names (Zayıf İsimlendirme)**; değişken, metod veya sınıfların belirsiz, kısa, yanıltıcı ya da tutarsız isimlerle adlandırılmasıdır.  
Örneğin `x`, `temp` veya `doSomething` gibi isimler kodun amacını yeterince ifade etmez.

---

## Sonuçları

- **Okunabilirlik Sorunu**: Kodun ne yaptığını anlamak zorlaşır; daha fazla zaman harcanır.
- **Hata Riski**: Belirsiz isimler yanlış anlamalara ve hatalı kullanımlara yol açar.
- **Bakım Zorluğu**: Kodun değiştirilmesi veya hata ayıklanması karmaşık hâle gelir.
- **Ekip İletişim Problemi**: Kodun amacı anlaşılmaz; işbirliği zorlaşır.
- **Yorum İhtiyacı**: Kötü isimler gereksiz yorum ekleme ihtiyacını artırır.

---

## Çözüm

- **Anlamlı İsimler**: Kodun amacını ve kavramı açıkça ifade eden isimler kullanın.
- **Bağlama Uygunluk**: İsimlerin kodun bağlamına ve iş mantığına uygun olmasına dikkat edin.
- **Kısa ama Açıklayıcı**: İsmi gereğinden uzun tutmadan, anlamı netleştirin (`tmp` yerine `temporaryResult`).
- **Tutarlılık**: Projede camelCase, PascalCase gibi tek bir stil kullanın.
- **Refactoring**: Kötü isimleri daha iyi ve açıklayıcı isimlerle değiştirin.
- **Yorumları Azalt**: İyi isimlendirme ile yorum ihtiyacını minimuma indirin.
```
