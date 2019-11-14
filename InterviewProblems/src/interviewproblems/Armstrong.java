package interviewproblems;

/**
 * A number is called an Armstrong number if it is equal to the n power(n being # of digits) of its every digit. 
 * For example, 153 is an Armstrong number because of 153= 1+ 125+27, which is equal to 1^3+5^3+3^3. 
 * You need to write a program to check if the given number is Armstrong number or not.
 * @author Johnny
 *
 */
public class Armstrong {
	
	public static void armstrongNumber(int num) {
		int numLength = String.valueOf(num).length();
		int tempNum = num;
		int sum = 0;
		while (tempNum > 0) {
			// divide by 10 and get remainder, which is the digit
			int digit = tempNum % 10;
			tempNum = tempNum / 10;
			// cube digit and add to sum
			int nPow = (int)Math.pow(digit, numLength);
			sum += nPow;
		}
		
		// compare sum of cubed digits to original num
		if (sum == num) {
			System.out.println("Number: " + num + " is an Armstrong Number");
		}
		else {
			System.out.println("Number: " + num + " is NOT an Armstrong Number");
		}
	}
	
	public static void main(String[] args) {
		armstrongNumber(153);
		armstrongNumber(120);
		armstrongNumber(1253);
		armstrongNumber(1634);
	}
}
