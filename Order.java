/*
 * Class: CMSC203 
 * Instructor:Dr.Grinberg
 * Description:  Order class adds new orders to array lists
 * Due: 04/29/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Damaris Constante
*/
import java.util.ArrayList;

public class Order implements OrderInterface , Comparable{
	private int orderNum;
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	private ArrayList<Beverage> listBev; //list of beverages within the order array list of beverage objects
	//parametrized constructor
	public Order(int ordertime, Day orderDay, Customer customer) {
		this.orderNum=orderNum;
		this.orderTime=orderTime;
		this.orderDay=orderDay;
		this.customer=customer;
		this.listBev=new ArrayList<>();
	}
	//determines if the order day is the weekend or not
	public boolean isWeekend() {
		if(getOrderDay()==Day.SATURDAY || getOrderDay()==Day.SUNDAY) {
			return true;
		}
		return false;
	}
	/**
	 * returns the beverage listed in the item number of the order 
	 * @param int itemNo
	 */
	public Beverage getBeverage(int bevNum) {
			
			return	listBev.get(bevNum);
	}
	
	//adds alcohol order to coffee
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee coffee= new Coffee(bevName,size,extraShot,extraSyrup);
		listBev.add(coffee);
		
	}
	//adds the alcohol order tot his order
	public void addNewBeverage(String bevName, Size size) {
		boolean theWeekend;
		if(getOrderDay()==Day.SATURDAY || getOrderDay() == Day.SUNDAY) {
			theWeekend=true;
		}
		else {
			theWeekend=false;
		}
		Alcohol alcohol= new Alcohol(bevName,size,theWeekend);
		listBev.add(alcohol);
		
	}
	//adds the smoothie beverage order
		public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtien) {
			Smoothie smoothie= new Smoothie(bevName, size, numOfFruits, addProtien);
			listBev.add(smoothie);
				
		}
	@Override
	public String toString() {
		String customInfo;
		customInfo= "Order number: "+orderNum+" Time: "+orderTime+" Order day:"+orderDay+" Customer: "+customer +"\n";
		for(Beverage a: listBev) {
			customInfo+=a+" ";
		}
		return customInfo;
		
	}
	//compares current object with specified object
	public int compareTo(Order order) {
		if (orderNum == order.getOrderNum()) {
			return 0;
		}
		else if (orderNum > order.getOrderNum()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	public int listSize() {
		
		return listBev.size();
	}
	//calculates and returns the total amount for this order
	public double calcOrderTotal() {
		double overallTotal=0;
		for(Beverage a: listBev) {
			overallTotal+=a.calcPrice();
		}
		return overallTotal;
	}
	//returns the number of beverage of same type in an order
	public int findNumOfBeveType(Type type) {
	int count = 0;
		for (Beverage bev : listBev) {
			if (bev.getBevType() == type) {
				count++;
			}
		}
		
		return count;
	}
	//getters and setters

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public Day getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(Day orderDay) {
		this.orderDay = orderDay;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Beverage> getListBev() {
		return listBev;
	}

	public void setListBev(ArrayList<Beverage> listBev) {
		this.listBev = listBev;
	}
		
	

}
