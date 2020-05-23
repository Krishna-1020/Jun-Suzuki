package edu.umb.cs680.hw07;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem inst = null;
    private LinkedList<Directory> rootDir = new LinkedList<>();

    private FileSystem() {
    }

    public static FileSystem getFileSystem() {
        if (inst == null) {
            inst = new FileSystem();
        }
        return inst;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDir;
    }

    public void addRootDir(Directory rootDir) {
        this.rootDir.add(rootDir);
    }
}