# 🧠 Memento Design Pattern

## 📌 Nedir?
**Memento Design Pattern**, bir nesnenin **iç durumunu** (state) kaydetmek ve gerektiğinde **geri yüklemek** (undo gibi) için kullanılan davranışsal bir tasarım desenidir.  

Bu desen, nesnenin iç detaylarını dışarı sızdırmadan, bir “anlık görüntüsünü” (memento) alır ve bu görüntüyü daha sonra geri yükleyerek eski hâline döner.

---

## 🎯 Amaç
- Nesnenin önceki durumlarını saklayıp, gerektiğinde geri dönmek.
- Özellikle:
  - Geri alma / ileri alma (undo / redo)
  - Oyunlarda checkpoint (kayıt)
  - Karmaşık işlemleri geri almak

---

## 🛠 Nasıl Çalışır?
1. **Originator**: Durumu tutan nesne; `createMemento()` ve `restoreMemento()` metotları ile durumunu kaydeder / geri yükler.
2. **Memento**: Kaydedilen durumu temsil eden nesne.
3. **Caretaker**: Memento’yu tutar, ancak iç detaylarını bilmez; sadece geri yüklemek için saklar.

> Originator, Memento nesnesiyle kendi iç durumunu güvenli şekilde yedekler ve geri yükler.
> Caretaker ise bu Memento nesnelerini yönetir (liste tutarak çoklu undo gibi).

---

## ✈ Gerçek Hayattan Örnek
Bir metin editörü düşün:
- Kullanıcı yazdıkça editör, metnin “memento”larını kaydeder.
- Kullanıcı `Ctrl + Z` yaptığında, editör en son kaydedilen memento’yu geri yükler.

---

## ✅ Avantajları
- Nesnenin iç durumu **dışarı sızdırılmaz**.
- Geri alma (undo) gibi özellikleri kolayca uygulamayı sağlar.
- Kullanıcı için güvenli bir yedekleme ve geri dönüş mekanizması sunar.

---

## ⚠ Dezavantajları
- Çok sayıda memento tutmak **bellek tüketimini artırabilir**.
- Memento nesnelerinin yönetimi (özellikle çok sayıda undo/redo) karmaşık hale gelebilir.

---

## ✏ Özet
> Memento Design Pattern, bir nesnenin önceki durumlarını güvenli şekilde kaydedip, gerektiğinde geri yükleyerek eski hâline dönmeyi sağlar.
> **Originator** durumu kaydeder, **Memento** bu durumu tutar, **Caretaker** mementoları yönetir.

---
