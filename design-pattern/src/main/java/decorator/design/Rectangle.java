package decorator.design;

/**
 * 被装饰的具体类，本身具有一定的功能
 * @author summer
 * @date 2021/2/23 12:28
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw a rectangle");
    }
}
