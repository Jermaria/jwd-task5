package by.jwd.task5.service.impl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.jwd.task5.model.entity.CustomPoint;
import by.jwd.task5.model.entity.Triangle;
import by.jwd.task5.model.service.TriangleService;
import by.jwd.task5.model.service.impl.TriangleServiceImpl;

public class TriangleServiceImplTest {
    
    private static final TriangleService service = TriangleServiceImpl.getInstance();
    private Triangle rightTriangle;
    
    @BeforeMethod
    public void initTriangles() {
        Set<CustomPoint> points = new HashSet<CustomPoint>();
        CustomPoint cp1 = new CustomPoint(0, 3);
        CustomPoint cp2 = new CustomPoint(4, 0);
        CustomPoint cp3 = new CustomPoint(0, 0);
        points.add(cp1);
        points.add(cp2);
        points.add(cp3);
        rightTriangle = new Triangle(points);   
    }

    @Test
    public void calculateAreaTest() {        
        double actual = service.calculateArea(rightTriangle);
        double expected = 6;
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void calculatePerimeterTest() {
        double actual = service.calculatePerimeter(rightTriangle);
        double expected = 12;
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void isTriangleAcuteTest() {
        boolean isAcute = service.isTriangleAcute(rightTriangle);
        assertFalse(isAcute);
    }

    @Test
    public void isTriangleIsoscelesTest() {
        boolean isIsosceles = service.isTriangleIsosceles(rightTriangle);
        assertFalse(isIsosceles);
    }

    @Test
    public void isTriangleObtuseTest() {
        boolean isObtuse = service.isTriangleObtuse(rightTriangle);
        assertFalse(isObtuse);
    }

    @Test
    public void isTriangleRightTest() {
        boolean isRight = service.isTriangleRight(rightTriangle);
        assertTrue(isRight);
    }
}
