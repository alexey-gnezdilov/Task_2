package repository.impl;

import databaseInMemory.DocumentsDatabase;
import entitiy.documents.Document;
import entitiy.staff.Person;
import repository.DocumentsRepo;

import java.util.List;

public class DocumentsRepoImpl implements DocumentsRepo {

    private final DocumentsDatabase documentsDatabase;

    public DocumentsRepoImpl() {
        documentsDatabase = new DocumentsDatabase();
    }

    @Override
    public boolean create(Document document) {
        return documentsDatabase.getDocuments().add(document);
    }

    @Override
    public Document read(Integer registrationNumber) {
        return documentsDatabase.getDocuments()
                .stream()
                .filter(doc -> doc.getRegistrationNumber().equals(registrationNumber))
                .findAny()
                .orElse(null);
    }

    @Override
    public int update(Integer registrationNumber, Person documentAuthor) {
        read(registrationNumber).setDocumentAuthor(documentAuthor);
        return 1;
    }

    @Override
    public boolean delete(Integer registrationNumber) {
        return documentsDatabase.getDocuments().removeIf(doc -> doc.getRegistrationNumber().equals(registrationNumber));
    }

    @Override
    public List<Document> getDocuments() {
        return documentsDatabase.getDocuments();
    }

    @Override
    public boolean documentListIsEmpty() {
        return documentsDatabase.getDocuments().isEmpty();
    }

}