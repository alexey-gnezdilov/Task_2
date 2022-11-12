package entitiy.staff;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Organization extends Staff{

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
        Organization org = (Organization) o;
        return getId().equals(org.getId()) &&
                fullName.equals(org.fullName) &&
                shortName.equals(org.shortName) &&
                director.equals(org.director) &&
                contactNumber.equals(org.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), fullName, shortName, director, contactNumber);
    }
}