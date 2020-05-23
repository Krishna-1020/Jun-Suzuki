package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFS extends FileSystem {

	private static APFS a = null;

	private APFS() {
	}

	public static APFS getFileSystem() {
		if (a == null) {
			a = new APFS();
			a.initFileSystem("Root", 1800);
		}
		return a;
	}

	public LinkedList<ApfsElement> getRootDirs(ApfsElement b) {
		LinkedList<ApfsElement> child = new LinkedList<>();
		while (b.getParent() != null) {
			child.add(b.getParent());
			b = b.getParent();
		}
		return child;
	}

	protected FSElement createDefaultRoot() {
		return new ApfsDirectory(null, "Root", 0, LocalDateTime.of(2019, 2, 2, 12, 0), "author", null);
	}

	public void setRootDir(ApfsDirectory dir) {
		super.setRoot(dir);
	}

	public ApfsDirectory getRootDir() {
		return (ApfsDirectory) this.getRoot();
	}

	public static void main(String[] args) {
		System.out.println("APFS successful");
	}
}