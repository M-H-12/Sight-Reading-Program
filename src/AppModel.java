import java.util.Random;

/**
 * @since November 24, 2020
 * @author M-H-12
 * The model for the application (WIP).
 */
public class AppModel {

	/**
	 * Generates a random number.
	 */
	private Random gen;
	
	/**
	 * Creates a new AppModel
	 */
	public AppModel(){
		
		gen = new Random();
		
	}
	
	/**
	 * Generates a random number from 0 to 15,
	 * @return the number to be generated.
	 */
	public int genNumber() {

		return gen.nextInt(16);
		
	}
	
	/**
	 * Generates 4 random numbers from 0 to 15,
	 * @return the numbers to be generated.
	 */
	public int [] genNumbers() {

		int notes[] = new int[4]; 
		for(int i = 0; i < 4; i++)
			notes[i] = gen.nextInt(16);
		
		return notes;
		
	}
	
}
