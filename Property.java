public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	/*
	 * constructor that creates a new propety using empty strings, it also creates a default
	 * plot
	 */
	public Property(){
		propertyName="";
		city="";
		owner="";
		rentAmount=0;
		this.plot=new Plot();
	}
	/**
	 * Constructor that creates a new property object using given value. It also creates a default plot
	 * @param String propertyName, String city, double rentAmount, String owner
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		
		this.propertyName=propertyName;
		this.city=city;
		this.rentAmount=rentAmount;
		this.owner=owner;
		this.plot=new Plot();
	}
	/**
	 * Constructor creates a new property object using given values. It also creates a plot
	 * using given values of a plot.
	 * @param String propertyName,String city,double rentAmount,String owner,int x,int y,
			int width,int depth
	 */
	public Property(String propertyName,String city,double rentAmount,String owner,int x,int y,
			int width,int depth) {
		
		this.propertyName=propertyName;
		this.city=city;
		this.rentAmount=rentAmount;
		this.owner=owner;
		this.plot= new Plot(x,y,width,depth);
	}
	/**
	 * Constructor that creates a new copy of the gievn property object
	 * @param property otherProperty
	 */
	public Property(Property otherProperty) {
		propertyName=otherProperty.propertyName;
		city=otherProperty.city;
		rentAmount=otherProperty.rentAmount;
		owner=otherProperty.owner;
		plot=otherProperty.plot;
	}
	/*
	 * toString method to represent a property instance
	 */
	public String toString(){
		return propertyName+","+city+","+owner+","+rentAmount;
	
	}
	/*
	 * Getters and Setters for name,city,rentAmount,owner, and plot
	 */
	public String getName() {
		return propertyName;
	}
	public void setName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Plot getPlot() {
		return plot;
	}
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	
}
