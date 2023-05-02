import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {
	Alcohol a1,a2,a3,a4;
	
	@BeforeEach
	void setUp() throws Exception {
		a1=new Alcohol("Martini", Size.SMALL, false);
		a2=new Alcohol("Negroni", Size.MEDIUM, true);
		a3=new Alcohol("Mojito", Size.SMALL, false);
		a4=new Alcohol("Martini", Size.SMALL, false);
	}

	@AfterEach
	void tearDown() throws Exception {
		a1=null;
		a2=null;
		a3=null;
		a4=null;
	}
	
	@Test
	void testCalcPrice() {
		assertEquals(2.0,a1.calcPrice(),.001);
		assertEquals(3.6, a2.calcPrice(), .001);
		assertEquals(2.0, a3.calcPrice(), .001);
		
	}
	@Test
	void testEquals() {
		assertFalse(a1.equals(a2));
		assertTrue(a1.equals(a4));
	}

}
