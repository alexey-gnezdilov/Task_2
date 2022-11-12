package controller.document;

import controller.BaseController;
import manager.Manager;
import java.util.Scanner;

public abstract class BaseDocumentController extends BaseController {

    protected Scanner scanner = new Scanner(System.in);

    private static final String INPUT_REGISTRATION_NUMBER =
            Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("INPUT_REGISTRATION_NUMBER");

    protected static final String DOCUMENT_DOESNT_EXIST =
            Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("DOCUMENT_DOESN'T_EXIST");

    protected static final String LIST_IS_EMPTY =
            Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("LIST_IS_EMPTY");

    public String getRegistrationNumber() {
        String registrationNumber;
        boolean isNumber;
        do {
            System.out.print(INPUT_REGISTRATION_NUMBER);
            registrationNumber = scanner.nextLine();
            isNumber = Manager.CUSTOM_SYSTEM_UTIL.isNumeric(registrationNumber);
        } while (!isNumber);
        return registrationNumber;
    }
}