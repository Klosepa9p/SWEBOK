public class UserManager {
    // Kullanıcıyı kaydet
    public void SaveUser(String user_id, String UserName, int age) { // Tutarsız isimlendirme: PascalCase ve snake_case
        if (user_id == null || UserName == null) {
            throw new IllegalArgumentException("Invalid user data"); // İngilizce hata mesajı
        }
        save_to_database(user_id, UserName, age); // Alt çizgi kullanımı
    }

    // Veritabanına kaydet
    private void save_to_database(String id, String name, int userAge) {
        DB.store(id, name, userAge); // Farklı metod ismi ve parametre sırası
        send_notification("Kullanıcı kaydedildi: " + name); // Türkçe bildirim
    }

    // Bildirim gönder
    public void send_notification(String message) {
        NotificationService.SendMsg(message); // Tutarsız isimlendirme: SendMsg
    }
}

class DB {
    public static void store(String id, String name, int age) {
        System.out.println("Kullanıcı kaydedildi: ID=" + id + ", İsim=" + name + ", Yaş=" + age);
    }
}

class NotificationService {
    public static void SendMsg(String msg) { // Tutarsız: PascalCase
        System.out.println("Bildirim: " + msg);
    }
}

/*
Sorun: Yukarıdaki kodda birden fazla tutarsızlık var:

İsimlendirme: SaveUser (PascalCase), save_to_database (snake_case) ve send_notification (alt çizgi) farklı isimlendirme
kurallarını kullanıyor.

Parametre İsimleri: user_id ve UserName gibi tutarsız isimlendirmeler (karışık case kullanımı).

Hata Mesajları: Hata mesajları İngilizce (Invalid user data), bildirimler ise Türkçe (Kullanıcı kaydedildi),
bu da dilde tutarsızlık yaratıyor.

Metod Yapıları: Benzer işlemler (kayıt ve bildirim) farklı yaklaşımlarla ve tutarsız metod isimleriyle uygulanıyor.
Bu tutarsızlıklar, kodun anlaşılmasını ve bakımını zorlaştırıyor.
*/