package by.jwd.task5.model.service;

import by.jwd.task5.model.entity.Triangle;

public interface TriangleService {
    
    double calculateArea(Triangle t);
    double calculatePerimeter(Triangle t);
    boolean isTriangleRight(Triangle t);
    boolean isTriangleIsosceles(Triangle t);
    boolean isTriangleEquilateral(Triangle t);
    boolean isTriangleObtuse(Triangle t);
    boolean isTriangleAcute(Triangle t);
}
