package adapter.design.anything.can.fly;

/**
 * @author issyu 30320182200070
 * @date 2021/1/25 18:28
 */
public class Main {

    public static void main(String []args){
        FlyTiger flyTiger = new FlyTiger();
        flyTiger.tiger("flyTiger");

        /**
         * 缺省适配器模式
         */
        Dog dog = new Dog();
        dog.action();
    }
}
