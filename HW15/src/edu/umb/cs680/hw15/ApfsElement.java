package edu.umb.cs680.hw15;

import java.time.LocalDateTime;

public abstract class ApfsElement extends FSElement{
	public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime Time, String ownerName, LocalDateTime lastModified) {
		super(parent, name, size, Time);
		this.ownerName = ownerName;
		this.lastModified = lastModified;
	}
	private String ownerName;
	private LocalDateTime lastModified;

	public String getOwnerName() {
		return ownerName;
	}
	public abstract boolean isDirectory();
	public LocalDateTime getLastModified() {
		return lastModified;
	}

	
	public static void main(String[] args) {
		System.out.println("The class ApfsElement has run successfully");
	}
}
