import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {
	Smoothie s1,s2,s3,s4;
	@BeforeEach
	void setUp() throws Exception {
		s1= new Smoothie("Bannna shake",Size.SMALL,1,true);
		s2= new Smoothie("Mango Strawberry blast",Size.MEDIUM,3,true);
		s3= new Smoothie("Tropical explossion",Size.LARGE,4,false);
		s4 = new Smoothie("Bannna shake",Size.SMALL,1,true);
	}

	@AfterEach
	void tearDown() throws Exception {
		s1=null;
		s2=null;
		s3=null;
		s4=null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(4.0,s1.calcPrice(),.001);
		assertEquals(6.0, s2.calcPrice(), .001);
		assertEquals(6.0, s3.calcPrice(), .001);
	}

	@Test
	void testGetFruit() {
		assertEquals(1,s1.getFruit(),.001);
		assertEquals(4,s3.getFruit(),.001);
	}
	@Test
	void testEquals() {
		assertFalse(s1.equals(s2));
		assertTrue(s1.equals(s4));
	}
}
