package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double rate = 0;
		
		ArrayList<RateDomainModel> Rates = RateDAL.getAllRates();
		RateDomainModel a = new RateDomainModel(); 
		
		for( RateDomainModel r : Rates ){
			if (GivenCreditScore >= r.getiMinCreditScore()){
				rate = r.getdInterestRate();
				a= r;
				
			}
		}
		if(rate==0){
			throw new RateException(a);
			
		}
		return rate;
	
		
		
	}
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
