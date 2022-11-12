package controller;

import controller.document.BaseDocumentController;
import entitiy.documents.Document;
import manager.Manager;

public class FindDocumentController extends BaseDocumentController {

    public void findDocument() {
            String registrationNumber = getRegistrationNumber();
            Document temporaryDocument = Manager.DOCUMENTS_REPO.read(Integer.parseInt(registrationNumber));
            if (temporaryDocument != null) {
                System.out.println(temporaryDocument);;
                Manager.CUSTOM_SYSTEM_UTIL.delay();
            } else {
                System.out.println(DOCUMENT_DOESNT_EXIST);
                Manager.CUSTOM_SYSTEM_UTIL.delay();
            }
    }
}