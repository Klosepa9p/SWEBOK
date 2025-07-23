## 🧩 Dependency Inversion Principle (DIP)

- **Bağımlılıkların tersine çevrilmesi**:  
  Yüksek seviyeli modüller (iş mantığı) ve düşük seviyeli modüller (veri erişimi, dış servisler)  
  **somut sınıflara** değil, **soyutlamalara (arayüz / abstract class)** bağımlı olur.

- Böylece:
  - Yüksek seviyeli modül → arayüzü kullanır
  - Somut sınıf (implementasyon) → bu arayüzü uygular
  - Kontrol, bağımlılığın yönünü tersine çevirir: somut sınıflar **soyutlamalara bağımlı hale gelir**

---

### 🧭 Örnek (Sigara Analojisi)

> Bir kullanıcının sadece tek bir sigara markasına bağımlı olması, **istenmeyen bir durumdur**.  
> Gittiği bakkalda o marka yoksa, kullanıcı sigara içemez.

- Eğer kullanıcı **belirli bir markaya değil de** *sigara içme* soyutlamasına bağımlıysa,
- Tüm sigara markalarını kullanabilir.
- Böylece kullanıcı markalara değil, markalar kullanıcıya bağımlı olur.

---

### ✅ Doğru yaklaşım

- Somut sınıflara (GarantiBank, SamsungPrinter vs.) **doğrudan bağımlı olmak yerine**,  
- Bir **arayüz (interface)** veya **soyut sınıfa** bağımlı olunur.
- Bu soyutlama sayesinde:
  - Kod genişletilebilir ve değiştirilebilir hale gelir.
  - Yeni implementasyonlar eklemek için mevcut kodu değiştirmek gerekmez.

---

### 📜 Kısa özet

- Yüksek seviyeli modüller, düşük seviyeli modüllerin detayına değil; **soyutlamalara bağımlı olmalıdır**.
- Soyutlamalar (arayüz/abstract class) → detayları bilmez; detaylar (somut sınıflar) → soyutlamaya bağımlıdır.

---
