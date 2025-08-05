## Speculative Generality

### Açıklama

**Speculative Generality (Varsayımsal Genellik)**, henüz ihtiyaç olmayan ancak "ileride lazım olur" düşüncesiyle yazılmış soyutlamalar, arayüzler, kalıtımlar veya parametreli yapılar anlamına gelir. Bu yaklaşım, gelecekteki kullanım senaryolarına göre tasarım yapmayı amaçlar ancak genellikle kodun karmaşıklaşmasına neden olur. Yazılım geliştirmede **YAGNI (You Aren't Gonna Need It)** ilkesiyle çelişir.

---

### Neye Sebep Olur?

- Gereksiz soyutlamalar kodun okunabilirliğini ve bakımını zorlaştırır.
- Geliştirici, gereksiz sınıflar veya arayüzler arasında gezinmek zorunda kalır.
- Kodun test edilmesi zorlaşır çünkü ihtiyaç olmayan yolları da test etmeye çalışmak gerekebilir.
- Değişiklik yapmak karmaşık hale gelir.

---

### Çözüm

- Kullanılmayan soyutlamaları, arayüzleri, base class'ları kaldırın.
- Gerçek ihtiyaç doğmadan genellemeye gitmeyin (YAGNI prensibini uygulayın).
- Sade ve doğrudan kod yazmayı tercih edin.
