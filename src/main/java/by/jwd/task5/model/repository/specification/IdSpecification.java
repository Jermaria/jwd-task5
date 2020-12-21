package by.jwd.task5.model.repository.specification;

import java.util.function.Predicate;

import by.jwd.task5.model.entity.Triangle;

public class IdSpecification implements Predicate<Triangle> {
    
    private int id;

    public IdSpecification(int id) {
        this.id = id;
    }
    
    @Override
    public boolean test(Triangle t) {
        boolean isSearched = (t.getTriangleId() == id);
        return isSearched;
    }

}
