package by.jwd.task5.model.service.impl;


import by.jwd.task5.model.entity.CustomPoint;
import by.jwd.task5.model.entity.Triangle;
import by.jwd.task5.model.service.TriangleService;
import by.jwd.task5.model.warehouse.TriangleWarehouse;

public class TriangleServiceImpl implements TriangleService {
    
    private static final TriangleServiceImpl instance = new TriangleServiceImpl();
    private TriangleWarehouse warehouse = TriangleWarehouse.getInstance();
    
    private TriangleServiceImpl() {}

    public static TriangleServiceImpl getInstance() {
        return instance;
    }

    @Override
    public double calculateArea(Triangle t) {
        double area;
        double[] sides = calculateSides(t);
        double halfPerimeter = calculatePerimeter(t) / 2;
        double temp = halfPerimeter * (halfPerimeter - sides[0]) * (halfPerimeter - sides[1]) * (halfPerimeter - sides[2]);
        area = Math.sqrt(temp);
        addAreaToWarehouse(t.getTriangleId(), area);
        return area;
    }

    @Override
    public double calculatePerimeter(Triangle t) {
        double perimeter = 0;
        double sides[] = calculateSides(t);
        for (double side : sides) {
            perimeter += side;
        }
        addPerimeterToWarehouse(t.getTriangleId(), perimeter);
        return perimeter;
    }
    
    private void addAreaToWarehouse(int index, double area) {
        warehouse.putToAreas(index, area);
    }
    
    private void addPerimeterToWarehouse(int index, double perimeter) {
        warehouse.putToPerimeters(index, perimeter);
    }
    
    private double[] calculateSides(Triangle t) {
        double[] sides = new double[t.getVertices().size()];
        CustomPoint[] points = new CustomPoint[t.getVertices().size()];
        t.getVertices().toArray(points);
        sides[0] = calculateSideLength(points[0], points[1]);
        sides[1] = calculateSideLength(points[1], points[2]);
        sides[2] = calculateSideLength(points[0], points[2]);
        return sides;
    }
    
    private double calculateSideLength(CustomPoint a, CustomPoint b) {
        double length = 0;
        double temp = Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2);
        length = Math.sqrt(temp);
        return length;
    }   
    
    @Override
    public boolean isTriangleRight(Triangle t) {
        double[] sides = calculateSides(t);
        shiftLongestSideToStart(sides);
        double c = sides[0];
        double a = sides[1];
        double b = sides[2];
        
        boolean isRight = (c * c == a * a + b * b);
        return isRight;
    }
    
    private int defineLongestSideIndex(double[] sides) {
        int indexOfMax = 0;
        for(int i = 1; i < sides.length; i++) {
            if (sides[i ] > sides[indexOfMax]) {
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }
    
    private void shiftLongestSideToStart(double[] sides) {  // убрать статик
        int indexOfMax = defineLongestSideIndex(sides);
        double temp = sides[0];
        sides[0] = sides[indexOfMax];
        sides[indexOfMax] = temp;
    }

    @Override
    public boolean isTriangleIsosceles(Triangle t) {
        double[] sides = calculateSides(t);
        int equalSidesNumber = calculateEqualSidesNumber(sides);
        boolean isIsosceles = (equalSidesNumber > 0);
        return isIsosceles;
    }
    
    private int calculateEqualSidesNumber(double[] sides) {
        int counter = 0;
        for (int i = 0; i < sides.length - 1; i++) {
            for (int j = i+1; j < sides.length; j++) {
                if (sides[i] == sides[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public boolean isTriangleEquilateral(Triangle t) {
        double[] sides = calculateSides(t);
        int equalSidesNumber = calculateEqualSidesNumber(sides);
        boolean isEquilateral = (equalSidesNumber > 1);
        return isEquilateral;
    }

    @Override
    public boolean isTriangleObtuse(Triangle t) {
        double[] sides = calculateSides(t);
        shiftLongestSideToStart(sides);
        double c = sides[0];
        double a = sides[1];
        double b = sides[2];
        boolean isObtuse = (c * c > a * a + b * b);
        return isObtuse;
    }

    @Override
    public boolean isTriangleAcute(Triangle t) {
        double[] sides = calculateSides(t);
        shiftLongestSideToStart(sides);
        double c = sides[0];
        double a = sides[1];
        double b = sides[2];       
        boolean isAcute = (c * c < a * a + b * b);
        return isAcute;
    }
}
