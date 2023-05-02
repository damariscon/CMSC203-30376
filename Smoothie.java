/*
 * Class: CMSC203 
 * Instructor:Dr.Grinberg
 * Description: Smoothie class gets calc of smoothie drink in order by getting how
 * many fruits and if they want protein powder or not
 * Due: 04/29/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Damaris Constante
*/
public class Smoothie extends Beverage{
	private int fruit;
	private boolean proteinPowder;
	private final double PRICE_PROTEIN=1.5;
	private final double PRICE_PER_FRUIT=.5;
	//parametrized constructor
	public Smoothie(String bevName,Size bevSize,int fruit, boolean proteinPowder) {
		super(bevName, Type.SMOOTHIE, bevSize);
		this.fruit=fruit;
		this.proteinPowder=proteinPowder;
	}
	@Override
	public String toString() {
		String basics;
		basics="\nName: "+getBevName()+" Type: "+getBevType()+" Beverage Size: "+getBevSize();
		if(fruit>0) {
			basics+=" \nFruit?: "+fruit+ " Price of fruit: $" +fruit*PRICE_PER_FRUIT;
		}
		//prints protein powder if it is true or false
		basics+="\nProtein powder?: "+proteinPowder+" \nPrice is: $"+calcPrice();
		
		return basics;
		
	}
	//supposed to be overriden but its not working like that
	public boolean equals(Smoothie bev) {
		if(super.equals(bev) && this.proteinPowder==bev.getProteinPowder() && this.fruit==bev.getFruit()) {
			return true;
		}
		return false;
	}
	
	//calcPrice of order
	@Override
	public double calcPrice() {
		double total=super.getBASE_PRICE();
		if(super.getBevSize() == Size.MEDIUM) {
			total+=super.getSIZE_PRICE();
		}
		else if(super.getBevSize() ==Size.LARGE) {
			total+=2*super.getSIZE_PRICE();
		}
		if(getProteinPowder()==true) {
			total+=PRICE_PROTEIN;
		}
		if(getFruit()>0) {
			total+=getFruit()*PRICE_PER_FRUIT;
		}
		return total;
	}
	//setters and getters
	public int getFruit() {
		return fruit;
	}
	public void setFruit(int fruit) {
		this.fruit = fruit;
	}
	public boolean getProteinPowder() {
		return proteinPowder;
	}
	public void setProteinPowder(boolean proteinPowder) {
		this.proteinPowder = proteinPowder;
	}
	public double getPRICE_PROTEIN() {
		return PRICE_PROTEIN;
	}
	public double getPRICE_PER_FRUIT() {
		return PRICE_PER_FRUIT;
	}
	
	//DONE EXCEPT EQUALS AND CALC
}
