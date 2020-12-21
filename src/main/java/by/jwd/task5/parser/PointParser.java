package by.jwd.task5.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import by.jwd.task5.validation.InitialDataValidator;

public class PointParser {
    
    private static final String SPACE_DELIMETER = " ";
    private static final String FULL_STOP_DELIMETER = "\\.";
    
    public List<Integer> parsePoints(String verticesData) {
        List<Integer> pointDetails = new ArrayList<Integer>();
        String[] vertices = verticesData.split(SPACE_DELIMETER);
        if (InitialDataValidator.isDataValidForTriangle(vertices)) {
            for (String vertice : vertices) {
                List<Integer> parsedDetails = parsePointDetails(vertice);
                pointDetails = Stream.concat(pointDetails.stream(), parsedDetails.stream()).collect(Collectors.toList());
            }
        }
        return pointDetails;
    }
    
    private List<Integer> parsePointDetails(String pointData) {
        List<Integer> pointDetails = new ArrayList<Integer>();
        String[] values = pointData.split(FULL_STOP_DELIMETER);
        for (String value : values) {
            pointDetails.add(Integer.parseInt(value));
        }
        return pointDetails;
    }
}
