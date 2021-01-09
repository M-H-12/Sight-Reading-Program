import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @since November 24, 2020
 * @author M-H-12
 * Connects the view to the model.
 */
public class AppController {
	
	/**
	 * The app's GUI.
	 */
	private AppView view;
	/**
	 * The app's model.
	 */
	private AppModel model;
	
	/**
	 * Creates a new AppController object.
	 */
	public AppController() {
		
		view = new AppView(); //Creates a new AppView object.
		model = new AppModel(); //Creates a new AppModel object.
		this.view.singleListener(new AddSingleListener()); //Adds a listener for the single note button.
		this.view.fourListener(new AddFourListener()); //Adds a listener for the 5 note button.
		this.view.quitListener(new AddQuitListener()); //Adds a listener for the quit button.
		this.view.menuListener(new AddMenuListener()); //Adds a listener for the menu button.
		
	}

	/**
	 * Retrieves the view.
	 * @return the GUI of the app.
	 */
	public AppView getView() {
		return view;
	}

	/**
	 * Sets the view for the object.
	 * @param view the app's new GUI.
	 */
	public void setView(AppView view) {
		this.view = view;
	}

	/**
	 * Retrieves the model for the app.
	 * @return the model for the app.
	 */
	public AppModel getModel() {
		return model;
	}

	/**
	 * Sets the model for the app.
	 * @param model the new model for the app.
	 */
	public void setModel(AppModel model) {
		this.model = model;
	}
	
	/**
	 * Runs the program.
	 * @param args arguments from the command line (not used).
	 */
	public static void main(String[] args) {
		AppController app = new AppController(); //Creates a new AppController object

	}

	/**
	 * @since November 24, 2020
	 * @author M-H-12
	 * The listener for the single note button.
	 */
	class AddSingleListener implements ActionListener{
	
		@Override
		/**
		 * Determines if the single note button is pressed.
		 */
		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource() == view.getSingle()) {
				
				int note = model.genNumber();
				
				view.singlePane(note);
				
				
			}
			
		}
		
	}
	
	/**
	 * @since November 24, 2020
	 * @author M-H-12
	 * The listener for the four notes button.
	 */
	class AddFourListener implements ActionListener{
		
		@Override
		/**
		 * Determines if the four notes button is pressed.
		 */
		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource() == view.getFour()) {
				
				int [] notes = model.genNumbers();
				
				view.fourPane(notes);
			}
			
		}
		
	}
	
	/**
	 * @since November 24, 2020
	 * @author M-H-12
	 * The listener for the quit button.
	 */
	class AddQuitListener implements ActionListener{
			
			@Override
			/**
			 * Determines if the quit button is pressed.
			 */
			public void actionPerformed(ActionEvent e) {
		
				if(e.getSource() == view.getQuit()) view.dispose();
					
			}		
	}
	
	/**
	 * @since January 6, 2020
	 * @author M-H-12
	 * The listener for the menu button.
	 */
	class AddMenuListener implements ActionListener{
			
			@Override
			/**
			 * Changes the screen back to the main menu.
			 */
			public void actionPerformed(ActionEvent e) {
		
				if(e.getSource() == view.getMenuButton()) {
					
					view.getContentPane().removeAll();
					view.getContentPane().invalidate();
					
					view.getContentPane().add(view.getMenu());
					view.getContentPane().revalidate();
					view.getContentPane().repaint();
					
				}
					
			}		
	}

}
