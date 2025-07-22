## 🧩 Refactoring (Yeniden Yapılandırma)

- Var olan yazılımın **davranışını değiştirmeden**, **iç yapısını iyileştirme** işlemidir.
- Amaç:
  - Kodun okunabilirliğini artırmak,
  - Bakımını kolaylaştırmak,
  - Performansı iyileştirmek,
  - Kod tekrarını azaltmak,
  - Daha sürdürülebilir ve esnek bir yapı oluşturmaktır.

---

### 🧪 Yaygın Refactoring Yöntemleri

| Yöntem                         | Açıklama                                                   |
|-------------------------------|------------------------------------------------------------|
| **Extract Method**             | Uzun veya karmaşık bir metodu, anlamlı alt parçalara ayırmak. |
| **Rename Variable/Method**     | Anlamlı isimlendirme ile kodun okunabilirliğini artırmak.    |
| **Inline Method**              | Gereksiz küçük metotları kaldırmak ve çağrıldığı yere taşımak.|
| **Replace Temp with Query**    | Geçici değişkenleri fonksiyon çağrıları ile değiştirmek.      |
| **Introduce Parameter Object** | Çok sayıda parametreyi bir nesne içinde toplamak.             |
| **Move Method/Field**          | Metod veya alanı daha uygun sınıfa taşımak.                    |
| **Decompose Conditional**     | Karmaşık şart ifadelerini daha küçük ve anlaşılır hale getirmek.|
| **Encapsulate Field**          | Doğrudan değişkenlere erişimi sınırlayıp getter/setter kullanmak.|

---

