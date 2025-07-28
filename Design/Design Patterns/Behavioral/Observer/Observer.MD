# 👀 Observer Design Pattern

## 📌 Nedir?
Bir nesnede (**Subject**) bir değişiklik olduğunda;  
bu değişiklikten haberdar olması gereken **gözlemciler** (**Observers**) otomatik olarak **bilgilendirilir**.

Bu desen sayesinde:
- Konu (subject) ve gözlemciler (observers) arasında **gevşek bağlılık** sağlanır.
- Konu değiştiğinde, tüm kayıtlı gözlemciler otomatik olarak güncellenir.

---

## 🎯 Amaç
- Nesneler arası doğrudan bağımlılığı azaltmak.
- Bir nesnenin durumu değiştiğinde, birden fazla nesnenin bu değişiklikten haberdar edilmesini sağlamak.
- Sistem değişikliklerine kolayca tepki verebilen **dinamik ve esnek bir yapı** kurmak.

---

## ✈ Gerçek Hayattan Örnek
Bir hava durumu uygulaması düşünelim:
- Merkezdeki **hava durumu servisi** bir **subject**’tir.
- Telefon, tablet veya web uygulamaları bu servise **observer** olarak kayıt olur.
- Hava durumu değiştiğinde, servis tüm kayıtlı uygulamalara **otomatik bildirim** gönderir.

---

## ✅ Avantajları
- Konu (subject) ve gözlemciler (observers) arasında **düşük bağımlılık** sağlar.
- Gözlemci eklemek veya çıkarmak **kolaydır**.
- Dinamik olarak yeni gözlemciler kayıt olabilir, sistem **esnek hale gelir**.

---

## ⚠ Dezavantajları
- Çok sayıda gözlemci olduğunda, **performans** etkilenebilir.
- Bildirim sırası **kontrol edilemez**, hangi observer’ın önce tepki vereceği belli değildir.
- Hataların izlenmesi zor olabilir; bir observer yanlış çalışırsa tüm sistemi etkileyebilir.

---
