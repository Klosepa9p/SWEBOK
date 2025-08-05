// Şu an yalnızca tek ödeme tipi olduğundan interface'e gerek yok
public class CreditCardProcessor {
    public void processPayment(double amount) {
        System.out.println("Credit Card ile ödeme işlendi: " + amount);
    }
}

public class PaymentService {
    private CreditCardProcessor processor;

    public PaymentService(CreditCardProcessor processor) {
        this.processor = processor;
    }

    public void makePayment(double amount) {
        processor.processPayment(amount);
    }
}

/*
Açıklama:

- Gereksiz interface kaldırıldı.
- Kod sade, doğrudan ve anlaşılır hale geldi.
- Gerçekten yeni bir ödeme tipi eklendiğinde (örneğin PayPalProcessor), o zaman interface’e ihtiyaç olup olmadığı değerlendirilir.
- YAGNI (You Ain't Gonna Need It) ilkesi uygulanmış oldu.
*/