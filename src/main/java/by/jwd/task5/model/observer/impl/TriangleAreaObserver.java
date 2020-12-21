package by.jwd.task5.model.observer.impl;

import by.jwd.task5.model.entity.Triangle;
import by.jwd.task5.model.observer.Observer;
import by.jwd.task5.model.observer.TriangleEvent;
import by.jwd.task5.model.service.TriangleService;
import by.jwd.task5.model.service.impl.TriangleServiceImpl;
import by.jwd.task5.model.warehouse.TriangleWarehouse;

public class TriangleAreaObserver implements Observer {
    
    private TriangleService service = TriangleServiceImpl.getInstance();
    private TriangleWarehouse warehouse = TriangleWarehouse.getInstance();

    @Override
    public void parameterChanged(TriangleEvent event) {
        Triangle triangle = event.getSource();
        double area = service.calculateArea(triangle);
        warehouse.replaceInAreas(triangle.getTriangleId(), area);
    }
}
