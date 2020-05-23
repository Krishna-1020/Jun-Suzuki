package edu.umb.cs680.hw12;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {

	public ApfsFile(ApfsElement parent, String name, int size, LocalDateTime creationTime, String owner,
			LocalDateTime lastModDate) {
		super(parent, name, size, creationTime, owner, lastModDate);
	}

	public Boolean isDirectory() {
		return false;
	}

	public void accept(ApfsFSVisitor vtr) {
		vtr.visit(this);
	}

	public static void main(String[] args) {
		System.out.println("ApfsFile successful");
	}
}
