//This is the class for the order
import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable {
	//field variables
	private int orderNumber;  
	private int orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverages;
	
	//Constructor
	public Order(int orderTime, DAY orderDay, Customer customer) {
		orderNumber = genOrderNum();
		this.orderDay = orderDay;
		this.orderTime = orderTime;
		this.customer = customer; 
		beverages = new ArrayList<>();
	}
	
	//A method to generate a random number within the range of 10000 and 90000
	public int genOrderNum() {
		//generate a new random object
		Random rand = new Random();
		
		//set up the range in the rand object
		int randInt = rand.nextInt(90000-10000) + 10000;
		
		//return the random value
		return randInt;
	}
	
	//Includes order number, time, day, customer name , 
	// customer age and the list of beverages (with information of the beverage).
	@Override
	public String toString() {
		String c = "-----------------------------------------" + orderDay.toString() +
				", " + orderTime + "\n" + customer.toString() + " Order Num: " + 
				orderNumber;
		for (Beverage b: beverages) {
			c+="\n" + b.toString();
		}
		
		c+="\nOrderTotal: " + calcOrderTotal();
		
		return c;
	}
	
	//This is to check if it is a weekend which incorporates the alcohol fee
	public boolean isWeekend() {
		if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			return true;
		}
		else
			return false;
	}
	
	//this retrieves the beverage item number
	public Beverage getBeverage(int itemNum) {
		return beverages.get(itemNum);
	}
	
	//This checks the order number and works as validation
	public int compareToOne(Order o) {
		if(orderNumber == o.getOrderNo()) {
			return 0;
		}
		else if (orderNumber > o.getOrderNo()) {
			return 1;
		}
		else
			return -1;
	}
	
	//This calculates the total of the order
	public double calcOrderTotal() {
		//accumulator
		double orderTotal = 0;
		
		for (Beverage b: beverages) {
			orderTotal+=b.calcPrice();
		}
		return orderTotal;
	}
	
	//this returns the number of the beverage type 
	public int findNumOfBeveType(TYPE type) {
		int count = 0;
		
		for(Beverage b: beverages) {
			if(b.getType() == type) {
				count++;
			}
		}
		return count;
	}
	
	//This returns the total amount of items purchased
	public int getTotalItems() {
		return beverages.size();
	}
	
	/** ADD BEVERAGES **/
	public void addNewBeverage(String name, SIZE size, 
			boolean extraShot, boolean extraSyrup) {
		Coffee c = new Coffee(name,size,extraShot,extraSyrup);
		beverages.add(c);
	}
	
	public void addNewBeverage(String name, SIZE size, 
			int fruits, boolean addProtein) {
		Smoothie s = new Smoothie(name,size,fruits,addProtein);
		beverages.add(s);
	}
	
	public void addNewBeverage(String name, SIZE size) {
		boolean isWeekend = false;
		if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			isWeekend = true;
		}
		Alcohol a = new Alcohol(name,size, isWeekend);
		beverages.add(a);
	}
	
	//Setters 
	
	public void setOrderNum(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}
	
	public void setOrderDay(DAY day) {
		this.orderDay = day;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	//Getters
	public int getOrderNo() {
		return orderNumber;
	}
	
	public int getOrderTime() {
		return orderTime;
	}
	
	public DAY getOrderDay() {
		return orderDay;
	}
	public Customer getCustomer() {
		return new Customer(customer);
	}
	
	public ArrayList<Beverage> getBeverages(){
		return beverages;
	}
	
	public int compareTo(Object o) {
	       // TODO Auto-generated method stub
	       return 0;
	   }
	
}
