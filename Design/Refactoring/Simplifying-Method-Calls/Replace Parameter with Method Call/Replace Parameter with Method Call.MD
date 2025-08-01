## 🔧 Replace Parameter with Method Call Yöntemi

### 🐞 Problem
- Bir metot, istemciden aldığı bir parametreyi kullanmak yerine, bu parametrenin değerini  
  zaten erişebileceği bir kaynaktan (örneğin, başka bir metot veya nesne) elde edebiliyorsa, bu parametre gereksizdir.
- Gereksiz parametreler, metot imzasını karmaşıklaştırır ve istemci kodun daha fazla veri geçmesini gerektirir.

---

### ✅ Çözüm
- Metoda geçirilen parametreyi kaldırın ve metot içinde, bu parametrenin değerini sağlayan bir metot çağrısı kullanın.  
- Böylece istemci, parametre geçmek zorunda kalmaz.

---

### 🌱 Faydaları
- Metot imzası daha sade ve temiz olur.
- İstemci kodun gereksiz veri geçmesi önlenir.
- Kodun okunabilirliği ve bakımı kolaylaşır.

---

### 🛠️ Nasıl Uygulanır
1. Parametrenin metot içinde nasıl kullanıldığını ve değerinin nereden alınabileceğini belirleyin.
2. Parametrenin değerini sağlayan bir metot çağrısı ekleyin.
3. Metot imzasından parametreyi kaldırın ve metot içinde bu çağrıyı kullanın.
4. İstemci kodlarını, parametresiz metot çağrısına uygun şekilde güncelleyin.
5. Kodu test edin.


