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
    public Document read(Integer regNum) {
        return documentsDatabase.getDocuments()
                .stream()
                .filter(doc -> doc.getRegistrationNumber().equals(regNum))
                .findAny()
                .orElse(null);
    }

    @Override
    public int update(Integer regNum, Person author) {
        read(regNum).setAuthor(author);
        return 1;
    }

    @Override
    public boolean delete(Integer regNum) {
        return documentsDatabase.getDocuments().removeIf(doc -> doc.getRegistrationNumber().equals(regNum));
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