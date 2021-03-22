package adapter.design.anything.can.fly;

/**
 * @author issyu 30320182200070
 * @date 2021/1/25 18:19
 */
public class FlyTiger implements Tiger {

    private FlyTigerAdapter flyTigerAdapter;


    @Override
    public void tiger(String tigerName) {
        flyTigerAdapter = new FlyTigerAdapter();
        flyTigerAdapter.tiger(tigerName);
    }
}
