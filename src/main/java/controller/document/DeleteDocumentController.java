package controller.document;

import manager.Manager;

public class DeleteDocumentController extends BaseDocumentController {

    private static final String DOCUMENT_SUCCESSFULLY_DELETED =
            Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("DOCUMENT_SUCCESSFULLY_DELETED");

    public void deleteDocument() {
            String registrationNumber = getRegistrationNumber();
            if (Manager.DOCUMENTS_REPO.delete(Integer.parseInt(registrationNumber))) {
                System.out.println(DOCUMENT_SUCCESSFULLY_DELETED);
                Manager.CUSTOM_SYSTEM_UTIL.delay();
            } else {
                System.out.println(DOCUMENT_DOESNT_EXIST);
                Manager.CUSTOM_SYSTEM_UTIL.delay();
            }
    }
}