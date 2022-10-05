	//Name: Semih
	//Surname: Bað
	//Student ID:150120070

public class Product {
	private String productName;
	private java.util.Calendar saleDate;
	private double price;

	
	public Product(String sName, java.util.Calendar sDate, double price) throws Exception{
		setProductName(sName);
		setSaleDate(sDate);
		setPrice(price);
	}
	
	
	
	public String toString() {
		return ("Product [productName="+getProductName()+", transactionDate="+getSaleDate().get(5)+"/"+getSaleDate().get(2)+"/"+getSaleDate().get(1)+", price="+getPrice()+"]");
	}
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) throws Exception {
		productName = productName.trim();
		if(productName.length() == 0) {
			throw new Exception("Please write a String value");
		}
		if(productName.length() < 3) {
			throw new Exception("String value should be no less than 3 symbols");
		}
		this.productName = productName;
	}

	
	
	public java.util.Calendar getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(java.util.Calendar saleDate) {
		this.saleDate = saleDate;
	}

	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
