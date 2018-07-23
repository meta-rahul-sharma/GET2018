package lcmhcf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testLcmAndHcf {

	@Test
	void testHcf1() {
		LcmAndHcf hcf = new LcmAndHcf();
		int result = hcf.Hcf(34, 56);
		assertEquals(2, result);
	}
	
	@Test
	void testHcf2() {
		LcmAndHcf hcf = new LcmAndHcf();
		int result = hcf.Hcf(34, 34);
		assertEquals(34, result);
	}
	
	@Test
	void testLcm1() {
		LcmAndHcf lcm = new LcmAndHcf();
		int result = lcm.Lcm(34, 56);
		assertEquals(952, result);
	}
	
	@Test
	void testLcm2() {
		LcmAndHcf lcm = new LcmAndHcf();
		int result = lcm.Lcm(34, 34);
		assertEquals(34, result);
	}

}
