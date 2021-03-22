package cn.edu.xmu.noBlock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * @author summer
 * @date 2021/2/19 13:02
 */
public class NoBlockServer {

    public static void main(String[] args) throws IOException {
            //获取通道
            ServerSocketChannel server=
                    ServerSocketChannel.open();
            //切换成非阻塞模式
            server.configureBlocking(false);
            //绑定连接
            server.bind(new InetSocketAddress("localhost",6666));
            //获取选择器
            Selector selector = Selector.open();
            //将通道注册到选择器上
            server.register(selector, SelectionKey.OP_ACCEPT);

            //轮询地获得选择器上已就绪事件----->select()>0，说明已就绪
            while (selector.select()>0){
                //获取当前选择器所注册地选择键（已就绪地监听事件）
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                //获取已就绪的事件，不同的事件做不同的事情
                while (selector.select()>0){
                    SelectionKey selectionKey = iterator.next();
                    //接受事件已就绪
                    if(selectionKey.isAcceptable()){
                        //获取客户端的连接
                        SocketChannel client=server.accept();
                        //切换成非阻塞模式
                        client.configureBlocking(false);
                        //注册到选择器上---->拿到客户端的来凝结为了读取通道的数据,监听就绪事件
                        client.register(selector,SelectionKey.OP_ACCEPT);
                        //读事件就绪
                    }else if(selectionKey.isReadable()){
                        SocketChannel client
                                = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(10240);
                        //得到文件通道，将客户端传递过来的图片写道到本地项目下
                        FileChannel outChannel =
                                FileChannel.open(Paths.get("asdf.jpg"),
                                        StandardOpenOption.WRITE,StandardOpenOption.CREATE);
                        while(client.read(byteBuffer)>0){
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
                        server.close();
                    }

                }
                iterator.remove();
            }

    }
}
