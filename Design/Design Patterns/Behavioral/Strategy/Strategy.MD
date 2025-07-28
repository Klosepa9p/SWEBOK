# 🧠 Strategy Design Pattern

## 📌 Nedir?
**Strategy Design Pattern**, bir nesnenin **algoritmasını veya davranışını** çalışırken (**runtime**) **dinamik olarak** değiştirebilmeyi sağlar.  

Bu desen sayesinde:
- Farklı algoritmalar, aynı işi yapacak şekilde bir arayüz üzerinden **birbirlerinin yerine geçebilir**.
- Algoritmalar, **kullanıcıdan veya sistemin koşullarından bağımsız olarak** kolayca seçilebilir veya değiştirilebilir.

---

## 🎯 Amaç
- Bir işlemi gerçekleştiren **algoritmaların** (stratejilerin) birbirinden bağımsız şekilde tanımlanması.
- İlgili algoritmayı **çalışma zamanında seçebilmek**.
- Kod tekrarını azaltmak ve kodu **esnek, genişletilebilir** hale getirmek.

---

## 🛠 Nasıl Çalışır?
1. **Strategy**: Ortak arayüz veya soyut sınıf; tüm stratejilerin uyacağı bir şablon sağlar.
2. **ConcreteStrategy**: Bu arayüzü uygulayan, farklı algoritmaları temsil eden sınıflar.
3. **Context**: Stratejiyi kullanan sınıf; hangi algoritmanın kullanılacağını **çalışma zamanında** belirler.

---

## ✈ Gerçek Hayattan Örnek
Bir **navigasyon uygulaması** düşünelim:  
- Kullanıcı "en hızlı rota", "en kısa rota" veya "trafiksiz rota" seçeneklerinden birini seçebilir.
- Uygulama, farklı **rota bulma algoritmalarını** (stratejileri) çalışma zamanında seçerek uygular.
- Kullanıcı tercihini değiştirdiğinde, strateji de değişir.

---

## ✅ Avantajları
- Algoritmalar birbirinden **bağımsız** geliştirilir ve test edilir.
- Yeni algoritma eklemek kolaydır.
- Kodun okunabilirliği ve **esnekliği** artar.
- **Çalışma zamanında** strateji seçilebilir.

---

## ⚠ Dezavantajları
- Stratejiler arasında çok fazla küçük sınıf olabilir (**sınıf sayısı artar**).
- Stratejiler Context’ten ayrı olsa da, bazen Context’in strateji hakkında çok şey bilmesi gerekebilir.

---

## ✏ Özet
> **Strategy Design Pattern**, bir nesnenin davranışını (algoritmasını) çalışma zamanında değiştirmeyi sağlayarak,
> daha esnek ve genişletilebilir bir yapı kurar.

---