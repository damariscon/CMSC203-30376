
/*
 * Class: CMSC203 
 * Instructor:Dr.Grinberg
 * Description: coffee class gets calc of coffee drink in order by getting 
 * whether or not customer wants extra shot or extra syrup
 * Due: 04/29/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Damaris Constante
*/
public class Coffee extends Beverage{
	private boolean extraCoffee;
	private boolean extraSyrup;
	private final double PRICE_XCOFFEE=.5;
	private final double PRICE_XSYRUP=.5;
	
	//parametrized constructor
	public Coffee(String bevName, Size bevSize,boolean extraCoffee, boolean extraSyrup) {
		super(bevName, Type.COFFEE, bevSize);
		this.extraCoffee=extraCoffee;
		this.extraSyrup=extraSyrup;
	}
	//toString prints basics=name,type,size and then whether or not they got more coffee or more syrup
	@Override
	public String toString() {
		String basics;
		basics="\nBev name: "+this.getBevName()+" Type: "+getBevType()+" Size "+getBevSize()+" ";
		if(extraCoffee==true) {
			basics+="\nExtra coffee?: "+extraCoffee;
		}
		else if(extraSyrup==true) {
			basics+="\nExtra syrup?: "+extraSyrup;
		}
		basics+="\nPrice is: $"+calcPrice();
		
		return basics;	
	}
	//supposed to be overriden but not working
	public boolean equals(Coffee bev) {
		if(super.equals(bev) && extraCoffee== bev.getExtraCoffee() && extraSyrup== bev.getExtraSyrup()) {
			return true;
		}
		return false;
	}
	
	@Override
	public double calcPrice() {
		double total=super.getBASE_PRICE();
		if(super.getBevSize() == Size.MEDIUM) {
			total+=super.getSIZE_PRICE();
		}
		else if(super.getBevSize() ==Size.LARGE) {
			total+=2*super.getSIZE_PRICE();
		}
		if(getExtraCoffee()==true) {
			total+=PRICE_XCOFFEE; //+.5 cents extra coffee
		}
		if(getExtraSyrup()==true) { //+.5 cents extra syrup
			total+=PRICE_XSYRUP;
		}
		return total;
	}
	//getters and setters	
	public boolean getExtraCoffee() {
		return extraCoffee;
	}
	public void setExtraCoffee(boolean extraCoffee) {
		this.extraCoffee = extraCoffee;
	}
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}
	public double getPRICE_XCOFFEE() {
		return PRICE_XCOFFEE;
	}
	public double getPRICE_XSYRUP() {
		return PRICE_XSYRUP;
	}

}
