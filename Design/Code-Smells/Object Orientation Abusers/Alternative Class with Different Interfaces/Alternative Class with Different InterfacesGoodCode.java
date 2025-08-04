public interface Notifier {
    void sendNotification(String recipient, String message);
}

public class EmailNotifier implements Notifier {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("E-posta gönderildi: " + recipient + ", Mesaj: " + message);
    }
}

public class SMSNotifier implements Notifier {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("SMS gönderildi: " + recipient + ", Mesaj: " + message);
    }
}

public class PushNotifier implements Notifier {
    private final String device;

    public PushNotifier(String device) {
        this.device = device;
    }

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Push bildirimi gönderildi: " + recipient + ", Cihaz: " + device + ", Mesaj: " + message);
    }
}

public class NotificationManager {
    public void sendNotification(Notifier notifier, String recipient, String message) {
        notifier.sendNotification(recipient, message);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifier();
        Notifier pushNotifier = new PushNotifier("Android");

        manager.sendNotification(emailNotifier, "user@example.com", "Merhaba!");
        manager.sendNotification(smsNotifier, "+1234567890", "Merhaba!");
        manager.sendNotification(pushNotifier, "user123", "Merhaba!");
    }
}

/*

Açıklama: Düzeltilmiş kodda, Alternative Class with Different Interfaces sorunu şu şekilde giderildi:

Ortak Arayüz: Notifier adında bir arayüz tanımlandı ve tüm bildirim sınıfları (EmailNotifier, SMSNotifier, PushNotifier)
bu arayüzü uyguladı. Bu, metod imzasını (sendNotification) tutarlı hale getirdi.

Tutarlı İsimlendirme: Metod isimleri ve parametreler tüm sınıflarda aynı oldu, böylece arayüzler birleştirildi.

Kapsülleme: PushNotifier için cihaz bilgisi, constructor aracılığıyla kapsüllendi ve sendNotification metodunun imzası
diğer sınıflarla uyumlu hale getirildi.

Koşullu İfadelerin Kaldırılması: NotificationManager, koşullu ifadeler yerine doğrudan Notifier arayüzünü kullanarak
bildirim gönderiyor, bu da kodu sadeleştirdi.

Genişletilebilirlik: Yeni bir bildirim türü eklendiğinde, sadece Notifier arayüzünü uygulayan yeni bir sınıf yazmak yeterli.

Bu değişiklikler, kodun okunabilirliğini, bakım kolaylığını ve genişletilebilirliğini artırdı. Farklı arayüzlere sahip
alternatif sınıflar yerine, tutarlı bir arayüz kullanılarak Alternative Class with Different Interfaces code smell'i
ortadan kaldırıldı.

*/