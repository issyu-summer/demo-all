package factory.design.chouxiang.factory;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 17:48
 */
public class MiPhone implements Phone{
    public MiPhone(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("Mi Phone");
    }
}
