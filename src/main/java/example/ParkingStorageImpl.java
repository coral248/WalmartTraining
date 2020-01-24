package example;

class ParkingStorageImpl implements ParkingStorage {

	private ParkingRepository repository;

	public ParkingStorageImpl(ParkingRepository repository) {
		this.repository = repository;
	}

	@Override
	public long addParkingEntry(long entryTime) {
		ParkingEntry entry = new ParkingEntry();
		entry.setTime(entryTime);
		return repository.save(entry).getCode();
	}

	@Override
	public long fetchEntryTime(long code) {
		return repository.findById(code).get().getTime();
	}
}