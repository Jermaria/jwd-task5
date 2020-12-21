package by.jwd.task5.validation;

import java.util.List;

import by.jwd.task5.model.entity.CustomPoint;

public class TriangleParameterValidator {
    
    public static boolean isDataValidForTriangle(List<Integer> vertices) {
        CustomPoint a = new CustomPoint(vertices.get(0), vertices.get(1));  // вынести индексы в константы
        CustomPoint b = new CustomPoint(vertices.get(2), vertices.get(3));
        CustomPoint c = new CustomPoint(vertices.get(4), vertices.get(5));

        boolean isTriangle = (!areOnSameLine(a, b, c));
        return isTriangle;        

    }
    
    private static boolean areOnSameLine(CustomPoint a, CustomPoint b, CustomPoint c) {
        boolean areOnSameLine;
        double leftEquationPart = (b.getY() - a.getY()) / (b.getX() - a.getX());
        double rightEquationPart = (c.getY() - a.getY()) / (c.getX() - a.getX());
        areOnSameLine = (leftEquationPart == rightEquationPart);
        return areOnSameLine;
    }
 

}
