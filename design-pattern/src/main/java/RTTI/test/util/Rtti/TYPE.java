package RTTI.test.util.Rtti;

public enum TYPE{
    COMPUTER(0,"RTTI.test.Computer"),
    MOBILE(1,"RTTI.test.Mobile");
    private int code;
    private String className;

    TYPE(int code,String className){
        this.code=code;
        this.className =className;
    }
    String getClassName(){
        return this.className;
    }
    int getCode(){
        return this.code;
    }
}
