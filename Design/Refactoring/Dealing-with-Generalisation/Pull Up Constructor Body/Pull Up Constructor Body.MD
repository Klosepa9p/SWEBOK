## ⬆️ Pull Up Constructor Body Yöntemi

### 🐞 Problem

- Birden fazla alt sınıf (**subclass**) yapıcıları (**constructor**) aynı veya çok benzer kod içeriyorsa, bu kod tekrarı (**duplication**) oluşturur.
- Aynı başlatma mantığının farklı alt sınıflarda tekrar etmesi, bakım ve güncelleme süreçlerini zorlaştırır.

---

### ✅ Çözüm

Alt sınıfların yapıcılarındaki ortak kodu, **üst sınıfın** (**superclass**) yapıcısına taşıyarak kod tekrarını ortadan kaldırmak ve başlatma mantığını tek bir yerde tanımlamak.

---

### 🌱 Faydaları

- Kod tekrarı azalır, bakım kolaylaşır.
- Ortak başlatma mantığı üst sınıfta merkezileşir, tutarlılık artar.
- Alt sınıfların yapıcıları daha sade ve odaklanmış hale gelir.

---

### 🛠️ Nasıl Uygulanır

1. Alt sınıfların yapıcılarındaki ortak kodu belirleyin.
2. Ortak kodun tüm alt sınıflarda aynı veya çok benzer olduğundan emin olun.
3. Ortak kodu üst sınıfın yapıcısına taşıyın.
4. Alt sınıfların yapıcılarında üst sınıf yapıcısını çağırın (örn. `super()`).
5. Gerekirse parametreleri veya erişim seviyesini ayarlayın.
6. Kodun doğru çalıştığından emin olmak için test et.