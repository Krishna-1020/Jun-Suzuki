package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileSystemTest {

static LocalDateTime PresentTime = LocalDateTime.of(2020, 05, 22, 0, 0);
	
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
	public void testforrootinstance() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertEquals(root.getOwnerName(), "Krishna");
		assertEquals(root.getLastModified(), PresentTime);
	}
	private String[] stringarraycreation(ApfsDirectory dir) {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(dir.getParent());
		String[] infofordirectory = { Boolean.toString(dir.isDirectory()), dir.getName(), 
				Integer.toString(dir.getSize()), dir.getCreationTime().toString(), 
				optionalDirectory.isPresent()?dir.getParent().getName():null, 
						Integer.toString(dir.getTotalSize()),
						Integer.toString(dir.countChildren()), FilesystemofApfs.getFileSystemName(), 
						Integer.toString(FilesystemofApfs.getCapacity()), dir.getOwnerName(),dir.getLastModified().toString() };
		return infofordirectory;
	}
	
	@Test
	public void testforrootstatus() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "root", "0", PresentTime.toString(), null, "3500", "2", "drive", "3500", "Krishna", PresentTime.toString()};
		ApfsDirectory actual = root.findDirByName("root");
		assertArrayEquals(expected,stringarraycreation(actual));
	}
	
	

}
