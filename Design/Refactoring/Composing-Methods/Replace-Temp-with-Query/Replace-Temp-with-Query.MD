## 🔄 Replace Temp with Query Yöntemi

### 🐞 Problem

- Geçici bir değişken, bir hesaplamanın sonucunu saklamak için kullanılıyorsa; bu, kodun okunabilirliğini ve yeniden kullanılabilirliğini sınırlayabilir.
- Değişken yalnızca bir kez hesaplanıp kullanılıyorsa, kod gereksiz yere karmaşıklaşabilir.

---

### ✅ Çözüm

Geçici değişkeni, hesaplamayı yapan bir **sorgu metodu** (query method) ile değiştirerek kaldırmak  
ve hesaplamayı metot içinde kapsülleyerek daha temiz ve modüler hale getirmek.

---

### 🌱 Faydaları

- Kod daha modüler ve yeniden kullanılabilir olur.
- Hesaplama mantığı tek bir yerde toplanır, bakım kolaylaşır.
- Okunabilirlik artar, gereksiz değişkenler azalır.

---

### 🛠️ Nasıl Uygulanır

1. Geçici değişkenin hesaplandığı ifadeyi belirleyin.
2. Bu ifadeyi, anlamlı bir isme sahip yeni bir metot olarak tanımlayın.
3. Kodda geçici değişken yerine, yeni metodu çağırın.
4. Geçici değişkeni tamamen kaldırın.
5. Kodun doğru çalıştığından emin olmak için test et.
