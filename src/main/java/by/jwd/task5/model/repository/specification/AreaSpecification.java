package by.jwd.task5.model.repository.specification;

import java.util.function.Predicate;

import by.jwd.task5.model.entity.Triangle;
import by.jwd.task5.model.service.TriangleService;
import by.jwd.task5.model.service.impl.TriangleServiceImpl;

public class AreaSpecification implements Predicate<Triangle> {
    
    private static final TriangleService service = TriangleServiceImpl.getInstance();
    private double minArea;
    private double maxArea;

    public AreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean test(Triangle t) {
        double area = service.calculateArea(t);
        boolean isWithin = (area >= minArea && area <= maxArea);
        return isWithin;
    }

}
