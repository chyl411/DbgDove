package cn.dbg.dove.main;

import cn.dbg.dove.station.MessageStation;
import cn.dbg.dove.station.MessageStationImpl;
import cn.dbg.dove.tunnel.HttpTunnel;
import cn.dbg.dove.tunnel.Tunnel;
import cn.dbg.dove.tunnel.WsTunnel;
import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApplicationStarter {
    Logger logger = LoggerFactory.getLogger(ApplicationStarter.class);

    /**
     * start with mode client or server,default value is client
     * decide with "mode" environment vairable
     * @param args
     */
    public void run(String[] args) {
        String mode = System.getProperty("mode");
        if (StrUtil.equals(mode, Constant.MODE.SERVER.getMode())) {
            startServer();
        } else {
            startClient();
        }
    }

    /**
     * start with server mode
     */
    private void startServer() {}

    /**
     * start with client mode
     */
    private void startClient() {
        logger.info("starting client......");
        MessageStation messageStation = createStation();
        startTunnel(messageStation);
        // startListen();
    }

    private MessageStation createStation() {
        logger.info("create MessageStationImpl.");
        return new MessageStationImpl();
    }

    /**
     * start tunnel thread ,fetch push messages and send, get messages and store in station
     */
    private void startTunnel(MessageStation station) {
        logger.info("create startTunnelThread");
        String protocol = System.getProperty("protocol");
        Tunnel tunnel = null;
        if(StrUtil.equals(protocol, "ws")) {
            tunnel = new WsTunnel();
        } else {
            tunnel = new HttpTunnel();
        }
        tunnel.pushAndPull(station);
    }
}
