# 📦 Kodun Evrimi: Cohesion ve Coupling Açısından Analiz

---

## 🔹 1. Kod – Düzeltilmeden Önce

### ✅ Analiz

| Kriter       | Durum |
| ------------ | ---- |
| **Cohesion** | `Application` sınıfı çok fazla iş yapıyor: ID ve plaka üretmek, katalog fiyatını belirlemek, vergi oranını hesaplamak ve sonuçları yazdırmak. Bu da **düşük bağlılık (low cohesion)** anlamına gelir. |
| **Coupling** | `Application` doğrudan iş kurallarını (katalog fiyatları, vergi oranları vb.) içeriyor. Bu kurallar değiştiğinde `Application` sınıfı da değişmek zorunda kalıyor. Bu da **yüksek bağımlılık (high coupling)** oluşturur. |

> Kısaca: Kod okunabilirliği ve bakımı zordur. Test etmek de zorlaşır; değişiklik yapmak risklidir.

---

## ✏️ 2. Kod – Düzeltilmiş Versiyon

### ✅ Analiz

| Kriter       | Durum |
| ------------ | ---- |
| **Cohesion** | Her sınıf net ve tek bir sorumluluğa sahip: <br>• `VehicleInfo`: katalog bilgisi ve vergi hesaplama <br>• `Vehicle`: tekil araç bilgisi <br>• `VehicleRegistry`: ID/plaka üretme ve araç oluşturma <br>• `Application`: sadece süreci başlatmak. Bu, **yüksek bağlılık (high cohesion)** sağlar. |
| **Coupling** | `Application` artık katalog fiyatını ve vergi oranlarını **bilmez**; bu detaylar `VehicleInfo` ve `VehicleRegistry` sınıflarında saklanır. Böylece **düşük bağımlılık (low coupling)** elde edilir. |

> Kısaca: Kod okunabilir, anlaşılır ve test edilebilir hale gelir. İş kuralları değişirse sadece ilgili sınıf değişir.

---

## 🧩 **Karşılaştırmalı Genel Sonuç**

|                | İlk Kod | Düzeltilmiş Kod |
| -------------- | ------: | --------------: |
| **Cohesion**   | Düşük   | Yüksek          |
| **Coupling**   | Yüksek  | Düşük           |
| **Bakım ve test** | Zor | Kolay |
| **Okunabilirlik** | Daha düşük | Daha yüksek |

---

## ✅ **Avantajlar (Düzeltilmiş Tasarım)**

- Kod okunabilirliği ve anlaşılırlığı artar.
- **Single Responsibility Principle (SRP)** – Tek sorumluluk ilkesi uygulanır.
- İş kurallarında değişiklik gerektiğinde sadece ilgili sınıf güncellenir.
- Daha kolay bakım ve test imkânı sağlar.
- Katmanlı ve modüler yapı sayesinde geliştirilebilirlik artar.

---

> 🔧 Bu iyileştirme, yazılım tasarımında **high cohesion** ve **low coupling** prensiplerinin pratikte nasıl değer kattığını güzel bir örnekle gösterir.
