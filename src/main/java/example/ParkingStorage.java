package example;

interface ParkingStorage {
	
	long addParkingEntry(long entryTime);
	
	long fetchEntryTime(long code);
}