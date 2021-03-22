package factory.design.chouxiang.factory.factory;

import factory.design.chouxiang.factory.*;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 17:50
 */
public class MiFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }

    @Override
    public Pc makePc() {
        return new MiPc();
    }
}
