package com.example.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author issyu 30320182200070
 * @date 2021/1/12 9:57
 */
public class Test {
    public static void main(String [] args) throws IOException {
        FileWriter fileWriter = null;
        BufferedWriter butteredWriter = null;
        String  test;
        test = "hello,test";
        //无法追加在hello,test的后面，会将hello,test作为文件名生成一个新的文件
        fileWriter = new FileWriter(test);
        butteredWriter = new BufferedWriter(fileWriter);
        butteredWriter.write(",no test no work");
        butteredWriter.flush();
        butteredWriter.close();

    }
}
