package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ElementComparator implements Comparator<ApfsElement>{

	@Override
	public int compare(ApfsElement e1, ApfsElement e2) {
		if(e1 instanceof ApfsDirectory && e2 instanceof ApfsDirectory)
			return 3;
		else if(e1 instanceof ApfsDirectory && e2 instanceof ApfsFile)
			return 2;
		else if(e2 instanceof ApfsDirectory && e1 instanceof ApfsFile)
			return 1;
		else 
			return 0;
	}

	public static void main(String[] args) {
		System.out.println("ElementComparator successful");
	}
}
