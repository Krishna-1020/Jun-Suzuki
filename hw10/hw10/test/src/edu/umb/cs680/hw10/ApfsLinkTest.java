package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsLinkTest {
	
	static LocalDateTime localTime = LocalDateTime.of(2020, 04, 22, 0, 0);
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
		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "Krishna", localTime);
		ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "Krishna", localTime);
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "Krishna", localTime);
		ApfsFile a = new ApfsFile(applications, "a", 350, localTime, "Krishna", localTime);
		ApfsFile b = new ApfsFile(applications, "b", 700, localTime, "Krishna", localTime);
		ApfsFile c = new ApfsFile(home, "c", 800, localTime, "Krishna", localTime);
		ApfsFile d = new ApfsFile(home, "d", 80, localTime, "Krishna", localTime);
		ApfsLink x = new ApfsLink(home, "x", 0, localTime, "Krishna", localTime, applications);
		ApfsFile e = new ApfsFile(code, "e", 700, localTime, "Krishna", localTime);
		ApfsFile f = new ApfsFile(code, "f", 870, localTime, "Krishna", localTime);
		ApfsLink y = new ApfsLink(code, "y", 0, localTime, "Krishna", localTime, b);
	}
	
	@Test
	public void testforhome() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "home", "0", localTime.toString(), "root" };
		ApfsDirectory actual = root.findDirByName("home");
		assertArrayEquals(expected,stringelementforfs(actual));
	}
	
	@Test
	public void verifyTargetEqualitya() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "a", "350", localTime.toString(), "applications" };
		// this needs to return true for applications as b is a  part of applications but still returning false.
		ApfsFile actual = root.findFileByName("a");
		assertArrayEquals(expected,stringelementforfs(actual));
	}
	@Test
	public void verifyTargetEqualityB() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "false", "b", "700", localTime.toString(), "applications" };
		// this needs to return true for applications as b is a  part of applications but still returning false.
		ApfsFile actual = root.findFileByName("b");
		assertArrayEquals(expected,stringelementforfs(actual));
	}

}

