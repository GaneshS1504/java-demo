package clientApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student implements Cloneable{
	
	private Long id;
	private String name;
	private List<String> subjects = new ArrayList<>();
	
	public Student(Long id, String name, List<String> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.subjects = subjects;
	}
	
	public Student(Long long1, String string) {
		this.id = long1;
		this.name = string;
	}
	
	public Student() {
		super();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
	
		Student student = new Student();
		student.setId(this.getId());
		student.setName(this.getName());
		for(String s : this.getSubjects()) {
			student.getSubjects().add(s);
		}
		
		return student;

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", subjects=" + subjects + "]";
	}
	
	public void addSubjects() {
		
		subjects.add("Maths");
		subjects.add("Science");
	}
	
}



public class ObjectCloneExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Student student1 = new Student(Long.valueOf(15),"Ganesh");
		student1.addSubjects();
		System.out.println("Before clone"+student1);
		
		Student student2 = (Student) student1.clone();
		
		student1.getSubjects().add("English");
		System.out.println("After Clone"+student1);
		
		System.out.println("Cloned Object"+student2);
		
	}

}
