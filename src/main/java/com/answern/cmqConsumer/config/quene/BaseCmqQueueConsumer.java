package com.answern.cmqConsumer.config.quene;

import com.qcloud.cmq.CMQClientException;
import com.qcloud.cmq.Message;
import com.qcloud.cmq.Queue;

/**
 *
 */
public abstract class BaseCmqQueueConsumer extends CMQAbstractQueneConsumer {
    public BaseCmqQueueConsumer() {
    }

    public BaseCmqQueueConsumer(String endpoint, String secretId, String secretKey) {
        super(endpoint, secretId, secretKey);
    }

    public BaseCmqQueueConsumer(String secretId, String secretKey, String endpoint, String path, String method) {
        super(secretId, secretKey, endpoint, path, method);
    }

    @Override
    public abstract boolean consume(String var1);


    public void receiveMq() {
        Queue queue;
        try {
            queue = this.getQueue(this.getQueueName());
        } catch (Exception var5) {
            var5.printStackTrace();
            throw new CMQClientException("CMQQueueConsumer queue init error.", var5);
        }

        while(true) {
            while(true) {
                try {
                    Message msg = queue.receiveMessage(this.getPollingWaitSeconds());
                    //System.out.println((new JSONObject(msg)).toString());
                    this.consume(msg, queue);
                } catch (Exception var6) {
                    //var6.printStackTrace();
                    try {
                        Thread.sleep((long)this.getPollingIntervalSeconds());
                    } catch (InterruptedException var4) {
                        var6.printStackTrace();
                    }
                }
            }
        }
    }

    public void consume(Message message, Queue queue) {
        if (this.consume(message.msgBody)) {
            try {
                queue.deleteMessage(message.receiptHandle);
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        }

    }

    final class ConsumerThread implements Runnable {
        Message message;
        Queue queue;

        public ConsumerThread(Message message, Queue queue) {
            this.message = message;
            this.queue = queue;
        }
        @Override
        public void run() {
            BaseCmqQueueConsumer.this.consume(this.message, this.queue);
        }
    }
}
