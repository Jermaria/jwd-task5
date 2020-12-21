package by.jwd.task5.validation;

import java.util.regex.Pattern;

/**
 * The validator checks if the data in file can be used to create a CustomPoint 
 * and if there are enough points to create a triangle.
 * It doesn't perform any checks on geometric rules related to triangle (see ServerSideValidator).
 */

public class InitialDataValidator {
    
    private static final Pattern CUSTOM_POINT_PATTERN = Pattern.compile("^-?(?:0|[1-9][0-9]*)\\.-?(?:0|[1-9][0-9]*)+$");
    private static final int TRIANGLE_VERTICES_NUMBER = 3;

    public static boolean isDataValidForTriangle(String[] vertices) {
        boolean isValid = false;
        if (isNumberOfVerticesValid(vertices)) {
            isValid = true;
            int i = 0;
            while (i < vertices.length) {
                if (!isCustomPointDataValid(vertices[i])) {
                    isValid = false;
                    break;
                }
                i++;
            }
        }
        return isValid;
    }
    
    private static boolean isNumberOfVerticesValid(String[] vertices) {
        boolean isValid = vertices.length == TRIANGLE_VERTICES_NUMBER;
        return isValid;
    }
    
    private static boolean isCustomPointDataValid(String PointValue) {
        boolean isMatching = CUSTOM_POINT_PATTERN.matcher(PointValue).matches();
        return isMatching;
    }

}