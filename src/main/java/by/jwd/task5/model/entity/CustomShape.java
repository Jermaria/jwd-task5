package by.jwd.task5.model.entity;

import by.jwd.task5.model.observer.Observable;
import by.jwd.task5.model.observer.Observer;

public abstract class CustomShape implements Observable {
    
    private CustomPoint shapeCenter;    // won't usually be initialized
    
    public CustomShape() {}

    public CustomPoint getShapeCenter() {
        return shapeCenter;
    }

    public void setShapeCenter(CustomPoint shapeCenter) {
        this.shapeCenter = shapeCenter;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((shapeCenter == null) ? 0 : shapeCenter.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomShape other = (CustomShape) obj;
        if (shapeCenter == null) {
            if (other.shapeCenter != null)
                return false;
        } else if (!shapeCenter.equals(other.shapeCenter))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getName());
        builder.append(" [shapeCenter=");
        builder.append(shapeCenter);
        builder.append("]");
        return builder.toString();
    }
    
    public abstract void attach(Observer observer);

    public abstract void detach(Observer observer);

    public abstract void notifyObservers();
}
