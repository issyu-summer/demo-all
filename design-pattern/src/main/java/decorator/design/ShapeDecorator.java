package decorator.design;

/**
 * 装饰类，它的存在仅仅是一个声明,其子类才是有具体装饰效果的类
 * @author summer
 * @date 2021/2/23 12:22
 */
public abstract class ShapeDecorator implements Shape{

    private Shape shape;

    public ShapeDecorator(Shape shape){
        this.shape=shape;
    }

    @Override
    public void draw(){
        shape.draw();
    }

    void setColor(){

    }
}
