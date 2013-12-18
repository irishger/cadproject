package ie.cit.gerry;

public class Product {
	
	private int sku;
	private String name;
	private String description;
	private double pricePerUnit;
	private String unitDescription;
	private int stockLevel;
	
	public Product() {
		
	}
	
	public Product(int sku, String name, String description, 
			double pricePerUnit, String unitDescription, int stockLevel) {
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.pricePerUnit = pricePerUnit;
		this.unitDescription = unitDescription;
		this.stockLevel = stockLevel;
	}
	
	public int getSku() {
		return sku;
	}
	
	
	public void setSku(int sku) {
		this.sku = sku;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPricePerUnit() {
		return pricePerUnit;
	}


	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}


	public String getUnitDescription() {
		return unitDescription;
	}


	public void setUnitDescription(String unitDescription) {
		this.unitDescription = unitDescription;
	}


	public int getStockLevel() {
		return stockLevel;
	}


	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
	
	

}
