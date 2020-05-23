package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw15.APFS;
import edu.umb.cs680.hw15.ApfsDirectory;
import edu.umb.cs680.hw15.ApfsFile;
import edu.umb.cs680.hw15.ApfsLink;

class FileSystemTest {

static LocalDateTime PresentTime = LocalDateTime.of(2020, 05, 22, 0, 0);
private String[] arraystringfordirectory(ApfsDirectory directory) {
	APFS FilesystemofApfs = APFS.getAPFSFileSystem();
	Optional<ApfsDirectory> optionalDirectory = Optional.ofNullable(directory.getParent());
	String[] inforofdirectory = { Boolean.toString(directory.isDirectory()), directory.getName(), 
			Integer.toString(directory.getSize()), directory.getCreationTime().toString(), 
			optionalDirectory.isPresent()?directory.getParent().getName():null, 
					Integer.toString(directory.getTotalSize()),
					Integer.toString(directory.countChildren()), FilesystemofApfs.getFileSystemName(), 
					Integer.toString(FilesystemofApfs.getCapacity()), directory.getOwnerName(),directory.getLastModified().toString() };
	return inforofdirectory;
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
	public void Testforfileowner() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		assertEquals(root.getOwnerName(), "Krishna");
		assertEquals(root.getLastModified(), PresentTime);
	}
	
	
	@Test
	public void testfordirectorysetup() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		ApfsDirectory root = (ApfsDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "root", "0", PresentTime.toString(), null, "3500", "2", "drive", "3500", "Krishna", PresentTime.toString()};
		ApfsDirectory actual = root.findDirByName("root");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	

}
