import java.lang.reflect.*;

/**
 * @author issyu 30320182200070
 * @date 2021/1/17 10:24
 */
public class Application {
    public static void main(String []args) throws ClassNotFoundException {
        String name = "test";
        String  reflect ="reflect";
        String nameString ="java.lang.String";
        //获取c1的类对象
//        Class c1=name.getClass();
//        Class c2=reflect.getClass();
//        Class c3=null;
        //c3=Boolean.TYPE;
        //c3=Class.forName(nameString);
        //System.out.println(c3.getName());
        //System.out.println(c1.getSuperclass());
        //System.out.println(c2.getName());



        //Class [] p={int.class,String.class};
        //Object [] ags={95,"user-wang"};

//        //创建user对象
//        User user = new User(25,"xiaoHeiBao");
//        //获取名称
//        String allNameCanBeGot = user.getClass().getName();
//        //获取user对象的类对象class1
//        Class class1=user.getClass();
//        //指定方法的参数类型p
//        Class [] p ={int.class,String.class};
//        try {
//            //获取class1的所有构造函数（私有也能获取）
//            Constructor []constructors=class1.getDeclaredConstructors();
//            //获取class1的公开构造函数
//            Constructor [] publicConstructors=class1.getConstructors();
//            //获取class1参数类型是p的构造函数（私有也能获取）
//            Constructor constructor=class1.getDeclaredConstructor(p);
//            //获取class1参数类型是p的公开构造函数
//            Constructor publicConstructor =class1.getConstructor(p);
//            /**
//             * 以下进行构造实例user2
//             */
//            //指定实例的属性ags
//            Object []ags={25,"xiaoMing"};
//            try {
//                //如果是私有的构造方法,需要权限,公开的不需要
//                constructor.setAccessible(true);
//                //此处需要强制转换,泛型User不能传递到newInstance（）中
//                User user2= (User) constructor.newInstance(ags);
//                //此处不需要强制转换,泛型User一直传递到了newInstance（）中
//                User user3=user.getClass().getDeclaredConstructor(p).newInstance(ags);
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//            /**
//             * 以下进行实例中的私有方法的调用
//             */
//             Method method =class1.getDeclaredMethod("welcome", String.class);
//             method.setAccessible(true);
//             try {
//                 method.invoke(user,"tips");
//             } catch (IllegalAccessException e) {
//                 e.printStackTrace();
//             } catch (InvocationTargetException e) {
//                 e.printStackTrace();
//             }
//            /**
//             * 以下进行私有属性的修改
//             */
//             //此处filed是user对象的filed
//            Field field= null;
//            try {
//                User user1 = user.getClass().getDeclaredConstructor(p).newInstance(ags);
//                field = user.getClass().getDeclaredField("age");
//                field.setAccessible(true);
//                //此处使用user对象的filed修改了user1的私有属性
//                field.set(user1,295);
//                //以上说明,filed并不是专属于某个user对象的,而是属于User这个类对象的
//            } catch (NoSuchFieldException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        try {
           //User user1=user.getClass().getDeclaredConstructor(p).newInstance(ags);
//            //可以使用newInstance构造任意实例
//            try {
//                //此处filed是user对象的filed
//                Field field=user.getClass().getDeclaredField("age");
//                field.setAccessible(true);
//                //此处使用user对象的filed修改了user1的私有属性
//                field.set(user1,298);
//                //以上说明,filed并不是专属于某个user对象的,而是属于User这个类对象的
//                System.out.println(field.get(user1).toString());
//            } catch (NoSuchFieldException e) {
//                e.printStackTrace();
//            }
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        try {
//            Field field = user.getClass().getDeclaredField("age");
//            field.setAccessible(true);
//            try {
//                field.set(user,25);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//            System.out.println(user.getClass().getDeclaredField("age"));
//            try {
//                System.out.println(field.get(user).toString());
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//        Class []params ={int.class,String.class};
//        Class []prvateParams={String.class};
//        Class c1 =user.getClass();
//        try {
//            Method method =c1.getDeclaredMethod("welcome", String.class);
//            Constructor constructor = c1.getConstructor(params);
//            Constructor privateConstructor = c1.getDeclaredConstructor(prvateParams);
//            try {
//                constructor.newInstance(24,"xiaoMing");
//                privateConstructor.setAccessible(true);
//                privateConstructor.newInstance("xiaoHong");
//                method.setAccessible(true);
//                Object[] argls={"tipstips"};
//                method.invoke(user,argls);
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }

//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//         Class c4=user.getClass();
//
//        try {
//            Class [] params ={int.class,String.class};
//            Constructor constructor = c4.getDeclaredConstructor(params);
//            System.out.println(Modifier.toString(constructor.getModifiers())+"参数：");
//            Class [] parameterTypes =constructor.getParameterTypes();
//           for (Class parameterType:parameterTypes) {
//               System.out.println(parameterType.getName()+" ");
//           }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        Constructor[]constructors=c4.getDeclaredConstructors();
//        for (Constructor c :constructors) {
//            System.out.println(Modifier.toString(c.getModifiers())+"参数：");
//            Class [] parameterTypes =c.getParameterTypes();
//            for (Class parameterType:parameterTypes) {
//                System.out.println(parameterType.getName()+" ");
//            }
//            System.out.println(" ");
//        }
//        Boolean b;
//        //字面常量的方式获取Class对象,这种方式不会初始化Class对象
//        Class clazz = User.class;
//        Field field = null;
//        try {
//            field = clazz.getDeclaredField("age");
//            field.setAccessible(true);
//            //field.set(new User(),295);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }

        /**
         * 使用反射进行强制类型转换
         */
        Animal animal = new Dog();
//        System.out.println(animal instanceof Animal);
        System.out.println(Animal.class.isInstance(animal));
        Class<Dog> dog = Dog.class;
        Class.forName("Dog");
        Dog dog1=dog.cast(animal);


    }
}
