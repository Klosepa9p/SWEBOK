public class UserManager {
    public void saveUser(String userId, String userName, int age) {
        validateUser(userId, userName);
        saveToDatabase(userId, userName, age);
        sendNotification("Kullanıcı kaydedildi: " + userName);
    }

    private void validateUser(String userId, String userName) {
        if (userId == null || userName == null) {
            throw new IllegalArgumentException("Geçersiz kullanıcı bilgisi");
        }
    }

    private void saveToDatabase(String userId, String userName, int age) {
        Database.saveUser(userId, userName, age);
    }

    private void sendNotification(String message) {
        NotificationService.sendMessage(message);
    }
}

class Database {
    public static void saveUser(String userId, String userName, int age) {
        System.out.println("Kullanıcı kaydedildi: ID=" + userId + ", İsim=" + userName + ", Yaş=" + age);
    }
}

class NotificationService {
    public static void sendMessage(String message) {
        System.out.println("Bildirim: " + message);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Inconsistency sorunu şu şekilde giderildi:

İsimlendirme Tutarlılığı: Tüm metodlar ve sınıflar camelCase kullanıyor (örneğin, saveUser, saveToDatabase, sendMessage).
UserManager, Database ve NotificationService sınıflarında tutarlı isimlendirme sağlandı.

Parametre İsimleri: user_id ve UserName yerine userId ve userName gibi tutarlı ve açıklayıcı isimler kullanıldı.

Dil Tutarlılığı: Hata mesajları ve bildirimler tamamen Türkçe yapıldı (örneğin, "Geçersiz kullanıcı bilgisi",
"Kullanıcı kaydedildi").

Metod Yapıları: Benzer işlemler (kayıt ve bildirim) tutarlı metod isimleri ve yapılarla uygulandı (örneğin,
saveUser ve saveToDatabase).

Metod Bölme: Kod, tek sorumluluğa sahip metodlara ayrıldı (validateUser, saveToDatabase, sendNotification),
bu da okunabilirliği artırdı.

Bu değişiklikler, kodun tutarlılığını, okunabilirliğini ve bakım kolaylığını artırdı. Kod tabanı artık daha profesyonel
ve ekip üyeleri için anlaşılır bir yapıya sahip.
*/