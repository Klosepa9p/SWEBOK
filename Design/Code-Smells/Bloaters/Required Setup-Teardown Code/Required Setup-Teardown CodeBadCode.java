public class DatabaseConnection {
    private Connection conn;
    private boolean isInitialized;

    public void connect(String url, String user, String password) {
        // Bağlantıyı manuel olarak başlat
        conn = DriverManager.getConnection(url, user, password);
        isInitialized = true;
    }

    public void executeQuery(String query) {
        if (!isInitialized) {
            throw new IllegalStateException("Bağlantı başlatılmadı!");
        }
        // Sorguyu çalıştır
        System.out.println("Sorgu çalıştırıldı: " + query);
    }

    public void close() {
        // Bağlantıyı manuel olarak kapat
        if (conn != null) {
            conn.close();
            isInitialized = false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        // Setup kodu manuel olarak çağrılmalı
        db.connect("jdbc:mysql://localhost:3306/test", "user", "pass");
        db.executeQuery("SELECT * FROM users");
        // Teardown kodu manuel olarak çağrılmalı
        db.close();
    }
}

//Sorun: DatabaseConnection sınıfı, kullanılmadan önce connect metodunun çağrılmasını ve iş bittikten sonra close metodunun manuel olarak çağrılmasını gerektiriyor. Eğer geliştirici bu adımları unutursa, bağlantı başlatılmadan kullanılmaya çalışılabilir veya açık bağlantılar sızabilir (resource leak).

