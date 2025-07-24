#include <iostream>
#include <string>
using namespace std;

class Metadata {
public:
    string author;
    int version;

    Metadata(string author, int version)
        : author(author), version(version) {}

    Metadata* clone() const {
        return new Metadata(author, version);
    }
};

class Document {
private:
    string content;
    Metadata* metadata;
    bool ownsMetadata;

public:
    Document(const string& content, Metadata* metadata, bool owns = true)
        : content(content), metadata(metadata), ownsMetadata(owns) {}

    // Shallow copy: sadece pointer kopyalanır, sahiplik yok
    Document* shallowClone() const {
        return new Document(content, metadata, false);
    }

    // Deep copy: Metadata da kopyalanır, sahiplik var
    Document* deepClone() const {
        return new Document(content, metadata->clone(), true);
    }

    void setAuthor(const string& author) {
        metadata->author = author;
    }

    void setVersion(int version) {
        metadata->version = version;
    }

    void show() const {
        cout << "Content: " << content
             << " | Author: " << metadata->author
             << " | Version: " << metadata->version << endl;
    }

    ~Document() {
        if (ownsMetadata) {
            delete metadata;
        }
    }
};

int main() {
    Metadata* meta = new Metadata("Alice", 1);
    Document* original = new Document("Design Patterns Guide", meta);

    cout << "=== Orijinal ===" << endl;
    original->show();

    Document* shallow = original->shallowClone();
    Document* deep = original->deepClone();

    cout << "\n=== Clone'ları oluşturduktan sonra ===" << endl;
    shallow->show();
    deep->show();

    original->setAuthor("Bob");
    original->setVersion(2);

    cout << "\n=== Orijinali değiştirdikten sonra ===" << endl;
    cout << "Orijinal: "; original->show();
    cout << "Shallow:  "; shallow->show();
    cout << "Deep:     "; deep->show();

    delete original;
    delete shallow;
    delete deep;

    return 0;
}
