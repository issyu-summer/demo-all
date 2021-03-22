package adapter.design.anything.can.fly;

/**
 * @author issyu 30320182200070
 * @date 2021/1/25 18:17
 */
public class Fly implements Action {
    @Override
    public void action() {
        System.out.println("this animal can fly");
    }
}
