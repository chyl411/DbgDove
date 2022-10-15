package cn.dbg.dove.tunnel;


import cn.dbg.dove.station.MessageStation;
import cn.hutool.core.exceptions.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.codec.binary.Hex;

/**
 * Http tunnel
 */
public class HttpTunnel implements Tunnel {
    private static Logger logger = LoggerFactory.getLogger(HttpTunnel.class);

    static MessageStation station = null;
    static Integer gapMillis = null;
    public void pushAndPull(MessageStation station) {
        this.station = station;
        // the duration of http requests gap. between prev request is over to next request is send
        gapMillis = Integer.parseInt(System.getProperty("gapMillis"));

        jdwpHandShake();
    }

    public void jdwpHandShake() {
        TODO
    }


    private static class HttpTunnelThread extends Thread {
        @Override
        public void run() {
            while (true) {
                if(HttpTunnel.station.getPushMessageCount() > 0) {
                    // because http is one request and one response, it is block when request send.
                    // so we do not need to consider message sequence .
                    StringBuilder builder = new StringBuilder();
                    while (station.getPushMessageCount() > 0) {
                        byte[] bytes = station.fetchPushMessage();
                        String hexString = Hex.encodeHexString(bytes);

                    }
                }
                try {
                    Thread.sleep(gapMillis);
                } catch (InterruptedException e) {
                    logger.error("InterruptedException occur. " + ExceptionUtil.getMessage(e));
                    e.printStackTrace();
                }
            }
        }
    }
}
