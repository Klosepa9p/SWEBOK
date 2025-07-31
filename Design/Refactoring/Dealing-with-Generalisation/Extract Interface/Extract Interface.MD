## 🏗️ Extract Superclass Yöntemi

### 🐞 Problem

- Birden fazla sınıf, ortak özellikler (**alanlar**) veya davranışlar (**metotlar**) içeriyorsa; bu durum **kod tekrarı** (**duplication**) oluşturur.
- Ortak mantığın farklı sınıflarda tekrar etmesi, bakım ve güncelleme süreçlerini zorlaştırır.

---

### ✅ Çözüm

Ortak özellikleri ve davranışları **yeni bir üst sınıfa** (**superclass**) taşıyarak kod tekrarını ortadan kaldırmak  
ve ilgili sınıfları bu üst sınıftan **türetmek**.

---

### 🌱 Faydaları

- Kod tekrarı azalır, bakım ve geliştirme süreçleri kolaylaşır.
- Ortak mantık üst sınıfta merkezileşir, **tutarlılık** artar.
- Sınıflar daha sade ve yalnızca kendi özel sorumluluklarına odaklanır.

---

### 🛠️ Nasıl Uygulanır

1. Ortak özellikleri ve davranışları tespit edin.
2. Yeni bir **üst sınıf** oluşturun ve bu ortak alanları/metotları bu sınıfa taşıyın.
3. Mevcut sınıfları, yeni üst sınıftan **türetin** (örn. `extends` ile).
4. Gerekirse üst sınıfı **soyut (abstract)** hale getirin.
5. Kodun doğru çalıştığından emin olmak için test edin.



## 📷 Görsel Anlatım

**Önce:**  
![Önceki hali](before.png)

**Sonra:**  
![Sonraki hali](after.png)