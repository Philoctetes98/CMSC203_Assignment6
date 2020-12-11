//This class represents a customer 

public class Customer {
	//field variables
	private String name;
	private int age;
	
	//Constructor
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//Copy Constructor
	public Customer(Customer c) {
		name = c.getName();
		age = c.getAge();
	}
	
	//String representation for Customer including the name and age
	//getters and setters  and any other methods that are needed for your design.
	@Override
	public String toString() {
		return name + ", " + age;
	}
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

}
