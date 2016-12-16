package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	private RateDomainModel RateDo;
	
	public RateException(RateDomainModel Rate){
		this.RateDo = Rate;
	}
	public RateDomainModel getGivenCreditScore() {
		return this.RateDo;
	}
	
}
