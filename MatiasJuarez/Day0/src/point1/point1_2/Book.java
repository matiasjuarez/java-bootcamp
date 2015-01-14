package point1.point1_2;

public class Book {
	private String name;
	private Author author;
	private double price;
	private int qtyInStock;
	
	public Book(String name, Author author, double price)
	{
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
	public Book(String name, Author author, double price, int qtyInStock)
	{
		this.name = name;
		this.author = author;
		this.price = price;
		this.qtyInStock = qtyInStock;
	}
	
	public String getName(){
		return name;
	}
	
	public Author getAuthor()
	{
		return author;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public int getQuantity()
	{
		return qtyInStock;
	}
	
	public void setQuantity(int quantity){
		this.qtyInStock = quantity;
	}
	
	public String getAuthorName(){
		return author.getName();
	}
	
	public String toString(){
		String str = name + " by " + author.toString();
		return str;
	}
}
