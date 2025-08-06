# Unnecessary Hierarchy

## 🔍 Nedir?

**Unnecessary Hierarchy**, yazılım tasarımında ihtiyaç duyulmadığı halde karmaşık ve derin sınıf hiyerarşilerinin oluşturulmasıdır.  
Bu hiyerarşiler genellikle gereksiz katmanlar ve soyutlamalar içerir ve basit yapıları karmaşıklaştırır.

---

## 🚫 Neden Kötüdür?

- 🧩 **Kod karmaşıklaşır**: Basit işlevler gereksiz katmanlara bölünür.
- 🐢 **Geliştirme ve bakım yavaşlar**: Değişiklikler hiyerarşinin birçok katmanına yayılır.
- 🔍 **Anlaşılması zorlaşır**: Hangi sınıfın hangi görevi üstlendiği belirsizleşir.
- ❌ **Performans etkilenebilir**: Fazla soyutlama ve yönlendirme işlem maliyetini artırabilir.
- ⚠️ **YAGNI ilkesine aykırıdır**: “You Aren’t Gonna Need It” prensibi ihlal edilir.

---

## ✅ Çözüm Yaklaşımı

- Hiyerarşi tasarlarken sadece gerçek ihtiyaçlara odaklan.
- Gereksiz katman ve soyutlamaları kaldır.
- Basit ve düz yapılar tercih et.
- Tasarım kararlarını sürekli gözden geçirerek sadeleştir.
- Kompozisyon (composition) gibi alternatif tasarım tekniklerini değerlendir.

---

## 📚 Gerçek Hayattan Analoji

Bir iş yerinde, tek bir işi yapmak için gereksiz yere çok sayıda yönetici ve müdür olması gibi.  
Bu durumda iş akışı yavaşlar, iletişim zorlaşır ve kararlar gecikir.

Benzer şekilde yazılımda gereksiz hiyerarşiler verimliliği düşürür ve karmaşa yaratır.
