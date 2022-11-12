package repository.impl;

import databaseInMemory.StaffDatabase;
import entitiy.staff.Department;
import entitiy.staff.Organization;
import entitiy.staff.Person;
import repository.StaffRepo;
import java.util.List;

public class StaffRepoImpl implements StaffRepo {

    private final StaffDatabase staffDatabase;

    public StaffRepoImpl() { staffDatabase = new StaffDatabase(); }

    @Override
    public List<Person> getPersons() { return staffDatabase.getPersons();}

    @Override
    public List<Department> getDepartments() {return staffDatabase.getDepartments();}

    @Override
    public List<Organization> getOrganizations() {
        return staffDatabase.getOrganizations();
    }

    @Override
    public Person getPerson(String fullName) {
        return getPersons()
                .stream()
                .filter(person -> person.getFullName().equals(fullName))
                .findAny()
                .orElse(null);
    }
}