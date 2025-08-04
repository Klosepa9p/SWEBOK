public class NotificationService {
    // E-posta bildirim gönderimi (birinci yöntem)
    public void sendEmailNotification(String recipient, String message) {
        // E-posta protokolü ile doğrudan gönderim
        System.out.println("E-posta gönderildi: " + recipient + ", Mesaj: " + message);
    }

    // SMS bildirim gönderimi (farklı bir yöntem)
    public void sendSMS(String phoneNumber, String text) {
        // SMS API'si kullanarak gönderim
        String formattedText = "SMS: " + text;
        System.out.println("SMS gönderildi: " + phoneNumber + ", Mesaj: " + formattedText);
    }

    // Push bildirim gönderimi (başka bir yöntem)
    public void sendPushNotification(String userId, String notificationContent, String deviceType) {
        // Cihaza özgü push bildirimi
        if (deviceType.equals("Android")) {
            System.out.println("Android Push: " + userId + ", Mesaj: " + notificationContent);
        } else if (deviceType.equals("iOS")) {
            System.out.println("iOS Push: " + userId + ", Mesaj: " + notificationContent);
        }
    }
}

//Sorun: Yukarıdaki kodda, bildirim gönderme işlemi için üç farklı yöntem (e-posta, SMS, push) farklı yaklaşımlarla ve tutarsız arayüzlerle uygulanıyor. Her biri farklı parametreler alıyor ve farklı formatlama mantığı kullanıyor, bu da Oddball Solution kokusuna neden oluyor.