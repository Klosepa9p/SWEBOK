# 🧩 Facade Design Pattern

## 📌 Tanım
Bütün sınıfları ortak bir çatı altında toplayıp, client’ın bu arayüz (facade) üzerinden erişebilmesini sağlar.  
Facade deseni; karmaşık bir alt sistemin (çok sayıda sınıf ve modül) tüm detaylarını istemcinin görmesine gerek kalmadan **tek bir basit arabirim** üzerinden kullanılmasını sağlar.

---

## 🎯 Amacı
- Sistemin karmaşıklığını **soyutlamak** ve sadeleştirmek
- Alt sistemdeki sınıflara olan **bağımlılığı azaltmak**
- Kullanıcıya **kolay, anlaşılır ve tek bir giriş noktası** sunmak

---

## 🛠 Nasıl Çalışır?
- Karmaşık bir sistemde birden fazla sınıf veya modül bulunur.
- **Facade** sınıfı, bu karmaşık yapının üstünde “kapı” gibi durur.
- Client, sistemin detaylarına doğrudan erişmek yerine sadece Facade ile etkileşim kurar.

---

## ✅ Avantajları
- Kullanımı **kolaylaştırır** ve kullanıcı deneyimini artırır.
- Alt sistemdeki değişikliklerin client’a etkisini **azaltır**.
- Kodun okunabilirliğini ve bakımını **kolaylaştırır**.
- Bağımlılıkları **azaltır**, modüler bir yapı sağlar.

---

## ⚠️ Dezavantajları
- Facade sınıfı **çok fazla sorumluluk** üstlenirse *God Object* riskine yol açabilir.
- Facade, alt sistemdeki tüm özellikleri sunmazsa, özel ihtiyaçlar için client’ın alt sisteme doğrudan erişmesi gerekebilir.

---

## 📚 Ne Zaman Kullanılır?
- Alt sistemin karmaşıklığını **gizlemek** istendiğinde
- Çok sayıda modül veya sınıfın kontrol edilmesi gereken durumlarda
- Daha sade ve temiz bir API sunmak istendiğinde

---

## 🧰 Özet
- Facade, istemcinin alt sistem detaylarıyla uğraşmasını **engeller**.
- Daha düzenli, okunabilir ve sürdürülebilir kod sağlar.
- Karmaşık işlevleri tek bir **basit arabirim** altında toplar.

---

