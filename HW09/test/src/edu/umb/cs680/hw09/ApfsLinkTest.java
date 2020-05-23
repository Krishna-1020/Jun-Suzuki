package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsLinkTest {
	
	static LocalDateTime PresentTime = LocalDateTime.of(2020, 05, 22, 0, 0);
	private String[] stringelementforfs(FSElement Elementforfs) {
		Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(Elementforfs.getParent());
		String[] informationoffs = { Boolean.toString(Elementforfs.isDirectory()), Elementforfs.getName(), 
				Integer.toString(Elementforfs.getSize()), Elementforfs.getCreationTime().toString(), 
				optionalDirectory.isPresent()?Elementforfs.getParent().getName():null};
		return informationoffs;
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
	public void verifyTargetEqualityfileb() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "b", "700", PresentTime.toString(), "applications" };
		//tried for a worked in hw9
		ApfsFile actual = (ApfsFile) root.findLinkByName("y").getTarget();
		assertArrayEquals(expected,stringelementforfs(actual));
	}
	@Test
	public void testforhome() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "applications", "0", PresentTime.toString(), "root" };
		ApfsDirectory actual = (ApfsDirectory) root.findLinkByName("x").getTarget();
		assertArrayEquals(expected,stringelementforfs(actual));
	}
	
	
	@Test
	public void verifyTargetEqualityB() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "b", "700", PresentTime.toString(), "applications" };
		// this needs to return true for applications as b is a  part of applications but still returning false.
		ApfsFile actual = (ApfsFile) root.findLinkByName("y").getTarget();
		assertArrayEquals(expected,stringelementforfs(actual));
	}

}
