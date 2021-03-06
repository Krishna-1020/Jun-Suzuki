package edu.umb.cs680.hw09;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement{

	public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime Time, String ownerName, LocalDateTime lastModified) {
		super(parent, name, size, Time, ownerName, lastModified);
		parent.appendChild(this);
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	public static void main(String[] args) {
		System.out.println("The class APFSfile has run successfully");
	}
}
