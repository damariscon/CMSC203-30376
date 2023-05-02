import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {
	Coffee c1,c2,c3,c4;
	@BeforeEach
	void setUp() throws Exception {
		c1=new Coffee("Latte",Size.SMALL,true, false);
		c2= new Coffee("Espresso",Size.MEDIUM,false, true);
		c3= new Coffee("Americano",Size.LARGE,false, false);
		c4 =new Coffee("Latte",Size.SMALL,true, false);
	}

	@AfterEach
	void tearDown() throws Exception {
		c1=null;
		c2=null;
		c3=null;
		c4=null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(2.5,c1.calcPrice(),.001);
		assertEquals(3.5,c2.calcPrice(),.001);
		assertEquals(4.0,c3.calcPrice(),.001);
	}
	@Test
	void testEquals() {
		assertFalse(c1.equals(c2));
		assertTrue(c1.equals(c4));
	}

}
