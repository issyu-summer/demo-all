package streamAPI.test;

import java.util.List;
import java.util.OptionalInt;

/**
 * @author issyu 30320182200070
 * @date 2021/1/29 14:28
 */
public class StreamUtil {

    public static int getMaxLengthStartWith(String strs, List<String> stringList){
        int longest = -1;
        OptionalInt optionalInt=stringList.stream()
                .filter(str -> str.startsWith("a"))
                .mapToInt(String::length)
                //.mapToInt(String::length)
                .max();
        if(optionalInt.isPresent()){
            return optionalInt.getAsInt();
        }
        return longest;
    }
}
