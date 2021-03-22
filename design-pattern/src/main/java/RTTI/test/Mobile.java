package RTTI.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 16:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {

    private String name;
    private Long phoneNumber;

    public void contact(String person){
        System.out.println(this.name+"is contacting with person:"+person+" using "+phoneNumber);
    }
}
