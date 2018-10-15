package com.answern.cmqConsumer.base;

import org.slf4j.Logger;
import com.answern.cmqConsumer.base.loggerTest.LoggerBuilder;
import org.springframework.stereotype.Component;

/**
 * 需求名称:根据 不同系统打印日志到不同文件中<br/>
 *
 * @author [wem] <br/>
 * 创建时间:[2018/10/13 11:35]  <br/>
 * 版本:[v1.0]   <br/>
 */
public class WrightFile {

    public void printFile(String info){

        String systemName=getSystemName(info);
        LoggerBuilder loggerBuilder =new LoggerBuilder();
        Logger logger = loggerBuilder.getLogger(systemName);
        logger.info(info);
    }
    private String getSystemName(String info){
        String[] infoSplit = info.split(",");
        for (String keysValue :infoSplit){
            String[] keysi = keysValue.split(":");
            if("systemName".equals(keysi[0])){
                return keysi[1];
            }
        }
        return "";
    }

}
