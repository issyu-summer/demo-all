package adapter.design.anything.can.fly;

/**
 * 将fly封装为飞虎适配器
 * @author issyu 30320182200070
 * @date 2021/1/25 18:00
 */
public class FlyTigerAdapter implements Tiger{

    private Fly fly;

    /**
     * 通过构造器传入需要的对象
     */
    public FlyTigerAdapter(){
        fly = new Fly();
    }

    @Override
    public void tiger(String tigerName) {
        System.out.println("this animal is "+tigerName);
        fly.action();
    }
}
