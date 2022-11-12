package entitiy.documents;

import entitiy.staff.Department;
import entitiy.staff.Person;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Incoming extends Document{

    private Person sender;
    private Department recipientDepartment;
    private Integer outNumber;
    private LocalDate outRegistrationDate;

    public Incoming(
            UUID id,
            String type,
            String text,
            Integer regNum,
            LocalDate regDate,
            Person author,
            Person sender,
            Department recipientDepartment,
            Integer outNumber,
            LocalDate outRegistrationDate) {
        super(id, type, text, regNum, regDate, author);
        this.sender = sender;
        this.recipientDepartment = recipientDepartment;
        this.outNumber = outNumber;
        this.outRegistrationDate = outRegistrationDate;
    }
}