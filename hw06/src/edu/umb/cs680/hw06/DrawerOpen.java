package edu.umb.cs680.hw06;

public class DrawerOpen implements State {
    private static DVDPlayer play = DVDPlayer.getInstance();
    private DrawerOpen() {}

    private static DrawerOpen instance = null;

    public static DrawerOpen getInstance() {
        if (instance == null)
            instance = new DrawerOpen();
        return instance;
    }

    @Override
    public void openClosedButtonPushed() {
        play.close();
        play.changeState(DrawerClosedNotPlaying.getInstance());
    }

    @Override
    public void playButtonPushed() {
        play.close();
        play.play();
        play.changeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed() {
        System.out.println("Do nothing");
    }

    public static void main(String[] args){
        System.out.println("The class DrawerOpen has run successfully");
    }
}