package exception;

public class DocumentExistException extends Exception{
    public DocumentExistException() {
        System.out.println("The document already exist! Another document will be created.");
    }
}
