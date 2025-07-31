## 🔄 Replace Type Code with State/Strategy Yöntemi

### 🐞 Problem

- Bir sınıf, davranışını bir tür kodu (type code) ile koşullu mantık (örneğin, `if`/`switch`) kullanarak belirliyorsa, bu durum kodu karmaşık ve bakımı zor hale getirir.
- Yeni türler eklendiğinde, koşullu mantık büyür ve hata riski artar.

---

### ✅ Çözüm

- Tür kodunu kaldırın ve her türü temsil eden bir **State** veya **Strategy** nesnesi oluşturun.
- Bu nesneler, türle ilgili davranışları kapsüller ve polimorfizm aracılığıyla kullanılır.

---

### 🌱 Faydaları

- Kod daha modüler ve esnek olur, yeni türler eklemek kolaylaşır.
- Koşullu mantık azalır, okunabilirlik ve bakım iyileşir.
- Açık/Kapalı İlkesine (Open/Closed Principle) uyum artar.

---

### 🛠️ Nasıl Uygulanır

1. Tür kodunun kontrol ettiği davranışları belirleyin.
2. Her tür için bir **State** veya **Strategy** arayüzü/sınıfı oluşturun ve davranışları bu sınıflara taşıyın.
3. Ana sınıfta tür kodu yerine **State/Strategy** nesnesine referans tutun.
4. Koşullu mantığı, polimorfik metot çağrılarıyla değiştirin.
5. Kodu test edin.
