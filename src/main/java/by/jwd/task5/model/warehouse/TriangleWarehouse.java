package by.jwd.task5.model.warehouse;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TriangleWarehouse {
    
    private static final TriangleWarehouse instance = new TriangleWarehouse();
    private Map<Integer, Double> perimeters;        // there are 2 observers
    private Map<Integer, Double> areas;
    
    private TriangleWarehouse() {}

    public static TriangleWarehouse getInstance() {
        return instance;
    }

    public boolean areasContainKey(Object key) {
        return areas.containsKey(key);
    }

    public Double putToAreas(Integer key, Double value) {
        return areas.put(key, value);
    }

    public Double getArea(Integer key) {
        return areas.get(key);
    }

    public Collection<Double> areasValues() {
        return areas.values();
    }

    public Set<Entry<Integer, Double>> areasEntrySet() {
        return areas.entrySet();
    }

    public boolean removeFromAreas(Integer key, Double value) {
        return areas.remove(key, value);
    }

    public Double replaceInAreas(Integer key, Double value) {
        return areas.replace(key, value);
    }

    public boolean perimetersContainKey(Integer key) {
        return perimeters.containsKey(key);
    }

    public Double putToPerimeters(Integer key, Double value) {
        return perimeters.put(key, value);
    }

    public Double getPerimeter(Integer key) {
        return perimeters.get(key);
    }

    public Set<Entry<Integer, Double>> perimetersEntrySet() {
        return perimeters.entrySet();
    }

    public boolean removeFromPerimeters(Integer key, Double value) {
        return perimeters.remove(key, value);
    }

    public Double replaceInPerimeters(Integer key, Double value) {
        return perimeters.replace(key, value);
    }

}
