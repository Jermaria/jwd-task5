package by.jwd.task5.model.observer;

public interface Observable {
    
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
