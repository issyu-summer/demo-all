package factory.design.chouxiang.factory.factory;

import factory.design.chouxiang.factory.IPhone;
import factory.design.chouxiang.factory.MacPc;
import factory.design.chouxiang.factory.Pc;
import factory.design.chouxiang.factory.Phone;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 17:51
 */
public class IFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new IPhone();
    }

    @Override
    public Pc makePc() {
        return new MacPc();
    }
}
