package by.jwd.task5.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import by.jwd.task5.model.observer.Observer;
import by.jwd.task5.model.observer.TriangleEvent;

public class Triangle extends CustomShape implements Serializable {
    
    private int triangleId;
    private Set<CustomPoint> vertices;
    private List<Observer> observers;
    
    public Triangle() {}
    
    public Triangle(Set<CustomPoint> vertices) {
        this.vertices = vertices;
        this.observers = new ArrayList<Observer>();
    }
    
    public Triangle(int triangleId, Set<CustomPoint> vertices) {
        this.triangleId = triangleId;
        this.vertices = vertices;
        this.observers = new ArrayList<Observer>();
    }

    public int getTriangleId() {
        return triangleId;
    }

    public void setTriangleId(int triangleId) {
        this.triangleId = triangleId;
    }

    public Set<CustomPoint> getVertices() {
        return Collections.unmodifiableSet(this.vertices); 
    }

    public void setVertices(Set<CustomPoint> vertices) {
        this.vertices = vertices;
        notifyObservers();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + triangleId;
        result = prime * result + ((vertices == null) ? 0 : vertices.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Triangle other = (Triangle) obj;
        if (triangleId != other.triangleId)
            return false;
        if (vertices == null) {
            if (other.vertices != null)
                return false;
        } else if (!vertices.equals(other.vertices))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getName());
        builder.append(" [triangleId=");
        builder.append(triangleId);
        builder.append(", vertices=");
        builder.append(vertices);
        builder.append("]");
        return builder.toString();
    }
    
    @Override
    public void attach(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        TriangleEvent event = new TriangleEvent(this);
        observers.forEach(o -> o.parameterChanged(event));
    }

    
}
