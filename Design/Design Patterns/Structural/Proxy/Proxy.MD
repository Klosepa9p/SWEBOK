# 🧩 Proxy Design Pattern (Vekil Tasarım Deseni)

Oluşturduğumuz tasarımda bazı sınıfların, nesnelerin yahut işleyişlerin **sorumluluk ve süreçteki işlevsel hallerini bir başka nesne üzerinde kontrol edebilir** ve sorumluluğu bu nesneye yükleyebiliriz.  

Daha net bir ifadeyle, nesnelerin süreçteki **vekaletini** başka bir sınıfa devredebiliriz. 
---

## 🎯 Proxy Design Pattern (Proxy Tasarım Deseni)

Proxy Design Pattern; **Client tarafından erişilecek nesneye vekalet eden** bir tasarım desenidir.  
Burada vekaletten kasıt; ilgili nesneyi kontrol edecek bir **Proxy nesnesi** kullanmaktır.

---

## ✅ Proxy Design Pattern Nerede Kullanılır?

Üç farklı durumda kullanılır:

### 📡 Remote Proxy (Uzak Proxy)
- Uzak bir nesne kullanılacağı durumlarda tercih edilir.
- Uzaktaki nesneye local bir temsilci sağlar ve gerekli kontrolleri yapar.

### 🖼 Virtual Proxy
- Üretimi veya kullanımı maliyetli nesneler için tercih edilir.
- Örneğin; yüksek boyutlu bir resmin yüklenmesi zaman alıyorsa, önce “yükleniyor” görseli gösterilir, yükleme bitince gerçek resim gösterilir.

### 🛡 Protection Proxy
- Yetkilendirme veya login işlemleri gibi senaryolarda kullanılır.
- Belirli işlemleri sadece yetkili kullanıcıların yapabilmesini sağlar.

---

## 🧰 Proxy Pattern Temel Kavramları

| Terim           | Açıklama                                                                                       |
|-----------------|------------------------------------------------------------------------------------------------|
| **Client**      | Proxy üzerinden gerçek nesneye erişen istemci.                                                 |
| **Subject**     | Proxy ve Real Subject'in türediği interface veya abstract class.                               |
| **Real Subject**| Asıl işlemleri yapan gerçek nesne.                                                              |
| **Proxy**       | Gerçek nesneye erişimi kontrol eden vekil nesne; istemci gerçek nesneye doğrudan değil, proxy üzerinden ulaşır. |

---

## ✏️ Özet

Proxy Design Pattern;  
- Gerçek nesneye erişimi **dolaylı hale getirerek** kontrol imkânı sağlar.
- Güvenlik, performans, gecikmeli yükleme veya uzaktan erişim gibi senaryolarda kullanılır.
- Client’ın gerçek nesneye erişimini bir **vekil sınıf (proxy)** aracılığıyla yönetir.

---

