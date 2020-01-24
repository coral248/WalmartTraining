package test.java.example.cucumber.mockmvc;
public class ProductInventoryInfo {
	private String id;
	private int inventory;
	private int minInventory;

	public String getId() {
		return id;
	}

	public int getInventory() {
		return inventory;
	}

	public int getMinInventory() {
		return minInventory;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public void setMinInventory(int minInventory) {
		this.minInventory = minInventory;
	}

}