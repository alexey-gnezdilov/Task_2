package manager;

import controller.*;
import controller.document.CreateDocumentController;
import controller.document.DeleteDocumentController;
import controller.document.EditDocumentController;
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

public class Manager {

    public static final JaxbService JAXB_SERVICE;

    public static final StartController START_UP_CONTROLLER;
    public static final CreateDocumentController CREATE_CONTROLLER;
    public static final DeleteDocumentController DELETE_CONTROLLER;
    public static final EditDocumentController EDIT_CONTROLLER;
    public static final FindDocumentController FIND_CONTROLLER;
    public static final ShowDocumentController SHOW_CONTROLLER;

    public static final DocumentsRepo DOCUMENTS_REPO;
    public static final StaffRepo STAFF_REPO;

    public static final DocumentFactory DOCUMENT_FACTORY;

    public static final CustomSystemUtil CUSTOM_SYSTEM_UTIL;

    public static final PersonService AUTHORS_REPORT;

    static {

        CUSTOM_SYSTEM_UTIL = new CustomSystemUtilImpl();

        JAXB_SERVICE = new JaxbServiceImpl();

        STAFF_REPO = new StaffRepoImpl();

        START_UP_CONTROLLER = new StartController();
        CREATE_CONTROLLER = new CreateDocumentController();
        DELETE_CONTROLLER = new DeleteDocumentController();
        EDIT_CONTROLLER = new EditDocumentController();
        FIND_CONTROLLER = new FindDocumentController();
        SHOW_CONTROLLER = new ShowDocumentController();

        DOCUMENTS_REPO = new DocumentsRepoImpl();

        DOCUMENT_FACTORY = new DocumentFactoryImpl();

        AUTHORS_REPORT = new PersonServiceImpl();
    }

}