package by.jwd.task5.conversion;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.jwd.task5.model.entity.CustomPoint;

public class FileDataToCustomPointConverterTest {
    
    private static final String FILE_PATH = "resources/data/points_db.txt";
    private static final FileDataToCustomPointConverter converter = FileDataToCustomPointConverter.getInstance();
    private Map<Integer, CustomPoint[]> points;
    @BeforeMethod
    public void initExpectedMap() {
        CustomPoint[] cp1 = new CustomPoint[3];
        cp1[0] = new CustomPoint(2, 7);
        cp1[1] = new CustomPoint(3, 1);
        cp1[2] = new CustomPoint(3, 4);
        CustomPoint[] cp2 = new CustomPoint[3];
        cp2[0] = new CustomPoint(6, 2);
        cp2[1] = new CustomPoint(6, 7);
        cp2[2] = new CustomPoint(2, 3);
        CustomPoint[] cp3 = new CustomPoint[3];
        cp3[0] = new CustomPoint(1, 1);
        cp3[1] = new CustomPoint(2, 2);
        cp3[2] = new CustomPoint(4, 3);
        CustomPoint[] cp4 = new CustomPoint[3];
        cp4[0] = new CustomPoint(1, 1);
        cp4[1] = new CustomPoint(2, 1);
        cp4[2] = new CustomPoint(3, 3);
        CustomPoint[] cp5 = new CustomPoint[3];
        cp5[0] = new CustomPoint(6, 4);
        cp5[1] = new CustomPoint(3, 2);
        cp5[2] = new CustomPoint(4, 2);
        CustomPoint[] cp6 = new CustomPoint[3];
        cp6[0] = new CustomPoint(2, 1);
        cp6[1] = new CustomPoint(4, 1);
        cp6[2] = new CustomPoint(4, 6);
        CustomPoint[] cp7 = new CustomPoint[3];
        cp7[0] = new CustomPoint(1, 0);
        cp7[1] = new CustomPoint(0, 2);
        cp7[2] = new CustomPoint(3, 4);
        CustomPoint[] cp8 = new CustomPoint[3];
        cp8[0] = new CustomPoint(5, 2);
        cp8[1] = new CustomPoint(4, 1);
        cp8[2] = new CustomPoint(6, 0);
        CustomPoint[] cp9 = new CustomPoint[3];
        cp9[0] = new CustomPoint(1, 4);
        cp9[1] = new CustomPoint(5, 1);
        cp9[2] = new CustomPoint(4, 7);
        points = new HashMap<Integer, CustomPoint[]>();
        points.put(1, cp1);
        points.put(2, cp2);
        points.put(3, cp3);
        points.put(4, cp4);
        points.put(5, cp5);
        points.put(6, cp6);
        points.put(7, cp7);
        points.put(8, cp8);
        points.put(9, cp9);
        
    }

    @Test
    public void convertDataToPointsTest() {
        try {
            Map<Integer, CustomPoint[]> actual = converter.convertDataToPoints(FILE_PATH);
            Map<Integer, CustomPoint[]> expected = points;
            boolean isEqual = areEqualWithArrayValue(actual, expected);
            assertTrue(isEqual);
        } catch (ConversionException e) {
            fail();
        }
    }
    
    // custom method to compare array as a value of Map
    private boolean areEqualWithArrayValue(Map<Integer, CustomPoint[]> actual, Map<Integer, CustomPoint[]> expected) {
        if (actual.size() != expected.size()) {
            return false;
        }        
        return actual.entrySet().stream()
                            .allMatch(e -> Arrays.equals(e.getValue(), expected.get(e.getKey())));
    }
}
