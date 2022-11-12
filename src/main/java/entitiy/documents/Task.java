package entitiy.documents;

import entitiy.staff.Person;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Task extends Document{

    private String issueDate;
    private String executionTerm;
    private Person responsibleExecutor;
    private String controllerSign;
    private Person controller;

    public Task(
            UUID id,
            String documentType,
            String documentText,
            Integer registrationNumber,
            LocalDate registrationDate,
            Person documentAuthor,
            String issueDate,
            String executionTerm,
            Person responsibleExecutor,
            String controllerSign,
            Person controller) {
        super(id, documentType, documentText, registrationNumber, registrationDate, documentAuthor);
        this.issueDate = issueDate;
        this.executionTerm = executionTerm;
        this.responsibleExecutor = responsibleExecutor;
        this.controllerSign = controllerSign;
        this.controller = controller;
    }
}