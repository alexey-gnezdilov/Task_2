package dto;

import entitiy.staff.Organization;
import lombok.Setter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "organizations.xml")
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
public class Organizations extends AbstractDTO<Organization>{
    @XmlElement(name = "organization")
    private List<Organization> organizations;

    @Override
    public List<Organization> getList() {
        return organizations;
    }
}