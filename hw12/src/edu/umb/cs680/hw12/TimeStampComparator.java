package edu.umb.cs680.hw12;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<ApfsElement>{

	public int compare(ApfsElement e1, ApfsElement e2) {
		return e1.getCreationTime().compareTo(e2.getCreationTime());
	}

	public static void main(String[] args) {
		System.out.println("TimeStampComaprator successful");
	}

}
