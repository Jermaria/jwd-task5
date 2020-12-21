package by.jwd.task5.model.service.impl;

import java.util.Comparator;
import java.util.List;

import by.jwd.task5.model.entity.Triangle;
import by.jwd.task5.model.service.TriangleSortingService;

public class TriangleSortingServiceImpl implements TriangleSortingService {

    @Override
    public void sortById(List<Triangle> triangles) {
        triangles.sort(Comparator.comparing(Triangle::getTriangleId));
    }

    @Override
    public void sortByFirstX(List<Triangle> triangles) {
        Comparator<Triangle> comparator = (t1, t2) ->
                                    Integer.valueOf(t1.getVertices().iterator().next().getX())
                                            .compareTo(Integer.valueOf(t1.getVertices().iterator().next().getX()));
        triangles.sort(comparator);  
    }

    @Override
    public void sortByFirstY(List<Triangle> triangles) {
        Comparator<Triangle> comparator = (t1, t2) ->
        Integer.valueOf(t1.getVertices().iterator().next().getY())
                .compareTo(Integer.valueOf(t1.getVertices().iterator().next().getY()));
        triangles.sort(comparator);  
    }
}
