/**
 * @author issyu 30320182200070
 * @date 2021/1/29 18:29
 */
public class MyThread extends Thread {
    private String name;
    public MyThread(String name){
        this.name=name;
    }
    @Override
    public void run() {
        for(int i =0;i<10;i++ ) {
            System.out.println(name+"运行：i="+i);
        }
    }

    public static void main(String[] args) {
        MyThread myThreadA = new MyThread("ThreadA");
        MyThread myThreadB = new MyThread("ThreadB");
        myThreadA.run();
        myThreadB.run();
    }
}
