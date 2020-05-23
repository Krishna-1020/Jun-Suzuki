package edu.umb.cs680.hw12;

public class ApfsCountingVisitor<T> implements ApfsFSVisitor<T> {

	private int dirNumber=0;
	private int fileNumber=0;
	private int linkNumber=0;
	
	@Override
	public void visit(ApfsLink link) {
		linkNumber++;
	}
	
	@Override
	public void visit(ApfsDirectory dir) {
		dirNumber++;
		
	}
	
	@Override
	public void visit(ApfsFile file) {
		fileNumber++;
	}
	
	public int getDirNum() {
		return dirNumber;
	}
	
	public int getLinkNum() {
		return linkNumber;
	}
	
	public int getFileNum() {
		return fileNumber;
	}
	
	public static void main(String[] args) {
		System.out.println("ApfsCountingVisitor successful");
	}

}
