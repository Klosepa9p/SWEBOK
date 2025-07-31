## 🧩 Introduce Assertion Yöntemi

### 🐞 Problem

- Kod, belirli bir durumun veya verinin doğru olduğunu **varsayar**, ancak bu varsayım açıkça belirtilmemişse:
  - Hata ayıklama zorlaşır.
  - Beklenmedik hatalar ortaya çıkabilir.
- Koşulların geçerliliği kontrol edilmezse, kodun **güvenilirliği azalır**.

---

### ✅ Çözüm

Kodun kritik noktalarında, **varsayımları açıkça doğrulayan assertion ifadeleri** ekleyin.  
Bu, kodun doğru çalıştığını kontrol etmek için bir savunma mekanizmasıdır ve hataları **erken tespit etmeye** yardımcı olur.

---

### 🌱 Faydaları

- Kodun varsayımları açıkça ifade edilir; **okunabilirlik** ve **anlaşılabilirlik** artar.
- Hatalar erken aşamada fark edilir; **hata ayıklama kolaylaşır**.
- Kodun **güvenilirliği** ve **sağlamlığı** artar.

---

### 🛠️ Nasıl Uygulanır

1. Kodun hangi **varsayımlara** dayandığını belirleyin.
2. Bu varsayımları kontrol eden **assertion ifadeleri** ekleyin (örn. `assert` anahtar kelimesi veya özel bir kütüphane fonksiyonu).
3. Assertion mesajlarına, hata durumunda anlamlı ve açıklayıcı bilgiler ekleyin.
4. Assertion’ların yalnızca **geliştirme/test ortamında** aktif olduğundan, üretimde devre dışı kalacağından emin olun.
5. Kodu test edin.

---

> 🧠 **Not:** Assertions, program mantığını "korumak" için kullanılır; üretim ortamında performansı etkilememesi için genellikle devre dışı bırakılır.



