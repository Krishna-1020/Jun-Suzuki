package edu.umb.cs680.hw09;

import java.time.LocalDateTime;

public abstract class FSElement {
	private String name;
	private int size;
	private LocalDateTime Time;
	private ApfsDirectory parent; 
	public int getSize() {
		return size;
	}
	public FSElement(ApfsDirectory parent, String name, int size, LocalDateTime Time) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.Time = Time;
	}
	
	
	public String getName() {
		return name;
	}
	
	public LocalDateTime getCreationTime() {
		return Time;
	}
	
	public ApfsDirectory getParent() {
		return parent;
	}
	public abstract boolean isDirectory();
	
	public static void main(String[] args) {
		System.out.println("The class FSElement ran successfully");
	}
}
