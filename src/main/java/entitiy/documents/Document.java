package entitiy.documents;

import entitiy.interfaces.Storable;
import entitiy.staff.Person;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public abstract class Document implements Comparable<Document>, Storable, Cloneable{

    private UUID id;
    private String type;
    private String text;
    private Integer registrationNumber;
    private LocalDate registrationDate;
    private transient Person author;

    public Document(
            UUID id,
            String type,
            String text,
            Integer registrationNumber,
            LocalDate registrationDate,
            Person author) {
        this.id = id;
        this.type = type;
        this.text = text;
        this.registrationNumber = registrationNumber;
        this.registrationDate = registrationDate;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("%s       № %s at %s %s",
                getType(),
                getRegistrationNumber(),
                getRegistrationDate(),
                getText());
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Document doc = (Document) o;
        return id.equals(doc.id) &&
                type.equals(doc.type) &&
                text.equals(doc.text) &&
                registrationNumber.equals(doc.registrationNumber) &&
                registrationDate.equals(doc.registrationDate) &&
                author.equals(doc.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, text, registrationNumber, registrationDate, author);
    }

    @Override
    public int compareTo(Document document) {
        return Comparator
                .comparing(Document::getRegistrationNumber)
                .thenComparing(Document::getRegistrationDate)
                .compare(this, document);
    }

    @Override
    public Document clone() throws CloneNotSupportedException {
        return (Document) super.clone();
    }

    @Override
    public UUID getStorableID() {
        return getId();
    }

    @Override
    public void setStorageName() {}

}