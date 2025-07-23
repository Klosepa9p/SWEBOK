## 🧩 Liskov Substitution Principle (LSP)

- Ana sınıftan (üst sınıf / base class) türeyen alt sınıfların (derived / child)  
  **üst sınıfın bütün özelliklerini kullanabilir** olması gerekir.

- Yani: herhangi bir alt sınıf, **üst sınıfın yerine** geçebilmelidir.  
  (Bir nesne, onun alt sınıfı ile sorunsuzca değiştirilebilmelidir.)

---

### ⚠️ İstenmeyen durum

> Üst sınıfta tanımlanan bir özellik veya metot, alt sınıfta **boş (dummy)** bırakılır,  
> veya sadece **hata fırlatarak** kontrol edilirse → tasarım LSP’ye aykırı olur.  
> Bu durum, gerçek kullanımda beklenmedik hatalara (runtime exception) yol açar.

---

### 📜 LSP bir *sözleşmedir*

- Üst sınıf ile alt sınıf arasında bir **sözleşme (contract)** imzalanır.
- Alt sınıf, bu sözleşmeye sadık kalmalı; üst sınıfta tanımlanan davranışları  
  bozmayacak şekilde kendi özel davranışını ekleyebilir.

---

### 🔄 Polimorfizm ile aynı mı?

> “Zaten polimorfizm yapıyoruz, bu aynı şey değil mi?” demek yanlıştır.  
> LSP bir *ilkedir*; polimorfizmin **nasıl doğru uygulanacağını** tarif eder:
> - Alt sınıf, üst sınıfın yerine geçebilir olmalı
> - Üst sınıfın beklenen davranışını değiştirmemeli

---

✅ **Kısa özet:**  
> Alt sınıflar, üst sınıfın yerine kullanılabilmeli ve beklenen şekilde çalışmalıdır.  
> Böylece sistem tutarlı, genişletilebilir ve bakım yapılabilir olur.

---