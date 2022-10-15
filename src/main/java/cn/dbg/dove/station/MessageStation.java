package cn.dbg.dove.station;

/**
 * message station has two cache queues,one is for messages need to send ,
 * the other one is for messge to get
 */
public interface MessageStation {
    /**
     * add push message to station
     */
    public boolean addPushMessage(byte[] message);

    /**
     * fetch one message which need send from station
     */
    public byte[] fetchPushMessage();

    public int getPushMessageCount();

    /**
     * add pull message to station
     */
    public boolean addPullMessage(byte[] message);

    /**
     * fetch one message which need send from station
     */
    public byte[] fetchPullMessage();

    public int getPullMessageCount();
}
