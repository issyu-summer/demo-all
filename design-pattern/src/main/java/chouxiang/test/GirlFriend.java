package chouxiang.test;

/**
 * @author issyu 30320182200070
 * @date 2021/1/25 19:44
 */
public abstract class GirlFriend implements Person{

    /**
     * 说话
     */
    public abstract void speak();

    /**
     * 做饭
     */
    public abstract void cook();

    @Override
    public void walk(){
        System.out.println("she can walk like a person");
    }
}
