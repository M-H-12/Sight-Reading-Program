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
	 * Generates a note from a random number (TEMPORARY, WILL BE REMOVED IN FUTURE).
	 * @return the random note.
	 */
	public String getNote() {
		
		int noteNum = genNumber();
		
		if(noteNum < 7)
			return ((char)(noteNum + 65) + "");
		else if(noteNum == 7)
			return "A (High)";
		else if(noteNum == 8)
			return "G (Low)";
		else if(noteNum == 9)
			return "G# (Low)";
		else if(noteNum == 10)
			return "F# (Low)";
		else if(noteNum == 11)
			return "A#";
		else if(noteNum == 12 || noteNum == 13)
			return (char)(55 + noteNum) + "#";
		else
			return (char)(56 + noteNum) + "#";
		
		
	}
	
}
