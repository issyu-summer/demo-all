package factory.design.simple.factory;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 17:22
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("draw a square");
    }
}
