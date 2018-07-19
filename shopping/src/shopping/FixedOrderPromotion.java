package shopping;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 * 
 * @author RahulSharma
 *used for fixed quantity promotion eg. quantiy >12
 */
public class FixedOrderPromotion implements Promotion {

	private Double minimumPrice=6000d;
	private Double discount;
	private int minimumOrder=12;
	
	@Override
	public Double getMinimumPrice() {
		// TODO Auto-generated method stub
		return minimumPrice;
	}

	@Override
	public void setMinimumPrice(Double minimum_price) {
		// TODO Auto-generated method stub
		this.minimumPrice=minimum_price;
	}

	@Override
	public double getFixedDiscount() {
		// TODO Auto-generated method stub
		return discount;
	}

	@Override
	public void setFixedDiscount(double discount) {
		// TODO Auto-generated method stub
		this.discount=discount;
		
	}

	/**
	 * checking that user promocode is valid or not and in between date of availability
	 */
	@Override
	public boolean isPromotionApplicable(String promotion) {
		// TODO Auto-generated method stub
		boolean promoReturn=false;
		for(PromotionEnum promo:PromotionEnum.values()){
			if(promo.equals(promotion)){
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				
				Date buyDate = new Date();
				String currentDate = dateFormat.format(buyDate); 
				try {
					if(dateFormat.parse(promo.getStartDate()).before(format.parse(currentDate)) && 
							dateFormat.parse(currentDate).before(dateFormat.parse(promo.getEndDate()))){					
						double discount = promoToDiscount(promotion);
						setFixedDiscount(discount);
						promoReturn = true;
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return promoReturn;
	}
	
	public void setOrder(int minimumOrder){
		this.minimumOrder = minimumOrder;
	}
	
	public int getOrder(){
		return minimumOrder;
	}
	
	/**
	 * convert promo code to discount
	 * @param promo
	 * @return discount factor
	 */
	public double promoToDiscount(String promo){
		double discount=0d;
		for(int i=promo.length()-2; i<promo.length(); i++){
			discount*=10;
			discount+=(promo.charAt(i)-'0');
		}
		discount/=100;
		discount=1-discount;
		return discount;
	}
	
}
