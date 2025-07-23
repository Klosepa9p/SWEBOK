## 🛡️ Encapsulation (Kapsülleme)

- **Encapsulation (kapsülleme)**, bir nesnenin iç detaylarını (veri ve işlemler) dış dünyadan gizler.
- Sadece belirlenen erişim yöntemleri (örneğin `get` ve `set` fonksiyonları) ile verilere erişilmesine izin verilir.
- Bu sayede:
  - Veri tutarlılığı ve güvenliği korunur.
  - Dış kod (*client*), nesnenin iç yapısının nasıl çalıştığını bilmek zorunda kalmaz.
- İç yapıda değişiklik yapılması gerektiğinde, dışarıya sunulan erişim arayüzü (`get`/`set`) aynı kalabildiği için:
  - Bakım ve değişiklik yapmak kolaylaşır.
  - Kodun yeniden kullanılabilirliği ve sürdürülebilirliği artar.
- `get` ve `set` fonksiyonlarının tek başına olması genellikle yeterli değildir:
  - Mantıksız veya hatalı değerlerin atanmasını engellemek için bu fonksiyonların içinde doğrulama (*validation*) yapılmalıdır.

> 📌 Bu prensip, yazılımda hem okunabilirliği hem de güvenilirliği artırır.
