public class DatabaseConnection implements AutoCloseable {
    private final Connection conn;

    public DatabaseConnection(String url, String user, String password) {
        // Constructor içinde bağlantıyı otomatik başlat
        this.conn = DriverManager.getConnection(url, user, password);
    }

    public void executeQuery(String query) {
        // Bağlantı zaten başlatıldığı için ek kontrol gerekmez
        System.out.println("Sorgu çalıştırıldı: " + query);
    }

    @Override
    public void close() {
        // AutoCloseable ile bağlantıyı otomatik kapat
        if (conn != null) {
            conn.close();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // try-with-resources ile otomatik setup ve teardown
        try (DatabaseConnection db = new DatabaseConnection("jdbc:mysql://localhost:3306/test", "user", "pass")) {
            db.executeQuery("SELECT * FROM users");
        } // close() otomatik olarak çağrılır
    }
}



//Açıklama: Düzeltilmiş kodda, DatabaseConnection sınıfı AutoCloseable arayüzünü uyguluyor ve bağlantı başlatma işlemi constructor içinde gerçekleştiriliyor. Bu, setup işleminin manuel olarak yapılmasını gereksiz kılıyor. Ayrıca, try-with-resources yapısı kullanılarak close metodu otomatik olarak çağrılıyor, böylece teardown işlemi de garantileniyor. Bu yaklaşım, hem hata olasılığını azaltıyor hem de kodu daha temiz ve güvenli hale getiriyor. Geliştiricinin manuel olarak setup/teardown yapması gerekmediği için kullanım kolaylaşıyor ve kapsülleme korunuyor.