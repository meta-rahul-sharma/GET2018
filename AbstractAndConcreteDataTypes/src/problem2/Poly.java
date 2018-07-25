package problem2;
/**
 * Implementation of Immutable class Poly which containg basic properties of 
 * polynomial equations and can perform operations on a polynomial like:-
 * 1. evaluate 
 * 2. add
 * 3. multiply 
 * 4. degree etc.
 * @author rahul sharma
 *Creation date: 25/7/2018
 */
public final class Poly {
	private final int[][] polynomial;
	private final int coefficient = 0;
	private final int power = 1;
	private final int columns = 2;

	/**
	 * Constructor of Poly class where we are initailizing user inputs
	 * @param polynomial 2D array which contain coefficient and power
	 */
	public Poly(int[][] polynomial) {
		int[][] withoutZeroCoefficient = removeZeroCoefficient(polynomial);
		this.polynomial = new int[withoutZeroCoefficient.length][columns];
		//System.out.println(withoutZeroCoefficient.length);
		for (int i = 0; i < withoutZeroCoefficient.length; i++) {
			this.polynomial[i][coefficient] = withoutZeroCoefficient[i][coefficient];
			this.polynomial[i][power] = withoutZeroCoefficient[i][power];
			//System.out.println(this.polynomial[i][coefficient]+" "+this.polynomial[i][power]);
		}
	}

	/**
	 * Used for returning 2D array of Poly class which contain 
	 * coefficient and power
	 * @return 2D array named polynomial
	 */
	public int[][] getPolynomial() {
		return polynomial;
	}

	/**
	 * Used for polynomial evaluation on specific value example value = 5
	 * @param value (To put in polynomial equation)
	 * @return Evaluated value of polynomial
	 */
	public double evaluate(float value) {
		double evaluation = 0;
		for (int i = 0; i < this.length(); i++) {
			evaluation += polynomial[i][coefficient]
					* Math.pow(value, polynomial[i][power]);
		}
		return evaluation;
	}
	
	/**
	 * Used for returning degree of polynomial
	 * @return degree
	 */
	public int degree() {
		int degree = polynomial[0][power];
		for (int i = 1; i < polynomial.length; i++) {
			if (degree < polynomial[i][power]) {
				degree = polynomial[i][power];
			}
		}
		return degree;
	}
	
	/**
	 * Used for Adding 2 objects 2D array named polynomial of class Poly
	 * @param poly     (Another object of Poly class to Add with this object of class)
	 * @return 2D array of polynomial
	 */
	public int[][] addPoly(Poly poly) {
		int[][] polynomialAdd = new int[Math.max(this.degree(), poly.degree()) + 1][columns];
		sort2DMatrix sort = new sort2DMatrix();
		sort.sortbyColumn(this.polynomial, power);
		sort.sortbyColumn(poly.polynomial, power);

		int point1 = 0;
		int point2 = 0;
		int addPointer = 0;
		//complexity in O(m+n)
		while (point1 < this.length() && point2 < poly.length()) {
			if (this.polynomial[point1][power] == poly.polynomial[point2][power]) {
				polynomialAdd[addPointer][coefficient] = this.polynomial[point1][coefficient]
						+ poly.polynomial[point2][coefficient];
				polynomialAdd[addPointer][power] = this.polynomial[point1][power];
				addPointer++;
				point1++;
				point2++;
			} else if (this.polynomial[point1][power] < poly.polynomial[point2][power]) {
				polynomialAdd[addPointer][coefficient] = this.polynomial[point1][coefficient];
				polynomialAdd[addPointer][power] = this.polynomial[point1][power];
				point1++;
				addPointer++;
			} else if (this.polynomial[point1][power] > poly.polynomial[point2][power]) {
				polynomialAdd[addPointer][coefficient] = poly.polynomial[point1][coefficient];
				polynomialAdd[addPointer][power] = poly.polynomial[point1][power];
				point2++;
				addPointer++;
			}

		}

		while (point1 < this.length()) {
			polynomialAdd[addPointer][coefficient] = this.polynomial[point1][coefficient];
			polynomialAdd[addPointer][power] = this.polynomial[point1][power];
			point1++;
			addPointer++;
		}

		while (point2 < poly.length()) {
			polynomialAdd[addPointer][coefficient] = poly.polynomial[point1][coefficient];
			polynomialAdd[addPointer][power] = poly.polynomial[point1][power];
			point2++;
			addPointer++;
		}

		int[][] add = new int[addPointer][columns];
		for (int i = 0; i < addPointer; i++) {
			add[i][coefficient] = polynomialAdd[i][coefficient];
			add[i][power] = polynomialAdd[i][power];
			//System.out.println(add[i][coefficient] + " " + add[i][power]);
		}

		return add;
	}
	
	/**
	 * Used for Multiplying 2 objects 2D array named polynomial of class Poly
	 * @param poly     (Another object of Poly class to Multiply with this object of class)
	 * @return 2D array of polynomial
	 */
	public int[][] multiplyPoly(Poly poly) {
		int index = 0;
		int[][] multiply = new int[this.length() * poly.length()][columns];
		for (int i = 0; i < this.length(); i++) {
			for (int j = 0; j < poly.length(); j++) {
				multiply[index][power] = this.polynomial[i][power]
						+ poly.polynomial[j][power];
				multiply[index][coefficient] = this.polynomial[i][coefficient]
						* poly.polynomial[j][coefficient];
				//System.out.println(multiply[index][coefficient] + " "
				//	+ multiply[index][power]);
				index++;
			}
		}
		sort2DMatrix sort = new sort2DMatrix();
		sort.sortbyColumn(multiply, power);
		int[][] result = addSamePowerCoefficient(multiply);
		return result;
	}

	/**
	 * Used for returning number of rows of the polynomial 2D array
	 * of Poly class 
	 * @return polynomial 2D array rows count
	 */
	private int length() {
		return this.polynomial.length;
	}
	
	/**
	 * Here we are removing elements in 2D array such that no 2 element in power
	 * column have same power
	 * @param perfromOn  2D array we are performing our method
	 * @return 2D array without same power as elements in power column
	 */
	private int[][] addSamePowerCoefficient(int[][] perfromOn) {
		int[][] samePower = new int[perfromOn.length][columns];
		int index = 0;
		int power = perfromOn[0][this.power];
		int value = perfromOn[0][coefficient];
		for(int i = 1; i < samePower.length; i++) {
			if(power == perfromOn[i][this.power]) {
				value += perfromOn[i][coefficient];
			} else {
				samePower[index][this.power] = power;
				samePower[index][coefficient] = value;
				value = perfromOn[i][coefficient];
				power = perfromOn[i][this.power];
				index++;
			}
		}
		samePower[index][this.power] = power;
		samePower[index][coefficient] = value;
		index++;
		
		int[][] result = new int[index][columns];
		for(int i= 0; i< index; i++) {
			result[i][this.power] = samePower[i][this.power];
			result[i][coefficient] = samePower[i][coefficient];
			//System.out.println(result[i][coefficient]+" "+result[i][this.power]);
		}
		return result;
	}
	
	private int[][] removeZeroCoefficient(int[][] array) {
		int numberOfZero = 0; 
		for(int i = 0; i < array.length; i++) {
			if(array[i][coefficient] == 0) {
				numberOfZero++;
			}
		}
		
		int index = 0;
		int[][] result = new int[array.length - numberOfZero][columns];
		for(int i = 0; i < array.length; i++) {
			if(array[i][coefficient] != 0) {
				result[index][power] = array[i][power];
				result[index][coefficient] = array[i][coefficient];
				
				//System.out.println(result[index][coefficient]+" "+result[index][power]);
				index++;
			}
		}
		return result;
	} 
}
