package cn.edu.xmu.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author issyu 30320182200070
 * @date 2021/1/16 13:07
 */
public class Producer {

    public static void main(String []args){
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer(
                "producer_group_1");
        defaultMQProducer.setNamesrvAddr("192.168.119.136:9876");
        defaultMQProducer.setSendMsgTimeout(15000);
        try {
            defaultMQProducer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        for(int i=0;i<=1;i++){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            String format =simpleDateFormat.format(date);
            Message message = new Message(
                    "rocketTest",String.valueOf(i),format.getBytes());
            SendResult sendResult = new SendResult();
            try {
                sendResult=defaultMQProducer.send(message);
            } catch (MQClientException|RemotingException|MQBrokerException|InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                    "key"+i+"消息发送的结果为"+sendResult.toString()+
                            "\t消息Id为"+sendResult.getMsgId());
        }

    }
}
