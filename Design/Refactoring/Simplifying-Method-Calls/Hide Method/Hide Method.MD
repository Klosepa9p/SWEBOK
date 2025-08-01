## 🔒 Hide Method Yöntemi

### 🐞 Problem
- Bir metodun istemciler tarafından doğrudan kullanılması gerekmiyorsa veya yalnızca sınıfın iç mantığı için kullanılıyorsa, bu metodun `public` olması gereksiz erişime ve yanlış kullanıma yol açabilir.
- `Public` metotlar, sınıfın arayüzünü genişletir ve istemcilerin bağımlılığını artırır.

---

### ✅ Çözüm
- Metodun erişim seviyesini (`public` → `private` veya `protected`) düşürerek yalnızca sınıfın veya alt sınıfların erişebileceği şekilde gizleyin.

---

### 🌱 Faydaları
- Sınıfın arayüzü sadeleşir, istemciler yalnızca gerekli metotları görür.
- Yanlış kullanım riski azalır, **enkapsülasyon (encapsulation)** artar.
- Kodun bakımı ve güvenliği iyileşir.

---

### 🛠️ Nasıl Uygulanır
1. Metodun istemciler tarafından gerçekten kullanılıp kullanılmadığını analiz edin.
2. Metodun erişim seviyesini `public` yerine `private` veya `protected` yapın.
3. İstemci kodlarında varsa metot çağrılarını kaldırın veya uygun alternatiflerle değiştirin.
4. Kodu test edin.
