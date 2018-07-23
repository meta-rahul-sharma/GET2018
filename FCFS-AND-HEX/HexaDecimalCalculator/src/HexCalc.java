/**
 * creation date 17/7/2018
 * 
 * @author rahul sharma arithmatic calculations of hex no.'s
 * 
 */
public class HexCalc {
	/**
	 * add hexFirst to HexSecond
	 * 
	 * @param hexFirst
	 * @param hexSecond
	 * @return addition
	 */
	public String add(final String hexFirst, final String hexSecond) {
		int decimalFirst = hexToDecimal(hexFirst);
		int decimalSecond = hexToDecimal(hexSecond);
		int decimalAdd = decimalFirst + decimalSecond;
		String hexAdd = decimalToHex(decimalAdd);
		return hexAdd;
	}

	/**
	 * subtract hexFirst to HexSecond
	 * 
	 * @param hexFirst
	 * @param hexSecond
	 * @return subtraction
	 */
	public String subtract(final String hexFirst, final String hexSecond) {
		int decimalFirst = hexToDecimal(hexFirst);
		int decimalSecond = hexToDecimal(hexSecond);
		int decimalAdd = decimalFirst - decimalSecond;
		String hexSubtract;
		if (decimalAdd > 0) {
			hexSubtract = decimalToHex(decimalAdd);
		} else {
			hexSubtract = decimalToHex(Math.abs(decimalAdd));
			hexSubtract = '-' + hexSubtract;
		}
		return hexSubtract;
	}

	/**
	 * multiply hexFirst to HexSecond
	 * 
	 * @param hexFirst
	 * @param hexSecond
	 * @return Multiplication
	 */
	public String multiply(final String hexFirst, final String hexSecond) {
		int decimalFirst = hexToDecimal(hexFirst);
		int decimalSecond = hexToDecimal(hexSecond);
		int decimalMultiply = decimalFirst * decimalSecond;
		String hexMultiply = decimalToHex(decimalMultiply);
		return hexMultiply;
	}

	/**
	 * divide hexFirst to HexSecond
	 * 
	 * @param hexFirst
	 * @param hexSecond
	 * @return division
	 */
	public String divide(final String hexFirst, final String hexSecond) {
		int decimalFirst = hexToDecimal(hexFirst);
		int decimalSecond = hexToDecimal(hexSecond);
		if(decimalSecond == 0) {
			throw new AssertionError();
		}
		
		int	decimalDivide = decimalFirst / decimalSecond;
		
		String hexDivide = decimalToHex(decimalDivide);
		return hexDivide;
	}

	/**
	 * convert hexadecimal to decimal
	 * 
	 * @param string
	 *            hex
	 * @return decimal value
	 */
	public int hexToDecimal(String hex) {
		int decimal = 0;
		int hexMultiplier = 1;
		hex = hex.toLowerCase();
		for (int i = hex.length() - 1; i >= 0; i--) {
			if (hex.charAt(i) >= '0' && hex.charAt(i) <= '9') {
				decimal += (hex.charAt(i) - '0') * hexMultiplier;
			} else {
				if (hex.charAt(i) >= 'a' && hex.charAt(i) <= 'f') {
					decimal += (hex.charAt(i) - 'a' + 10) * hexMultiplier;
				}
			}
			hexMultiplier *= 16;
		}
		return decimal;
	}

	/**
	 * convert decimal to hexadecimal
	 * 
	 * @param decimal
	 * @return hexadecimal value
	 */
	public String decimalToHex(int decimal) {
		String hex = "";
		String code = "0123456789abcdef";
		String hexResult = "";
		if (decimal == 0) {
			hexResult = "0";
		} else {
			while (decimal != 0) {

				int index = decimal % 16;
				decimal /= 16;
				hex = hex + code.charAt(index);
			}

			for (int i = hex.length() - 1; i >= 0; i--) {
				hexResult = hexResult + hex.charAt(i);
			}
		}
		return hexResult;
	}

	/**
	 * check if sting is hexadecimal or not
	 * 
	 * @param hex
	 * @return
	 */
	public boolean checkHex(String hex) {
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
	 * 
	 * @param hexFirst
	 * @param hexSecond
	 * @return true if hexFirst less than hexSecond
	 */
	public boolean isLessThan(String hexFirst, String hexSecond) {
		int decimalFirst = hexToDecimal(hexFirst);// to remove
		String first = decimalToHex(decimalFirst);// extra zero's eg. 000a=a

		int decimalSecond = hexToDecimal(hexSecond);
		String second = decimalToHex(decimalSecond);

		if (first.length() > second.length()) {
			return true;
		} else {
			if (first.length() < second.length()) {
				return false;
			} else {
				for (int i = 0; i < first.length(); i++) {
					if (first.charAt(i) > second.charAt(i)) {
						return false;
					} else if (first.charAt(i) < second.charAt(i)) {
						return true;
					} else if(i == first.length() - 1 && first.charAt(i) == second.charAt(i)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * compare to hexadecimal string
	 * 
	 * @param hexFirst
	 * @param hexSecond
	 * @return true if hexFirst greater than hexSecond
	 */
	public boolean isGreaterThan(String hexFirst, String hexSecond) {
		int decimalFirst = hexToDecimal(hexFirst);// to remove
		String first = decimalToHex(decimalFirst);// extra zero's eg. 000a=a

		int decimalSecond = hexToDecimal(hexSecond);
		String second = decimalToHex(decimalSecond);

		if (first.length() > second.length()) {
			return true;
		} else {
			if (first.length() < second.length()) {
				return false;
			} else {
				for (int i = 0; i < first.length(); i++) {
					if (first.charAt(i) < second.charAt(i)) {
						return false;
					} else if (first.charAt(i) > second.charAt(i)) {
						return true;
					} else if(i == first.length() - 1 && first.charAt(i) == second.charAt(i)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * compare to hexadecimal string
	 * 
	 * @param hexFirst
	 * @param hexSecond
	 * @return true if hexFirst equal to hexSecond
	 */
	public boolean isEqual(String hexFirst, String hexSecond) {
		int decimalFirst = hexToDecimal(hexFirst);// to remove
		String first = decimalToHex(decimalFirst);// extra zero's eg. 000a=a

		int decimalSecond = hexToDecimal(hexSecond);
		String second = decimalToHex(decimalSecond);

		if (first.length() == second.length()) {
			for (int i = 0; i < first.length(); i++) {
				if (first.charAt(i) != second.charAt(i)) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

}
