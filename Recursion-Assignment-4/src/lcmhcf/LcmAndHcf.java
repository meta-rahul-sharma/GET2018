package lcmhcf;

/**
 * Implementation of LCM AND HCF
 * @author Rahul Sharma
 */
public class LcmAndHcf {
	
	/**
	 * @param firstNo
	 * @param secondNo
	 * @return LCM of firstNo and secondNO
	 */
	public int Lcm(int firstNo, int secondNo) {
		int result = -1;
		if (!(firstNo == 0 && secondNo == 0)) {
			if (firstNo == 0 || secondNo == 0) {
				result = 0;
			} else {
				result = firstNo * secondNo / Hcf(firstNo, secondNo);
			}
		}
		return result;
	}

	/**
	 * @param firstNo
	 * @param secondNo
	 * @return HCF of firstNo and secondNO
	 */	
	public int Hcf(int firstNo, int secondNo) {
		int result = -1;
		if (!(firstNo == 0 && secondNo == 0)) {
			if (firstNo == 0) {
				result = secondNo;
			} else {
				result = Hcf(secondNo % firstNo, firstNo);
			}
		}
		return result;
	}
}
