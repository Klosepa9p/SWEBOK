## 🧩 Downcasting

- Üst (*base / super*) sınıf tipindeki bir nesneyi, alt (*derived / sub*) sınıf tipine dönüştürmektir.
- Daha genel bir tipten, daha özel bir tipe dönüş yapıldığı için **manuel** olarak yapılmalıdır.
- Bu işlem **otomatik** (implicit) yapılmaz; `static_cast` veya `dynamic_cast` gibi explicit (açık) dönüşüm gerekir.
- Yanlış bir türde downcast, **tanımsız davranış (undefined behavior)** oluşturur veya exception fırlatabilir.


- Çoğu zaman runtime’da kontrol gerektirir.

- `dynamic_cast`  kullanıyorsan: runtime type information (RTTI) ile çalışır → runtime’da gerçek tipe bakar.

- `static_cast` kullanıyorsan: compile time’da olur, runtime kontrol yoktur → tehlikelidir.

### dynamic_cast nasıl fark yaratır?

- dynamic_cast runtime’da gerçek tipi kontrol eder.

- Eğer nesne gerçekten Child değilse, nullptr döner.

- Böylece yanlış kullanımı engeller.
---