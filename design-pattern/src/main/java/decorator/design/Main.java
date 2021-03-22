package decorator.design;

/**
 * @author summer
 * @date 2021/2/23 12:25
 */
public class Main {

    /**
     * 可以看出来，具体的装饰类同时装饰了多个实体类
     * 一个装饰类可以在不影响核心功能的情况下，为多个类添加新功能
     */
    public static void main(String[] args) {
        Circle circle = new Circle();
        Shape redCircle = new RedShapeDecorator(circle);
        redCircle.draw();
        Rectangle rectangle = new Rectangle();
        Shape redRectangle= new RedShapeDecorator(rectangle);
        redRectangle.draw();
    }
}
