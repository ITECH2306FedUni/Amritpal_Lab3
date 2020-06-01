package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class VacantLandTest {

	@Test
	public void test() {
		VacantLand object1 = new VacantLand();
		String overlays[]= {"leveling","fencing"};
		object1.setOverlays(overlays);
		assertEquals("leveling",object1.getOverlays()[0]);
	
	}

}
