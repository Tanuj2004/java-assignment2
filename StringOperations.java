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
	public static String appendString(String s,String toAppend)
	{
		char[] result = new char[s.length() + toAppend.length()];
		int i=0;
		for(i = 0;i < s.length();i++)
		{
			result[i] = s.charAt(i);
		}
		for (int j = 0; j < toAppend.length(); j++, i++) {
		result[i] = toAppend.charAt(j);
		}
		return new String(result);
	}
	public static int countwords(String s)
	{
		int count = 0;
		boolean inword = false;
		int endword = s.length() - 1;
		for (int i = 0;i < s.length();i++)
		{
			if (Character.isLetter(s.charAt(i)) && i != endword)
					{
				inword = true;
					}
			else if ( !Character.isLetter(s.charAt(i)) && inword)
			{
				count ++;
				inword = false;
			}
			else if (Character.isLetter(s.charAt(i)) && i == endword)
			{
				count ++;
			}
		}
		return count ;
	}

public static String Replacechar(String original,char oldchar,char newchar)
	
	{
		char[] result = new char[original.length()];
		
		for(int i = 0;i < original.length();i++)
			
		   {
			if(original.charAt(i) == oldchar)
			{
				result[i] = newchar;
			}
			else 
			{
				result[i] = original.charAt(i);
			}
			}
		return new String(result);
		}
	public static boolean ispalindrome(String str)
	{
		if(str == null || str.length() == 0)
		{
			return true;
		}
		
		for(int i = 0; i <= str.length()/2;i++)
		{
			char start = str.charAt(i);
			char end =str.charAt(str.length() - 1 - i);
		
		if (start != end)
		{
			return false;
		}
		}
		return true;
	}
    public static String splicer(String str ,int start,int end )
    {
    	int newlen = str.length() - end ;
    	char[] result = new char [newlen];
    	int in = 0;
    	for (int i = 0 ;i < start;i++ )
    	{
    		result[in++] = str.charAt(i);
    	}
    	for (int i = start + end ;i < str.length();i++)
    	{
    		result[in++] = str.charAt(i);
    		
    	}
    		return new String(result);
      }
    public static String[] splitter(String str,String delimiter)
    {
    	return str.split(delimiter);    	
    }
    public static char maxrepeat(String str)
    {
    	int maxcount = 0;
    	char maxChar = '\0';
    	for (int i = 0;i < str.length();i++)
    	{
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
    public static String Sorting(String str)
    {
    	char temp;
    	char string[] = str.toCharArray();
    	for(int i = 0 ;i < string.length; i++)
    	{
    		for(int j = i + 1;j < string.length; j++ )
    		{
    			if(string[i]>string[j])
    			{
    				temp = string[i];
    				string[i] = string[j];
    				string[j] = temp;
     			}
    		}
    	}
    	return new String(string);
    }
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
	   public static String reverse(String str) {
	        char[] result = new char[str.length()];
	        for (int i = 0; i < str.length(); i++) {
	            result[i] = str.charAt(str.length() - 1 - i);
	        }
	        return new String(result);
	    }
	   
public static void main(String[] args) {
		
  Scanner input =new Scanner(System.in);
  String response;
  do
  {
  System.out.println("Enter the string to perform operations:");
  String str = input.nextLine();
  
  System.out.println(Constants.INDEX);
  System.out.println("Enter your choice"); 
 int choice = input.nextInt();
 input.nextLine();
 
 
 switch (choice)
 {
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
	  System.out.println("Is ths given string palindrome: " + ispalindrome(str));
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
	  System.out.println("The max repeating character is: " + maxrepeat(str));
	 break;
 case 8:
	 System.out.println(" The sorted string: " + Sorting(str));
	 break;
 case 9:

     System.out.println("Enter the number of positions to shift:");
     int shift = input.nextInt();
     String shiftedString = stringshifter(str, shift);
     System.out.println("The shifted String is: " + shiftedString);
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
