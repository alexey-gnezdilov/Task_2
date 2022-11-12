package entitiy.documents;

import entitiy.staff.Organization;
import entitiy.staff.Person;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Outgoing extends Document{

    private Organization recipientOrganization;
    private String deliveryMethod;

    public Outgoing(
            UUID id,
            String documentType,
            String documentText,
            Integer registrationNumber,
            LocalDate registrationDate,
            Person documentAuthor,
            Organization recipientOrganization,
            String deliveryMethod) {
        super(id, documentType, documentText, registrationNumber, registrationDate, documentAuthor);
        this.recipientOrganization = recipientOrganization;
        this.deliveryMethod = deliveryMethod;
    }
}