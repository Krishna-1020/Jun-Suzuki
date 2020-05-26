package edu.umb.cs680.hw08;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem inst = null;
    private LinkedList<Directory> rootDirs = new LinkedList<>();

    private FileSystem() {}

    public static FileSystem getFileSystem() {
        if (inst == null) {
            inst = new FileSystem();
        }
        return inst;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDirs;
    }

    public void addRootDir(Directory rootDir) {
        this.rootDirs.add(rootDir);
    }
    public static void main(String[] args) {
        System.out.println("The File has run completely");
    }
}
