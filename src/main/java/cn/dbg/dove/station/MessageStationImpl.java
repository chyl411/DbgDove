package cn.dbg.dove.station;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * message station has two cache queues,one is for messages need to send ,
 * the other one is for messge to get
 */
public class MessageStationImpl implements MessageStation {
    /**
     * cache messages need to push
     */
    ConcurrentLinkedQueue<byte[]> pushMessageQueue = new ConcurrentLinkedQueue<byte[]>();
    /**
     * cache message need to pull
     */
    ConcurrentLinkedQueue<byte[]> pullMessageQueue = new ConcurrentLinkedQueue<byte[]>();


    public boolean addPushMessage(byte[] message) {
        return pushMessageQueue.add(message);
    }

    public byte[] fetchPushMessage() {
        return pushMessageQueue.poll();
    }

    public int getPushMessageCount() {
        return pushMessageQueue.size();
    }

    public boolean addPullMessage(byte[] message) {
        return pullMessageQueue.add(message);
    }

    public byte[] fetchPullMessage() {
        return pullMessageQueue.poll();
    }

    public int getPullMessageCount() {
        return pullMessageQueue.size();
    }

}
