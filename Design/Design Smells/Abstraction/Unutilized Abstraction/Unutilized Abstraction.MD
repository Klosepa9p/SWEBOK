# Unutilized Abstraction

## 🔍 Nedir?

**Unutilized Abstraction**, bir yazılım bileşeni için tasarlanmış soyutlamaların (sınıf, arayüz, yapı vb.) hiç kullanılmaması veya sistemin geri kalanıyla bağlantısız kalmasıdır.

Bu genellikle “ihtiyaç duyulacak” varsayımıyla yazılan ama sonradan bağlam dışında kalan yapılarda görülür. Yazılmış ama çağrılmayan sınıflar, implement edilmeyen arayüzler bu duruma örnektir.

---

## 🚫 Neden Kötüdür?

- 🧱 **Kod tabanını şişirir**: Gereksiz dosyalar, yapılar, sınıflar proje karmaşıklığını artırır.
- 🔍 **Kodun okunabilirliğini düşürür**: Başka bir geliştirici bu soyutlamaların niye var olduğunu anlamaya çalışır.
- 🐌 **Bakımı zorlaştırır**: Kullanılmayan ama sistemde duran yapılar, silinmeye korkulan “ölü kod” hâline gelir.
- ⏳ **Zaman kaybıdır**: Yazılması ve korunması emek ister, ama hiçbir işe yaramaz.

---

## ✅ Çözüm Yaklaşımı

- 🧽 Kullanılmayan soyutlamaları **düzenli kod temizliği** (code cleanup) süreçlerinde tespit edip kaldır.
- 📦 Kod incelemelerinde “bu yapı gerçekten kullanılıyor mu?” sorusunu sor.
- 🧪 Test kapsamı kontrol edilirken **kullanılmayan yolları** ayıkla.
- 🚫 Önceden değil, gerçekten ihtiyaç ortaya çıktığında soyutlama yap.

---

## 📚 Gerçek Hayattan Analoji

Bir evde hiç kullanılmayan ama tüm odayı kaplayan bir spor aleti düşün. Belki bir gün kullanırım diye alınmış ama ne kurulmuş ne de çalıştırılmış.  
Orada durur, yer kaplar, evi daraltır ve sonunda üzerine çamaşır asılır.

Bu da yazılımdaki kullanılmayan soyutlamalar gibidir:  
**“Kodun içinde ama işlevin dışında.”**
