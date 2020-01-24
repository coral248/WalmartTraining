package main.java.example;

interface ConsumerStorage {
	
	long addParkingEntry(long entryTime);
	
	long fetchEntryTime(long code);
}