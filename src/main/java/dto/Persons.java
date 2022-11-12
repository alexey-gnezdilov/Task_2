package dto;

import entitiy.staff.Person;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "persons")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
public class Persons extends AbstractDTO<Person>{
    @XmlElement(name = "person")
    private List<Person> persons = null;

    @Override
    public List<Person> getList() {
        return persons;
    }
}