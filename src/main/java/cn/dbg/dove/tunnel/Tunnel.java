package cn.dbg.dove.tunnel;


import cn.dbg.dove.station.MessageStation;

/**
 * an tunnel,can send message and receive message
 */
public interface Tunnel {
    /**
     * jdwp protocol handshake
     */
    public void jdwpHandShake();
    public void pushAndPull(MessageStation station);
}
