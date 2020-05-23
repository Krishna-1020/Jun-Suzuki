package edu.umb.cs680.hw09;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement{

	private ApfsElement target;
	
	public ApfsElement getTarget() {
		return target;
	}

	public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime Time, String ownerName, LocalDateTime lastModified, ApfsElement target) {
		super(parent, name, size, Time, ownerName, lastModified);
		this.target = target;
		parent.appendChild(this);
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	public static void main(String[] args) {
		System.out.println("The class  ApfsLink has run successfully");
	}
}
