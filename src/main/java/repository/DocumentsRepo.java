package repository;

import entitiy.documents.Document;
import entitiy.staff.Person;

import java.util.List;

public interface DocumentsRepo {
    boolean create(Document document);
    Document read(Integer regNum);
    int update(Integer regNum, Person author);
    boolean delete(Integer regNum);
    List<Document> getDocuments();
    boolean documentListIsEmpty();
}
