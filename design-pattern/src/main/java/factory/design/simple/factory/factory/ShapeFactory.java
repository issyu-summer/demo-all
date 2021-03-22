package factory.design.simple.factory.factory;

import factory.design.factory.method.Circle;
import factory.design.factory.method.Rectangle;
import factory.design.factory.method.Shape;
import factory.design.factory.method.Square;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 17:24
 */
public class ShapeFactory {

    public Shape getShape(String shapeType){
        if(shapeType==null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("circle")){
            return new Circle();
        }else if(shapeType.equalsIgnoreCase("square")){
            return new Square();
        } else if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}
