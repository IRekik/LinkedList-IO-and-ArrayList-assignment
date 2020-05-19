import java.util.Scanner;

public class CellPhone {
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	public long getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public CellPhone(long serialNum, String brand, int year, double price) {
		this.serialNum=serialNum;
		this.brand=brand;
		this.year=year;
		this.price=price;
	}
	public CellPhone(CellPhone c, long l) {
		serialNum=l;
		brand=c.brand;
		year=c.year;
		price=c.year;
	}
	public CellPhone clone(CellPhone c) {
		Scanner k = new Scanner (System.in);
		System.out.println("Please enter a serial number");
		long sNumber=k.nextInt();
		CellPhone clone = new CellPhone(c,sNumber);
		k.close();
		return clone;
	}
	public String toString() {
		return ( "[" + this.serialNum + " " + this.brand + "  " + this.year +  "  " + this.price + "$ ]");
	}
	public boolean equals(CellPhone c) {
		if (c == null || this.getClass() != c.getClass())
			return false;
		else {
			CellPhone h=c;
			return (this.brand.equalsIgnoreCase(h.getBrand()) && this.year == h.year && this.price == h.price);
		}
	}
}
