package edu.umb.cs680.hw12;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsElement> {

	public int compare(ApfsElement e1, ApfsElement e2) {
		return e1.getName().toString().compareTo(e2.getName().toString());
	}

	public static void main(String[] args) {
		System.out.println("The AlphabeticalComparator has run completely");
	}

}
