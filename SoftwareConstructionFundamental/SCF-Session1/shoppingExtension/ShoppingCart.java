package shopping;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Making of Shopping cart in an store
 * @author RahulSharma
 *created on 16-07-2018
 */
public class ShoppingCart {
	private int total_items=0;
	private Scanner in;
	private Double billOfCart;
	private ArrayList <Item> cartItems = new ArrayList<Item>();
	private ArrayList <Item> items = new ArrayList <Item>();
	public boolean isCartEmpty(){
		if(cartItems.size()==0)
			return true;
		else
			return false;
	}
	/**
	 * initializes the product on store
	 */
	public void initializeProductDetails(){
		Integer[] productId={1,2,3,4};
		String[] productName= {"watches", "shoes", "shirts", "jeans"};
		Double[] productPrice= {1000d, 560d, 650d, 900d};
		Integer[] productQuantity= {34, 23, 25, 13};
		
		for(int i=0; i<productId.length; i++){
			items.add(new Item(productId[i],productName[i],productPrice[i],productQuantity[i]));
		}
	}
	
	/**
	 * show product of store available
	 */
	public void showProducts(){
		for(int i=0; i<items.size(); i++){
			items.get(i).details();
		}
	}
	
	/**
	 * used for adding items in the shopping cart
	 * and also reflect quantity of store
	 */
	public void addItem() {
		System.out.println("Enter product no");
		final int productNo= in.nextInt();
		
		System.out.println("Enter product quantity");
		final int product_quantity= in.nextInt();
		
		final int itemNo = isCartItemInProduct(productNo);
		final int itemIndexInCart = isPresent(productNo);
		if(itemNo!=-1&&itemIndexInCart==-1) {
			in= new Scanner(System.in);
			cartItems.add(new Item());
			cartItems.get(total_items).setId(productNo);
			cartItems.get(total_items).setQuantity(product_quantity);
			cartItems.get(total_items).setPrice(items.get(itemNo-1).getPrice());
			cartItems.get(total_items).setName(items.get(itemNo-1).getName());
			
			
			int addQuantity= items.get(itemNo-1).getQuantity()-product_quantity;
			items.get(itemNo-1).setQuantity(addQuantity);
			total_items++;
		}
		else {
			if(itemIndexInCart!=-1){
				System.out.println("Already Added use updateItem");
			}
			else{
				System.out.println("Entered wrong product no");
				addItem();
			}
		}
	}
	
	/**
	 * used for removing items from shopping cart
	 * and also reflect quantity of store
	 */
	public void removeItem() {
		if(!isCartEmpty()) {
		
			System.out.println("Enter product no");
			int removeProduct= in.nextInt();
			int cart_id= isPresent(removeProduct);
			if(cart_id !=-1) {
				items.get(removeProduct-1).setQuantity(
						items.get(removeProduct-1).getQuantity()+
						cartItems.get(cart_id-1).getQuantity());
				cartItems.remove(removeProduct-1);
				total_items--;
			}
			else
				System.out.println("Product do not exist");
		}
	}
	
	/**
	 * used for updating quantity of shopping cart
	 * and also reflect quantity of store
	 */
	public void upadeItem(){
		System.out.println("Enter which product to update");
		final int updateItem = in.nextInt();
		final int updateCartItem = isPresent(updateItem);
		if(!isCartEmpty()&& updateCartItem!=-1) {
			
			System.out.println("Enter product quantity");
			int new_quantity= in.nextInt();
			if(new_quantity==0) {
				items.get(updateItem-1).setQuantity(
						cartItems.get(updateCartItem-1).getQuantity()+
						items.get(updateItem-1).getQuantity());
				cartItems.remove(updateCartItem-1);
				total_items--;
			}
			else {
				int difference=cartItems.get(updateCartItem-1).getQuantity()-new_quantity;
				if(difference>0){
					items.get(updateItem-1).setQuantity(
							items.get(updateItem-1).getQuantity()+Math.abs(difference));
				}
				else{
					items.get(updateItem-1).setQuantity(
							items.get(updateItem-1).getQuantity()-Math.abs(difference));
				}
				cartItems.get(updateCartItem-1).setQuantity(new_quantity);
			}
		}
		else{
			System.out.println("Product not in the cart");
		}
	}
	
	/**
	 * used for displaying cart items
	 */
	public void showCartItem() {
		if(cartItems.size()==0) {
			System.out.println("Cart is Empty");
		}
		for(int i=0; i<cartItems.size(); i++) {
			System.out.println("product no "+cartItems.get(i).getId()+"\n"+
							   "product quantity "+cartItems.get(i).getQuantity());
		}
	}
	
	/**
	 * 
	 * @param presentItem
	 * @return index of shopping cart item and if item not present return -1
	 */
	public int isPresent(int presentItem) {
		for(int i=0; i<cartItems.size(); i++) {
			if(cartItems.get(i).getId()==presentItem) {
				return i+1;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @param productNo
	 * @return index of cart item if in store and else -1 
	 */
	public int isCartItemInProduct(int productNo) {
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).getId()==productNo) {
				return i+1;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @return generated total bill of shopping cart
	 */
	public Double bill(){
		billOfCart=0d;
		int cartTotalOrder=0;
		for(int i=0; i<cartItems.size(); i++){
			billOfCart+= cartItems.get(i).getPrice()*cartItems.get(i).getQuantity();
			cartTotalOrder+= cartItems.get(i).getQuantity();
		}
		double discountedBill=checkPromotion(billOfCart, cartTotalOrder);
		return discountedBill;
	}
	
	/**
	 * check user promo code on bill
	 * @param billOfCart
	 * @param cartTotalOrder
	 * @return available discount
	 */
	public double checkPromotion(double billOfCart, int cartTotalOrder) {
		double result=billOfCart;
		FixedProductPromotion productPromo = new FixedProductPromotion();
		FixedOrderPromotion orderPromo = new FixedOrderPromotion();
		System.out.println("Do you have PromoCode? true if yes else no");
		Scanner in = new Scanner(System.in);
		boolean checkPromo = in.nextBoolean();
		if(checkPromo) {
			String promotion = "SALE20";//using one of 4 promocode
			if(productPromo.isPromotionApplicable(promotion) && productPromo.getMinimumPrice()<=billOfCart) {
				double discount=productPromo.promoToDiscount(promotion);
				result*=discount;
			} else {
				if(orderPromo.isPromotionApplicable(promotion) && orderPromo.getOrder()<=cartTotalOrder) {
					double discount=orderPromo.promoToDiscount(promotion);
					result*=discount;
				}
			}
		}
		return result; 
	}
	
	/**
	 * provide menu to the user of store
	 */
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
			
		case 5:Double finalBill=0d;
			if(!isCartEmpty())
				finalBill=bill();
			System.out.println("Total Bill:"+billOfCart+"\n"+"Final Bill:"+finalBill);
			break;
			
		default:System.out.println("Wrong choice");
			break;
		}
		
	}
}
