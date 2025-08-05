public class DocumentProcessor {
    private String documentContent;
    private boolean isValidated;
    private boolean isFormatted;

    private DocumentProcessor() {
        this.isValidated = false;
        this.isFormatted = false;
    }

    public static DocumentProcessor loadDocument(String content) {
        if (content == null) {
            throw new IllegalArgumentException("Doküman içeriği boş olamaz");
        }
        DocumentProcessor processor = new DocumentProcessor();
        processor.documentContent = content;
        return processor;
    }

    public DocumentProcessor validateDocument() {
        if (documentContent == null) {
            throw new IllegalStateException("Doküman yüklenmedi");
        }
        // Doğrulama mantığı
        this.isValidated = true;
        System.out.println("Doküman doğrulandı");
        return this;
    }

    public DocumentProcessor formatDocument() {
        if (!isValidated) {
            throw new IllegalStateException("Doküman önce doğrulanmalı");
        }
        // Formatlama mantığı
        this.isFormatted = true;
        System.out.println("Doküman formatlandı");
        return this;
    }

    public void saveDocument() {
        if (!isFormatted) {
            throw new IllegalStateException("Doküman önce formatlanmalı");
        }
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
        DocumentProcessor processor = DocumentProcessor.loadDocument("Örnek içerik")
            .validateDocument()
            .formatDocument();
        processor.saveDocument();
    }
}

/*
Açıklama: Düzeltilmiş kodda, Hidden Temporal Coupling sorunu şu şekilde giderildi:

- Fluent Arayüz: Metodlar (validateDocument, formatDocument), kendilerini döndürerek metod zincirleme (method chaining) kullanımına olanak tanıyor. Bu, doğru sırayı teşvik eder.
- Statik Fabrika Metodu: loadDocument bir statik fabrika metodu olarak tanımlandı, böylece nesne oluşturma ve ilk adım açıkça bağlandı.
- Zamansal Bağımlılığı Açık Hale Getirme: Metod zincirleme, geliştiricinin metodları doğru sırayla çağırmasını doğal bir şekilde teşvik ediyor.
- Durum Kontrolü: Hala hata kontrolleri mevcut, ancak zincirleme yapı, yanlış sıralama olasılığını azaltıyor.
- Dokümantasyon İyileştirmesi: Kodun yapısı, kullanım sırasını kendi kendine açıklar hale geldi, bu da ek belgeleme ihtiyacını azalttı.

Bu değişiklikler, kodun okunabilirliğini, kullanım kolaylığını ve güvenilirliğini artırdı. Zamansal bağımlılıklar açık hale getirilerek Hidden Temporal Coupling code smell'i ortadan kaldırıldı.
*/

