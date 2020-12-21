package by.jwd.task5.model.factory;

public class FactoryException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public FactoryException() {}
    
    public FactoryException(Exception e) {       
        super(e);
    }
    
    public FactoryException(String message, Exception e) {
        super(message, e);
    }
    
    public FactoryException(String message) {
        super(message);
    }

}
