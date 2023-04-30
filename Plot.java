public class Plot {
	private int x;
	private int y;
	private int depth;
	private int width;
	/*
	 * Constructor that creates a default plot with width and depth of 1
	 */
	public Plot() {
		width=1;
		depth=1;
		x=0;
		y=0;
	}
	/**
	 * constructor that creates a plot using the given values
	 * @param int x, int y, int width, int depth
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;
	}
	/*
	 * constructor that creates a new plot given another plot. This constructor
	 * must call an appropriate exsisting constructor. copy constructor 
	 */
	public Plot(Plot otherPlot) {
		x=otherPlot.x;
		y=otherPlot.y;
		width=otherPlot.width;
		depth=otherPlot.depth;
	}
	/*
	 * Method that determines if the given plot instance is overlapped by the current
	 * plot
	 */
	public boolean overlaps(Plot plot) {
		if(x==plot.x || y==plot.y) {
			return true;
		}
		else{
			return false;
		}
	}
	/*
	 * Determines if the given plot is encompassed by(is contained by) this plot.
	 * if an edge lies on the edge of the current plot this is acceptable
	 */
	public boolean encompasses(Plot plot) {
		if(x>plot.x || y>plot.y) {
			return true;
		}
		else{
			return false;
		}
		
	}
	/*
	 * toString method to represent a plot instance with x,y,wdith,and depth
	 */
	public String toString(){
		
		return x+","+y+","+width+","+depth;
		
	}
	/*
	 * Setters and getters for x,y,depth,and width
	 */
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
}
