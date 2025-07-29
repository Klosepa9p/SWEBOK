# 🧬 State Design Pattern

## 📌 Nedir?
**State Design Pattern**, bir nesnenin davranışının, **iç durumuna göre dinamik olarak değişmesini** sağlar.  
Bu desen sayesinde:
- Durumlar (`State`) **nesne olarak** temsil edilir.
- Nesnenin durumu değiştiğinde, davranışı da değişir.
- Karmaşık `if-else` veya `switch` blokları yerine, **duruma özel sınıflar (ConcreteState)** kullanılır.

---

## 🎯 Amaç
- Nesnenin **duruma bağlı davranışlarını** kolay yönetmek.
- `if-else` blokları yerine, her durumu ayrı sınıf olarak tanımlayarak **kodun okunabilirliğini ve bakımını artırmak**.
- **Çalışma zamanında** durumu değiştirdiğimizde, nesnenin davranışının da değişmesini sağlamak.

---

## 🛠 Nasıl Çalışır?
1. **State (Arayüz veya soyut sınıf)**: Tüm durumların ortak davranışlarını tanımlar.
2. **ConcreteState**: Belirli bir durumu temsil eder; duruma özgü davranışları uygular.
3. **Context**: Mevcut durumu tutar ve client’tan gelen isteği ilgili ConcreteState’e iletir.

> `Client`, `Context` ile çalışır; hangi durumda olduğunu bilmez.  
> Davranışlar, mevcut duruma bağlı olarak ConcreteState tarafından belirlenir.

---

## ✈ Gerçek Hayattan Örnek
Bir medya oynatıcı (müzik çalar) düşünelim:
- **Durumlar (ConcreteState)**: Oynatılıyor, Duraklatıldı, Durduruldu.
- **Context**: Müzik çalar.
- Kullanıcı “play”, “pause” veya “stop” tuşlarına bastığında, Context mevcut ConcreteState’e bu isteği iletir.
- Davranış, hangi durumda olduğuna göre değişir.

---

## ✅ Avantajları
- Duruma bağlı davranışlar, **ayrı sınıflara bölünür**; kod daha okunur ve esnek olur.
- Yeni bir durum eklemek **çok kolaydır**; mevcut kodu değiştirmeden yeni ConcreteState eklenir.
- Kod tekrarını azaltır ve **polymorphism** avantajı sağlar.

---

## ⚠ Dezavantajları
- Durum sayısı fazla olduğunda, **çok sayıda ConcreteState sınıfı** oluşabilir.
- Tasarımı ilk etapta anlamak, basit projeler için zor olabilir.

---

## ✏ Özet
> **State Design Pattern**, bir nesnenin davranışını, iç durumuna göre çalışma zamanında değiştirmeyi sağlar.  
> Karmaşık if-else blokları yerine, her durumu bir sınıf olarak tanımlayarak daha **esnek, okunabilir ve genişletilebilir** bir yapı kurar.

---
