
public abstract class Beverage {
	private String bevName;
	private Type bevType;
	private Size bevSize;
	private final double BASE_PRICE=2.0;
	private final double SIZE_PRICE=1; //addition 1 to go a size up
	/*
	 * constructor to 
	 */
	public Beverage(String bevName,Type bevType, Size bevSize) {
		this.bevName=bevName;
		this.bevType=bevType;
		this.bevSize=bevSize;
	}
	//abstract method to calcPrice and return bev price
	public abstract double calcPrice();
	//toString
	public String toString() {
		return "Beverage name: "+bevName+" Beverage type: "+bevType+" Beverage Size: "+bevSize ;
	}
	//@Override
	public boolean equals(Beverage bev) {
		boolean status=false;
		if(this.bevName.equals(bev.bevName) && this.bevType.equals(bev.bevType) && this.bevSize.equals(bev.bevSize)) {
			status= true;
		}
		return status;
	}
	//setters and getters
	public double getBASE_PRICE() { //since constant only getter no setter
		return BASE_PRICE;
	}
	public double getSIZE_PRICE() {
		return SIZE_PRICE;
	}
	public String getBevName() {
		return bevName;
	}
	public void setBevName(String bevName) {
		this.bevName = bevName;
	}
	public Type getBevType() {
		return bevType;
	}
	public void setBevType(Type bevType) {
		this.bevType = bevType;
	}
	public Size getBevSize() {
		return bevSize;
	}
	public void setBevSize(Size bevSize) {
		this.bevSize = bevSize;
	}
	//DONE
}
