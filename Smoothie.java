//This is the subclass which represents a smoothie beverage

public class Smoothie extends Beverage{
	//field variables
	private int fruits;
	private boolean addProtein;
	private double proteinCost = 1.50;
	private double fruitCost = 0.50;
	
	//Constructor
	public Smoothie(String n, SIZE s, int fruits, boolean addProtein) {
		super(n,TYPE.SMOOTHIE, s);
		this.fruits = fruits;
		this.addProtein = addProtein;
	}
	
	//String representation of a Smoothie drink including the name , 
	// size, whether or not protein is added , number of fruits and the price
	@Override
	public String toString() {
		String s = getName() + ", " + getSize() + ", " + fruits;
		
		if(addProtein) {
			s+="Protein Powder";
		}
		s+=", $" + calcPrice();
		
		return s;
	}
	
	//checks equality based on the Beverage class equals 
	// method and additional instance variables for this class.
	public boolean equals(Smoothie s) {
		if (super.equals(s) && fruits == s.getFruits() && addProtein == s.getProtein()) {
			return true;
		}
		else
			return false;
	}
	
	//This returns the price of the smoothie depending on size and whether or not
	//fruits and/or proteins were added
	public double calcPrice() {
		double price = super.getBasePrice();
		
		if(super.getSize() == SIZE.MEDIUM) {
			price+=super.getSizePrice();
		}
		
		if(super.getSize() == SIZE.LARGE) {
			price += 2*super.getSizePrice();
		}
		
		if(addProtein) {
			price+=proteinCost;
		}
		
		return price;
	}
	
	//Setters
	public void setNumOfFruits(int numFruits) {
		fruits = numFruits;
	}
	
	public void setAddProtein(boolean addProtein) {
		this.addProtein = addProtein;
	}
	
	//Getters
	public int getFruits() {
		return fruits;
	}
	
	public boolean getProtein() {
		return addProtein;
	}
	
	public double getFruitCost() {
		return fruitCost;
	}
	
	public double getProteinCost() {
		return proteinCost;
	}
}
