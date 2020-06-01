package operation;
import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.*;
/**
 * @author Amritpal kaur ramana
 * @version 1.0
 * @Created 20 may, 2020
 */

public class AddRatePayerTest {
	private final int noOfPayersInFile = 8;
	@Test
	public void test() {
		Scanner console = new Scanner(System.in);
		AddRatePayer ratepayers = new AddRatePayer(console);
		
		assertEquals(noOfPayersInFile,ratepayers.getNumberOfRatePayers());
	
	}
}

