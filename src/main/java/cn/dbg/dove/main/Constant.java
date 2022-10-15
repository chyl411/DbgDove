package cn.dbg.dove.main;


public class Constant {
    public enum MODE {
        CLIENT("CLIENT"),
        SERVER("SERVER");

        String mode;
        private MODE(String m) {
            this.mode = m;
        }

        String getMode() {
            return mode;
        }
    }
}
