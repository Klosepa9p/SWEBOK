# 🧩 Mediator Design Pattern

## 🎯 Amaç
Sistemimizde çok sayıda nesne oluşturulduğunda, bu nesnelerin birbirleriyle iletişim kurması gerekebilir.  
Eğer her nesne diğerlerini doğrudan tanırsa:
- Karmaşık ve yönetilmesi zor bir yapı oluşur.
- Nesneler arasında sıkı bağımlılıklar olur.
- Sistemin bakımı ve genişletilmesi zorlaşır.

---

## 🛠 Çözüm
Bu problemi çözmek için:
- **Merkezi bir yapı** kurulur.
- Bu yapıda **aracı bir sınıf** (Mediator) tanımlanır.
- Nesneler, birbirleriyle doğrudan iletişim kurmak yerine, mediator üzerinden haberleşir.
- Böylece nesnelerin birbirini tanıma zorunluluğu ortadan kalkar.

---

## ✅ Avantajları
- Nesneler arasındaki **bağımlılığı azaltır** (*loose coupling*).
- Karmaşık iletişim senaryoları daha **merkezi ve yönetilebilir** hale gelir.
- Sistemin **bakımı ve genişletilmesi** kolaylaşır.
- Nesneler daha **yeniden kullanılabilir** olur; mediator değiştikçe farklı iletişim senaryoları uygulanabilir.

---

## ⚠ Dezavantajları
- Tüm iletişim mediator’a toplandığı için, **tek bir noktada karmaşıklık** birikebilir.
- Çok sayıda farklı iletişim kuralı eklenirse, mediator sınıfı büyüyerek **zor yönetilebilir** hale gelebilir.

---

## ✏ Özet
> Sistemimizde birçok nesne oluşturmak ve bu nesnelerin birbiriyle iletişimi zorunlu olduğunda,  
> **merkezi bir aracı (Mediator) sınıf** oluşturulur.  
> Nesneler doğrudan değil, mediator aracılığıyla iletişim kurar; böylece bağımlılıklar azaltılır ve sistem daha esnek hale gelir.



## ✈ Gerçek Hayattan Örnek: Hava Trafik Kontrol Kulesi

Havaalanlarında, uçakların iniş ve kalkışlarını organize eden **kontrol kuleleri** bulunur.  
Bütün pilotlar, doğrudan diğer pilotlarla konuşmak yerine bu kule ile iletişim kurar ve havaalanı uygunluğunu öğrenirler.

Eğer bu kuleler olmasaydı:
- Bütün pilotların, diğer tüm pilotlarla **tek tek** iletişim kurması gerekirdi.
- Bu durum hem **zaman alırdı** hem de iletişim ağı çok **karmaşık** hale gelirdi.
- Karmaşıklık arttıkça **hata riski** de artardı.

Kontrol kulesi burada bir **Mediator (aracı)** görevi görerek:
- Tüm iletişimi merkezi olarak yönetir.
- Pilotların doğrudan birbirine bağımlı olmasını engeller.
- Sistemi daha **güvenli, hızlı ve yönetilebilir** hale getirir.

