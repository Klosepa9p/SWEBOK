## 🔧 Preserve Whole Object Yöntemi

### 🐞 Problem
- Bir metot, bir nesnenin birden fazla alanına (field) **ayrı ayrı parametre** olarak erişiyorsa,  
  bu durum metot imzasını karmaşıklaştırır ve istemci kodu gereksiz yere ayrıntılı hale getirir.
- Nesnenin birden çok parçasını parametre olarak geçirmek, nesnenin bütünlüğünü bozar ve bağımlılığı artırır.

---

### ✅ Çözüm
- Ayrı ayrı alanları parametre olarak geçirmek yerine, **tüm nesneyi metot parametresi olarak geçin**.
- Metot, nesnenin gerekli alanlarına kendisi erişsin.

---

### 🌱 Faydaları
- Metot imzası daha sade ve anlaşılır olur.
- Nesnenin bütünlüğü korunur, bağımlılıklar azalır.
- Kodun esnekliği artar, nesne değiştiğinde metot imzasını güncelleme ihtiyacı azalır.

---

### 🛠️ Nasıl Uygulanır
1. Metodun, bir nesnenin birden fazla alanını parametre olarak aldığını belirleyin.
2. Metot imzasını değiştirerek, ayrı ayrı alanlar yerine nesnenin kendisini parametre olarak alın.
3. Metot içinde, nesnenin alanlarına doğrudan erişin.
4. İstemci kodlarını, nesneyi geçecek şekilde güncelleyin.
5. Kodu test edin.

