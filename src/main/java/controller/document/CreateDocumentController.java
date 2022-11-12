package controller.document;

import entitiy.documents.Document;
import entitiy.documents.Incoming;
import entitiy.documents.Outgoing;
import entitiy.documents.Task;
import exception.DocumentExistException;
import manager.Manager;
import org.apache.commons.lang3.RandomUtils;

public class CreateDocumentController extends BaseDocumentController {

    private static final String MENU_OF_CREATING =
            Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("MENU_OF_CREATING");

    private static final String INVALID_INPUT =
            Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("INVALID_INPUT_2");

    private static final String MENU_OF_TYPES =
            Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("MENU_OF_TYPES");

    private static final String NO_SUCH_TYPE =
            Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("NO_SUCH_TYPE");

    private static final String DOCUMENT_HAS_BEEN_CREATED =
            Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("DOCUMENT_HAS_BEEN_CREATED");

    public void showCreateDocController() {
        String selection;
        do {
            selection = showInputMenu(MENU_OF_CREATING);
            switch (selection) {
                case "1":
                    showSingleDocController();
                    break;
                case "2":
                {
                    for (int i = 1; i <= 100; i++) {
                        selection = String.valueOf(RandomUtils.nextInt(1,4));
                        try {
                            if (createDocument(selection)) {
                                throw new DocumentExistException();
                            } else {
                                System.out.println(DOCUMENT_HAS_BEEN_CREATED);
                            }
                        } catch (DocumentExistException e) {}
                    }
                    selection = "0";
                }
                    break;
                case "3":
                    break;
                default:
                    System.out.println(INVALID_INPUT);
                    Manager.CUSTOM_SYSTEM_UTIL.delay();
            }
        } while (!selection.equals("3"));
    }

    public void showSingleDocController() {
        String selection;
        do {
            selection = showInputMenu(MENU_OF_TYPES);
            switch (selection) {
                case "1":
                case "2":
                case "3": {
                    try {
                        if (createDocument(selection)) {
                            throw new DocumentExistException();
                        } else {
                            System.out.println(DOCUMENT_HAS_BEEN_CREATED);
                            Manager.CUSTOM_SYSTEM_UTIL.delay();
                        }
                    } catch (DocumentExistException e) {
                        Manager.CUSTOM_SYSTEM_UTIL.delay();
                    }
                }
                case "4":
                    break;
                default:
                    System.out.println(NO_SUCH_TYPE);
                    Manager.CUSTOM_SYSTEM_UTIL.delay();
            }
        } while (!selection.equals("4"));
    }

    //переделать на return Document, в ином случае return null
    //переделать String selection в int selection
    //добавить default - выкинуть Exception - создать свой класс
    private boolean createDocument(String selection) {

        Document temporaryDocument = null;

        switch (selection) {
            case "1":
                temporaryDocument = Manager.DOCUMENT_FACTORY.generateDocument(Task.class);
                break;
            case "2":
                temporaryDocument = Manager.DOCUMENT_FACTORY.generateDocument(Incoming.class);
                break;
            case "3":
                temporaryDocument = Manager.DOCUMENT_FACTORY.generateDocument(Outgoing.class);
                break;
        }

        if (temporaryDocument == null
                || Manager.DOCUMENTS_REPO.read(temporaryDocument.getRegistrationNumber()) == null) {
            Manager.DOCUMENTS_REPO.create(temporaryDocument);
            return false;
        } else {
            return true;
        }
    }
}