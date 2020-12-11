//This is the subclass that represents a coffee beverage

public class Coffee extends Beverage{
	//field variables
	private boolean extraShot;
	private boolean extraSyrup;
	private final double SHOT_COST = 0.5;
	private final double SYRUP_COST = 0.5;
	
	//Constructor
	public Coffee(String n, SIZE s, boolean extraShot, boolean extraSyrup) {
		super(n, TYPE.COFFEE, s);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	//This returns the name and size of the coffee. It also
	//shows whether the customer wanted an extra shot and/or extra syrup
	@Override
	public String toString() {
		String s = getName() + "," + getSize();
		if(extraShot)
			s+="Extra shot";
		if(extraSyrup)
			s+="ExtraSyrup";
		s+=", $" + calcPrice();
		return s;
	}
	
	//This returns the price of the coffee depending on size and whether or not
	//an extra shot and/or extra syrup was ordered
	public double calcPrice() {
		double price = super.getBasePrice();
		
		//price of a medium coffee
		if(super.getSize() == SIZE.MEDIUM) {
			price+=super.getSizePrice();
		}
		//price of a large coffee
		if(super.getSize() == SIZE.LARGE) {
			price+=super.getSizePrice();
		}
		
		//price of an extra shot added
		if(extraShot) {
			price+=SHOT_COST;
		}
		
		//price of extra syrup added
		if(extraSyrup) {
			price+=SYRUP_COST;
		}
		
		return price;
	}
	
	// checks equality based on the Beverage class 
	// equals method and additional instance variables for this class.
	public boolean equals(Coffee c) {
		if (super.equals(c) && extraShot == c.getExtraShot() && 
				extraSyrup == c.getExtraSyrup()) {
			return true;
		}
		else
			return false;
	}
	
	//Setters
	
	public void setSyrup(boolean s) {
		extraSyrup = s;
	}
	
	public void setShot(boolean sh) {
		extraShot = sh;
	}
	
	//Getters
	
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	public double getShotCost() {
		return SHOT_COST;
	}
	
	public double getSyrupCost() {
		return SYRUP_COST;
	}
}


