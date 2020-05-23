package edu.umb.cs680.hw07;

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

    @BeforeAll
    public static void setUp() {
        root = new Directory(null, "root");

        applications = new Directory(root, "applications");
        home = new Directory(root, "home");
        root.appendChild(applications);
        root.appendChild((home));

        a = new File(applications, "a", 10);
        b = new File(applications, "b", 10);
        applications.appendChild(a);
        applications.appendChild(b);


        c = new File(home, "c", 10);
        d = new File(home, "d", 10);
        code = new Directory(home, "code");
        home.appendChild(c);
        home.appendChild(d);
        home.appendChild(code);

        e = new File(code, "e", 10);
        f = new File(code, "f", 10);
        code.appendChild(e);
        code.appendChild(f);
    }

    @Test
    public void verifyDirectoryEqualityRoot() {
        String[] expected = {"root", "true", "0", "2", "60"};
        String[] actual = dirToStringArray(root);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityApplications() {
        String[] expected = {"applications", "true", "0", "2", "20"};
        String[] actual = dirToStringArray(applications);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityHome() {
        String[] expected = {"home", "true", "0", "3", "40"};
        String[] actual = dirToStringArray(home);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityCode() {
        String[] expected = {"code", "true", "0", "2", "20"};
        String[] actual = dirToStringArray(code);
        assertArrayEquals(expected, actual);
    }

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
        LinkedList<FSElement> expected = new LinkedList<>(Arrays.asList(c, d, code));
        LinkedList<FSElement> actual = home.getChildren();
        assertEquals(expected, actual);
    }


}
