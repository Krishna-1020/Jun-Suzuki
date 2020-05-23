package edu.umb.cs680.hw06;

public interface State {
    void openClosedButtonPushed();
    void playButtonPushed();
    void stopButtonPushed();
    public static void main(String[] args){
    	System.out.println("The interface has run successfully");
    }
}