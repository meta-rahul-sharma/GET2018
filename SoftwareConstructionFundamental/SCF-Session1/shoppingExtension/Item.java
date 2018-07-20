package shopping;
/**
 * 
 * @author RahulSharma
 *creating item and their respective details
 */
public class Item {
	private Integer id;
	private String name;
	private Double price;
	private Integer quantity;

	public Item() {
		/**in = new Scanner(System.in);
		System.out.println("product name:");
		this.name=in.nextLine();
		System.out.println("product price:");
		this.price=in.nextDouble();
		System.out.println("product quantity:");
		this.quantity=in.nextInt();*/
	}
	
	public Item(final int id, final String name, final Double price, final int quantity){
		this.id=id;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	
	public void details() {
		System.out.println("product id:"+id+" "+
	                     "product name:"+name+" "+
				         "product price:"+price+" "+
	                     "product quantity:"+quantity+" ");
	}

	public void setPrice(final Double price) {
		this.price=price;
	}
	
	public Double getPrice(){
		return price;
	}
	
	public void setId(final int id){
		this.id=id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setQuantity(final int quantity){
		this.quantity=quantity;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
}
