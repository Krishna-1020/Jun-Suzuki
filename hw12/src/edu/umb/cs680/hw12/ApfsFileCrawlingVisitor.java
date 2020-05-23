package edu.umb.cs680.hw12;

import java.util.ArrayList;

public class ApfsFileCrawlingVisitor<T> implements ApfsFSVisitor<T> {

	ArrayList<ApfsFile> files = new ArrayList<>();
	
	public void visit(ApfsLink link) {

		return;
	}

	public void visit(ApfsDirectory dir) {

		return;
	}

	public void visit(ApfsFile file) {
		files.add(file);
	}
	
	public ArrayList getFiles() {
		return files;
	}

	public static void main(String[] args) {
		System.out.println("ApfsFileCrawlingVisitor successful");
	}
}
