import java.io.*;

/**
 * @author summer
 * @date 2021/2/21 9:15
 */
public class FileUtil {


    public static void main(String[] args) {
        File file= new File("E:\\Skul.exe");
        //transferTo(file,"D:\\test\\test2.txt");
        splitFile(file);
        submerge();
    }

    private static void submerge(){
        String name = "Skul";
        String type=".exe";
        String fileName;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(name+type),true);
            for(int i=0;i<4;i++) {
                fileName=name+i+type;
                File file = new File(fileName);
                byte [] bytes = new byte[(int) file.length()];
                FileInputStream fileInputStream =new FileInputStream(file);
                fileInputStream.read(bytes);
                fileOutputStream.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void splitFile(File file){
        String tmp=file.getName();
        StringBuilder stringBuilder = new StringBuilder(tmp);
        long length =file.length();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte [] bytes =new byte[(int) length];
            fileInputStream.read(bytes);
            int fileNum= Math.toIntExact(length / 100 / 1024 + 1);
            for(int i = 0; i<fileNum; i++){
                FileOutputStream fileOutputStream =
                        new FileOutputStream(String.valueOf(stringBuilder.insert(tmp.lastIndexOf("."),i)));
                stringBuilder = new StringBuilder(tmp);
                if(i<3) {
                    fileOutputStream.write(bytes, i * 100 * 1024, 100 * 1024);
                }else {
                    fileOutputStream.write(bytes,3*100*1024, (int) (length-3*100*1024));
                }
                fileOutputStream.close();
            }
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 任何文件都可以使用字节流。
     * 当输出流的文件不存在时会自动创建文件
     */
    public static void transferTo(File file,String path){
        try {
            FileInputStream fileInputStream= new FileInputStream(file);
            byte [] bytes= new byte[(int) file.length()];
            fileInputStream.read(bytes);
            File file1=new File(path);
            FileOutputStream fileOutputStream =new FileOutputStream(file1);
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
