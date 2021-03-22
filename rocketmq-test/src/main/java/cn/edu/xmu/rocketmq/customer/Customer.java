package cn.edu.xmu.rocketmq.customer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author issyu 30320182200070
 * @date 2021/1/16 13:32
 */
public class Customer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer(
                "customer_group_1");
        defaultMQPushConsumer.setNamesrvAddr("192.168.119.136:9876");
        defaultMQPushConsumer.setConsumeFromWhere(
                ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        defaultMQPushConsumer.subscribe(
                "customerTest","*");
        defaultMQPushConsumer.registerMessageListener(
                (MessageListenerConcurrently) (list, consumeConcurrentlyContext)
                        -> {
                    byte[] body =list.get(0).getBody();
                    try{
                        String ms = new String(body,"utf-8");
                        System.out.println(Thread.currentThread().getContextClassLoader()+"监听到消息"+ms);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                });
        defaultMQPushConsumer.start();
    }
}
