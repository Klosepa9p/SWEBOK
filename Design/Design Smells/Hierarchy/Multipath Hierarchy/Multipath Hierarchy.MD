# Multipath Hierarchy

## 🔍 Nedir?

**Multipath Hierarchy**, nesne yönelimli tasarımda bir sınıfın aynı üst sınıfı birden fazla farklı yoldan miras aldığı durumdur.  
Bu genellikle çoklu kalıtımın karmaşık yapılar oluşturmasıyla ortaya çıkar ve sınıf hiyerarşisinde döngüsel veya çatışan miras ilişkilerine sebep olabilir.

---

## 🚫 Neden Kötüdür?

- ⚠️ **Belirsizlik yaratır**: Aynı özellik veya metot birden çok yoldan gelebilir, hangi tanımın kullanılacağı belirsizleşir.
- 🧩 **Bakımı zorlaştırır**: Hangi mirasın geçerli olduğunu anlamak güçleşir.
- 🐞 **Hata ve çakışma riski artar**: Çakışan metotlar veya özellikler sorunlara yol açabilir.
- 📉 **Tasarım karmaşası**: Karmaşık ve anlaşılması güç hiyerarşiler oluşur.
- 🛠️ **Bazı programlama dilleri tarafından desteklenmez** veya sınırlamalar getirir.

---

## ✅ Çözüm Yaklaşımı

- Çoklu kalıtım gerekiyorsa dikkatli tasarla ve çatışmaları önle.
- Mümkünse **kompozisyon (composition)** kullanarak işlevsellikleri birleştir.
- Arayüzler (interface) üzerinden kalıtım yaparak somut sınıfların çatışmasını azalt.
- Tasarımda net ve sade hiyerarşiler oluşturmaya özen göster.

---

## 📚 Gerçek Hayattan Analoji

Bir kişinin hem bir departmanın hem de başka bir departmanın doğrudan patronu olması ve bu iki patronun farklı direktifler vermesi durumu gibi.  
Kişi hangi direktife uyacağını bilemez ve görevler çatışır.

Bu durum organizasyonda karmaşa ve verimsizlik yaratır.

---
