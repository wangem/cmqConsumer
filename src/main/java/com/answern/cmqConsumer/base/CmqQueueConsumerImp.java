package com.answern.cmqConsumer.base;

import com.answern.cmqConsumer.config.quene.BaseCmqQueueConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 需求名称:CMQ包提供了一个接口，必须用来实现消费者的方法<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/10/12 17:27]  <br/>
 * 版本:[v1.0]   <br/>
 */
public class CmqQueueConsumerImp extends BaseCmqQueueConsumer {

    private Logger logger = LoggerFactory.getLogger(CmqQueueConsumerImp.class);

    public CmqQueueConsumerImp(){

    }
    public CmqQueueConsumerImp(String endpoint, String secretId, String secretKey){
        super(endpoint, secretId, secretKey);
    }

    /**
     * 消费的方法
     * @param msgBody
     * @return
     */
    @Override
    public boolean consume(String msgBody) {
        WrightFile wrightFile = new WrightFile();
        if(StringUtils.isEmpty(msgBody)) {
            logger.info("消费消息内容为空");
        }
        logger.info(msgBody);
        wrightFile.printFile(msgBody);
        return true;
    }
}
