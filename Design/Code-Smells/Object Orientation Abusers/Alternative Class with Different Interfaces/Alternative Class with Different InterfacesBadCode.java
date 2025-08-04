public class EmailNotifier {
    public void notifyUser(String recipient, String messageContent) {
        System.out.println("E-posta gönderildi: " + recipient + ", Mesaj: " + messageContent);
    }
}

public class SMSNotifier {
    public void sendSMS(String phone, String text) {
        System.out.println("SMS gönderildi: " + phone + ", Mesaj: " + text);
    }
}

public class PushNotificationService {
    public void push(String userId, String notification, String device) {
        System.out.println("Push bildirimi gönderildi: " + userId + ", Cihaz: " + device + ", Mesaj: " + notification);
    }
}

public class NotificationManager {
    public void sendNotification(String type, String recipient, String message, String device) {
        if (type.equals("email")) {
            EmailNotifier email = new EmailNotifier();
            email.notifyUser(recipient, message);
        } else if (type.equals("sms")) {
            SMSNotifier sms = new SMSNotifier();
            sms.sendSMS(recipient, message);
        } else if (type.equals("push")) {
            PushNotificationService push = new PushNotificationService();
            push.push(recipient, message, device);
        }
    }
}

/*

Sorun: Yukarıdaki kodda, EmailNotifier, SMSNotifier ve PushNotificationService sınıfları aynı işlevi (bildirim gönderme)
yerine getiriyor, ancak farklı arayüzlere sahip:

Metod isimleri tutarsız: notifyUser, sendSMS, push.

Parametreler farklı: PushNotificationService ek bir device parametresi alıyor.

NotificationManager sınıfı, bu farklı arayüzleri yönetmek için koşullu ifadeler kullanıyor, bu da kod karmaşıklığını
artırıyor. Bu, Alternative Class with Different Interfaces kokusuna neden oluyor ve kodun okunabilirliğini, bakımını ve
genişletilebilirliğini zorlaştırıyor.

*/