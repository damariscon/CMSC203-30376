
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
public class BradleyBeverageDriver {
	public static void main(String[]args) {
		BevShop bevShop = new BevShop();
		//intro
		System.out.println("The current order in progress can have at most "+bevShop.getMAX_ALCOHOL()+
				" alcoholic beverages.");
		System.out.println("The minimum age to order an alcohol drink is: "+bevShop.getMIN_AGE_ALCOHOL());
		//creating variables for driver
		int customerAge=0;
		String customerName="";
		Scanner keyboard= new Scanner(System.in);
		final String YES="yes";
		final String NO="no";
		String customerAns="";
		String addNewBev="";
		String coffee="coffee";
		String alcohol="alcohol";
		String smoothie="smoothie";
		String userDrink="";
		final String T="true";
		final String F="false";
		String bevSize="";
		String drinkName="";
		int order=0;
		//coffee variables
		boolean extraCoffee=false;
		boolean extraSyrup=false;
		//smoothie variables
		int fruit=0;
		boolean proteinPowder=false;
		//array lists for bev and orders
		ArrayList<Coffee> coffeeList= new ArrayList<>();
		ArrayList<Alcohol> alcoholList= new ArrayList<>();
		ArrayList<Smoothie> smoothieList= new ArrayList<>();
		ArrayList<BevShop> bevShopList=new ArrayList<>();
		//loop for customer to start new order 
		do {
			//add to order number
			order++;
			System.out.println("Please start a new order(Yes/No): \n");
			customerAns=keyboard.nextLine();
			if(customerAns.equalsIgnoreCase(NO)) {
				return;
			}
			System.out.println("Would you please enter your name: ");
			customerName=keyboard.nextLine();
			System.out.println("\nWould you please enter your age ");
			customerAge=keyboard.nextInt();
			//stop from skipping
			keyboard.nextLine();
			//input customer details
			Customer customer= new Customer(customerName, customerAge);
			//start new order with day and time
			Order order1=new Order(6, Day.MONDAY, customer); 
			order1.setOrderTime(6);
			System.out.println("Today is "+ Day.MONDAY+ "\n Time is: "+order1.getOrderTime()+" O'Clock"
			+"\nYour total order for now is: $"+order1.calcOrderTotal());
			//loop to add more bevs
			do {
				//check if age is valid alcohol age
				if(bevShop.isValidAge(customer.getAge())) {
					System.out.println("Your age is above 21 and you are eligiable to order alchol.");
					//get size
					System.out.println("What size would you like your drink?(Small, Medium, Large) ");
					bevSize=keyboard.nextLine();
					//get drink name
					System.out.println("What drink would you like to add?(Coffee/smoothie/alcohol): ");
					userDrink=keyboard.nextLine();
				}
				else {
					System.out.println("Your age is below 21 and you are not eligiable to order alchol.");
					//get size
					System.out.println("What size would you like your drink?(Small, Medium, Large) ");
					bevSize=keyboard.nextLine();
					System.out.println("What drink would you like to add?(Coffee/smoothie): ");
					//get drink name
					userDrink=keyboard.nextLine();
					keyboard.nextLine();
				}
				
				//add coffee drink
				if(userDrink.equalsIgnoreCase(coffee)==true) {
					System.out.println("What coffee would you like?: ");
					drinkName=keyboard.nextLine();
					System.out.println("Would you like extra coffee?(True/False): ");
					extraCoffee=keyboard.nextBoolean();
					System.out.println("Would you like extra Syrup?(True/False): ");
					extraSyrup=keyboard.nextBoolean();
					//intialize coffee values add new beverage
					Coffee c1=null;
					if(bevSize.equals("small")) {
						c1= new Coffee(drinkName, Size.SMALL, extraCoffee,extraSyrup);
						order1.addNewBeverage(drinkName, Size.SMALL, extraCoffee,extraSyrup);
					}
					else if(bevSize.equals("medium")) {
						c1= new Coffee(drinkName, Size.MEDIUM, extraCoffee,extraSyrup);
						order1.addNewBeverage(drinkName, Size.MEDIUM, extraCoffee,extraSyrup);
					}
					else if(bevSize.equals("large")) {
						c1= new Coffee(drinkName, Size.LARGE, extraCoffee,extraSyrup);
						order1.addNewBeverage(drinkName, Size.LARGE, extraCoffee,extraSyrup);
					}
					else {
						System.out.println("invalid try again");
					}
					coffeeList.add(c1);
					System.out.println("Your total: "+order1.calcOrderTotal());
					
				}
				//add alcoholic drink if of age
				else if(userDrink.equalsIgnoreCase(alcohol)&& bevShop.isValidAge(customer.getAge())==true){
					System.out.println("What alcoholic drink would you like?: ");
					drinkName=keyboard.nextLine();
					//intialize alcohol values add new beverage
					Alcohol a1=null;
					if(bevSize.equals("small")) {
						a1=new Alcohol(drinkName, Size.SMALL,order1.isWeekend());
						order1.addNewBeverage(drinkName, Size.SMALL);
					}
					else if(bevSize.equals("Medium")) {
						a1=new Alcohol(drinkName, Size.MEDIUM,order1.isWeekend());
						order1.addNewBeverage(drinkName, Size.MEDIUM);
					}
					else if(bevSize.equals("Large")) {
						a1=new Alcohol(drinkName, Size.LARGE,order1.isWeekend());
						order1.addNewBeverage(drinkName, Size.LARGE);
					}
					else {
						System.out.println("invalid try again");
					}
					alcoholList.add(a1);
					System.out.println("Your total: "+order1.calcOrderTotal());
				}
				//add smoothie drink
				else if(userDrink.equalsIgnoreCase(smoothie)==true) {
					System.out.println("What type of smoothie would you like?: ");
					drinkName=keyboard.nextLine();
					System.out.println("How many fruit would you like?: ");
					fruit=keyboard.nextInt();
					//keyboard.nextLine();//stop from skipping
					System.out.println("Would you like protien powder?(True/False): ");
					proteinPowder=keyboard.nextBoolean();
					
					Smoothie s1=null;
					if(bevSize.equals("small")) {
						s1= new Smoothie(drinkName, Size.SMALL,fruit,proteinPowder);
						order1.addNewBeverage(drinkName, Size.SMALL,fruit,proteinPowder);
						//bevShop.processSmoothieOrder(drinkName, Size.SMALL,fruit,proteinPowder);
					}
					else if(bevSize.equals("Medium")) {
						s1= new Smoothie(drinkName, Size.MEDIUM,fruit,proteinPowder);
						order1.addNewBeverage(drinkName, Size.MEDIUM,fruit,proteinPowder);
						//bevShop.processSmoothieOrder(drinkName, Size.MEDIUM,fruit,proteinPowder);
					}
					else if(bevSize.equals("Large")) {
						s1= new Smoothie(drinkName, Size.LARGE,fruit,proteinPowder);
						order1.addNewBeverage(drinkName, Size.LARGE,fruit,proteinPowder);
						//bevShop.processSmoothieOrder(drinkName, Size.LARGE,fruit,proteinPowder);
					}
					else {
						System.out.println("invalid try again");
					}
					smoothieList.add(s1);
					System.out.println("Your total: "+order1.calcOrderTotal());
				}
				//get current order total ask to add another bev
				System.out.println("Current order total: "+order1.calcOrderTotal());
				System.out.println("Would you like to add a new beverage?(Yes/No): ");
				keyboard.nextLine();
				addNewBev=keyboard.nextLine();
			}
			//ask to make new order
			while(addNewBev.equalsIgnoreCase(YES));
			System.out.println("Would you like to start a new order?(Yes/No): ");
			customerAns=keyboard.nextLine();
			if(customerAns.equalsIgnoreCase(YES)) {
				order++; //increments order number
			}
			System.out.println("Current order total: "+bevShop.totalOrderPrice(1));
		}
		
		while(customerAns.equalsIgnoreCase(YES));
		//end of program
		System.out.println("Thank you! Programmer: Damaris Constante");
	}

}
