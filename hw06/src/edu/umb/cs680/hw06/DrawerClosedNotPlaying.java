package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements State {
    private static DVDPlayer play = DVDPlayer.getInstance();
    private DrawerClosedNotPlaying() {}

    private static DrawerClosedNotPlaying instance = null;

    public static DrawerClosedNotPlaying getInstance() {
        if (instance == null)
            instance = new DrawerClosedNotPlaying();
        return instance;
    }

    @Override
    public void openClosedButtonPushed() {
        play.open();
        play.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed() {
        play.play();
        play.changeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed() {
        System.out.println("Do nothing");
    }

    public static void main(String[] args){
        System.out.println("The DrawerClosedNotPlaying has run successfully");
    }
}