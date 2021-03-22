package cn.edu.xmu.block;

import io.lettuce.core.StrAlgoArgs;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author summer
 * @date 2021/2/19 11:19
 */
public class Server {

    public static void main(String[] args) {

        try {
            ServerSocketChannel serverSocketChannel =
                    ServerSocketChannel.open();
            FileChannel outChannel =
                    FileChannel.open(Paths.get("test-server.jpg") ,
                            StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",6666));
            SocketChannel client = serverSocketChannel.accept();

            ByteBuffer byteBuffer = ByteBuffer.allocate(10240);

            while (client.read(byteBuffer)!=-1){
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }

            byteBuffer.put("img upload success".getBytes());
            byteBuffer.flip();
            client.write(byteBuffer);
            byteBuffer.clear();
            outChannel.close();
            client.close();
            serverSocketChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
