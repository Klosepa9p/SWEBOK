# Broken Modularisation

## 🔍 Nedir?

**Broken Modularisation**, yazılım sisteminde modüllerin veya bileşenlerin doğru şekilde ayrılmaması ve birbirine aşırı bağımlı olması durumudur.  
Modüller arası sınırlar net çizilmemiş, sorumluluklar karışmış ve bağımlılıklar kontrolsüz şekilde yayılmıştır.

---

## 🚫 Neden Kötüdür?

- 🧩 **Kod karmaşıklaşır ve anlaşılması zorlaşır**: Modüller arası ilişkiler kafa karıştırıcı olur.
- 🔗 **Yüksek bağımlılık (tight coupling)** ortaya çıkar: Bir modüldeki değişiklik diğerlerini kolayca etkiler.
- 🛠️ **Bakımı zor ve maliyetli hale gelir**: Küçük bir değişiklik tüm sistemi etkileyebilir.
- 📉 **Yeniden kullanım imkanı azalır**: Modüller izole olmadığı için tekrar kullanımı zorlaşır.
- ⚠️ **Test edilebilirlik düşer**: Modüller bağımsız test edilemez.

---

## ✅ Çözüm Yaklaşımı

- Modüllerin sorumluluklarını net belirle ve sınırlarını çiz.
- Düşük bağlılık (loose coupling), yüksek bağlılık (high cohesion) prensiplerine uygun tasarla.
- Arayüzler (interfaces) ve soyutlamalar kullanarak bağımlılıkları azalt.
- Modüller arası iletişimi iyi yönet ve sadece gerekli veri alışverişine izin ver.
- Kodun modülerliğini düzenli refaktör ile iyileştir.

---

## 📚 Gerçek Hayattan Analoji

Bir fabrikanın farklı bölümlerinin duvarları kaldırılarak hepsinin birbirine karışması gibidir.  
Böylece herhangi bir bölümde yapılan iş diğerlerini doğrudan etkiler ve sorun çıktığında tüm fabrika zarar görür.

İyi bir fabrika gibi, yazılımda da modüller net ayrılmalı ve bağımsız çalışmalıdır.
