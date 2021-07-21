import java.util.Scanner;


//Creating a class with methods that convert Roman numerals to digits and the other way around
class RomanNumerals {
	
	String string = "";
	short number = 0;
	
	public int convertToInt(String input) {
		
		//Making sure the roman numerals are in upper case
		input = input.toUpperCase();
		
		
		//I used try and catch here because depending on the conditional statement, there can be an out of bounds error
		try {
			
			//Using a for loop to cycle through the letters in the roman numerals
			for (int x = 0; x < input.length(); x++) {
				
				//Depending on the letter, I add the corresponding number to the number variable (which is originally 0)
				if (input.charAt(x) == 'M') {
					number += 1000;
				}
				
				//For conditionals that check for 2 letters side by side, 
				//I added the corresponding number to the number variable and also add 1 to the x accumulator to skip an index
				//(this can cause an out of bounds error which is why i used try and catch)
				if (input.charAt(x) == 'C' && input.charAt(x + 1) == 'M') {
					number += 900;
					
					x = x + 1;
				}
				
				if (input.charAt(x) == 'D') {
					number += 500;
				}
				
				if (input.charAt(x) == 'C' && input.charAt(x + 1) == 'D') {
					number += 400;
					
					x = x + 1;
				}
				
				if (input.charAt(x) == 'C') {
					number += 100;
				}
				
				if (input.charAt(x) == 'X' && input.charAt(x + 1) == 'C') {
					number += 90;
					
					x = x + 1;
				}
				
				if (input.charAt(x) == 'L') {
					number += 50;
				}
				
				if (input.charAt(x) == 'X' && input.charAt(x + 1) == 'L') {
					number += 40;
					
					x = x + 1;
				}
				
				if (input.charAt(x) == 'X') {
					number += 10;
				}
				
				if (input.charAt(x) == 'I' && input.charAt(x + 1) == 'X') {
					number += 9;
					
					x = x + 1;
				}
				
				if (input.charAt(x) == 'V') {
					number += 5;
				}
				
				if (input.charAt(x) == 'I' && input.charAt(x + 1) == 'V') {
					number += 4;
					
					x = x + 1;
				}
				
				if (input.charAt(x) == 'I') {
					number += 1;
				}
				
			}
			
			//Returning the number as a short integer
			return number;
			
		} catch (java.lang.StringIndexOutOfBoundsException q) {
			
			//Returning the number as a short integer
			return number + 1;
		}
		
	}
	
	public String convertToString(short input) {
		
		
		//Making 2 arrays with all the letters and their corresponding number in order
		int[] intConversion = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] letterConversion = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		//Going through all the numbers in the integer list
		for (int i = 0; i < intConversion.length; i++) {
			
			//Checking to see if the inputted number is grater than or equal to the current number in the integer list
			while (input >= intConversion[i]) {
				
				//If it is greater or equal to the number, I add the corresponding letter(s) to the string variable I declared at the beginning
		    	string += letterConversion[i];
		    	
		    	//I subtract the number from the inputted number
		        input -= intConversion[i];        
		    }
			
		}
	    
		//Returning the Roman Numeral
	    return string;
	}
		
}

//Main class
public class RomanAllenMathew {

	public static void main(String[] args) {
		
		RomanNumerals roman = new RomanNumerals();
		Scanner scan = new Scanner (System.in);
		
		//Getting the user's input
		System.out.println("Input a number to convert into Roman Numerals:");
		short intInput = scan.nextShort();
		
		//Outputting the roman numerals
		System.out.println("\n" + intInput + " in Roman Numerals is: ");
		System.out.println(roman.convertToString(intInput) + "\n");
		
		//Getting the user's input
		System.out.println("Input a Roman Numeral to convert into a number:");
		String strInput = scan.next();
		
		//Outputting the number
		System.out.println("\n" + strInput + " as a number is: ");
		System.out.println(roman.convertToInt(strInput) + "\n");

	}


}