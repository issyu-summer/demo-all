package factory.design.chouxiang.factory.factory;

import factory.design.chouxiang.factory.Pc;
import factory.design.chouxiang.factory.Phone;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 17:35
 */
public interface AbstractFactory {
    Phone makePhone();
    Pc makePc();
}
