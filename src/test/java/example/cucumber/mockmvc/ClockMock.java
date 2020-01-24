package test.java.example.cucumber.mockmvc;



final class ClockMock  {
	private long currTime;

	public long now() {
		return currTime;
	}
	
	public void setCurrTime(long currTime) {
		this.currTime = currTime;
	}
}