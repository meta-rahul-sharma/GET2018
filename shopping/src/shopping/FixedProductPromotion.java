package shopping;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 * 
 * @author RahulSharma
 *used for fixed price promotion eg. price >7000d
 */
public class FixedProductPromotion implements Promotion{
    private double minimumPrice=7000d;
    private double discount;
	@Override
	public Double getMinimumPrice() {
		// TODO Auto-generated method stub
		return minimumPrice;
	}

	@Override
	public void setMinimumPrice(Double minimumPrice) {
		this.minimumPrice = minimumPrice;
		
	}

	@Override
	public double getFixedDiscount() {
		// TODO Auto-generated method stub
		return discount;
	}

	@Override
	public void setFixedDiscount(double discount) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * checking that user promocode is valid or not and in between date of availability
	 */
	@Override
	public boolean isPromotionApplicable(String promotion) {
		// TODO Auto-generated method stub
		boolean promoReturn=false;
		for(PromotionEnum promo:PromotionEnum.values()){
			if(promo.getCode().equals(promotion)){
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