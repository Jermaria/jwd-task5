package by.jwd.task5.model.factory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task5.model.entity.CustomPoint;
import by.jwd.task5.model.entity.Triangle;
import by.jwd.task5.util.IdGenerator;
import by.jwd.task5.validation.TriangleParameterValidator;

public class TriangleFactory extends AbstractShapeFactory {
    
    private static final TriangleFactory instance = new TriangleFactory();    
    private static final Logger logger = LogManager.getLogger();
    
    private TriangleFactory() {}

    public static TriangleFactory getInstance() {
        return instance;
    }

    @Override
    public Triangle createShape(List<Integer> shapeData) throws FactoryException {      
        if (!TriangleParameterValidator.isDataValidForTriangle(shapeData)) {
            logger.log(Level.ERROR, "invalid vertice data ", Arrays.asList(shapeData));
            throw new FactoryException("invalid vertice data " + " " + Arrays.asList(shapeData));
        }
        Set<CustomPoint> vertices = createVertices(shapeData);
        int id = IdGenerator.generateId();  
        Triangle triangle = new Triangle(id, vertices);
        return triangle;
    }
    
    private Set<CustomPoint> createVertices(List<Integer> pointsData) {
        Set<CustomPoint> points = new HashSet<CustomPoint>();
        int i = 0;
        while (i < pointsData.size()) {
            CustomPoint point = new CustomPoint(pointsData.get(i), pointsData.get(++i));
            points.add(point);
            ++i;
        }
        return points;
    }
}
