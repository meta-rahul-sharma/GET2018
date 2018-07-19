/**creation date 17/7/2018
 * @author rahul sharma
 * arithmatic calculations of hex no.'s
 * 
 */
public class HexCalc {
	/**
	 * add hexFirst to HexSecond
	 * @param hexFirst
	 * @param hexSecond
	 * @return addition
	 */
	public static String add(final String hexFirst, final String hexSecond){
		int decimalFirst = hexToDecimal(hexFirst);
		int decimalSecond = hexToDecimal(hexSecond);
		int decimalAdd= decimalFirst + decimalSecond;
		String hexAdd = decimalToHex(decimalAdd);
		return hexAdd;
	}
	
	/**
	 * subtract hexFirst to HexSecond
	 * @param hexFirst
	 * @param hexSecond
	 * @return subtraction
	 */
	public static String subtract(final String hexFirst, final String hexSecond){
		int decimalFirst = hexToDecimal(hexFirst);
		int decimalSecond = hexToDecimal(hexSecond);
		int decimalAdd= decimalFirst - decimalSecond;
		String hexSubtract;
		if(decimalAdd>0){
			hexSubtract = decimalToHex(decimalAdd);
		} else {
			hexSubtract = decimalToHex(Math.abs(decimalAdd));
			hexSubtract = '-'+hexSubtract;
		}
		return hexSubtract;
	}
	
	/**
	 * multiply hexFirst to HexSecond
	 * @param hexFirst
	 * @param hexSecond
	 * @return Multiplication
	 */
	public static String multiply(final String hexFirst, final String hexSecond){
		int decimalFirst = hexToDecimal(hexFirst);
		int decimalSecond = hexToDecimal(hexSecond);
		int decimalMultiply= decimalFirst * decimalSecond;
		String hexMultiply = decimalToHex(decimalMultiply);
		return hexMultiply;
	}
	
	/**
	 * divide hexFirst to HexSecond
	 * @param hexFirst
	 * @param hexSecond
	 * @return division
	 */
	public static String divide(final String hexFirst, final String hexSecond){
		int decimalFirst = hexToDecimal(hexFirst);
		int decimalSecond = hexToDecimal(hexSecond);
		int decimalDivide= decimalFirst / decimalSecond;
		String hexDivide = decimalToHex(decimalDivide);
		return hexDivide;
	}
	
	/**
	 * convert hexadecimal to decimal
	 * @param string hex
	 * @return decimal value
	 */
	public static int hexToDecimal(String hex){
		int decimal=0;
		int hexMultiplier=1;
		hex = hex.toLowerCase();
		for(int i=hex.length()-1; i>=0; i--){
			if(hex.charAt(i)>='0' && hex.charAt(i)<='9')
			{
				decimal+= (hex.charAt(i)-'0')*hexMultiplier;
			}
			else{
				if(hex.charAt(i)>='a' && hex.charAt(i)<='f'){
					decimal+= (hex.charAt(i)-'a'+10)*hexMultiplier;
				}
			}
			hexMultiplier*= 16;
		}
		return decimal;
	}
	
	/**
	 * convert decimal to hexadecimal
	 * @param decimal
	 * @return hexadecimal value 
	 */
	public static String decimalToHex(int decimal){
		String hex= "";
		String code="0123456789abcdef";
		while(decimal!=0){
			
			int index= decimal%16;
			decimal/=16;
			hex=hex+code.charAt(index);
		}
		String hexResult="";
		for(int i=hex.length()-1; i>=0; i--){
			hexResult=hexResult+hex.charAt(i);
		}
		return hexResult;
	}
	
	/**
	 * check if sting is hexadecimal or not
	 * @param hex
	 * @return
	 */
	public static boolean checkHex(String hex) {
		 boolean ret;
	        try {
	            int t = Integer.parseInt(hex, 16);
	            ret = true;
	        } catch (NumberFormatException e) {
	            ret = false;
	        }
	        return (ret);
	}
	
	/**
	 * compare to hexadecimal string
	 * @param hexFirst
	 * @param hexSecond
	 * @return true if hexFirst less than hexSecond
	 */
	public static boolean isLessThan(String hexFirst, String hexSecond){
		int decimalFirst = hexToDecimal(hexFirst);//to remove
		String first = decimalToHex(decimalFirst);//extra zero's eg. 000a=a
		
		int decimalSecond = hexToDecimal(hexSecond);
		String second = decimalToHex(decimalSecond);
		
		if(first.length()<second.length()){
			return true;
		}
		else{
			if(first.length()>second.length()){
				return false;
			}
			else{
				for(int i=0; i<first.length(); i++){
					if(first.charAt(i)>second.charAt(i)){
						return false;
					}
					else{
						if(first.charAt(i)<second.charAt(i)){
							return true;
						}
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * compare to hexadecimal string
	 * @param hexFirst
	 * @param hexSecond
	 * @return true if hexFirst greater than hexSecond
	 */
	public static boolean isGreaterThan(String hexFirst, String hexSecond){
		int decimalFirst = hexToDecimal(hexFirst);//to remove
		String first = decimalToHex(decimalFirst);//extra zero's eg. 000a=a
		
		int decimalSecond = hexToDecimal(hexSecond);
		String second = decimalToHex(decimalSecond);
		
		if(first.length()>second.length()){
			return true;
		}
		else{
			if(first.length()<second.length()){
				return false;
			}
			else{
				for(int i=0; i<first.length(); i++){
					if(first.charAt(i)<second.charAt(i)){
						return false;
					}
					else{
						if(first.charAt(i)>second.charAt(i)){
							return true;
						}
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * compare to hexadecimal string
	 * @param hexFirst
	 * @param hexSecond
	 * @return true if hexFirst equal to hexSecond
	 */
	public static boolean isEqual(String hexFirst, String hexSecond){
		int decimalFirst = hexToDecimal(hexFirst);//to remove
		String first = decimalToHex(decimalFirst);//extra zero's eg. 000a=a
		
		int decimalSecond = hexToDecimal(hexSecond);
		String second = decimalToHex(decimalSecond);
		
		if(first.length()==second.length()){
		     for(int i=0; i<first.length(); i++){
			     if(first.charAt(i)!=second.charAt(i)){
						return false;
			      }
		     }
		}
		else{
			return false;
		}
		return true;
	}
	
}
