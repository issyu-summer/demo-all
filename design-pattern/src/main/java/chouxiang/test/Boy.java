package chouxiang.test;

/**
 * @author issyu 30320182200070
 * @date 2021/1/25 19:46
 */
public class Boy {

    private GirlFriend girlFriend;

    public Boy(){

        girlFriend = new ChinaGirlFriend();
    }

    public void showGirlFriend(){
        girlFriend.speak();
        girlFriend.cook();
        /**
         * 调用的是父类（abstract-class:GirlFriend中实现的相应接口的方法）
         */
        girlFriend.walk();
    }
}
