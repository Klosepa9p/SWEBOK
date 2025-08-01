## 🛠 Replace Error Code with Exception Yöntemi

### 🐞 Problem
- Bir metot, hata durumlarını özel bir hata kodu (örneğin, `-1`, `null`, `"ERROR"`) döndürerek bildiriyorsa:
  - İstemciler bu kodları **kontrol etmek zorundadır**.
  - Hata yönetimi dağınık ve hataya açık hale gelir.
- Eğer istemci hata kodunu kontrol etmeyi unutursa, hatalar **sessizce gözden kaçabilir** ve sistem beklenmedik şekilde çalışabilir.

---

### ✅ Çözüm
- Hata kodlarını tamamen kaldırın.
- Bunun yerine, hata durumlarını bildirmek için **istisna (exception)** fırlatın.
- Böylece hata yönetimi, daha açık ve tutarlı bir şekilde yürütülür.

---

### 🌱 Faydaları
- Kodun **okunabilirliği** artar; hataların nerede ve neden oluştuğu daha belirgin olur.
- Hata durumları **zorunlu** hale gelir; istemci bu hataları yakalamak zorundadır (`try-catch`).
- **Bakım** ve **hata ayıklama** süreçleri kolaylaşır; çünkü hatalar stack trace ile detaylı olarak izlenebilir.

---

### 🛠️ Nasıl Uygulanır
1. Metodun hata kodlarını döndürdüğü durumları belirleyin.
2. Bu durumları temsil edecek uygun bir **istisna sınıfı** oluşturun (veya mevcut istisnalardan birini kullanın).
3. Metodu, hata kodu döndürmek yerine `throw` ifadesiyle istisna fırlatacak şekilde güncelleyin.
4. İstemci kodlarını, bu istisnaları `try-catch` bloklarıyla yakalayacak şekilde düzenleyin.
5. Kodu test ederek, istisna akışının doğru çalıştığından emin olun.

---

> 📌 **Not:**  
> - Hata yönetimini daha da iyileştirmek için, kendi özel istisna sınıflarınızı (`InvalidUserException`, `DataNotFoundException` vb.) tanımlayabilirsiniz.
> - Böylece hataların anlamı ve kaynağı daha net olur.
