# 🧾 Teknik Borç (Technical Debt)

**Teknik borç**, bir yazılım projesinde **hızlı sonuç almak için tercih edilen kısa vadeli çözümlerin**, uzun vadede **bakım ve geliştirme maliyetlerini artırmasına** neden olan durumu ifade eder.

Bu kavram ilk olarak 1992’de *Ward Cunningham* tarafından ortaya atılmıştır:

> "Nasıl ki borç aldığınızda ana parayı ve faizi zamanla geri ödersiniz, teknik borç da ileride daha fazla çaba, zaman ve kaynakla ödenir."

---

## 📌 Teknik Borç Nasıl Oluşur?

### ✅ Bilinçli (Deliberate) Teknik Borç
- Proje teslim tarihi yaklaştığı için “şimdilik böyle yapalım, sonra düzeltiriz” denerek yapılan geçici çözümler.
- MVP (Minimum Viable Product) geliştirme sürecinde hızlı davranmak adına alınan kararlar.

### ❌ Bilinçsiz (Inadvertent) Teknik Borç
- Kötü yazılım tasarımı veya düşük kod kalitesi.
- Yetersiz testler.
- Yetersiz deneyim veya bilgi eksikliği.
- Evrimsel mimari değişikliklerine uyum sağlayamama.

---

## 🧱 Teknik Borç Türleri

| Tür | Açıklama |
|-----|----------|
| **Kod Borcu** | Karmaşık, okunması ve test edilmesi zor kodlar. |
| **Tasarım Borcu** | Zayıf mimari, modüler olmayan yapı. |
| **Test Borcu** | Test eksikliği veya hatalı test yapısı. |
| **Dokümantasyon Borcu** | Yetersiz veya güncel olmayan belgeler. |
| **Altyapı Borcu** | Güncellenmeyen kütüphaneler, bağımlılıklar. |

---

## 🧠 Teknik Borcun Belirtileri

- Kod değişiklikleri zor ve riskli hale gelir.
- Yeni özellikler yavaş eklenir.
- Testler sürekli bozulur.
- Geliştirici ekip sık sık hatalarla uğraşır.
- Projenin bakım maliyeti artar.

---

## 🧮 Teknik Borç = Faiz

Kısa vadede zaman kazandırır ama uzun vadede daha fazla “faiz” ödemene neden olur. Bu faiz:

- Ekstra hata düzeltme maliyeti
- Refactoring (kod iyileştirme) zorunluluğu
- Ekip moralinin düşmesi
- Performans sorunları

---

## ⚖️ Teknik Borç Her Zaman Kötü mü?

Hayır. **Stratejik olarak alınan teknik borç**, zaman-kalite dengesini sağlamak için kabul edilebilir olabilir. Ancak bu borcun:

- **Belgelendirilmesi**
- **Planlı şekilde geri ödenmesi**
- **Takip edilmesi**

gereklidir.

---

## 🔧 Teknik Borç Nasıl Yönetilir?

1. **Kod İnceleme (Code Review)** ile hataları erken tespit et.
2. **Yazılım Metrikleri** kullanarak teknik borç seviyesini ölç (örnek: SonarQube).
3. **Refactoring** için sprintlerde zaman ayır.
4. **Test Kapsamını Artır**: Otomatik testler borcu azaltır.
5. **Teknik Borç Listesi** oluştur ve backlog'da takip et.
6. **Dokümantasyon**u güncel tut.

---

