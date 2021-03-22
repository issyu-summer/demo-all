package RTTI.test.util.Rtti;

import RTTI.test.Computer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationTargetException;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 16:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rtti {


    private String className;
    private Class<?> clazz;
    private Object object;

    /**
     * 通过无参构造方法在运行时构造相应类型的对象
     * @param type 对象类型
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public Object getInstance(TYPE type) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        if(type.equals(TYPE.COMPUTER)){
            //为啥要用反射？？？？？？
//            Computer computer = new Computer();
//            return computer;
            this.className=TYPE.COMPUTER.getClassName();
            clazz = Class.forName(className);
            object = clazz.getConstructor().newInstance();
        }else if(type.equals(TYPE.MOBILE)){
            this.className=TYPE.MOBILE.getClassName();
            clazz = Class.forName(className);
            object = clazz.getConstructor().newInstance();
        }
        return this.object;
    }

    /**
     * 通过有参构造方法在运行时构造相应类型的对象
     * @param type 对象类型
     * @param params 构造函数参数
     * @param paramTypes 构造函数类型
     * @throws ClassNotFoundException 类不存在
     * @throws NoSuchMethodException  方法不存在
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public Object getInstance(TYPE type, Object[] params, Class<?>[]paramTypes) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        if(type.equals(TYPE.COMPUTER)){
            this.className=TYPE.COMPUTER.getClassName();
            clazz = Class.forName(className);
            object = clazz.getConstructor(paramTypes).newInstance(params);
        }else if(type.equals(TYPE.MOBILE)){
            this.className=TYPE.MOBILE.getClassName();
            clazz = Class.forName(className);
            object = clazz.getConstructor(paramTypes).newInstance(params);
        }
        return this.object;
    }
}
