import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author issyu 30320182200070
 * @date 2021/1/17 10:34
 */

public class User {

    private int age;
    private String name;
    private int id;
    static {
        System.out.println("User Loading");
    }
    public User(int age) {
        this.age = age;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("hello,"+name+"\n"+age +"old");
    }

    private User(String name) {
        this.name = name;
        System.out.println("my name is"+name);
    }

    public User() {
        System.out.println("No args Constructor");
    }

    private void welcome(String tips){
        System.out.println("hello"+name+tips);
    }
}
