package com.answern.cmqConsumer.config.quene;


import com.qcloud.cmq.Account;
import com.qcloud.cmq.CMQClientException;
import com.qcloud.cmq.QueueMeta;

public abstract class CMQAbstractQueneConsumer extends Account {
    QueueMeta queueMeta;
    String queueName;
    int pollingWaitSeconds = 10;
    int pollingIntervalSeconds = 10;

    public CMQAbstractQueneConsumer() {
    }

    public CMQAbstractQueneConsumer(String endpoint, String secretId, String secretKey) {
        super(endpoint, secretId, secretKey);
    }

    public CMQAbstractQueneConsumer(String secretId, String secretKey, String endpoint, String path, String method) {
        super(secretId, secretKey, endpoint, path, method);
    }

    public int getPollingWaitSeconds() {
        return this.pollingWaitSeconds;
    }

    public void setPollingWaitSeconds(int pollingWaitSeconds) {
        this.pollingWaitSeconds = pollingWaitSeconds;
    }

    public QueueMeta getQueueMeta() {
        return this.queueMeta;
    }

    public void setQueueMeta(QueueMeta queueMeta) {
        this.queueMeta = queueMeta;
    }

    public String getQueueName() {
        return this.queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public int getPollingIntervalSeconds() {
        return this.pollingIntervalSeconds;
    }

    public void setPollingIntervalSeconds(int pollingIntervalSeconds) {
        this.pollingIntervalSeconds = pollingIntervalSeconds;
    }

    public void initClient() {
        if (this.getQueueName() != null && this.getQueueName().length() != 0) {
            (new CMQAbstractQueneConsumer.ReceivedThread(this)).start();
        } else {
            throw new CMQClientException("CMQQueueConsumer queue init error.");
        }
    }

    public abstract boolean consume(String var1);

    abstract void receiveMq();

    final class ReceivedThread extends Thread {
        CMQAbstractQueneConsumer consumer;

        public ReceivedThread(CMQAbstractQueneConsumer consumer) {
            this.consumer = consumer;
        }
        @Override
        public void run() {
            this.consumer.receiveMq();
        }
    }
}
