package service.docservices;

import entitiy.documents.Document;
import entitiy.documents.Incoming;
import entitiy.documents.Outgoing;
import entitiy.documents.Task;

public interface DocumentFactory {
    <T extends Document> T generateDocument(Class<T> aClass);
    Task createTask();
    Incoming createIncoming();
    Outgoing createOutgoing();
}
