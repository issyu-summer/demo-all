package RTTI.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author issyu 30320182200070
 * @date 2021/1/28 16:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computer {

    private String name;
    private Long id;

    public void play(String game){
        System.out.println("playing computer game:"+game);
    }

    private void part(){

    }
    private void  part(String test){

    }
}
