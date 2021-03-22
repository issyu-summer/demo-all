package streamAPI.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author issyu 30320182200070
 * @date 2021/1/29 14:59
 */
public class Main {
    private static String convert(int i){
        if(i==1){
            return "one";
        }else if(i==2){
            return "two";
        }else if(i==3){
            return "three";
        }else if(i==4){
            return "four";
        }else if(i==5){
            return "five";
        }else if(i==6){
            return "six";
        }else {
            return null;
        }
    }
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,1,1,1,2,3,4,5,6,8,8,9);
        //Stream<Integer> stream = integerList.stream().filter(x->x<=5);
        Map map =
                integerList.stream().collect(Collectors.toMap(Main::convert, v -> v, (v1, v2) -> v1));
        List<Integer> integerList1 = integerList.stream().filter(x->x>=4)
                .collect(Collectors.toList());
        integerList1.forEach(System.out::println);
//        Integer integer=stream.collect(Collectors.summingInt(Integer::intValue));
//        System.out.println(integer);
        //stream.max(Integer::compareTo).ifPresent(System.out::println);
//        stream.findFirst().ifPresent(System.out::println);
//        if(stream.allMatch(i->i==1)){
//            System.out.println("所有值都等于1");
//        }else{
//            System.out.println("存在一个值不等于1");
//        }
//
        //stream.map(Main::convert).forEach(System.out::println);
        //stream.distinct().forEach(System.out::println);
        //stream.limit(8).skip(4).forEach(System.out::print);
        //List<Integer> integerList1 =stream.collect(Collectors.toList());
        //integerList1.forEach(System.out::print);
    }
}
