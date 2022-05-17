package Gert_Learning.Mockito;

public class Stock {
	private String stockId;
	private String name;
	private int quantity;
	
	public Stock(String stockid, String name, int quantity) 
	{
		this.stockId = stockid;
		this.name = name;
		this.quantity = quantity;
	}
	
	public String getStockId() 
	{
		return stockId;
	}
	
	public void setStockId (String stockId) 
	{
		this.stockId = stockId;
	}
	
	public int getQuantity() 
	{
		return quantity;
	}
	
	public String getTicker() 
	{
		return name;
	}

}
