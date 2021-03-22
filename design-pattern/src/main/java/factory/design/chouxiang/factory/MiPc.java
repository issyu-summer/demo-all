package factory.design.chouxiang.factory;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 17:45
 */
public class MiPc implements Pc {

    public MiPc(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("mi pc");
    }
}
