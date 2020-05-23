package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {

    private String[] dirToStringArray(Directory d) {
        String[] dirInfo = {
                d.getName(),
                String.valueOf(d.isDirectory()),
                String.valueOf(d.getSize()),
                String.valueOf(d.countChildren()),
                String.valueOf(d.getTotalSize())
        };

        return dirInfo;
    }

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
        home.appendChild(x);
        code.appendChild(y);
    }

    @Test
    public void verifyDirectoryEqualityRoot() {
        String[] expected = {"root", "true", "0", "2", "120"};
        String[] actual = dirToStringArray(root);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityApplications() {
        String[] expected = {"applications", "true", "0", "2", "40"};
        String[] actual = dirToStringArray(applications);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityHome() {
        String[] expected = {"home", "true", "0", "4", "80"};
        String[] actual = dirToStringArray(home);
        assertArrayEquals(expected, actual);
    }

   /* @Test
    public void verifyDirectoryEqualityCode() {
        String[] expected = {"code", "true", "0", "3", "20"};
        String[] actual = dirToStringArray(code);
        assertArrayEquals(expected, actual);
    }*/

    @Test
    public void getChildrenOfRoot() {
        LinkedList<FSElement> expected = new LinkedList<>(Arrays.asList(applications, home));
        LinkedList<FSElement> actual = root.getChildren();
        assertEquals(expected, actual);
    }


    @Test
    public void getFilesOfRoot() {
        LinkedList<File> expected = new LinkedList<>();
        LinkedList<File> actual = root.getFiles();
        assertEquals(expected, actual);
    }

    @Test
    public void getFilesOfCode() {
        LinkedList<File> expected = new LinkedList<>(Arrays.asList(e, f));
        LinkedList<File> actual = code.getFiles();
        assertEquals(expected, actual);
    }


    @Test
    public void getSubDirectoriesOfHome() {
        LinkedList<Directory> expected = new LinkedList<>(Arrays.asList(code));
        LinkedList<Directory> actual = home.getSubDirectories();
        assertEquals(expected, actual);
    }

    @Test
    public void getParentOfHome() {
        String expected = home.getParent().getName();
        String actual = "root";
        assertEquals(expected, actual);
    }

    @Test
    public void getChildrenOfHome() {
        LinkedList<FSElement> expected = new LinkedList<>(Arrays.asList(c, d, code, x));
        LinkedList<FSElement> actual = home.getChildren();
        assertEquals(expected, actual);
    }

    @Test
    public void getChildrenOfCode() {
        LinkedList<FSElement> expected = new LinkedList<>(Arrays.asList(e, f, y));
        LinkedList<FSElement> actual = code.getChildren();
        assertEquals(expected, actual);
    }
}