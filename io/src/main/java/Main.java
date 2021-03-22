//import lombok.extern.slf4j.Slf4j;
//
//import java.io.File;
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
///**
// * @author summer
// * @date 2021/2/20 23:18
// */
//@Slf4j
//public class Main {
//
////    public static void main(String[] args) {
////        String folder = "D:\\test";
////        List<File>files= new ArrayList<>();
////        traverse(folder);
////        System.out.println(n);
////    }
//public static void main(String[] args) {
////    File fl=new File("D:\\test");
////    dgfile(fl);
//    System.out.println(2<<3);
//    System.out.println(Math.round(11.5));
//    short s1=0;
//    s1+=1;
//    final int i=1;
//    Integer a=0;
//    i+=1;
//}
//
//    private static void dgfile(File fl) {
//        File[] fl1 = fl.listFiles();
//        if (fl.isDirectory()){
//            for (File file : fl1) {
//                System.out.println(file.getPath());
//                if (file.isDirectory()){
//                    dgfile(file);
//                }
//            }
//        }
//    }
//
//    static int n=0;
//    private static void traverse(String fileName){
//        IntStream.range(0, n).mapToObj(i -> "\t").forEach(System.out::print);
//        System.out.print("|");
//        System.out.println(fileName);
//        File file = new File(fileName);
//        List<String> fileNames=new ArrayList<>();
//        if(file.isDirectory()){
//            n++;
//            fileNames=Arrays.stream(Objects.requireNonNull(file.listFiles())).map(f->fileName+"\\"+f.getName()).collect(Collectors.toList());
//            fileNames.forEach(Main::traverse);
//        }
//    }
//}
//
