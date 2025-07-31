## 🔄 Introduce Foreign Method Yöntemi

### 🐞 Problem

- Bir sınıf, başka bir sınıfın (örneğin yardımcı veya utility sınıf) nesnesine sık sık belirli bir işlem yapması gerekiyor ancak bunu kendi içinde gerçekleştiremiyor.  
- Bu durum kodda tekrar ve dağınıklık yaratabilir.  
- Hedef sınıfa yeni bir metot eklemek mümkün değilse (örneğin, sınıf üçüncü taraf bir kütüphane veya dışa kapalı kodsa), iş mantığı istemci sınıfta dağınık halde kalır.

---

### ✅ Çözüm

- İlgili işlemi, **istemci sınıf** içinde bir metot olarak tanımlayın.  
- Bu metot, yabancı sınıfın nesnesini kullanarak iş mantığını uygular.  
- Böylece metot, istemci sınıfın parçası gibi görünür ancak aslında yabancı sınıfın verilerini işler.

---

### 🌱 Faydaları

- Kod daha düzenli, organize ve okunabilir olur.  
- Tekrarlayan mantık tek bir metotta toplanır.  
- İstemci sınıf, yabancı sınıfın iç detaylarından soyutlanır.

---

### 🛠️ Nasıl Uygulanır

1. Yabancı sınıfın nesnesine sıkça yapılan işlemi belirleyin.  
2. İstemci sınıfta, bu işlemi gerçekleştiren yeni bir metot oluşturun.  
3. Metodu, yabancı sınıf nesnesini parametre olarak alacak veya erişecek şekilde tasarlayın.  
4. İstemci kodundaki ilgili işlemi, yeni metot çağrısıyla değiştirin.  
5. Kodu test ederek doğruluğunu teyit edin.
 