package by.jwd.task5.model.repository.specification;

import java.util.Iterator;
import java.util.function.Predicate;

import by.jwd.task5.model.entity.CustomPoint;
import by.jwd.task5.model.entity.Triangle;

public class FirstQuadrantSpecification implements Predicate<Triangle> {

    @Override
    public boolean test(Triangle t) {
        boolean isInFirstQuadrant = false;
        Iterator<CustomPoint> iterator = t.getVertices().iterator();
        while (iterator.hasNext()) {
            isInFirstQuadrant = true;
            CustomPoint cp = iterator.next();
            if (cp.getX() < 0 || cp.getY() < 0) {
                isInFirstQuadrant = false;
                break;
            }
        }  
        return isInFirstQuadrant;
    }
}
