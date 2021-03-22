package decorator.design;

import org.w3c.dom.UserDataHandler;

/**
 * 具体的装饰类，有特定的装饰效果
 * @author summer
 * @date 2021/2/23 12:23
 */
public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        //装饰
        setColor();
    }

    /**
     * 可以通过抽象类来声明一个通用的装饰函数
     */
    @Override
    public void setColor(){
        System.out.println("and this circle id red");

    }
}
