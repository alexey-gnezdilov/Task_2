package repository;

import entitiy.documents.Document;
import entitiy.staff.Person;

import java.util.List;

public interface DocumentsRepo {
    boolean create(Document document);
    Document read(Integer registrationNumber);
    int update(Integer registrationNumber, Person documentAuthor);
    boolean delete(Integer registrationNumber);
    List<Document> getDocuments();
    boolean documentListIsEmpty();
}
