package by.jwd.task5.model.observer;

import java.util.EventObject;

import by.jwd.task5.model.entity.Triangle;

public class TriangleEvent extends EventObject {

    private static final long serialVersionUID = 1L;

    public TriangleEvent(Triangle source) {
        super(source);
    }
    
    @Override
    public Triangle getSource() {
        return (Triangle)super.getSource();
    }
    

}
