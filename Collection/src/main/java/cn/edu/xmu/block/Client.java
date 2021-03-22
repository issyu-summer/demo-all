package cn.edu.xmu.block;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author summer
 * @date 2021/2/18 22:11
 */
@Slf4j
public class Client {

    //火车和轨道
    //服务器先启动，客户端和服务器的端口和host必须都保持一致
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel =
                    SocketChannel.open(new InetSocketAddress("127.0.0.1",
                            6666));
            FileChannel fileChannel =
                    FileChannel.open(
                            Paths.get("E:\\module\\img\\resource\\test.jpg"), StandardOpenOption.READ);
            ByteBuffer byteBuffer = ByteBuffer.allocate(10240);
            //read读取到流尾是0或-1
            while (fileChannel.read(byteBuffer)!=-1){

                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
            }
            //告诉服务端数据已经输出完了
            socketChannel.shutdownOutput();
            //否则服务端不知道是否还有数据接受，会阻塞这个连接
            int len=0;
            while ((len=socketChannel.read(byteBuffer))!=-1){
                byteBuffer.flip();
                System.out.println(new String(byteBuffer.array(),0,len));
                byteBuffer.clear();
            }
            fileChannel.close();
            socketChannel.close();

            //接受服务端的数据

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
