package by.jwd.task5.model.repository.specification;

import java.util.function.Predicate;

import by.jwd.task5.model.entity.Triangle;
import by.jwd.task5.model.service.TriangleService;
import by.jwd.task5.model.service.impl.TriangleServiceImpl;

public class PerimeterSpecification implements Predicate<Triangle> {
    
    private static final TriangleService service = TriangleServiceImpl.getInstance();
    private double minPerimeter;
    private double maxPerimeter;

    public PerimeterSpecification(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean test(Triangle t) {
        double p = service.calculatePerimeter(t);
        boolean isWithin = (p >= minPerimeter && p <= maxPerimeter);
        return isWithin;
    }
}
