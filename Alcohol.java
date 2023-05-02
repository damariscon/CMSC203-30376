/*
 * Class: CMSC203 
 * Instructor:Dr.Grinberg
 * Description: Alcohol class makes alcohol objects and gets price of 
 * alcoholic drink by getting the size and if its the weekend or not
 * Due: 04/29/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Damaris Constante
*/
public class Alcohol extends Beverage{
	private boolean offerOnWeekend;
	private final double WEEKEND_PRICE=.6;
	//paramterized constructor
	public Alcohol(String bevName, Size bevSize,boolean offerOnWeekend) {
		super(bevName, Type.ALCOHOL, bevSize);
		this.offerOnWeekend=offerOnWeekend;
	}
	@Override
	public String toString() {
		String basics;
		basics="Name: "+this.getBevName()+" Type: "+getBevType()+" Size: "+getBevSize()+" ";
		basics+="\nOffered on the weekened?: "+getOfferOnWeekend()+" \nPrice is: $"+calcPrice();
		return basics;
	}
	//Supposed to be overriden but not working
	public boolean equals(Alcohol bev) {
		if(super.equals(bev) && this.offerOnWeekend == bev.getOfferOnWeekend() ) {
			return true;
		}
		return false;
	}
	@Override
	public double calcPrice() {
		double total=super.getBASE_PRICE();
		if(super.getBevSize() == Size.MEDIUM) {
			total+=super.getSIZE_PRICE();//additional $1 to go to medium
		}
		else if(super.getBevSize() == Size.LARGE) { //additional $2 dollar to go to large
			total+=2*super.getSIZE_PRICE();
		}
		if(getOfferOnWeekend()) {
			total+=WEEKEND_PRICE;
		}
		return total;
	}
	
	//Getters and setters
	public boolean getOfferOnWeekend() {
		return offerOnWeekend;
	}

	public void setOfferOnWeekend(boolean offerOnWeekend) {
		this.offerOnWeekend = offerOnWeekend;
	}

	public double getWEEKEND_PRICE() { //since final only get no set
		return WEEKEND_PRICE;
	}
	//DONE EXCEPT EQUALS AND CALC

}
