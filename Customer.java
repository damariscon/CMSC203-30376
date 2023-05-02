
public class Customer {
	private String name;
	private int age;
	//parameterized constructor
	public Customer(String name, int age) {
		this.name=name;
		this.age=age;
	}
	//copy constructor
	public Customer(Customer person) {
		name=person.getName();
		age=person.getAge();
	}
	//toString
	@Override 
	public String toString(){
		return "Name:"+name+" Age:"+age;
	}
	
	//setters and getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
//DONE