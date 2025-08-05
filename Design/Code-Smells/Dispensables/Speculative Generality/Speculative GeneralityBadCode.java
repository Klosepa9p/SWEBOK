// Henüz yalnızca bir sınıf varken interface tanımlanmış
interface PaymentProcessor {
    void processPayment(double amount);
}

public class CreditCardProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Credit Card ile ödeme işlendi: " + amount);
    }
}

// Sadece tek bir ödeme yöntemi olduğu halde interface'e ihtiyaç yok
public class PaymentService {
    private PaymentProcessor processor;

    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void makePayment(double amount) {
        processor.processPayment(amount);
    }
}

/*
Açıklama:

Bu örnekte:
- PaymentProcessor interface’i yalnızca bir concrete sınıf (CreditCardProcessor) tarafından implement edilmiş.
- Henüz başka bir ödeme tipi (PayPal, Crypto vs.) yokken interface tanımlanmış.
- Bu, spekülatif bir soyutlama örneğidir çünkü henüz ihtiyaç yokken gelecekte lazım olur diye eklenmiş.
- Gereksiz yere bir abstraction layer (katman) oluşturulmuş.
*/