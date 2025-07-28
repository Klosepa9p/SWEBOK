## 🔗 Chain of Responsibility Design Pattern

Bir sistemde, bir sorumluluğun ardından başka sorumlulukların **zincir şeklinde** devam etmesi isteniyorsa;  
bu sorumluluk zincirini kolay yönetebilmek ve esnek hale getirebilmek için **Chain of Responsibility Design Pattern** kullanılır.

Bu desen sayesinde:
- İstek (request), zincirin başından başlayarak uygun işleyici (handler) tarafından karşılanana kadar zincirde ilerler.
- İstek gönderen nesne, hangi nesnenin isteği ele alacağını bilmek zorunda kalmaz.
- Yeni işleyici eklemek veya zinciri değiştirmek kolaylaşır.

---

## ✅ Avantajları
- İstek gönderen ve işleyen nesneler arasındaki **bağımlılığı azaltır**.
- Zincire yeni bir işleyici eklemek veya sıralamayı değiştirmek **kolaydır**.
- Kod daha **modüler** ve **bakımı kolay** hale gelir.

---

## ⚠ Dezavantajları
- Uygun bir işleyici yoksa istek **işlenmeden kalabilir**.
- Hangi işleyicinin isteği ele alacağını anlamak **zor** olabilir.
- Zincir çok uzarsa, **performans** etkilenebilir.

---

## ✈ Gerçek Hayattan Örnek
Bir şirkette, çalışanların izin talepleri şu şekilde bir zincirde ilerler:
- Önce takım liderine iletilir.
- Takım lideri onaylamazsa, müdüre gönderilir.
- Müdür de onaylamazsa, genel müdüre gider.

Her yönetici burada bir **Handler** görevi görür.  
Zincire yeni bir yönetici eklemek veya sırayı değiştirmek kolaydır.

---

## ✏ Özet
> Chain of Responsibility, bir isteğin uygun işleyici bulunana kadar zincirde dolaşmasını sağlayarak;
> bağımlılığı azaltır, sistemi daha esnek ve yönetilebilir hale getirir.
