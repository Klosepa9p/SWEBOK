## 🎛️ Parameterize Method Yöntemi

### 🐞 Problem
- Birden fazla metot, **benzer mantığı farklı sabit değerlerle** uyguluyorsa, bu durum **kod tekrarı** yaratır.
- Sabit değerlerin metot içinde **hard-coded** olması, metotların **esnekliğini azaltır** ve yeni varyasyonlar için **yeni metotlar** yazmak gerekir.

---

### ✅ Çözüm
Benzer metotları **tek bir metotta birleştir** ve farklılıkları bir **parametre** ile kontrol et.
- Sabit değerler parametre olarak geçirilir.
- Böylece **kod tekrarı azalır** ve **bakım kolaylaşır**.

---

### 🌱 Faydaları
- Kod tekrarı azalır, metot sayısı düşer.
- Metot daha **esnek** ve **yeniden kullanılabilir** hale gelir.
- Yeni varyasyonlar için sadece parametre değişir, yeni metot yazmak gerekmez.

---

### 🛠️ Nasıl Uygulanır
1. Benzer mantığı uygulayan metotları belirle.
2. Farklılıkları (örneğin, sabit değerler) bir **parametre** olarak tanımla.
3. Metotları **tek bir metotta birleştir** ve bu parametreyi kullanacak şekilde düzenle.
4. İstemci kodlarını, yeni parametreli metodu çağıracak şekilde güncelle.
5. Kodu test et.

---

> 💡 **İpucu:**  
> Parametreleştirme, özellikle sadece sabit bir sayının veya string'in değiştiği durumlarda çok etkilidir. Daha karmaşık farklar varsa, genellikle *Strategy Pattern* gibi daha gelişmiş teknikler gerekir.
