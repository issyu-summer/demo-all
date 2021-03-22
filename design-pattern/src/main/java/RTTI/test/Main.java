package RTTI.test;

import RTTI.test.util.Rtti.Rtti;
import RTTI.test.util.Rtti.TYPE;
import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 16:17
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
//        String type;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        type = br.readLine();
//        //使用通配已匹配任何类型
//        Class<?> clazz;
//        String className;
//        if("computer".equalsIgnoreCase(type)){
//            className = "RTTI.test.Computer";
//            clazz = Class.forName(className);
//            Computer computer= (Computer) clazz.getConstructor().newInstance();
//            computer.play("Far Cry 4");
//        }else if("mobile".equalsIgnoreCase(type)){
//             className ="RTTI.test.Mobile";
//             clazz=Class.forName(className);
//             Mobile mobile = (Mobile) clazz.getConstructor().newInstance();
//             mobile.contact("jack");
//        }
//        Rtti rtti = new Rtti();
//        Computer computer = (Computer)rtti.getInstance(TYPE.COMPUTER);
//        computer.play("Far Cry 5");
//        Class<?> [] paramTypes={String.class,Long.class};
//        Object [] params = {"tom",1245631135L};
//        Mobile mobile = (Mobile) rtti.getInstance(TYPE.MOBILE,params,paramTypes);
//        mobile.contact("jack");
          //正确不做任何事，不正确则抛出异常
          //Assert.isInstanceOf(String.class,12L,"not a String");


          //类(java中没有类型这一说了)
          Class<?> clazz = Class.forName("RTTI.test.Computer");
          Class<?> stringClass = String.class;
          if(clazz.equals(Computer.class)) {
              System.out.println(clazz.getDeclaredMethod("part",String.class,Long.class).getName());
          }
        //对象
          Computer computer = new Computer();

    }
}
