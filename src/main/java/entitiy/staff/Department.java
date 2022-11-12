package entitiy.staff;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Department extends Staff{

    private String fullName;
    private String shortName;
    private String director;
    private String contactNumber;

    @Override
    public String toString() {
        return String.format("%s - %s - %s",
                getFullName(),
                getDirector(),
                getContactNumber());
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Department dep = (Department) o;
        return getId().equals(dep.getId()) &&
                fullName.equals(dep.fullName) &&
                shortName.equals(dep.shortName) &&
                director.equals(dep.director) &&
                contactNumber.equals(dep.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), fullName, shortName, director, contactNumber);
    }
}