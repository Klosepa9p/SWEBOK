## 🔁 Duplicate Observed Data Yöntemi

### 🐞 Problem

- **Kullanıcı arayüzü (UI)** veya başka bir katmandaki veri, iş mantığı katmanındaki verilerle **sıkı sıkıya bağlı** olduğunda:
  - Katmanlar arası bağımlılık artar.
  - UI'deki veriler, iş mantığından bağımsız yönetilemez.
  - Kodun test edilmesi ve bakımı zorlaşır.

---

### ✅ Çözüm

UI veya ilgili katmanda kullanılacak verileri, iş mantığı katmanındaki verilerden **kopyalayarak (duplicate)** bağımsız bir veri modeli oluşturun.  
Bu kopya model, UI veya ilgili katman tarafından yönetilir ve iş mantığıyla **senkronize edilir**.

---

### 🌱 Faydaları

- Katmanlar arası bağımlılık azalır; **UI ve iş mantığı daha bağımsız** çalışır.
- **Test edilebilirlik artar**, çünkü UI verileri izole edilir.
- Kodun **modülerliği ve esnekliği** gelişir.

---

### 🛠️ Nasıl Uygulanır

1. UI veya ilgili katmanda kullanılan **verileri** tespit edin.
2. Bu veriler için **bağımsız bir veri modeli** (sınıf veya yapı) oluşturun.
3. İş mantığı verilerini, bu yeni veri modeline **kopyalayın**.
4. Senkronizasyon mekanizması kurun (ör. getter/setter, event/observer yapısı).
5. UI kodunu, iş mantığı verileri yerine **yeni veri modeliyle** çalışacak şekilde güncelleyin.
6. Kodu test edin.
