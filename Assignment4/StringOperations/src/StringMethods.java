import java.util.ArrayList;
/**
 * 
 * @author RAHUL SHARMA
 *
 */
public class StringMethods {
	private String classString;
	
	/**
	 * Initializes class variables
	 * @param classString
	 */
	public StringMethods(String classString){
		this.classString = classString;
	}
	
	/**
	 * 
	 * @param userString
	 * @return true if strings are equal else false
	 */
	public boolean isEquals(String userString){
		if(classString.length()==userString.length()){
		     for(int i=0; i<classString.length(); i++){
			     if(classString.charAt(i)!=userString.charAt(i)){
						return false;
						
			      }
		     }
		}
		else{
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @return reverse of the class string
	 */
	public String reverseString(){
		String reverseString="";
		for(int i=classString.length()-1; i>=0; i--){
			reverseString = reverseString + classString.charAt(i);
		}
		return reverseString;
	}
	
	/**
	 * 
	 * @return string of class with change of lower to uppercase and viceversa
	 */
	public String viceVersa(){
		String viceVersa = "";
		int lowerToUpper = 'a'-'A';
		for(int i=0; i<classString.length(); i++){
			if(classString.charAt(i)>='a' && classString.charAt(i)<='z'){
				viceVersa = viceVersa + (char)(classString.charAt(i)-lowerToUpper);
			} else if(classString.charAt(i)>='A' && classString.charAt(i)<='Z'){
					viceVersa = viceVersa + (char)(classString.charAt(i)+lowerToUpper);
			} else if(classString.charAt(i)==' '){
						viceVersa = viceVersa + " ";
			} else {
				viceVersa = viceVersa + classString.charAt(i);
			}
		}
		return viceVersa;
	}
	
	/**
	 * 
	 * @return largest word in a string
	 */
	public String largestWord(){
		ArrayList <Integer> wordCount = new ArrayList<Integer>();
		ArrayList <String> word = new ArrayList<String>();
		int characterCount = 0;
		String wordTaker = "";
		for(int i=0; i<classString.length(); i++){
			if((char)classString.charAt(i)==' ' || i==classString.length()-1){
				
				if(i==classString.length()-1){
					wordCount.add(characterCount+1);
					wordTaker = wordTaker + classString.charAt(classString.length()-1);
					word.add(wordTaker);
				}
				else {
					wordCount.add(characterCount);
					word.add(wordTaker);
				}
				characterCount = 0;
				wordTaker = "";
			} else{
				characterCount++;
				wordTaker = wordTaker + classString.charAt(i);
			}
		}
		
		int max=0;
		int index=-1;
		for (int i = wordCount.size()-1; i >= 0; i--){
			if (max<wordCount.get(i)){
				max = wordCount.get(i);
				index = i;
			}
		}
		return word.get(index);
	}
}
