package databaseInMemory;

import entitiy.documents.Document;
import java.util.ArrayList;
import java.util.List;

public class DocumentsDatabase {
    private final List<Document> documents;

    public DocumentsDatabase() { documents = new ArrayList<>(); }

    public List<Document> getDocuments() {
        return documents;
    }
}
