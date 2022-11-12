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

    public StaffDatabase(
            List<Person> persons,
            List<Department> departments,
            List<Organization> organizations) {
        this.persons = persons;
        this.departments = departments;
        this.organizations = organizations;
    }

    public List<Person> getPersons() { return persons;}
    public List<Department> getDepartments() {
        return departments;
    }
    public List<Organization> getOrganizations() { return organizations; }

}