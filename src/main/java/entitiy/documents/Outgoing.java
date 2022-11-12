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
            String type,
            String text,
            Integer regNum,
            LocalDate regDate,
            Person author,
            Organization recipientOrganization,
            String deliveryMethod) {
        super(id, type, text, regNum, regDate, author);
        this.recipientOrganization = recipientOrganization;
        this.deliveryMethod = deliveryMethod;
    }
}