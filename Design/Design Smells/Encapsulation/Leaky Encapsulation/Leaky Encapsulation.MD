# Leaky Encapsulation

## 🔍 Nedir?

**Leaky Encapsulation**, bir nesne ya da sınıfın iç detaylarının istemeden dışarıya sızmasıdır.  
Bu durum, dış bileşenlerin o iç detaylara doğrudan bağımlı hale gelmesine neden olur.  
Yani sınıfın içsel karmaşıklığı kullanıcıya yansır.

Sıklıkla şunlarla ortaya çıkar:
- İç veri yapılarının doğrudan döndürülmesi (örneğin: bir liste referansının verilmesi)
- API'lerin, veri yapısının iç organizasyonuna bağlı şekilde tasarlanması
- İç mantığın dış davranışa etki etmesi

---

## 🚫 Neden Kötüdür?

- 🔗 **Sıkı bağımlılık oluşturur**: Dış kod, sınıfın iç yapısına bağımlı hale gelir.
- 🔄 **Değişiklik maliyetini artırır**: İç yapıda yapılan bir değişiklik dışarıdaki birçok bileşeni kırabilir.
- 📉 **Kapsülleme ilkesini ihlal eder**: Nesnelerin içsel durumunu soyutlayarak koruma prensibi bozulur.
- 🧩 **Kodun yeniden kullanılabilirliğini azaltır**: Başka bağlamlarda kullanmak zorlaşır.

---

## ✅ Çözüm Yaklaşımı

- 🧱 İç yapıları döndürmek yerine, koruyucu kopyalar veya soyut arayüzler sun.
- 🚧 İç detaylara doğrudan erişimi engelle, yalnızca gerekli işlemler için yöntemler sağla.
- ✂️ İç ve dış sorumlulukları kesin çizgilerle ayır.
- 🔍 API tasarımında dış kullanıcıyı iç organizasyona maruz bırakmaktan kaçın.

---

## 📚 Gerçek Hayattan Analoji

Bir restoranın mutfağı, müşterilerin görebileceği şekilde açıkta olsa ve müşteriler doğrudan mutfak malzemelerine ulaşabiliyor olsa…  
Bu durumda hem hijyen hem iş akışı tehlikeye girer.

İyi bir restoran, mutfağını kapalı tutar ve sadece siparişi müşteriye servis eder.  
Aynı şekilde, iyi kapsülleme, içsel mantığı gizler ve sadece gereken işlevi dışarıya verir.
