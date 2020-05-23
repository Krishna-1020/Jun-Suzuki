package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> child;
    public FileSystem fS;

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink() {
        return false;
    }

    public Directory(Directory parent, String name) {
        super(parent, name, 0, LocalDateTime.now());
        this.child = new LinkedList<>();
        this.fS = FileSystem.getFileSystem();
    }

    public LinkedList<FSElement> getChildren() {
        return this.child;
    }

    public void appendChild(FSElement child) {
        this.child.add(child);
        child.setParent(this);
    }

    public int countChildren() {
        return this.child.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDir = new LinkedList<>();
        for (FSElement element : this.child) {
            if (element.isDirectory()) {
                subDir.add((Directory) element);
            }
        }
        return subDir;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement element : this.child) {
            if (element.isFile()) {
                files.add((File) element);
            }
        }
        return files;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement element : this.child) {
            if (element.isDirectory()) {
                Directory subDir = (Directory) element;
                totalSize += subDir.getTotalSize();

            } else if (element.isFile()) {
                totalSize += element.getSize();
            }
        }
        return totalSize;
    }

    public static void main(String args[]) {
        Directory root, applications, home, code;
        File a, b, c, d, e, f;
        Link x, y;

        root = new Directory(null, "root");

        applications = new Directory(root, "applications");
        a = new File(applications, "a", 10);
        b = new File(applications, "b", 10);

        home = new Directory(root, "home");
        c = new File(home, "c", 10);
        d = new File(home, "d", 10);
        code = new Directory(home, "code");

        e = new File(code, "e", 10);
        f = new File(code, "f", 10);

        x = new Link(home, "x", applications);
        y = new Link(code, "y", b);

        FileSystem.getFileSystem().addRootDir(root);
    }
}