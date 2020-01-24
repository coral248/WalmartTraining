package example;

public interface PricingPolicy {

	double calc(long entryTime, long paymentTime);

}