package adapter.design.anything.can.fly;

/**
 * @author issyu 30320182200070
 * @date 2021/1/25 18:55
 */
public class Dog {

    private DefaultDogAdapter defaultDogAdapter;


    public Dog(){
        defaultDogAdapter = new DefaultDogAdapter() {
            @Override
            public void eat() {
                System.out.println("this dog can eat");
            }

            @Override
            public void sleep(){
                System.out.println("this dog can sleep");
            }
        };
    }
    /**
     * <--不需要全部实现接口提供的方法时 -->
     * 狗不想执行全部的动作，只想吃和睡
     * 狗的动作缺省为吃
     */
    public void action(){
        this.defaultDogAdapter.eat();
        this.defaultDogAdapter.sleep();
        System.out.println("this dog can't run and jump");
    }
}
