package factory.design.chouxiang.factory;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 17:46
 */
public class MacPc implements Pc{
    public MacPc(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("Mac Pc");
    }
}
