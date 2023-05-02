import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent {
	Order order1,order2;
	@BeforeEach
	void setUp() throws Exception {
		order1 = new Order(3, Day.MONDAY, new Customer("Nahomi", 21));
		order2 = new Order(7, Day.SATURDAY, new Customer("Michael", 23));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsWeekend() {
		assertFalse(order1.isWeekend());
		assertTrue(order2.isWeekend());
	}

	@Test
	void testCalcOrderTotal() {
		order1.addNewBeverage("regular Coffee", Size.SMALL, false, false);
		order1.addNewBeverage("Mohito", Size.MEDIUM);
		order1.addNewBeverage("Tropical explosion", Size.LARGE, 2, true);
		assertEquals(11.5, order1.calcOrderTotal(),.001);
	}

}
