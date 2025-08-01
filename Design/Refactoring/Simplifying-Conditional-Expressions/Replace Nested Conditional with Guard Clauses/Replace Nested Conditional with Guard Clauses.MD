## 🛡️ Replace Nested Conditional with Guard Clauses Yöntemi

### 🐞 Problem
- İç içe geçmiş koşullu ifadeler (**nested conditionals**), kodun okunabilirliğini azaltır ve karmaşıklığı artırır.
- Derin iç içe yapılar, kodun akışını takip etmeyi zorlaştırır ve hata riskini yükseltir.

---

### ✅ Çözüm
İç içe koşullu ifadeleri, **erken dönüş** (*early return*) veya **koruma ifadeleri** (*guard clauses*) ile değiştirin.  
Her koşulu ayrı bir kontrol olarak yazın ve uygun durumlarda metottan hemen dönün.

---

### 🌱 Faydaları
- Kod daha **düz** ve okunabilir hale gelir.
- İç içe yapılar azalır, akış daha kolay takip edilir.
- Bakım ve hata ayıklama süreçleri basitleşir.

---

### 🛠️ Nasıl Uygulanır
1. İç içe koşullu ifadeleri tespit edin.
2. Her koşulu **guard clause** olarak yazın; uygun durumlarda `return` veya `throw` kullanın.
3. Ana mantığı, iç içe bloklar olmadan düz bir akışla yazın.
4. Kodu test edin.

---

> 💡 **Not:** Guard clause, özellikle “ön koşullar”ın hızlıca kontrol edilip hatalı durumlarda erken dönmeyi sağlar; böylece ana mantık temiz ve anlaşılır kalır.
