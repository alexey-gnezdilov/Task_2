package dto;

import entitiy.staff.Department;
import lombok.Setter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "departments.xml")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
public class Departments extends AbstractDTO<Department>{
    @XmlElement(name = "department")
    private List<Department> departments;

    @Override
    public List<Department> getList() {
        return departments;
    }
}