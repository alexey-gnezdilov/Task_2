package service.docservices.impl;

import entitiy.documents.Document;
import entitiy.documents.Incoming;
import entitiy.documents.Outgoing;
import entitiy.documents.Task;
import entitiy.staff.Department;
import entitiy.staff.Organization;
import entitiy.staff.Person;
import service.docservices.DocumentFactory;
import manager.Manager;
import org.apache.commons.lang3.RandomUtils;
import java.time.LocalDate;
import java.util.UUID;

public class DocumentFactoryImpl implements DocumentFactory {

    @Override
    @SuppressWarnings({"unchecked"})
    public <T extends Document> T generateDocument(Class<T> aClass) {
        if (aClass == Task.class) {
            return (T) createTask();
        } else if (aClass == Incoming.class) {
            return (T) createIncoming();
        } else if (aClass == Outgoing.class) {
            return (T) createOutgoing();
        }
        return null;
    }

    @Override
    public Task createTask() {
        UUID id = UUID.randomUUID();
        String type = "Task    ";
        String text = "Пока просто текст";
        Integer regNum = RandomUtils.nextInt(0, 5000);
        LocalDate regDate = LocalDate.now();
        Person author = Manager.STAFF_REPO.getPersons().get(RandomUtils.nextInt(0, 11));
        String issueDate = LocalDate.ofEpochDay(RandomUtils.nextInt(0, 326)).toString();
        String executionTerm = String.valueOf(RandomUtils.nextInt(0, 30));
        Person respExecutor = Manager.STAFF_REPO.getPersons().get(RandomUtils.nextInt(0, 11));
        String controlSign = String.valueOf(RandomUtils.nextInt() % 2 == 0);
        Person controller = Manager.STAFF_REPO.getPersons().get(RandomUtils.nextInt(0, 11));
        return new Task(id, type, text, regNum, regDate, author, issueDate, executionTerm, respExecutor,controlSign, controller);
    }

    @Override
    public Incoming createIncoming() {
        UUID id = UUID.randomUUID();
        String type = "Incoming";
        String text = "Пока просто текст";
        Integer regNum = RandomUtils.nextInt(0, 5000);
        LocalDate regDate = LocalDate.ofEpochDay(RandomUtils.nextInt(0, 326));
        Person author = Manager.STAFF_REPO.getPersons().get(RandomUtils.nextInt(0, 11));
        Person sender = Manager.STAFF_REPO.getPersons().get(RandomUtils.nextInt(0, 11));
        Department recipientDepartment = Manager.STAFF_REPO.getDepartments().get(RandomUtils.nextInt(0, 4));
        return new Incoming(id, type, text, regNum, regDate, author, sender, recipientDepartment, regNum, regDate);
    }

    @Override
    public Outgoing createOutgoing() {
        UUID id = UUID.randomUUID();
        String type = "Outgoing";
        String text = "Пока просто текст";
        Integer regNum = RandomUtils.nextInt(0, 5000);
        LocalDate regDate = LocalDate.ofEpochDay(RandomUtils.nextInt(0, 326));
        Person author = Manager.STAFF_REPO.getPersons().get(RandomUtils.nextInt(0, 11));
        Organization recipientOrganization = Manager.STAFF_REPO.getOrganizations().get(RandomUtils.nextInt(0, 4));
        String deliveryMethod = RandomUtils.nextInt() % 2 == 0 ? "byEmail" : "byPost";
        return new Outgoing(id, type, text, regNum, regDate, author, recipientOrganization, deliveryMethod);
    }
}