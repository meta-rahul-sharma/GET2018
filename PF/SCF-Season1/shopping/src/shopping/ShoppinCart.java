package shopping;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppinCart {
	private int total_items=0;
	private Scanner in;
	private Double bill_of_cart;
	private ArrayList <Item> cart_items = new ArrayList<Item>();
	private final ArrayList <Item> items = new ArrayList <Item>();
	public boolean isCartEmpty(){
		if(cart_items.size()==0)
			return true;
		else
			return false;
	}
	
	public void initializeProductDetails(){
		Integer[] product_ids={1,2,3,4};
		String[] product_names= {"watches", "shoes", "shirts", "jeans"};
		Double[] product_prices= {1000d, 560d, 650d, 900d};
		Integer[] product_quantities= {34, 23, 25, 13};
		
		for(int i=0; i<product_ids.length; i++){
			items.add(new Item(product_ids[i],product_names[i],product_prices[i],product_quantities[i]));
		}
	}
	
	public void showProducts(){
		for(int i=0; i<items.size(); i++){
			items.get(i).details();
		}
	}
	
	public void addItem() {
		System.out.println("Enter product no");
		final int product_no= in.nextInt();
		
		System.out.println("Enter product quantity");
		final int product_quantity= in.nextInt();
		
		final int item_no = isCartItemInProduct(product_no);
		final int cart_no = isPresent(product_no);
		if(item_no!=-1&&cart_no==-1) {
			in= new Scanner(System.in);
			cart_items.add(new Item());
			cart_items.get(total_items).setId(product_no);
			cart_items.get(total_items).setQuantity(product_quantity);
			cart_items.get(total_items).setPrice(items.get(item_no-1).getPrice());
			cart_items.get(total_items).setName(items.get(item_no-1).getName());
			
			
			int new_item_quantity= items.get(item_no-1).getQuantity()-product_quantity;
			items.get(item_no-1).setQuantity(new_item_quantity);
			total_items++;
		}
		else {
			if(cart_no!=-1){
				System.out.println("Already Added use updateItem");
			}
			else{
				System.out.println("Entered wrong product no");
				addItem();
			}
		}
	}
	
	public void removeItem() {
		if(!isCartEmpty()) {
		
			System.out.println("Enter product no");
			final int product_no_to_remove= in.nextInt();
			final int cart_id= isPresent(product_no_to_remove);
			if(cart_id !=-1) {
				items.get(product_no_to_remove-1).setQuantity(
						items.get(product_no_to_remove-1).getQuantity()+
						cart_items.get(cart_id-1).getQuantity());
				cart_items.remove(product_no_to_remove-1);
				total_items--;
			}
			else
				System.out.println("Product do not exist");
		}
	}
	
	public void upadeItem(){
		System.out.println("Enter which product to update");
		final int update_item_id = in.nextInt();
		final int update_cart_item_id = isPresent(update_item_id);
		if(!isCartEmpty()&& update_cart_item_id!=-1) {
			
			System.out.println("Enter product quantity");
			int new_quantity= in.nextInt();
			if(new_quantity==0) {
				items.get(update_item_id-1).setQuantity(
						cart_items.get(update_item_id-1).getQuantity()+
						items.get(update_item_id-1).getQuantity());
				cart_items.remove(update_cart_item_id-1);
				total_items--;
			}
			else {
				int difference=cart_items.get(update_cart_item_id-1).getQuantity()-new_quantity;
				if(difference>0){
					items.get(update_item_id-1).setQuantity(
							items.get(update_item_id-1).getQuantity()+Math.abs(difference));
				}
				else{
					items.get(update_item_id-1).setQuantity(
							items.get(update_item_id-1).getQuantity()-Math.abs(difference));
				}
				cart_items.get(update_cart_item_id-1).setQuantity(new_quantity);
			}
		}
		else{
			System.out.println("Product not in the cart");
		}
	}
	
	public void showCartItem() {
		for(int i=0; i<cart_items.size(); i++) {
			System.out.println("product no "+cart_items.get(i).getId()+"\n"+
							   "product quantity "+cart_items.get(i).getQuantity());
		}
	}
	
	public int isPresent(final int remove_cart_item) {
		for(int i=0; i<cart_items.size(); i++) {
			if(cart_items.get(i).getId()==remove_cart_item) {
				return i+1;
			}
		}
		return -1;
	}
	
	public int isCartItemInProduct(final int product_no) {
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).getId()==product_no) {
				return i+1;
			}
		}
		return -1;
	}
	
	public Double bill(){
		bill_of_cart=0d;
		for(int i=0; i<cart_items.size(); i++){
			bill_of_cart+=cart_items.get(i).getPrice()*cart_items.get(i).getQuantity();
		}
		return bill_of_cart;
	}
	
	public void menu(){
		System.out.println("1. showCartItem");
		System.out.println("2. addItem");
		System.out.println("3. removeItem");
		System.out.println("4. updateItem");
		System.out.println("5. bill");
		in = new Scanner(System.in);
		int select_item=in.nextInt();
		switch(select_item){
			
		case 1:
			showCartItem();
			break;
		
		case 2:
			addItem();
			break;
				
		case 3:
			if(!isCartEmpty())
				removeItem();
			break;
				
		case 4:
				upadeItem();
			break;
			
		case 5:Double print_bill=0d;
			if(!isCartEmpty())
				print_bill=bill();
			System.out.println(print_bill);
			break;
			
		default:System.out.println("Wrong choice");
			break;
		}
		
	}
	
}
