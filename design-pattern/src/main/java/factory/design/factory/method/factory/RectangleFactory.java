package factory.design.factory.method.factory;

import factory.design.factory.method.Rectangle;
import factory.design.factory.method.Shape;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 17:37
 */
public class RectangleFactory implements AbstractFactory {
    @Override
    public Shape makeShape() {
        return new Rectangle();
    }
}
