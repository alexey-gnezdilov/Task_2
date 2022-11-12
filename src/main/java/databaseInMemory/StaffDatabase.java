package databaseInMemory;

import dto.Departments;
import dto.Organizations;
import dto.Persons;
import entitiy.staff.Department;
import entitiy.staff.Organization;
import entitiy.staff.Person;
import manager.Manager;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class StaffDatabase {

    private List<Person> persons;
    private List<Department> departments;
    private List<Organization> organizations;

    public StaffDatabase() {
        this.persons = dataBaseLoader(Person.class, Persons.class, "persons.xml");
        this.departments = dataBaseLoader(Department.class, Departments.class, "departments.xml");
        this.organizations = dataBaseLoader(Organization.class, Organizations.class, "organizations.xml");
    }

    public List<Person> getPersons() { return persons;}
    public List<Department> getDepartments() {
        return departments;
    }
    public List<Organization> getOrganizations() { return organizations; }

    @SuppressWarnings({"unchecked"})
    private static <T> List<T> dataBaseLoader(Class<T> loadClass, Class dtoClass, String pathName) {
        try {
            return Manager.JAXB_SERVICE.unmarshalling(dtoClass, loadClass, pathName);
        } catch (JAXBException e) {
            return null;
        }
    }
}