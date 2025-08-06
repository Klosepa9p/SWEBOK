# Deficient Encapsulation

## 🔍 Nedir?

**Deficient Encapsulation**, bir sınıfın veya modülün iç durumunu yeterince gizlememesi ve dış bileşenlerin bu iç yapıya doğrudan erişmesine izin vermesidir.

Bu durum genellikle şu şekillerde ortaya çıkar:
- Tüm alanların `public` yapılması
- Getter/setter yöntemleriyle aşırı derecede iç veriye erişim sağlanması
- Nesnenin dışarıya çok fazla bilgi vermesi (information leakage)

---

## 🚫 Neden Kötüdür?

- 🧠 **Soyutlama bozulur**: Nesneler kendi durumlarını yönetemez hale gelir.
- 🪢 **Bağımlılık artar**: Diğer bileşenler iç yapıya doğrudan bağlı kalır.
- 🧩 **Kod kırılgandır**: Küçük bir içsel değişiklik bile sistemin diğer bölümlerini etkileyebilir.
- 🔄 **Refactoring zorlaşır**: İç yapıyı değiştirmek tüm bağlı kodları güncellemeyi gerektirebilir.

---

## ✅ Çözüm Yaklaşımı

- 🔐 Alanları `private` veya `protected` yaparak doğrudan erişimi engelle.
- 🧭 Yalnızca gerçekten gerekli olan bilgileri dışarıya sunan arabirimler oluştur.
- 🔍 Getter/setter'ları minimal ve amaca yönelik kullan.
- 🧱 Nesnenin iç yapısına değil, davranışına odaklan.

---

## 📚 Gerçek Hayattan Analoji

Bir fabrikanın kontrol paneli herkesin erişimine açık olursa, çalışanlar üretim sürecine bilinçsizce müdahale edebilir.  
Bu da makinenin dengesini bozar ve sonuçta sistem kararsız hale gelir.

Yani, kontrol dışı erişim = karmaşa.

İyi kapsülleme, yalnızca yetkili kişilerin kontrol paneline erişmesini sağlar. Yazılımda da aynı prensip geçerlidir:  
**"Kontrol içeride kalmalı, dışarıya sadece gerekliyse açılmalı."**
