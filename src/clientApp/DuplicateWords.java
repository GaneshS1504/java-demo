package clientApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

final class Student1{
	
	private final Long id;
	private final String name;
	private final List<String> list;
	public Student1(Long id, String name, List<String> list) {
		super();
		this.id = id;
		this.name = name;
		List<String> list1 = new ArrayList<>();
		for(String s : list) {
			list1.add(s);
		}
		this.list=list1;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<String> getList() {
		return new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return "Student1 [id=" + id + ", name=" + name + ", list=" + list + "]";
	}
	
}


public class DuplicateWords {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		Student1 s1 = new Student1(Long.valueOf(15),"Ganesh",list);
		System.out.println(s1);
		
		s1.getList().add("c");
		
		list.add("c");
		
		System.out.println(s1);
		
		
	}
	
}
