package com.answern.cmqConsumer;

import org.slf4j.Logger;
import com.answern.cmqConsumer.base.loggerTest.*;

/**
 * 需求名称:
 * 类描述:[一句话描述该类的功能]<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/10/15 15:09]  <br/>
 * 版本:[v1.0]   <br/>
 */
public class Main {
//    public static void main(String[] args) {
//        try {
//            LogBackConfigLoader.load("D:\\work\\mywork\\cmqConsumer\\src\\main\\resources\\config\\logback-boot.xml");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JoranException e) {
//            e.printStackTrace();
//        }
//        org.slf4j.Logger logger = LoggerFactory.getLogger("snail");
//        logger.info("Hello");
//    }
    public static void main(String[] args) {
        LoggerBuilder loggerBuilder =new LoggerBuilder();
        Logger logger = loggerBuilder.getLogger("test");
        logger.debug("shuai1 +++++++++++++++++++++++++++++++++++++debug");
        logger.warn("shuai2 +++++++++++++++++++++++++++++++++++++warn");
        logger.info("shuai3 +++++++++++++++++++++++++++++++++++++info");
        logger.error("shuai4 +++++++++++++++++++++++++++++++++++++error");

        Logger logger1 = loggerBuilder.getLogger("test1");
        logger1.debug("logger1 +++++++++++++++++++++++++++++++++++++debug");
        logger1.warn("logger1 +++++++++++++++++++++++++++++++++++++warn");
        logger1.info("logger1 +++++++++++++++++++++++++++++++++++++info");
        logger1.error("logger1 +++++++++++++++++++++++++++++++++++++error");
    }

}
