 🧩 Upcasting

- Türemiş (*derived / sub*) sınıf, ana (*base / super*) sınıfın tüm özelliklerini ve metotlarını barındırır.
- Bu nedenle türemiş sınıf nesnesi, ana sınıf tipinde bir referans veya işaretçi ile tutulabilir.
- **Ana sınıf tipinde tanımlanırsa hata olmaz**, çünkü alt sınıf, ana sınıfın tüm üyelerine sahiptir (*is-a ilişkisi*).
- Güvenli ve yaygın bir işlemdir.
- Kodun esnekliğini ve çok biçimliliği (polymorphism) sağlar.

- Compile time’da olur (statik).
- Otomatik (implicit) yapılır.
- Derleyici, alt sınıfın zaten üst sınıfı kapsadığını bildiği için, bu dönüşümü hemen yapar.
