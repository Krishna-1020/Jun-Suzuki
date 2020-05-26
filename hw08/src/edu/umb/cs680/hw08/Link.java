package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class Link extends FSElement {
    private FSElement tar;

    public Link(Directory parent, String name, FSElement tar) {
        super(parent, name, 0, LocalDateTime.now());
        this.tar = tar;
    }

    public boolean isDirectory() {
        return false;
    }

    public boolean isFile() {
        return false;
    }

    public boolean isLink() {
        return true;
    }

    public FSElement getTarget() {
        return this.tar;
    }
    public static void main(String[] args) {
        System.out.println("The Link has run successfully");
    }
}
