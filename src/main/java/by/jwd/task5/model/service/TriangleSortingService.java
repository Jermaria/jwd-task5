package by.jwd.task5.model.service;

import java.util.List;

import by.jwd.task5.model.entity.Triangle;

public interface TriangleSortingService {
    
    void sortById(List<Triangle> triangles);
    void sortByFirstX(List<Triangle> triangles);
    void sortByFirstY(List<Triangle> triangles);

}
