package repository;

import entitiy.staff.Department;
import entitiy.staff.Organization;
import entitiy.staff.Person;

import java.util.List;

public interface StaffRepo {
    List<Person> getPersons();
    List<Department> getDepartments();
    List<Organization> getOrganizations();
    Person getPerson(String fullName);
}
