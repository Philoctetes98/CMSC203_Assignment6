//This is the BevShop class

import java.util.ArrayList;

public class BevShop implements BevShopInterface{
	//field variables
	private int currentOrder;
	private int numOfAlcoholInOrder;
	private ArrayList<Order> orders;
	
	//Constructor
	public BevShop() {
		orders = new ArrayList<>();
	}
	
	//The string representation of all the orders and the total monthly sale.  
	@Override
	public String toString() {
		String s = "Monthly Orders\n";
		
		for(Order o: orders) {
			s+=o.toString();
		}
		
		s+="Total Monthly Sale: " +totalMonthlySale();
		return s;
	}
	
	//checks if the number of alcohol beverages for the current order 
    // has reached the maximum return true if number of alcohol drinks
	//for the current order has reached the maximum , false otherwise
	public boolean validTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		}
		else
			return false;
	}
	
	//check the valid age for the alcohol drink
	 // the parameter is age and returns true if age is more than
	 // minimum eligible age , false otherwise  
	public boolean validAge(int age) {
		if (age >= MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		else
			return false;
	}
	
	 //checks if the number of alcohol beverages for the current order 
	 // has reached the maximum
	 // return true if number of alcohol drinks for the current order 
	// has reached the maximum , false otherwise
	public boolean eligibleForMore() {
		if (numOfAlcoholInOrder < MAX_ORDER_FOR_ALCOHOL) {
			return true;
		}
		else
			return false;
	}
	
	//This is to check if the drink has reached the maximum amount of fruits
	public boolean isMaxFruit(int num) {
		if(num > MAX_FRUIT) {
			return true;
		}
		else
			return false;
	}
	
	//Creates a new order ,  NO BEVERAGE is added to the order yet 
	//time is a parameter which represents the time of the order  
	// day is a parameter which represents the day of the order of type DAY
	//Customer name and Customer age are also parameters
	public void startNewOrder(int time, DAY day, String customerName,
		 	int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day,customer);
		
		orders.add(order);
		currentOrder = orders.indexOf(order);
		numOfAlcoholInOrder = 0;
	}
	
	/**
	 * process the Coffee order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot,
			boolean extraSyrup) {
		orders.get(currentOrder).addNewBeverage(bevName, size, extraShot,
				extraSyrup);
	}
	
	/**
	 * process the Smoothie order for the current order  by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits to be added 
	 * @param addProtien true if protein is added , false otherwise
	 */
	public void processSmoothieOrder(String bevName, SIZE size, int fruits,
			boolean addProtein) {
		orders.get(currentOrder).addNewBeverage(bevName, size, fruits,
				addProtein);
	}
	
	/**
	 * process the Alcohol order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 */
	public void processAlcoholOrder(String bevName, SIZE size) {
		orders.get(currentOrder).addNewBeverage(bevName, size);
	}
	
	/**
	 * locate an order based on  the order number
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders  if found or -1 if not found
	 */
	public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * locates an order in the list of orders and returns the total value on the order.
	 * @param orderNo the order number
	 * @returns the calculated price on this order.
	 */
	public double totalOrderPrice(int orderNo) {
		double orderSale = 0;
		
		for(Order o: orders) {
			if(o.getOrderNo() == orderNo) {
				for(Beverage b: o.getBeverages()) {
					orderSale+=b.calcPrice();
				}
			}
		}
		return orderSale;
	}
	
	/**
	 *  Calculates the total sale of all the orders for this beverage shop
	 *  @return the total sale of all the orders 
	 */
	public double totalMonthlySale() {
		double totalSale = 0;
		
		for(Order o: orders) {
				for(Beverage b: o.getBeverages()) {
					totalSale+=b.calcPrice();
				}
			}
		return totalSale;
	}
	
	/**
	 * sorts the orders within this bevShop using the Selection
	 * sort algorithm
	 */
	public void sortOrders() {
		for (int i = 0; i < orders.size()- 1; i++) {
			int minOrder = i; 
			for(int j = i + 1; j < orders.size(); j++) {
				if(orders.get(j).getOrderNo() < orders.get(minOrder).getOrderNo()) {
					minOrder = j;
				}
			}
			Order temp = orders.get(minOrder);
			orders.set(minOrder, orders.get(i));
			orders.set(i,temp);
		}
	}
	
	/**
	 * returns Order in the list of orders at the index
	 * Notes: this method returns the shallow copy of the order
	 * @return Order in the list of orders at the index 
	 */
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	//Getters
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholInOrder;
	}
	
	public Order getCurrentOrder() {
		return orders.get(currentOrder);
	}
	
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
}
