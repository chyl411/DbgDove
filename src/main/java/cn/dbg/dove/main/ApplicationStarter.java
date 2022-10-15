package cn.dbg.dove.main;

import cn.hutool.core.util.StrUtil;

public class ApplicationStarter {
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
    private void startClient() {}
}
