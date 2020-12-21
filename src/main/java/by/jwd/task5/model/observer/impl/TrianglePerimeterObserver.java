package by.jwd.task5.model.observer.impl;

import by.jwd.task5.model.entity.Triangle;
import by.jwd.task5.model.observer.Observer;
import by.jwd.task5.model.observer.TriangleEvent;
import by.jwd.task5.model.service.TriangleService;
import by.jwd.task5.model.service.impl.TriangleServiceImpl;
import by.jwd.task5.model.warehouse.TriangleWarehouse;

public class TrianglePerimeterObserver implements Observer {

    @Override
    public void parameterChanged(TriangleEvent event) {
        TriangleService service = TriangleServiceImpl.getInstance();
        TriangleWarehouse warehouse = TriangleWarehouse.getInstance();
        Triangle triangle = event.getSource();
        double perimeter = service.calculatePerimeter(triangle);
        warehouse.replaceInPerimeters(triangle.getTriangleId(), perimeter);
    }

}
