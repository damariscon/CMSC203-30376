import java.util.ArrayList;
/*
 * Class: CMSC203 
 * Instructor:Dr.Grinberg
 * Description: Bev shop class adds orders of beverges to arraylist in order
 * to get order total etc.
 * Due: 04/29/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Damaris Constante
*/
public class BevShop implements BevShopInterface {
	private int alcoholDrinksCurrent;
	private final int MAX_ALCOHOL=3;
	private ArrayList<Order> order;
	private int currentOrders;
	private final int MIN_AGE_ALCOHOL=21;
	public BevShop() {
		order = new ArrayList<>();
	}
	//toString to print out the total of sales in monthly orders
	@Override
	public String toString() {
		String monthOrders = "Monthly Orders\n";
		
		for (Order x : order) {
			monthOrders += x.toString();
		}
		monthOrders += "Total Sales: " +totalMonthlySale();
		
		return monthOrders;
	}
	//get number of alcohol drinks an order currently has
	public int getNumOfAlcoholDrink() {
		return alcoholDrinksCurrent;
	}
	/**
	 * checks if age is too young for alcoholic drink
	 * @param int age
	 */
	public boolean isValidAge(int age) {
		if(age<MIN_AGE_ALCOHOL) {
			return false;
		}
		return true;
	}
	/**
	 * gets the order num from order object
	 * @param Order order
	 */
	public int getOrderNum(Order order) {
		return order.getOrderNum();
	}
	/**
	 * finds the order num
	 * @param int orderNum
	 */
	@Override
	public int findOrder(int orderNum) {
		for (int x = 0; x < order.size(); x++) {
			if (order.get(x).getOrderNum() == orderNum) {
				return x;
			}
		}
		
		return -1;
	}
	/**
	 * starts new order
	 * @param int time, Day day, String name, int age
	 */
	@Override
	public void startNewOrder(int time, Day day, String name, int age) {
		Customer customer = new Customer(name, age);
		Order order1 = new Order(time, day, customer);
		order.add(order1);
		currentOrders = order.indexOf(order1);
		alcoholDrinksCurrent = 0;
		
	}
	//gets total of monthly sales
	@Override
	public double totalMonthlySale() {
		double totalSales = 0;

			for (Order order1 : order) {
				for (Beverage bev : order1.getListBev()) {
					totalSales += bev.calcPrice();
				}
			}
		return totalSales;
	}
	//gets total of the number of monthly orders
	@Override
	public int totalNumOfMonthlyOrders() {
		return order.size();
	}
	//returns price of entire order
	public double totalOrderPrice(int orderNum) {
		double orderSale = 0;
		
		for (Order order1 : order) {
			if (order1.getOrderNum() == orderNum) {
				for (Beverage bev : order1.getListBev()) {
					orderSale += bev.calcPrice();
				}
			}
		}
		return orderSale;
	}
	/**
	 * process order add to array
	 * @param String name, Size size, boolean extraShot, boolean extraSyrup
	 */
	@Override
	public void processCoffeeOrder(String name, Size size, boolean extraShot, boolean extraSyrup) {
		// TODO Auto-generated method stub
		order.get(currentOrders).addNewBeverage(name, size, extraShot, extraSyrup);
	}
	/**
	 * process order add to array
	 * @param String name, Size size, int fuit, boolean proteinPowder
	 */
	@Override
	public void processSmoothieOrder(String name, Size size, int fuit, boolean proteinPowder) {
		// TODO Auto-generated method stub
		order.get(currentOrders).addNewBeverage(name, size, fuit, proteinPowder);
	}
	/**
	 * process order add to array
	 * @param String name, Size size
	 */
	@Override
	public void processAlcoholOrder(String name, Size size) {
		order.get(currentOrders).addNewBeverage(name, size);
		alcoholDrinksCurrent++;
		
	}

	//setter and getters
	public int getAlcoholDrinksCurrent() {
		return alcoholDrinksCurrent;
	}
	public void setAlcoholDrinksCurrent(int alcoholDrinksCurrent) {
		this.alcoholDrinksCurrent = alcoholDrinksCurrent;
	}
	public ArrayList<Order> getOrder() {
		return order;
	}
	public void setOrder(ArrayList<Order> order) {
		this.order = order;
	}
	public int getMAX_ALCOHOL() {
		return MAX_ALCOHOL;
	}
	public int getMIN_AGE_ALCOHOL() {
		return MIN_AGE_ALCOHOL;
	}
	

}
