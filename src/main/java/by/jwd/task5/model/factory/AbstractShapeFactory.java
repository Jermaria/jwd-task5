package by.jwd.task5.model.factory;

import java.util.List;

import by.jwd.task5.model.entity.CustomShape;

public abstract class AbstractShapeFactory {
    
    public abstract CustomShape createShape(List<Integer> shapeData) throws FactoryException;

}
