package manager;

import controller.*;
import controller.document.CreateDocumentController;
import controller.document.DeleteDocumentController;
import controller.document.UpdateDocumentController;
import dto.Departments;
import dto.Organizations;
import dto.Persons;
import entitiy.staff.Department;
import entitiy.staff.Organization;
import entitiy.staff.Person;
import repository.StaffRepo;
import repository.impl.StaffRepoImpl;
import service.docservices.DocumentFactory;
import service.jaxbservice.JaxbService;
import service.jaxbservice.impl.JaxbServiceImpl;
import service.docservices.impl.DocumentFactoryImpl;
import repository.DocumentsRepo;
import repository.impl.DocumentsRepoImpl;
import util.CustomSystemUtil;
import util.impl.CustomSystemUtilImpl;

import javax.xml.bind.JAXBException;
import java.util.List;

public class Manager {

    public static final JaxbService JAXB_SERVICE;

    public static final StartController START_UP_CONTROLLER;
    public static final CreateDocumentController CREATE_CONTROLLER;
    public static final DeleteDocumentController DELETE_CONTROLLER;
    public static final UpdateDocumentController EDIT_CONTROLLER;
    public static final ReaddDocumentController FIND_CONTROLLER;
    public static final ShowDocumentController SHOW_CONTROLLER;

    public static final DocumentsRepo DOCUMENTS_REPO;
    public static final StaffRepo STAFF_REPO;

    public static final DocumentFactory DOCUMENT_FACTORY;

    public static final CustomSystemUtil CUSTOM_SYSTEM_UTIL;

    static {

        CUSTOM_SYSTEM_UTIL = new CustomSystemUtilImpl();

        JAXB_SERVICE = new JaxbServiceImpl();

        START_UP_CONTROLLER = new StartController();
        CREATE_CONTROLLER = new CreateDocumentController();
        DELETE_CONTROLLER = new DeleteDocumentController();
        EDIT_CONTROLLER = new UpdateDocumentController();
        FIND_CONTROLLER = new ReaddDocumentController();
        SHOW_CONTROLLER = new ShowDocumentController();

        DOCUMENTS_REPO = new DocumentsRepoImpl();
        STAFF_REPO = new StaffRepoImpl(
                dataBaseLoader(Person.class, Persons.class, "persons"),
                dataBaseLoader(Department.class, Departments.class, "departments"),
                dataBaseLoader(Organization.class, Organizations.class, "organizations")
        );

        DOCUMENT_FACTORY = new DocumentFactoryImpl();
    }

    @SuppressWarnings({"unchecked"})
    private static <T> List<T> dataBaseLoader(Class<T> loadClass, Class dtoClass, String pathName) {
        try {
            return Manager.JAXB_SERVICE.unmarshalling(dtoClass, loadClass, pathName);
        } catch (JAXBException e) {
            return null;
        }
    }
}