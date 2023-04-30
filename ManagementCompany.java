public class ManagementCompany {
	
	public static final int MAX_PROPERTY=5;
	public static final int MGMT_DEPTH=10;
	public static final int MGMT_WIDTH=10;
	private String name;
	private String taxID;
	private double mgmFeePer;
	private int PropertiesCount;
	private Property [] properties;
	private Plot Plot; //defines the plot of the management company 
	
	/*
	 * Constructor creates a ManagementCompany object using empty strings, 
	 * creates a default Plot with maximum width and depth and it initializes the properties array
	 */
	public ManagementCompany() {
		name="";
		taxID="";
		Plot.setWidth(MGMT_WIDTH); //sets a default plot to deafult of 10x10
		Plot.setDepth(MGMT_DEPTH);
		properties=new Property [MAX_PROPERTY];//creates a property array of 5 max properties 
		//numberOfProperties=0;
		
	}
	/**
	 * Constructor creates a ManagementCompany object using the given values, 
	 * creates a default Plot with maximum width and depth and it initializes the properties array.
	 * @param String name, String taxID, double mgmFee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFee;
		this.Plot=new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
		properties=new Property[MAX_PROPERTY];//intializes to max property of 5
		PropertiesCount=0;
		
	}
	/**
	 * Constructor creates a ManagementCompany object using the given values creates a 
	 * Plot using the given values and it initializes the properties array. This constructor 
	 * should call an appropriate existing constructor.
	 * @param String name, String taxID, double mgmFee, int x, int y, 
	int width, int depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, 
			int width, int depth) {
		
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFee;
		this.Plot=new Plot(x,y,width,depth);
		properties=new Property[MAX_PROPERTY];
		PropertiesCount=0;
	
		
	}
	/**
	 * Creates a new ManagementCompany copy of the given ManagementCompany. 
	 * This constructor should call an appropriate existing constructor.
	 * @param ManagementCompany otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		name=otherCompany.name;
		taxID=otherCompany.taxID;
		mgmFeePer=otherCompany.mgmFeePer;
		PropertiesCount=0;
		this.Plot=new Plot();
		properties= new Property[MAX_PROPERTY];
		
		
	}
	/*
	 * Creates a property object by copying from another property and adds it to the properties array.
	 * this method should call an appropriate existing overloaded method.
	 */
	public int addProperty(Property proper) {
	
		
			if(proper==null) { 
				return -2;//if the property is null
			}
			//else if(properties[a].length>=MAX_PROPERTY) {
			//	num= -1; //if array is full
			//}
			else if(!this.Plot.encompasses(proper.getPlot())) {
				return -3;
			}
			
				for(int a1=0;a1<properties.length;a1++) {
					if(properties[a1]!=null) {
						if(properties[a1].getPlot().overlaps(proper.getPlot())) {
							return -4;
						}
					}
					else {
						properties[a1]=proper;
						return a1;
					}
				
			}
		
		return -1;
	}
	/*
	 * Removes(nullifies) the LAST property in the properties array
	 */
	public void removeLastProperty() {
		for(int a=0;a<properties.length;a++) {
			if(properties.length==a) {
				properties[a]=null;
			}
		}
		
	}
	/*
	 * Returns the total rent of the properties in the properties array 
	 */
	public double getTotalRent() {
		double totalRent=0.0;
		for(int a=0;a<properties.length;a++) {
			totalRent+=properties[a].getRentAmount();
		}
		return totalRent;
		
	}
	/*
	 * Gets the property in the array with the maximum amount of rent
	 */
	public Property getHighestRentProperty() {
		double max=0;
		Property maxProp = null; //store max property in max variable 
		for(int a=0;a<properties.length;a++) {
			if(max<properties[a].getRentAmount()) {//get amount of rent in each property
				max=properties[a].getRentAmount(); 
				maxProp=properties[a];
			}
		}
		return maxProp;
		
	}
	/*
	 * Checks if the properties array has reached the maximum capacity
	 */
	public boolean isPropertiesFull(){
		boolean full=false;
		int count=0;
		for(int a=0;a<properties.length;a++) {
			if(!(properties[a]==null)) {
				count++;
			}
		}
		if(count>=5) {
			full=true;
		}
		return full;
	}
	/*
	 * Checks if the management company has a valid (between 0-100) fee
	 */
	public boolean isManagementFeeValid() {
		boolean valid=false;
		if(mgmFeePer>0&&mgmFeePer<100) {
			valid=true;
		}
		
		return valid;
	}
	//to String for class
	public String toString(){
		double totalMgmFee=getTotalRent()*mgmFeePer/100;
		String propertiesString = "";
	    for (int a = 0; a < MAX_PROPERTY; a++) {
	      if (properties[a]==null) {
	        break;
	      } 
	      propertiesString += properties[a] + "\n"; 
	    }
		return "List of the properties for "+ getName()+", taxID: "+getTaxID()+
				"______________________________________________________\n"+propertiesString+
				"______________________________________________________\n"+"total management Fee: "
				+ totalMgmFee;
	}
	
	/*
	 * Getters and setters for maxProp,mgmtDepth,and mgmtWidth
	 */
	public static int getMaxProperty() {
		return MAX_PROPERTY;
	}
	public static int getMgmtDepth() {
		return MGMT_DEPTH;
	}
	public static int getMgmtWidth() {
		return MGMT_WIDTH;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaxID() {
		return taxID;
	}
	public void setTaxId(String taxId) {
		this.taxID = taxId;
	}
	public double getMgmFeePer() {
		return mgmFeePer;
	}
	public void setMgmFeePer(double mgmFee) {
		this.mgmFeePer = mgmFee;
	}
	public Property[] getProperties() {
		return properties;
	}
	public void setProperties(Property[] properties) {
		this.properties = properties;
	}
	public Plot getPlot() {
		return Plot;
	}
	public void setPlot(Plot Plot) {
		this.Plot = Plot;
	}
	public int getPropertiesCount() {
		return PropertiesCount;
	}
	public void setPropertiesCount(int numberOfProperties) {
		this.PropertiesCount = numberOfProperties;
	}
	
}
