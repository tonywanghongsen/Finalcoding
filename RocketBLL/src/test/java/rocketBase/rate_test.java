package rocketBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Before
	public void setUp() throws Exception {

	}
	@After
	public void tearDown() throws Exception {

	}
	
	@Test
	public void test() {
		assert(1==1);
		try{
			assert(RateBLL.getRate(600)==5);
			assert(RateBLL.getRate(650)==4.5);
			assert(RateBLL.getRate(700)==4);
			assert(RateBLL.getRate(750)==3.75);
			assert(RateBLL.getRate(800)==3.5);
		} catch (RateException e){
			e.printStackTrace();
		}
		

	}
	@Test(expected = RateException.class)
	public void test2() throws RateException {
		RateBLL.getRate(300);
	}


}
