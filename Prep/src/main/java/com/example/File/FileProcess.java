package com.example.File;

import java.util.ArrayList;
import java.util.List;

public class FileProcess {
public static void main(String[] args) {
	dir d1=new dir("doc");
	file f1=new file("f1", 100);
	file f2=new file("f2", 300);
	dir d2=new dir("pdf");
	d1.add(f1);
	d2.add(f2);
	d2.add(d1);
	System.out.println(d2.size());
}
}

interface fileentity{
	String name();
	int size();
}

class file implements fileentity{
	String name;
	int size;
	@Override
	public String name() {
		return name;
	}
	@Override
	public int size() {
		return size;
	}
	public file(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}
}

class dir implements fileentity{
	String name;
	//has a relationship
	List<fileentity> child;
	@Override
	public String name() {
		return name;
	}
	@Override
	public int size() {
		return child.stream().mapToInt(fileentity::size).sum();
	}
	public void add(fileentity name) {
		child.add(name);
	}
	public dir(String name) {
		super();
		this.name = name;
		this.child = new ArrayList<>();
	}	
	
}
