package factory.design.chouxiang.factory;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 17:49
 */
public class IPhone implements Phone{
    public IPhone(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("IPhone");
    }
}
