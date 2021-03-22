package cn.edu.xmu.noBlock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author summer
 * @date 2021/2/19 13:02
 */
public class NoBlockClient {

    public static void main(String[] args) {

        try {
            SocketChannel socketChannel=
                    SocketChannel.open(new InetSocketAddress("localhost",6666));
            //切换成非阻塞模式
            socketChannel.configureBlocking(false);

            //发送图片给服务端
            FileChannel fileChannel=
                    FileChannel.open(
                            Paths.get("E:\\module\\img\\resource\\test.jpg"), StandardOpenOption.READ);
            ByteBuffer byteBuffer = ByteBuffer.allocate(10240);

            while (fileChannel.read(byteBuffer)!=-1){
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
            }
            fileChannel.close();
            socketChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
