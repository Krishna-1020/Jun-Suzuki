package edu.umb.cs680.hw06;

public class DVDPlayer {

    private static DVDPlayer instance = null;
    private static State st;

    private DVDPlayer() {
        st = DrawerClosedNotPlaying.getInstance();;
    }

    public static DVDPlayer getInstance() {
        if (instance == null) {
            instance = new DVDPlayer();
        }

        return instance;
    }

    public Object getCurrentState() {
		return st;
	}

    public void changeState(State s) {
        st = s;
    }

    public void openCloseButtonPushed() {
        st.openClosedButtonPushed();
    }

    public void playButtonPushed() {
        st.playButtonPushed();
    }

    public void stopButtonPushed() {
        st.stopButtonPushed();
    }

    public void open() {
        System.out.println("Open Drawer");
    }

    public void close() {
        System.out.println("Close Drawer");
    }

    public void play() {
        System.out.println("Play DVD");
    }

    public void stop() {
        System.out.println("Stop playing DVD");
    }

    public static void main(String args[]) {
        DVDPlayer player = DVDPlayer.getInstance();
        player.openCloseButtonPushed();
        player.playButtonPushed();
        player.stopButtonPushed();
        player.openCloseButtonPushed();
        player.stopButtonPushed();
        player.openCloseButtonPushed();
        player.playButtonPushed();
    }
}