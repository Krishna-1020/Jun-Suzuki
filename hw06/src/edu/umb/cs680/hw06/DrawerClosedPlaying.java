package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State {
    private static DVDPlayer play = DVDPlayer.getInstance();
    private DrawerClosedPlaying() {}

    private static DrawerClosedPlaying instance = null;

    public static DrawerClosedPlaying getInstance() {
        if (instance == null)
            instance = new DrawerClosedPlaying();
        return instance;
    }

    @Override
    public void openClosedButtonPushed() {
        play.stop();
        play.open();
        play.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed() {
        System.out.println("Do nothing");
    }

    @Override
    public void stopButtonPushed() {
        play.stop();
        play.changeState(DrawerClosedNotPlaying.getInstance());


    }

    public static void main(String[] args){
        System.out.println("The class DrawerClosedPlaying has run successfully");
    }
}