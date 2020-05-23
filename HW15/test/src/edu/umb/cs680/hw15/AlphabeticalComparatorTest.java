package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw15.APFS;
import edu.umb.cs680.hw15.ApfsDirectory;
import edu.umb.cs680.hw15.ApfsElement;
import edu.umb.cs680.hw15.ApfsFile;
import edu.umb.cs680.hw15.ApfsLink;


class AlphabeticalComparatorTest {

	static LocalDateTime PresentTime = LocalDateTime.of(2020, 05, 22, 0, 0);
	private String[] Stringarrayforelement(LinkedList<ApfsElement> fsElements) {
		String[] listoffilename = new String[fsElements.size()];
		int i = 0;
		for(ApfsElement elementforapfs : fsElements) {
			listoffilename[i] = elementforapfs.getName();
			i++;
		}
		return listoffilename;
	}
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.initFileSystem("drive", 3500);
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, PresentTime, "Krishna", PresentTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, PresentTime, "Krishna", PresentTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, PresentTime, "Krishna", PresentTime);
		ApfsFile a = new ApfsFile(applications, "a", 350, PresentTime, "Krishna", PresentTime);
		ApfsFile b = new ApfsFile(applications, "b", 700, PresentTime, "Krishna", PresentTime);
		ApfsFile c = new ApfsFile(home, "c", 800, PresentTime, "Krishna", PresentTime);
		ApfsFile d = new ApfsFile(home, "d", 80, PresentTime, "Krishna", PresentTime);
		ApfsLink x = new ApfsLink(home, "x", 0, PresentTime, "Krishna", PresentTime, applications);
		ApfsFile e = new ApfsFile(code, "e", 700, PresentTime, "Krishna", PresentTime);
		ApfsFile f = new ApfsFile(code, "f", 870, PresentTime, "Krishna", PresentTime);
		ApfsLink y = new ApfsLink(code, "y", 0, PresentTime, "Krishna", PresentTime, b);
	}
	@Test
	void testorderofchild() {
		APFS Apfssystemfile = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)Apfssystemfile.getRootDir();
		String[] expected = {"applications", "home"};
		assertArrayEquals(expected,Stringarrayforelement(root.getChildren()));
	}
	@Test
	void checkOrderOfFiles() {
		APFS Apfssystemfile = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)Apfssystemfile.getRootDir();
		String[] expected = {"a", "b"};
		LinkedList<ApfsElement> actual = new LinkedList<ApfsElement>();
		for(ApfsElement apfselement : root.findDirByName("applications").getFiles()){
			actual.add(apfselement);
		}
		assertArrayEquals(expected,Stringarrayforelement(actual));
	}
	
	
	@Test
	void testdireorder() {
		APFS Apfssystemfile = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)Apfssystemfile.getRootDir();
		String[] expected = {"applications", "home"};
		LinkedList<ApfsElement> actual = new LinkedList<ApfsElement>();
		for(ApfsElement apfselement : root.getSubDirectories()){
			actual.add(apfselement);
		}
		assertArrayEquals(expected,Stringarrayforelement(actual));
	}
	
	
}
