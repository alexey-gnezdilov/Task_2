package entitiy.staff;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.Objects;

@Getter
@Setter
public class Person extends Staff implements Comparable<Person>{

    private String surname;
    private String name;
    private String patronymic;
    private String workPosition;
    private String birthDate;
    private String phoneNumber;

    public String getFullName() {
        return surname + " " + name + " " + patronymic;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s",
                getFullName(),
                getBirthDate(),
                getWorkPosition());
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Person person = (Person) o;
        return getId().equals(person.getId()) &&
                getFullName().equals(person.getFullName()) &&
                workPosition.equals(person.workPosition) &&
                birthDate.equals(person.birthDate) &&
                phoneNumber.equals(person.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName(), workPosition, birthDate, phoneNumber);
    }

    @Override
    public int compareTo(Person person) {
        return Comparator
                .comparing(Person::getFullName)
                .compare(this, person);
    }
}