public class DocumentProcessor {
    private String documentContent;
    private boolean isValidated;
    private boolean isFormatted;

    public void loadDocument(String content) {
        this.documentContent = content;
        this.isValidated = false;
        this.isFormatted = false;
    }

    public void validateDocument() {
        if (documentContent == null) {
            throw new IllegalStateException("Doküman yüklenmedi");
        }
        // Doğrulama mantığı
        this.isValidated = true;
        System.out.println("Doküman doğrulandı");
    }

    public void formatDocument() {
        if (!isValidated) {
            throw new IllegalStateException("Doküman önce doğrulanmalı");
        }
        // Formatlama mantığı
        this.isFormatted = true;
        System.out.println("Doküman formatlandı");
    }

    public void saveDocument() {
        if (!isFormatted) {
            throw new IllegalStateException("Doküman önce formatlanmalı");
        }
        // Kaydetme mantığı
        Database.saveDocument(documentContent);
        System.out.println("Doküman kaydedildi");
    }
}

class Database {
    public static void saveDocument(String content) {
        System.out.println("Doküman kaydedildi: " + content);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        DocumentProcessor processor = new DocumentProcessor();
        processor.formatDocument(); // Hata: Doküman yüklenmedi veya doğrulanmadı
        processor.loadDocument("Örnek içerik");
        processor.saveDocument(); // Hata: Doküman doğrulanmadı ve formatlanmadı
    }
}

/*
Sorun: Yukarıdaki kodda, DocumentProcessor sınıfı gizli zamansal bağımlılıklar içeriyor:

- Metodlar (loadDocument, validateDocument, formatDocument, saveDocument) belirli bir sırayla çağrılmalı: önce loadDocument, sonra validateDocument, ardından formatDocument ve son olarak saveDocument.
- Bu sıralama, kodda veya belgelerde açıkça belirtilmemiş, sadece hata fırlatma yoluyla zorlanıyor.
- Geliştiriciler, metodları yanlış sırayla çağırdığında hatalarla karşılaşır, bu da kodun kullanımını zorlaştırır ve hata olasılığını artırır.
*/