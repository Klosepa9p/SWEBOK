# Speculative Hierarchy

## 🔍 Nedir?

**Speculative Hierarchy**, yazılım tasarımında henüz ihtiyaç duyulmayan, ancak ileride gerekebileceği varsayılarak oluşturulan aşırı karmaşık veya gereksiz sınıf hiyerarşileridir.  
Bu tür hiyerarşiler, gereksiz soyutlamalar ve katmanlar içerir.

---

## 🚫 Neden Kötüdür?

- 🧩 **Kod karmaşıklaşır ve gereksiz büyür**: Kullanılmayan veya çok az kullanılan sınıflar kod tabanını şişirir.
- ❌ **Bakımı zorlaşır**: Fazla katman yüzünden değişiklikler zorlaşır.
- 🐢 **Geliştirme süreci yavaşlar**: İhtiyaç olmadan yapılan soyutlamalar zaman ve kaynak kaybına yol açar.
- ⚠️ **YAGNI (You Aren’t Gonna Need It) ilkesine aykırıdır**: Gerçek ihtiyaçlar yerine varsayımlar baz alınır.

---

## ✅ Çözüm Yaklaşımı

- Gereksiz soyutlamalardan kaçın; önce somut ve basit çözümler geliştir.
- İhtiyaç ortaya çıktıkça, gerektiğinde refaktör ederek hiyerarşi oluştur.
- Tasarım kararlarını, mevcut gereksinimlere göre al.
- Kodun aşırı karmaşıklaşmasını önlemek için sürekli değerlendirme yap.

---

## 📚 Gerçek Hayattan Analoji

Bir ev inşa ederken, gelecekte lazım olabilir diye her odayı fazladan duvarlarla bölmek ve kullanmayacağı odalar yaratmak gibidir.  
Bu durum evin kullanımını zorlaştırır, maliyeti artırır ve gereksiz karmaşa yaratır.

Benzer şekilde, yazılımda gereksiz hiyerarşiler planlamak da işi zorlaştırır ve verimliliği düşürür.
