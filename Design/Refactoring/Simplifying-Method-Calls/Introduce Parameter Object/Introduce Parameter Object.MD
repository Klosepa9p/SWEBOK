## 🔧 Introduce Parameter Object Yöntemi

### 🐞 Problem
- Bir metot, çok sayıda parametre alıyorsa, bu durum metot imzasını karmaşıklaştırır ve okunabilirliği azaltır.
- İlgili parametreler bir grup olarak mantıksal bir bütün oluşturuyorsa, bunları ayrı ayrı geçmek yerine bir nesne olarak birleştirmek daha anlamlıdır.

---

### ✅ Çözüm
- Birbiriyle ilişkili parametreleri tek bir nesne (parametre nesnesi) içinde toplayın ve metodu bu nesneyi alacak şekilde yeniden düzenleyin.  
- Bu nesne, ilgili verileri kapsüller ve gerektiğinde ek davranışlar içerebilir.

---

### 🌱 Faydaları
- Metot imzası daha sade ve okunabilir hale gelir.
- İlgili parametreler bir arada tutularak kodun mantıksal bütünlüğü artar.
- Parametre nesnesine davranışlar eklenebilir, bu da kodu daha esnek yapar.

---

### 🛠️ Nasıl Uygulanır
1. İlgili parametreleri bir grup olarak belirleyin.
2. Bu parametreler için yeni bir sınıf oluşturun ve parametreleri bu sınıfın alanları yapın.
3. Metot imzasını, ayrı parametreler yerine yeni sınıfın örneğini alacak şekilde güncelleyin.
4. İstemci kodlarını, yeni parametre nesnesini oluşturup geçecek şekilde düzenleyin.
5. Kodu test edin.
