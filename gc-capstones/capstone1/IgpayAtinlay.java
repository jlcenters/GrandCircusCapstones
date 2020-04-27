package week1capstone;
/*
 * @author jilliancenters
 */
import java.util.Scanner;

public class IgpayAtinlay {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Ethodsmay methods = new Ethodsmay();
		boolean playAgain = true;
		int i = 0;
		System.out.println("Welcome to the Official Pig Latin Translator! [PATENT PENDING]\n\n");
		//if/else statement with String.matches("*special character symbols*) would prevent software from translating a word. 
		
		
		while(playAgain) {
			if(i < 1) {
			System.out.print("Please enter the word or phrase you would like for me to translate.");
			}else if(i >= 1) {
				System.out.print("You know what to do: ");
			}
			
			
			boolean isEmpty = true;
				while(isEmpty){
					String english = scn.nextLine();
					if(english.equals("")){
						System.out.print("\n\nOops! Looks like you forgot to type something in. Please try again.\n");
					}else {
						System.out.print("\nAlright, ready for your translation?\n");
						
						
						
						english = methods.ranslatortay(english);
						english = methods.apitalizationcay(english);
						System.out.println(english + "\n");
						isEmpty = false;
					}			
				++i;
				
				
				
				System.out.print("Would you like to translate another word or phrase? (y/n)");
				playAgain = scn.nextLine().toLowerCase().startsWith("y");
				}
		}
		System.out.println("Goodbye.");
		scn.close();
	}
}
