//This is the subclass that represents an alcoholic beverage

public class Alcohol extends Beverage{
	//field variables
	private boolean isWeekend;
	private final double weekendFee = 0.6;
	
	//Constructor
	public Alcohol(String n, SIZE s, boolean isWeekend) {
		super(n,TYPE.ALCOHOL,s);
		this.isWeekend = isWeekend;
	}
	
	//String representation of a alcohol drink including the name, size, 
	// whether or not beverage is offered in the weekend and the price.
	@Override
	public String toString() {
		String s = getName() + ", " + getSize();
		
		if(isWeekend) {
			s+=" Weekend";
		}
		
		s+= ", $" + calcPrice();
		return s;
	}
	
	//checks equality based on the Beverage class equals method 
	// and additional instance variables for this class.
	public boolean equals(Alcohol a) {
		if(super.equals(a) && isWeekend == a.getWeekend()) {
			return true;
		}
		else
			return false;
	}
	
	//This returns the price of the alcohol depending on size and whether or not
	//it was purchased during the weekend
	public double calcPrice() {
		double price = super.getBasePrice();
		
		if(super.getSize() == SIZE.MEDIUM) {
			price+=super.getSizePrice();
		}
		
		if(super.getSize() == SIZE.LARGE) {
			price += 2*super.getSizePrice();
		}
		
		if(isWeekend) {
			price+=weekendFee;
		}
		
		return price;
	}
	
	//Setters
	public void setWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}
	
	//Getters
	public boolean getWeekend() {
		return isWeekend;
	}
	
	public double getWeekendFee() {
		return weekendFee;
	}
}