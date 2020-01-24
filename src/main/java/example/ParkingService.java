package example;

class ParkingService {

	Clock clock;
	ParkingStorage storage;
	PricingPolicy hourlyPricing = new HourlyPricing();
	
	public ParkingService(Clock clock, ParkingStorage storage) {
		this.clock = clock;
		this.storage = storage;
	}

	public long enterParking() {
		long entryTime = clock.now();
		return storage.addParkingEntry(entryTime);
	}

	public double clacPayment(long code) {
		long paymentTime = clock.now();
		long entryTime = storage.fetchEntryTime(code);
		return calcPayment(entryTime, paymentTime);
	}

	private double calcPayment(long entryTime, long paymentTime) {
		return hourlyPricing.calc(entryTime, paymentTime);
	}
}