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
    private String documentType;
    private String documentText;
    private Integer registrationNumber;
    private LocalDate registrationDate;
    private transient Person documentAuthor;

    public Document(
            UUID id,
            String documentType,
            String documentText,
            Integer registrationNumber,
            LocalDate registrationDate,
            Person documentAuthor) {
        this.id = id;
        this.documentType = documentType;
        this.documentText = documentText;
        this.registrationNumber = registrationNumber;
        this.registrationDate = registrationDate;
        this.documentAuthor = documentAuthor;
    }

    @Override
    public String toString() {
        return String.format("%s       № %s at %s %s",
                getDocumentType(),
                getRegistrationNumber(),
                getRegistrationDate(),
                getDocumentText());
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
                documentType.equals(doc.documentType) &&
                documentText.equals(doc.documentText) &&
                registrationNumber.equals(doc.registrationNumber) &&
                registrationDate.equals(doc.registrationDate) &&
                documentAuthor.equals(doc.documentAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                documentType,
                documentText,
                registrationNumber,
                registrationDate,
                documentAuthor);
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