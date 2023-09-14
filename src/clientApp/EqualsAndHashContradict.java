package clientApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Example {

	private String name;
	private int age;

	public Example(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Example other = (Example) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
}

class Car{
	
	private String name;
	private String model;
	
	public Car(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getModel() {
		return model;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(model, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(model, other.model) && Objects.equals(name, other.name);
	}


	
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", model=" + model + "]";
	}
	
	
	
}

public class EqualsAndHashContradict {

	public static void main(String[] args) {

		Example e1 = new Example("Ganesh", 15);
		Example e2 = new Example("Ganesh", 15);

		System.out.println(e1 == e2);
		System.out.println(e1.equals(e2));
		
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		
		Map<Car,Integer> map = new HashMap<>();
		Car car1 = new Car("mustang");
		car1.setModel("A01");
		Car car2 = new Car("ford");
		car2.setModel("A02");
		Car car3 = new Car("ford");
		car3.setModel("A02");
		

		map.put(car1, 1);
		map.put(car2, 2);
		map.put(car3, 3);
		
		System.out.println(map);
		
		car1.setModel("A03");
		
		System.out.println(map);
		
		System.out.println(map.get(car1));
		
		for(Map.Entry<Car, Integer> m : map.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
		}
				
	}

}
