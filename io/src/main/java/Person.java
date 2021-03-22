/**
 * @author summer
 * @date 2021/2/21 14:24
 */
public class Person {

    private String name;
    private String password;

    public Person(String name,String password,String lastName){
        this(name,password);
        this.password=password;
    }

    public Person(String name,String password){
        this.name=name;
        this.password=password;
    }




//    public Person getPerson(String name,String password){
//        this(name,password);
//    }
}
