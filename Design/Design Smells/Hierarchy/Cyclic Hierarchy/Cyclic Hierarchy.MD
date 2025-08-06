# Cyclic Hierarchy

## 🔍 Nedir?

**Cyclic Hierarchy**, nesne yönelimli tasarımda sınıflar arasında döngüsel (circular) kalıtım ilişkisi kurulması durumudur.  
Yani bir sınıf, dolaylı veya doğrudan kendisini üst sınıf olarak içeren bir hiyerarşide yer alır.  
Bu durum, hiyerarşinin sonsuz döngüye girmesine ve yapısal sorunlara yol açar.

---

## 🚫 Neden Kötüdür?

- 🔄 **Derleme hatalarına** neden olur: Çoğu programlama dili döngüsel kalıtımı desteklemez.
- 🧩 **Tasarım karmaşası yaratır**: Sınıfların ilişkileri anlaşılmaz ve karmaşıklaşır.
- 🛠️ **Bakımı ve genişletmesi zor olur**: Döngü nedeniyle değişiklikler zincirleme etki yapar.
- ❌ **Principle’lara aykırıdır**: SOLID prensiplerine ve iyi tasarım kurallarına uymaması beklenir.
- ⚠️ **Sonsuz döngü ve belirsiz davranışlar oluşabilir**.

---

## ✅ Çözüm Yaklaşımı

- Hiyerarşi tasarlanırken **döngüsel referanslardan kaçın**.
- Gerekirse kalıtım yerine **kompozisyon (composition)** veya diğer tasarım desenlerini kullan.
- Tasarım modellerini basitleştir ve net sorumluluklar belirle.
- Kodun ve yapının analizinde araçlardan faydalanarak döngüleri tespit et.

---

## 📚 Gerçek Hayattan Analoji

Bir şirkette A çalışanı, B çalışanının amiri, B ise C’nin amiri, C ise tekrar A’nın amiri olarak gösterilsin.  
Bu durumda herkes birbirinin amiri olur ve kimin kime bağlı olduğu anlaşılmaz.

Bu da çalışma düzenini bozar ve kaosa yol açar.

---

