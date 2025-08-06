# Imperative Abstraction

## 🔍 Nedir?

Imperative Abstraction (Emirsel Soyutlama), her işlemi temsil eden ayrı sınıflar oluşturulması yaklaşımıdır.  
Bu sınıflar genellikle tek bir iş yapar ve sınıf adı, yaptığı işlemi doğrudan ifade eder.  
Bu yaklaşımda odak, nesneler ya da domain varlıkları değil, işlemlerin kendisidir.  
Yani, sistemin davranışları parçalara bölünerek bağımsız sınıflarda tanımlanır.

---

## 🚫 Neden Kötüdür?

- Aynı kavramsal bağlama (örneğin bir domain varlığına) ait işlemler dağınık hale gelir.
- Çok fazla sayıda, tek görevli sınıf oluşur. Bu da sınıf enflasyonuna neden olur.
- Kodun okunabilirliğini ve sürdürülebilirliğini düşürür.
- Bakım maliyeti artar; bir domain varlığına ait işlemler üzerinde değişiklik yaparken birden fazla sınıfa müdahale gerekir.
- Gerçek dünya modellemesiyle (domain-driven design) zayıf bağ kurar.

---

## ✅ Çözüm Yaklaşımı

- Aynı konuya/domaine ait işlemleri bir araya toplayan, bütünsel ve uyumlu sınıflar oluşturulmalıdır.
- Soyutlama yapılırken işlemler değil, işlemlerin uygulandığı domain varlıkları esas alınmalıdır.
- Sınıf isimleri bir eylemi değil, bir kavramı veya sorumluluğu yansıtmalıdır.
- Bu sayede hem anlamlı soyutlama yapılır, hem de kod daha kolay anlaşılır ve genişletilebilir olur.

---

## 📚 Gerçek Hayattan Analoji

Bir şirkette personel işlemleri farklı kişilere dağıtılmış olsun:

- Biri sadece personel ekleme işi yapıyor,
- Diğeri sadece güncelleme,
- Bir başkası da sadece silme işlemiyle ilgileniyor.

Hepsi aynı personel verisi üzerinde çalışıyor ama ayrı ayrı görevlerde.  
Bu yapı, iletişim sorunlarına, verimsizliğe ve süreçte karmaşaya yol açar.

Daha anlamlı çözüm ise tüm bu işlemleri aynı kişiye, yani bir "İnsan Kaynakları Sorumlusu"na vermektir.  
Bu kişi tüm süreci uçtan uca yönetir, işler daha uyumlu ve organize şekilde yürür.

---
