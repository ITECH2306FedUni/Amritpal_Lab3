package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class HospitalTestCase {

	@Test
	public void test() {
		Property r= new Residential();
		 
		r.setUpExtraServices();
		r.calculateExtraServices();
		System.out.println(r.toString());
		
		System.out.println(r.calculateExtraServices());
		double results=r.calculateExtraServices();
		assertEquals(535.0,results,1);
	}

}
