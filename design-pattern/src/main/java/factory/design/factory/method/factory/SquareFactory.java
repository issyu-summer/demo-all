package factory.design.factory.method.factory;


import factory.design.factory.method.Shape;
import factory.design.factory.method.Square;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 17:36
 */
public class SquareFactory implements AbstractFactory {
    @Override
    public Shape makeShape() {
        return new Square();
    }
}
