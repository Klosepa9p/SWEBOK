# Unnecessary Abstraction

## 🔍 Nedir?

**Unnecessary Abstraction**, henüz ihtiyaç duyulmayan veya muhtemelen hiç ihtiyaç duyulmayacak olan soyutlamaların yapılmasıdır.

Bu genellikle “ileride lazım olur” düşüncesiyle sınıf, arayüz, inheritance (kalıtım) gibi soyutlama araçlarının erken ve gereksiz kullanılmasıyla ortaya çıkar.  
Henüz sadece tek bir yerde kullanılan bir işlev için ayrı bir soyutlama katmanı oluşturulması bu duruma örnektir.

---

## 🚫 Neden Kötüdür?

- 🧩 **Kod karmaşıklaşır**: Basit bir şey gereksiz şekilde katmanlı ve soyut hale gelir.
- ❌ **Bakım zorluğu yaratır**: Fazladan sınıflar ve yapılar, sistemi anlamayı ve değiştirmeyi zorlaştırır.
- 🐢 **Geliştirme yavaşlar**: Geliştiriciler, neden soyutlandığını bilmedikleri yapıları anlamaya zaman harcar.
- 🧪 **Test yükünü artırır**: Gereksiz arayüz ve sınıflar test kapsamını şişirir.
- 🪓 **YAGNI ilkesine aykırıdır**: “You Aren’t Gonna Need It” — ihtiyaç olmayan şeyi kodlama!

---

## ✅ Çözüm Yaklaşımı

- 🔍 Kodun **tekrar ettiğini** ya da **değişkenliğe açık olduğunu** görmeden soyutlama yapma.
- 🛠️ Önce somut ve işleyen bir çözüm yaz, soyutlama gerektiği yerde kendini belli eder.
- 🧼 Kodun **basitliğini koru**. Her soyutlamanın amacı olmalı.
- 📈 Refaktör süreçlerini **gerektikçe** devreye sok. Önceden değil.

---

## 📚 Gerçek Hayattan Analoji

Bir kişinin sadece çay içtiği bir ortamda, ona özel robotik kol, dokunmatik ekranlı çay makinesi ve sesle çalışan masa getirilmesi gibi düşün.  
Oysa kişi sadece normal bir bardak çay istiyor.

Bu tür çözümler:

- Maliyeti artırır,  
- Kullanımı zorlaştırır,  
- Arızalanma riskini yükseltir,  
- Ve **sorunu çözmek yerine daha fazla sorun yaratır**.

Basit bir bardak çayla da iş görebilecek bir durumda bu kadar “teknolojik çözüm” gereksizdir.
