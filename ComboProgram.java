import java.util.*;

/**
 * Representation of a random number generator. Collects user input.
 */
public class ComboProgram {
	public static void main(String[] args){
		Random generator = new Random();
		
		int firstNum = generator.nextInt(40);
		int secondNum = generator.nextInt(40);
		int thirdNum = generator.nextInt(40);
		
		ComboLock cmbLock = new ComboLock(firstNum, secondNum, thirdNum);
		System.out.println("First Random: " + firstNum);
		System.out.println("Second Random: " + secondNum);
		System.out.println("Third Random: " + thirdNum);
		
		int[] guesses = new int[3];
		while(true){
			for (int i = 0; i<=2; i++){
				System.out.print("Guess a number to release the lock: ");
				Scanner keyboard = new Scanner(System.in);
				guesses[i] = keyboard.nextInt();
			}
			
			if (guesses[0] == 0 && guesses[1] == 0 && guesses[2] == 0){
				break;
			}
			
			int guess1 = 40 - guesses[0];
			int guess2, guess3;
			
			if ((cmbLock.getDialPosition() + guesses[1]) < 40){
				guess2 = cmbLock.getDialPosition() + guesses[1];
			}
			else{
				guess2 = ((cmbLock.getDialPosition() + guesses[1]) - 40);
			}
			
			if (cmbLock.getDialPosition() - guesses[2] > 0){
				guess3 = cmbLock.getDialPosition() - guesses[2];
			}
			else{
				guess3 = (40 - (guesses[2] - cmbLock.getDialPosition()));
			}
			 
			cmbLock.turnRight(guess1);
			cmbLock.turnLeft(guess2);
			cmbLock.turnRight(guess3);

			if (cmbLock.open()){
				System.out.println("Correct!");
				break;
			}
			else
				System.out.println("Sorry, that is incorrect!");
		}
	}
}

