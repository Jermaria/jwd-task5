                                                                                    package by.jwd.task5.model.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import by.jwd.task5.model.entity.Triangle;

public class Repository {
    
    private static final Repository instance = new Repository();
    private List<Triangle> triangles = new ArrayList<Triangle>();;
    
    private Repository() {}

    public static Repository getInstance() {
        return instance;
    }

    public boolean add(Triangle e) {
        return triangles.add(e);
    }

    public boolean addAll(Collection<? extends Triangle> c) {
        return triangles.addAll(c);
    }

    public Triangle get(int index) {
        return triangles.get(index);
    }

    public Triangle set(int index, Triangle element) {
        return triangles.set(index, element);
    }

    public void add(int index, Triangle element) {
        triangles.add(index, element);
    }

    public Triangle remove(int index) {
        return triangles.remove(index);
    }
    
    public List<Triangle> query(Predicate<Triangle> specification) {
        List<Triangle> foundTriangles = triangles.stream().filter(o -> specification.test(o)).collect(Collectors.toList());
        return foundTriangles;
    }
}
