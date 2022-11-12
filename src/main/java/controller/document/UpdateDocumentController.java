package controller.document;

import entitiy.documents.Document;
import entitiy.staff.Person;
import manager.Manager;

public class UpdateDocumentController extends BaseDocumentController {

    private static final String FULL_NAME_REGULAR_EXPRESSION =
            Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("FULL_NAME_REGULAR_EXPRESSION");

    private static final String DOCUMENT_SUCCESSFULLY_CHANGED =
            Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("DOCUMENT_SUCCESSFULLY_CHANGED");

    private static final String INPUT_NEW_AUTHOR =
            Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("INPUT_NEW_AUTHOR");

    private static final String AUTHOR_DOESNT_EXIST =
            Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("AUTHOR_DOESNT_EXIST");

    public void editDocument() {
        Document previousDocument;
        String registrationNumber = getRegistrationNumber();
        try {
            previousDocument = Manager.DOCUMENTS_REPO.read(Integer.parseInt(registrationNumber)).clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
            //использовать String.format
            //вынести подписи в константы
        Manager.DOCUMENTS_REPO.update(Integer.parseInt(registrationNumber), inputNewAuthor());
        System.out.println(DOCUMENT_SUCCESSFULLY_CHANGED);
        System.out.println("Before: " + previousDocument + " " + previousDocument.getDocumentAuthor() + "\n");
        Document document = Manager.DOCUMENTS_REPO.read(Integer.parseInt(registrationNumber));
        System.out.println("After: " + document + " " + document.getDocumentAuthor());
        Manager.CUSTOM_SYSTEM_UTIL.delay();
    }

    private Person inputNewAuthor() {
        boolean doesAuthorExist;
        Person newAuthor;
        do {
            System.out.print(INPUT_NEW_AUTHOR);
            String authorName = scanner.nextLine();
            newAuthor = Manager.STAFF_REPO.getPerson(authorName);
            doesAuthorExist = authorName.matches(FULL_NAME_REGULAR_EXPRESSION) && newAuthor != null;
            if (!doesAuthorExist){
                System.out.println(AUTHOR_DOESNT_EXIST);
                Manager.CUSTOM_SYSTEM_UTIL.delay();
            }
        } while (!doesAuthorExist);
        return newAuthor;
    }
}