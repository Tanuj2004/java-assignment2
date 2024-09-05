/***
 *TASK--> When the program is run, the user will first enter a string. After that, the program should ask the user which operation they want to execute on the string. The available operations are
listed below: > Append                             > Split                                                 
              > CountWords                         > MaxRepeatingCharacter
              > Replace                            > Sort
              > isPalindrome                       > Shift 
              > Splice                             > Reverse
*Each method should perform its respective operation based on the user's input.
*Owner-->TANUJ YADAV
*DATE-->04/09/2024
 */
import java.util.Scanner;
public class StringOperations {
	/**
     * Appends one string to another.
     * And return the concatenated string
     */
	public static String appendString(String s,String toAppend){
		return s + toAppend;
	}
	  /**
     * Counts the number of words in a string.
     * And return the number of words in the string
     */
	public static int countwords(String s) {
		int countword = 0;
		boolean inword = false;
		int endword = s.length() - 1;
		for (int i = 0;i < s.length();i++) {
			if (Character.isLetter(s.charAt(i)) && i != endword){
				inword = true;
					}
			else if ( !Character.isLetter(s.charAt(i)) && inword){
				countword ++;
				inword = false;
			}
			else if (Character.isLetter(s.charAt(i)) && i == endword){
				countword ++;
			}
		}
		return countword ;
	}
    /**
     * Replaces all occurrences of a specified character in a string with a new character.
     * oldchar is the character which is to be replaced and the newchar is the new character which will replace the oldchar
     * And return the string with the characters replaced
     */
public static String Replacechar(String originalstring,char oldchar,char newchar){
		char[] result = new char[originalstring.length()];
		for(int i = 0;i < originalstring.length();i++) {
			if(originalstring.charAt(i) == oldchar){
				result[i] = newchar;
			}
			else{
				result[i] = originalstring.charAt(i);
			}
			}
		return new String(result);
		}
/**
 * Checks if a given string is a palindrome.
 * And true if the string is a palindrome, false otherwise
 */
	public static boolean ispalindrome(String str){
		if(str == null || str.length() == 0){
			return true;
		}
		for(int i = 0; i <= str.length()/2;i++){
			char start = str.charAt(i);
			char end =str.charAt(str.length() - 1 - i);
		if (start != end){
			return false;
		}
		}
		return true;
	}
    /**
     * Splice is used to remove a specified portion of the string, defined by a starting index and a length.
     * And return the spliced string
     */
    public static String splicer(String str ,int startindex,int endindex ) {
    	int newlength = str.length() - endindex ;
    	char[] result = new char [newlength];
    	int in = 0;
    	for (int i = 0 ;i < startindex;i++ ){
    		result[in++] = str.charAt(i);
    	}
    	for (int i = startindex + endindex ;i < str.length();i++){
    		result[in++] = str.charAt(i); 		
    	}
    		return new String(result);
      }
    /**
     * Splits a string based on a specified delimiter.
     * And return an array of substrings resulting from the split
     */
    public static String[] splitter(String str,String delimiter){
    	return str.split(delimiter);    	
    }
    /**
     * Finds the character that appears most frequently in the string.
     * And return the character that repeats the most
     */
    public static char maxrepeat(String str){
    	int maxcount = 0;
    	char maxChar = '\0';
    	for (int i = 0;i < str.length();i++) {
    		 char currentChar = str.charAt(i);
             int count = 0;
             for (int j = 0; j < str.length(); j++) {
                 if (str.charAt(j) == currentChar) {
                     count++;
                 }
             }
             if (count > maxcount) {
                maxcount = count;
                 maxChar = currentChar;
             }
         }
         return maxChar;
     }
    /**
     * Sorts the characters in a string in ascending order.
     * And return the sorted string
     */
    public static String Sorting(String str) {
    	char temp;
    	char string[] = str.toCharArray();
    	for(int i = 0 ;i < string.length; i++) {
    		for(int j = i + 1;j < string.length; j++ ) {
    			if(string[i]>string[j]){
    				temp = string[i];
    				string[i] = string[j];
    				string[j] = temp;
     			}
    		}
    	}
    	return new String(string);
    }
    /**
     * Shifts the characters in a string by a specified number of positions.
     * And return the shifted string
     */
    public static String stringshifter(String str, int shift) {
        int length = str.length();
        shift = shift % length;      
        char[] shifted = new char[length];
        for (int i = 0; i < length; i++) {
            int newPosition = (i + shift) % length;
            shifted[newPosition] = str.charAt(i);
        }
        return new String(shifted);
    }
    /**
     * Reverses the characters in a string.
     * And return the reversed string
     */
	   public static String reverse(String str) {
	        char[] result = new char[str.length()];
	        for (int i = 0; i < str.length(); i++) {
	            result[i] = str.charAt(str.length() - 1 - i);
	        }
	        return new String(result);
	    }
	   /***
	    * to validate the string
	    * @return true if the string is valid
	    */
	   public static boolean isValidString(String str) {
		    if (str == null || str.isEmpty()) {
		        return false;
		    }
		    for (char c : str.toCharArray()) {
		        if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
		            return false;
		        }
		    }
		    return true;
		}
        /**
	     * The main method where the program starts execution.
	     */
public static void main(String[] args) {	
  Scanner input =new Scanner(System.in);
  String response = null;
  do {
  System.out.println(Constants.INPUTSTR);
  String str = input.nextLine();
  if (!isValidString(str)) {
      System.out.println(Constants.INVALIDSTRING);
      continue;
  } 
  System.out.println(Constants.INDEX);
  System.out.println(Constants.CHOICE); 
 int choice = input.nextInt();
 input.nextLine();
 switch (choice) {
 case 1:
	 System.out.println(Constants.APPEND);
     String toAppend = input.nextLine();
     System.out.println("Appended String: " + appendString(str, toAppend));
	 break;
 case 2:
	 System.out.println("Word count: " + countwords(str));
	 break;
 case 3:
	   System.out.println(Constants.REPLACE);
       char oldChar = input.nextLine().charAt(0);
       System.out.println(Constants.NEW);
       char newChar = input.nextLine().charAt(0);
       System.out.println("New String " + Replacechar(str, oldChar, newChar));
	 break;
 case 4:
	  System.out.println(Constants.PALINDROME + ispalindrome(str));
	 break;
 case 5:
     System.out.println(Constants.SPLICE);
     int start = input.nextInt();
     System.out.println(Constants.REMOVE);
     int length = input.nextInt();
     input.nextLine(); 
     System.out.println("The spliced string :" + splicer(str, start, length));
	 break;
 case 6:
	   String delimiter = " ";
	    String[] words = splitter(str, delimiter);
	    System.out.println("Original String: " + str);
	    System.out.println("Split Strings:");
	    for (String word : words) {
	        System.out.println(word);
	    }	 
	 break;
 case 7:
	  System.out.println(Constants.MAXSTR + maxrepeat(str));
	 break;
 case 8:
	 System.out.println(Constants.SORTEDSTR + Sorting(str));
	 break;
 case 9:
     System.out.println(Constants.POSISHIFT);
     int shift = input.nextInt();
     String shiftedString = stringshifter(str, shift);
     System.out.println(Constants.SHIFTEDSTR + shiftedString);
     input.nextLine();
	 break;
 case 10:
	 System.out.println("Reversed string: " + reverse(str));
	 break;
 default:
		 System.out.println("Invalid choice");
		 break;
 }
 System.out.println( Constants.ASKAGAIN);
 response = input.nextLine();
  }
  while(response.equalsIgnoreCase("yes"));
 input.close();
	}
}
