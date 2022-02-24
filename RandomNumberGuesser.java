/*
 * Class: CMSC203 
 * Instructor:Farnaz Eivazi
 * Description:  generates a random number and has the user try and guess it 
 * Due: 2/23/2021
 * Platform/compiler: java eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Kian Charkhabi
*/

import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		Scanner c=new Scanner(System.in);
		System.out.println("Enter your first guess");
		RNG r=new RNG();
		int num=r.rand(),guess=c.nextInt(),low=0,high=100;
		String cont="yes";
		System.out.println("Number of guesses is "+r.getCount());
		r.resetCount();
		int go=1;
		do{
			if(r.inputValidation(guess, low, high)) {
				if(guess>num) {
					System.out.println("Your guess is too high");
					high=guess;
					System.out.println("Enter your guess between "+low+"-"+high);
					guess=c.nextInt();
				}else if(guess<num) {
					System.out.println("Your guess is too low");
					low=guess;
					System.out.println("Enter your gues between "+low+"-"+high);
					guess=c.nextInt();
				}else {
					System.out.println("Congratulations, you guessed correctly\nTry again? (yes or no)");
					cont=c.next();
					if(cont.equals("yes")) {
						go=1;
						r.resetCount();
						guess=r.rand();
						System.out.println("Enter your first guess");
						guess=c.nextInt();
						low=0;
						high=100;
					}else {
						go=0;
					}
				}
				if(go==1) {
					System.out.println("Number of guesses is "+(r.getCount()+1));
				}
			}else {
				guess=c.nextInt();
			}
		}while(cont.equals("yes"));
		System.out.println("Thanks for playing...\n\nKian Charkhabi");
	}

}
