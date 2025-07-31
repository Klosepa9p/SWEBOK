## 📦 Replace Array with Object Yöntemi

### 🐞 Problem

- Bir **dizi (array)**, farklı türde verileri tutmak için kullanılıyorsa; dizinin her elemanının **neyi temsil ettiği belirsiz** hale gelir ve kodun okunabilirliği düşer.
- Dizi elemanlarına **sabit indekslerle** erişim, hata riskini artırır ve kodun bakımını zorlaştırır.

---

### ✅ Çözüm

Diziyi, her elemanın anlamını açıkça belirten bir **nesne (sınıf)** ile değiştirin.  
Bu nesnede, dizinin elemanlarını temsil eden ve **anlamlı isimlere sahip** alanlar bulunur.

---

### 🌱 Faydaları

- Kod **daha okunabilir** ve **anlaşılır** hale gelir; alan isimleri verinin anlamını açıkça gösterir.
- İndeks yerine alan adları kullanıldığı için **hata riski azalır**.
- Nesneye davranış (metot) eklenebilir, bu da **enkapsülasyon** sağlar.

---

### 🛠️ Nasıl Uygulanır

1. Dizinin her elemanının **neyi temsil ettiğini** belirleyin.
2. Bu elemanları temsil eden **anlamlı alanlar** içeren yeni bir sınıf oluşturun.
3. Diziyi, bu yeni sınıfın bir örneğiyle değiştirin.
4. İstemci kodda, diziye indeksle erişim yerine **nesnenin alanlarını** kullanacak şekilde değişiklik yapın.
5. Kodu test edin.
