package by.jwd.task5.model.repository_manager;

import java.util.List;

import by.jwd.task5.model.entity.Triangle;
import by.jwd.task5.model.repository.Repository;

public class RepositoryManager {
    
    private static final Repository repository = Repository.getInstance();

    public void addTriangle(Triangle t) {
        repository.add(t);
    }
    
    public void addAll(List<Triangle> triangles) {
        repository.addAll(triangles);
    }

    public void changeTriangle(int index, Triangle t) {
        repository.set(index, t);
    }

    public Triangle getTringle(int index) {
        Triangle searched = repository.get(index);
        return searched;
    }

    public void removeTriangle(int index) {
        repository.remove(index);
    } 

}
