# 🪶 Command Design Pattern

## 📌 Nedir?
**Command Design Pattern**, bir işlemi gerçekleştiren isteği (**request**) bir nesne olarak paketler;  
böylece o isteği:
- **Kuyruğa alabilir**,
- **Kaydedebilir** (örneğin undo/redo),
- **Farklı zamanlarda veya farklı bağlamlarda** çalıştırabilirsin.

Bu desen, **isteği gönderen** nesne ile **isteği yerine getiren** nesne arasındaki bağımlılığı azaltır.

---

## 🎯 Amaç
- İstekleri (komutları) nesne olarak temsil ederek, bunları kolayca **iletebilmek**, **kuyruğa koyabilmek**, **kaydedebilmek** veya **geri alabilmek**.
- Komutları çalıştıran nesne ile komutları isteyen nesneyi **gevşek bağlı** hale getirmek.

---

## 🛠 Nasıl Çalışır?
1. **Command**: Ortak bir arayüz; tüm komut sınıfları bu arayüzü uygular.
2. **ConcreteCommand**: Gerçek işlemi tanımlar; alıcı nesneye (receiver) hangi işlemin uygulanacağını bilir.
3. **Receiver**: Komutun işlemini gerçekten gerçekleştiren sınıf.
4. **Invoker**: Komutu çağıran nesne; komutu ne zaman çalıştıracağını bilir.
5. **Client**: Hangi komutun oluşturulacağını ve invoker’a verileceğini belirler.

---

## ✈ Gerçek Hayattan Örnek
Bir televizyon uzaktan kumandası düşün:
- Her bir tuş bir **komut nesnesi**dir (örneğin: ses aç, ses kıs, kanal değiştir).
- **Invoker**: Kumanda
- **Receiver**: Televizyon
- Kullanıcı (client), hangi tuşa basacağını seçer; kumanda (invoker) doğru komutu çağırır.

---

## ✅ Avantajları
- Komutları **kuyruğa almak**, **kaydetmek**, **geri almak** (undo/redo) kolaylaşır.
- Komutu gönderen ve komutu çalıştıran nesne arasında **düşük bağlılık** sağlar.
- Yeni komut eklemek **kolaydır**, mevcut kodu değiştirmeden genişletebilirsin.

---

## ⚠ Dezavantajları
- Her işlem için ayrı bir **ConcreteCommand** sınıfı gerekir; bu da **sınıf sayısını artırabilir**.
- Basit işlemler için karmaşık bir yapı ortaya çıkabilir.

---

## ✏ Özet
> Command Design Pattern, işlemleri (komutları) nesne olarak paketleyerek;  
> bunları çalıştırma, kaydetme, geri alma gibi işlemleri **esnek ve kontrol edilebilir** hale getirir.

---
