# 🪶 Flyweight Design Pattern

## 📌 Nedir?
**Flyweight**, çok sayıda nesne üretmek zorunda olduğumuzda bellek kullanımını optimize etmeye yarayan **yapısal (structural) bir tasarım desenidir**.  
Temel amaç, **aynı olan (paylaşılan) verileri tek bir yerde saklayarak** tekrar tekrar kullanılmasını sağlamak; sadece farklı olan (değişken) verileri ayrı tutmaktır.

---

## 🧩 Nasıl Çalışır?
- Nesneleri iki kısma böler:
  - **Intrinsic (içsel) durum:** Değişmeyen ve paylaşılabilir kısım (örneğin: bir karakterin fontu, rengi).
  - **Extrinsic (dışsal) durum:** Her nesneye özel ve değişebilen kısım (örneğin: karakterin belgedeki konumu).

- Aynı intrinsic durum için **tek bir nesne** oluşturulur.
- Birden fazla yerde bu nesneye ihtiyaç duyulduğunda **yeni nesne yaratmak yerine mevcut nesne paylaşılır**.

---

## 📦 Avantajları
✅ **Bellek tasarrufu sağlar** – çok sayıda benzer nesne üretileceği durumlarda ciddi kazanç sağlar.  
✅ **Performansı artırır** – tekrar eden nesnelerin sadece bir defa üretilmesi yeterlidir.  
✅ Kodun yapısını daha temiz hale getirir.

---

## ⚠️ Dezavantajları
❗ Yapı daha karmaşık hale gelebilir; **extrinsic ve intrinsic** verilerin yönetimi dikkat ister.  
❗ Çok sayıda benzersiz (extrinsic) veri varsa, kazanç azalır.

---

## 🏗️ Kullanım Örneği
- Yazı editörü: Belgede binlerce aynı karakter var, hepsi için ayrı nesne yaratmak yerine; `char` değeri, font tipi gibi intrinsic durumlar paylaşılır, sadece pozisyon extrinsic olarak tutulur.
- Oyunlarda: Binlerce aynı düşman birimi, ağaç veya taş gibi nesnelerin ortak özellikleri paylaşılır.

---

## ✏️ Kısaca Özet
> **Flyweight Design Pattern**, büyük sayıda nesne üretmek yerine, **ortak olanları paylaşarak** bellek ve performans kazancı sağlar.
> Özellikle grafik motorları, yazı editörleri gibi yoğun nesne kullanan sistemlerde çok etkilidir.



## 🧩 Temel fark
|                     | Flyweight                                          | Prototype                                      |
|---------------------|----------------------------------------------------|------------------------------------------------|
| **Nesnelerin yapısı** | Ortak (intrinsic) ve farklı (extrinsic) kısımlar | Mevcut nesnenin tüm özellikleri kopyalanır     |
| **Paylaşım**        | Nesneler paylaşılır, aynı nesne birçok yerde kullanılır | Her klon ayrı nesnedir, paylaşılmaz           |
| **Hedef**           | Bellekten tasarruf (özellikle çok sayıda benzer nesnede) | Karmaşık nesneleri hızlı üretmek               |
| **Kullanım yeri**   | Yazı editörü, grafik motorları (ağaç, taş vb.)    | Oyun karakteri, form şablonu, belge kopyası   |

---

## ✏️ Özet
- **Flyweight**: "Nesneyi paylaş, aynı nesneyi tekrar kullan."
- **Prototype**: "Nesneyi klonla, yeni bir örnek oluştur."

> ⚡ İkisinin de asıl amacı performans ve kaynak tasarrufu sağlamak olsa da,  
> kullandıkları yaklaşım ve çözüm tamamen farklıdır.

 Prototype deseni, nesneyi yaratırken karşımıza çıkan problemi çözüyor. Flyweight design pattern ise zaten oluşturulmuş nesneleri belleğe aktarıyor! Yani hali hazırda bellekte olan nesnelerin bir kombinasyonunu oluşturuyorsunuz. Sonuç olarak birbirlerine benzemelerine karşın, pratikte oldukça farklı iki işleve sahip desenlerden bahsediyoruz.



## 📝Örnek Açıklaması

- **CharacterFlyweight**  
  Flyweight sınıfıdır; ortak (*intrinsic*) özellikleri tutar:  
  - sembol
  - font
  - boyut  
  `display` fonksiyonu, harici (*extrinsic*) durumları (örneğin, pozisyon) parametre olarak alır.

- **FlyweightFactory**  
  Flyweight nesnelerini oluşturur ve yeniden kullanır.  
  Aynı özelliklere sahip bir Flyweight zaten varsa, yeni bir nesne oluşturmak yerine mevcut olanı döndürür.

- **TextEditor (Client)**  
  Client sınıfıdır; `FlyweightFactory` kullanarak karakterleri ekler ve görüntüler.

- **Anahtar Oluşturma**  
  `createKey` fonksiyonu, Flyweight nesnelerini benzersiz şekilde tanımlamak için bir anahtar üretir.

- **💾 Bellek Tasarrufu**  
  Aynı özelliklere sahip karakterler (ör: `'A'`, *Arial*, `12`) için yalnızca bir Flyweight nesnesi oluşturulur ve paylaşılır.  
  Böylece çok sayıda karakter kullanılan senaryolarda ciddi bellek tasarrufu sağlanır.
