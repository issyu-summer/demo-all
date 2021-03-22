package decorator.design;

/**
 * 被装饰类，本身具有一些功能的完整类
 * @author summer
 * @date 2021/2/23 12:20
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw a circle");
    }
}
