//This is the abstract class that represents the general "beverage"

public abstract class Beverage {
	//field variables
	private String bevName;             //name of the beverage
	private TYPE type;                  //type of beverage
	private SIZE size;                  //size of beverage
	private final double basePrice = 2.0;  //the base price of the beverage
	private final double sizePrice = 1.0;  //additional price if customer goes size up
	
	//Constructor
	public Beverage(String bevName, TYPE type, SIZE size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	//Abstract method that calculates and returns the beverage price
	public abstract double calcPrice();
	
	//String representation for Beverage including the name and size
	@Override
	public String toString() {
		return bevName + " " + size;
	}
	
	//Checks equality based on name, type, size of the beverage
	public boolean equals(Beverage bev) {
		if (bevName.equals(bev.getName()) && type == bev.getType() &&
				size == bev.getSize()) {
			return true;
		}
		else
			return false;
	}
	
	//Setters
	public void setName(String n) {
		bevName = n;
	}
	
	public void setType(TYPE t) {
		type = t;
	}
	
	public void setSize(SIZE s) {
		size = s;
	}
	
	//Getters
	public String getName() {
		return bevName;
	}
	
	public TYPE getType() {
		return type;
	}
	
	public SIZE getSize() {
		return size;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	
	public double getSizePrice() {
		return sizePrice;
	}
}
