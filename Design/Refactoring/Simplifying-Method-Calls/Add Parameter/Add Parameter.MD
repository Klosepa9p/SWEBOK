## ➕ Add Parameter Yöntemi

### 🐞 Problem
- Bir metot, mevcut parametreleriyle tüm gerekli bilgileri alamıyorsa, işlevselliği eksik veya esnek olmayabilir.
- Metodun davranışını değiştirmek veya özelleştirmek için ek bilgi gerekiyorsa, bu bilgi metot içinde sabit kodlanmış (hard-coded) olabilir.

---

### ✅ Çözüm
Metoda yeni bir **parametre** ekleyerek eksik bilgiyi sağla.  
Bu sayede metot daha **esnek** ve yeniden kullanılabilir hale gelir.

---

### 🌱 Faydaları
- Metot daha **genelleştirilmiş** ve esnek olur.
- Sabit kodlanmış değerler yerine **dinamik veri** kullanılır.
- Kodun bakımı ve genişletilmesi kolaylaşır.

---

### 🛠️ Nasıl Uygulanır
1. Metodun ihtiyaç duyduğu ek bilgiyi belirle.
2. Metoda yeni bir parametre ekle ve metodun mantığını bu parametreyi kullanacak şekilde güncelle.
3. İstemci kodlarını, yeni parametreyi geçecek şekilde düzenle.
4. Gerekirse varsayılan değerler veya **aşırı yükleme (overloading)** ile geriye dönük uyumluluğu koru.
5. Kodu test et.

---

> 💡 **İpucu:** Yeni parametre, metodun amacını ve sorumluluğunu bozmayacak şekilde tasarlanmalıdır.
