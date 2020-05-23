package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSystemTest {
    private static Directory root, applications, home, code;
    private static File a, b, c, d, e, f;
    private static Link x, y;

    @BeforeAll
    public static void setUp() {
        root = new Directory(null, "root");

        applications = new Directory(root, "applications");
        home = new Directory(root, "home");
        root.appendChild(applications);
        root.appendChild((home));

        a = new File(applications, "a", 20);
        b = new File(applications, "b", 20);
        applications.appendChild(a);
        applications.appendChild(b);


        c = new File(home, "c", 20);
        d = new File(home, "d", 20);
        code = new Directory(home, "code");
        home.appendChild(c);
        home.appendChild(d);
        home.appendChild(code);

        e = new File(code, "e", 20);
        f = new File(code, "f", 20);
        code.appendChild(e);
        code.appendChild(f);

        x = new Link(home, "x", applications);
        y = new Link(code, "y", b);
    }

    @Test
    public void getRootDirsOfFileSystem() {
        FileSystem.getFileSystem().addRootDir(root);

        LinkedList<Directory> expected = new LinkedList<>(Arrays.asList(root));
        LinkedList<Directory> actual = FileSystem.getFileSystem().getRootDirs();
        assertEquals(expected, actual);
    }
}
