import manager.Manager;
public class Main {
    public static void main(String[] args) {
        disableWarning();
        Manager.START_UP_CONTROLLER.showMainController();
    }
    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }
}
