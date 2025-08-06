# Cyclically Dependent Modularisation

## 🔍 Nedir?

**Cyclically Dependent Modularisation**, yazılım modüllerinin birbirlerine döngüsel olarak bağımlı olması durumudur.  
Yani modüller arasında A → B → C → A gibi bir bağımlılık döngüsü vardır ve bu modüller birbirinden bağımsız çalışamaz.

---

## 🚫 Neden Kötüdür?

- 🔄 **Derleme ve çalışma sorunları**: Döngüsel bağımlılıklar derleyici ve çalışma zamanında hatalara yol açabilir.
- 🧩 **Tasarım karmaşası**: Modüller arasındaki sorumluluklar belirsizleşir.
- 🛠️ **Bakım ve test zorluğu**: Modüllerin bağımsız test edilmesi zorlaşır.
- 📉 **Yeniden kullanım azalır**: Bağımlılıklar nedeniyle modüller başka projelerde kolayca kullanılamaz.
- ⚠️ **Sistem esnekliğini azaltır**: Değişikliklerin etkisi yaygın ve öngörülemez olur.

---

## ✅ Çözüm Yaklaşımı

- Bağımlılıkları analiz ederek döngüleri tespit et.
- Modüller arasındaki sorumlulukları netleştir ve bağımlılıkları minimize et.
- Arayüzler ve soyutlamalar kullanarak bağımlılık yönünü tek taraflı yap.
- Tasarımı yeniden organize ederek döngüleri kır.
- Gerektiğinde modülleri yeniden yapılandır ve böl.

---

## 📚 Gerçek Hayattan Analoji

Üç departmanın birbirinin işine sürekli karışması ve kararları birbirine bağlaması gibidir.  
A departmanı B’den, B departmanı C’den, C departmanı tekrar A’dan izin almak zorunda kalırsa iş akışı durur ve verimsizleşir.

Bu durum organizasyonda kaosa neden olur; yazılımda da benzer şekilde karmaşaya yol açar.
