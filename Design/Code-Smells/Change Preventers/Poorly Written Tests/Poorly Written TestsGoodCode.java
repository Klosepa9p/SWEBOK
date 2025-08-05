import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

public class OrderProcessorTest {
    private final Database database = Mockito.mock(Database.class);
    private final OrderProcessor processor = new OrderProcessor(database);

    @Test
    public void shouldApplyVIPDiscountAndTax() {
        // Arrange
        String orderId = "123";
        double amount = 1000;
        boolean isVIP = true;
        double expectedAmount = 1000 * 0.9 * 1.18; // %10 indirim + %18 KDV

        // Act
        double result = processor.processOrder(orderId, amount, isVIP);

        // Assert
        assertEquals(expectedAmount, result, 0.01);
    }

    @Test
    public void shouldSaveOrderToDatabase() {
        // Arrange
        String orderId = "123";
        double amount = 1000;
        boolean isVIP = true;
        double finalAmount = 1000 * 0.9 * 1.18;

        // Act
        processor.processOrder(orderId, amount, isVIP);

        // Assert
        Mockito.verify(database).saveOrder(orderId, finalAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForInvalidOrderId() {
        // Arrange
        String orderId = null;
        double amount = 1000;
        boolean isVIP = true;

        // Act
        processor.processOrder(orderId, amount, isVIP);
    }
}

class OrderProcessor {
    private final Database database;

    public OrderProcessor(Database database) {
        this.database = database;
    }

    public double processOrder(String orderId, double amount, boolean isVIP) {
        if (orderId == null) {
            throw new IllegalArgumentException("Geçersiz sipariş kimliği");
        }
        double finalAmount = amount;
        if (isVIP) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * 0.18; // %18 KDV
        database.saveOrder(orderId, finalAmount);
        return finalAmount;
    }
}

interface Database {
    void saveOrder(String orderId, double amount);
}

/*
Açıklama: Düzeltilmiş kodda, Poorly Written Tests sorunu şu şekilde giderildi:

- Anlamlı İsimlendirme: Test metodları, neyi test ettiklerini açıkça ifade eden isimlerle adlandırıldı (örneğin, shouldApplyVIPDiscountAndTax, shouldSaveOrderToDatabase).
- Tek Sorumluluk İlkesi: Her test, tek bir davranışı doğruluyor (indirim ve vergi hesaplama, veritabanına kaydetme, hata durumu).
- AAA Deseni: Testler, Arrange-Act-Assert yapısına uygun şekilde organize edildi, bu da okunabilirliği artırdı.
- Bağımlılık İzolasyonu: Gerçek Database yerine bir mock nesne (Mockito ile) kullanıldı, bu da testlerin hızlı ve izole olmasını sağladı.
- Sade Test Verileri: Sert kodlanmış 1080 yerine, hesaplama açıkça ifade edildi (1000 * 0.9 * 1.18), bu da testin mantığını netleştirdi.
- Kapsamlılık: Farklı senaryolar (başarılı işlem, veritabanı kaydı, hata durumu) ayrı testlerle kapsandı.

Bu değişiklikler, testlerin okunabilirliğini, bakım kolaylığını ve güvenilirliğini artırdı. Kötü yazılmış testler yerine, net, odaklanmış ve izole testler yazılarak Poorly Written Tests code smell'i ortadan kaldırıldı.
*/