/**
 * ========================================================
 * Copyright(c) 2018 杭州旭智科技有限公司-版权所有
 * ========================================================
 * 本软件由杭州旭智科技有限公司所有, 未经书面许可, 任何单位和个人不得以
 * 任何形式复制代码的部分或全部, 并以任何形式传播。
 * 公司网址
 * <p>
 * http://www.xuzhistudy.com/
 * <p>
 * ========================================================
 */

package com.rocketmq.test;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : fengkewei
 * @date : 2019/3/19
 * @description :
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRocketmqApplication.class)
public class DefaultProductTest {

    private static final Logger logger = LoggerFactory.getLogger(DefaultProductTest.class);

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @Test
    public void send() throws MQClientException, RemotingException, MQBrokerException, InterruptedException{
        String msg = "demo msg test";
        logger.info("开始发送消息：" + msg);
        Message sendMsg = new Message("DemoTopic", "DemoTag", msg.getBytes());
        //默认3秒超时
        SendResult sendResult = defaultMQProducer.send(sendMsg);
        logger.info("消息发送响应信息：" + sendResult.toString());
    }
}
