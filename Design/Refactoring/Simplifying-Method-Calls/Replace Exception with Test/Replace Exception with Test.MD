## 🔄 Replace Exception with Test Yöntemi

### ❓ Problem
- Bir metot, hata durumlarını **istisnalar (exceptions)** ile yönetiyorsa ancak bu istisnalar istemci kod tarafından sürekli `catch` blokları ile kontrol ediliyorsa, kod karmaşık hale gelir.
- İstisnalar normal akışın bir parçası olarak kullanılmamalıdır; bu durum **okunabilirliği düşürür** ve **performansı etkileyebilir**.

---

### ✅ Çözüm
- İstisna fırlatmayı kaldırın.
- Yerine, hata durumunu metot çağrılmadan önce **koşullu bir test (if)** ile kontrol edin.
- Böylece istisna yönetimi yerine **daha açık ve sade bir kontrol akışı** sağlanır.

---

### 🌟 Faydaları
- Kod daha **doğrudan** ve **okunabilir** olur, `try-catch` blokları azalır.
- Normal akış için istisna kullanımı **önlenir**.
- Kodun **performansı ve bakımı** iyileşir.

---

### 🛠 Nasıl Uygulanır
1. İstisna fırlatan metodu ve **hangi durumlarda** istisna fırlattığını belirleyin.
2. Bu durumu, metot çağrılmadan önce bir **koşullu test** (`if`) ile kontrol edin.
3. Metottan **istisna fırlatma mantığını kaldırın** ve gerekiyorsa varsayılan bir davranış ekleyin.
4. İstemci kodlarını, yeni kontrol akışına göre güncelleyin.
5. **Kodu test edin.**
