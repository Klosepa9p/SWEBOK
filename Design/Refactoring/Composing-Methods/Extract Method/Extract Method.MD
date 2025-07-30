## ✂️ Extract Method Yöntemi

### 🐞 Problem

- Uzun ve karmaşık metotlar kodu anlaşılmaz kılar.
- Tekrar eden kod, bakımı zorlaştırır.
- Okunabilirlik ve test edilebilirlik düşer.

---

### ✅ Çözüm

Bir metodun içindeki belirli bir işlevi yapan kod bloğunu,  
açıklayıcı bir isme sahip yeni bir metoda taşıyarak orijinal metodu sadeleştirmek.

---

### 🌱 Faydaları

- Daha okunabilir ve modüler kod.
- Yeniden kullanılabilir metotlar.
- Kolay bakım ve test edilebilirlik.

---

### 🛠️ Nasıl Uygulanır

1. İşlevi yapan kod bloğunu seç.
2. Yeni bir metot oluştur, kod bloğunu bu metoda taşı ve anlamlı bir isim ver.
3. Gerekirse parametreleri ve dönüş değerini belirle.
4. Orijinal metotta yeni metodu çağır.
5. Kodun doğru çalıştığından emin olmak için test et.
