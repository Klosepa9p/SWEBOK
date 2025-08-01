## ✂️ Separate Query from Modifier Yöntemi

### 🐞 Problem
- Bir metot hem bir değer döndürüyor (**query**) hem de nesnenin durumunu değiştiriyorsa (**modifier**), bu durum kodun anlaşılmasını zorlaştırır.
- Sorgu ve değiştirici işlevlerin bir arada olması, metodun sorumluluğunu artırır ve yan etki riskini yükseltir.

---

### ✅ Çözüm
Metodu ikiye ayır:
- **Query metodu:** Yalnızca değer döndürür, **durumu değiştirmez**.
- **Modifier metodu:** Yalnızca nesnenin **durumunu değiştirir**, değer döndürmez.

Böylece her metot tek bir sorumluluğa sahip olur.

---

### 🌱 Faydaları
- Kod daha **açık** ve **anlaşılır** hale gelir, yan etkiler azalır.
- **Tek Sorumluluk İlkesi**’ne (Single Responsibility Principle) uyum artar.
- Metotların **yeniden kullanımı** ve **test edilmesi** kolaylaşır.

---

### 🛠️ Nasıl Uygulanır
1. Hem sorgu hem de değiştirici işlev yapan metodu belirle.
2. Sorgu kısmını (değer döndüren) ayrı bir metot olarak çıkar.
3. Durumu değiştiren kısmı ayrı bir metot olarak tanımla.
4. İstemci kodlarını, yeni metotları çağıracak şekilde güncelle.
5. Kodu test et.

---

> 💡 **İpucu:**  
> Query metodunun *hiçbir zaman* yan etki oluşturmamasına dikkat et; modifier metodunun ise yalnızca durumu değiştirmesine odaklan.
