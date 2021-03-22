package factory.design.factory.method.factory;

import factory.design.factory.method.factory.AbstractFactory;
import factory.design.factory.method.Circle;
import factory.design.factory.method.Shape;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 17:36
 */
public class CircleFactory implements AbstractFactory {
    @Override
    public Shape makeShape() {
        return new Circle();
    }
}
