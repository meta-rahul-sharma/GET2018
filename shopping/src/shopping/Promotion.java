package shopping;
/**
 * 
 * @author RahulSharma
 *interface with methods needed for promocodes
 */
public interface Promotion {
	public static enum PromotionEnum {
	    DISCOUNT50("DISCOUNT50","10/05/2018","12/12/2018" ),
	    SALE20("SALE20","05/07/2017","03/12/2018" ),
	    FIRST15("FIRST15","13/10/2017","25/08/2018"),
	    SUNDAY32("SUNDAY32","09/09/2018","05/01/2019");
	    
	    private String code;
	    private String start_date;
	    private String end_date;
	    
	    PromotionEnum(String code, String start_date, String end_date){
	    	this.code=code;
	    	this.start_date=start_date;
	    	this.end_date=end_date;	
	    }
	    
	    public String getCode(){
	    	return code;
	    }
	    
	    public String getStartDate(){
	    	return start_date;
	    }
	    
	    public String getEndDate(){
	    	return end_date;
	    }
	}
	
	public Double getMinimumPrice();
	public void setMinimumPrice(Double set_price);
	public double getFixedDiscount();
	public void setFixedDiscount(double discount);
	public boolean isPromotionApplicable(String promotion);
}
