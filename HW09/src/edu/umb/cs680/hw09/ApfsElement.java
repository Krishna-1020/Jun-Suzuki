package edu.umb.cs680.hw09;

import java.time.LocalDateTime;

public abstract class ApfsElement extends FSElement{
	
	private String ownerName;
	private LocalDateTime lastModified;

	public String getOwnerName() {
		return ownerName;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime Time, String ownerName, LocalDateTime lastModified) {
		super(parent, name, size, Time);
		this.ownerName = ownerName;
		this.lastModified = lastModified;
	}

	public abstract boolean isDirectory();
	
	public static void main(String[] args) {
		System.out.println("The classs ApfsElement has run successfully");
	}
}
