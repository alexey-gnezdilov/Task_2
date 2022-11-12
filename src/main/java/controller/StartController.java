package controller;

import controller.document.BaseDocumentController;
import manager.Manager;

public class StartController extends BaseDocumentController {

    private static final String MAIN = Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("MAIN");
    private static final String INVALID_INPUT = Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("INVALID_INPUT");
    private static final String GOOD_BYE = Manager.CUSTOM_SYSTEM_UTIL.getPropertyValue("GOOD_BYE");

    public void showMainController() {
        String selection;
        do {
            selection = showInputMenu(MAIN);
            switch (selection) {
                case "1":
                    Manager.CREATE_CONTROLLER.showCreateDocController();
                    break;
                case "2":
                    Manager.FIND_CONTROLLER.findDocument();
                    break;
                case "3":
                    Manager.DELETE_CONTROLLER.deleteDocument();
                    break;
                case "4":
                    Manager.EDIT_CONTROLLER.editDocument();
                    break;
                case "5":
                    Manager.SHOW_CONTROLLER.showAllDocumentsByAuthor();
                    break;
                case "6":
                    Manager.SHOW_CONTROLLER.createDocumentReports();
                    break;
                case "7":
                    System.out.println(GOOD_BYE);
                    break;
                default:
                    System.out.println(INVALID_INPUT);
                    Manager.CUSTOM_SYSTEM_UTIL.delay();
            }
        } while (!selection.equals("7"));
    }
}