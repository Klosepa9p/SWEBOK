public class NotificationService {
    public void sendNotification(Notification notification) {
        notification.send();
    }
}

interface Notification {
    void send();
}

class EmailNotification implements Notification {
    private final String recipient;
    private final String message;

    public EmailNotification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("E-posta gönderildi: " + recipient + ", Mesaj: " + message);
    }
}

class SMSNotification implements Notification {
    private final String phoneNumber;
    private final String message;

    public SMSNotification(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("SMS gönderildi: " + phoneNumber + ", Mesaj: " + message);
    }
}

class PushNotification implements Notification {
    private final String userId;
    private final String message;
    private final String deviceType;

    public PushNotification(String userId, String message, String deviceType) {
        this.userId = userId;
        this.message = message;
        this.deviceType = deviceType;
    }

    @Override
    public void send() {
        System.out.println(deviceType + " Push: " + userId + ", Mesaj: " + message);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        
        Notification email = new EmailNotification("user@example.com", "Merhaba!");
        Notification sms = new SMSNotification("+1234567890", "Merhaba!");
        Notification push = new PushNotification("user123", "Merhaba!", "Android");

        service.sendNotification(email);
        service.sendNotification(sms);
        service.sendNotification(push);
    }
}


//Açıklama: Düzeltilmiş kodda, bildirim gönderme işlemi için ortak bir Notification arayüzü tanımlandı ve her bildirim türü (e-posta, SMS, push) bu arayüzü uygulayan ayrı sınıflarla temsil edildi. NotificationService sınıfı, yalnızca Notification arayüzünü kabul ederek tutarlı bir şekilde tüm bildirim türlerini işler. Bu, Strateji Deseni kullanılarak Oddball Solution kokusunun ortadan kaldırılmasını sağlar. Kod artık daha tutarlı, genişletilebilir ve bakımı kolay hale geldi. Yeni bir bildirim türü eklendiğinde, sadece yeni bir sınıf oluşturularak sistem genişletilebilir.