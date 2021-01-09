import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @since November 24, 2020
 * @author M-H-12
 * The view for the application (WIP).
 */
@SuppressWarnings("serial")
public class AppView extends JFrame{

	/**
	 * The single note button.
	 */
	private JButton single;
	/**
	 * The 4 note button.
	 */
	private JButton four;
	/**
	 * The quit button.
	 */
	private JButton quit;
	/**
	 * The main menu text
	 */
	private JTextArea text;
	/**
	 * The picture showing all of the notes which might be tested.
	 */
	private JLabel picture;
	
	/**
	 * The button to return to the menu.
	 */
	private JButton menuButton;
	
	/**
	 * The menu panel.
	 */	
	private JPanel menu;
	
	/**
	 * The timer for the countdown.
	 */
	private Timer timer;
	
	/**
	 * The timer value
	 */
	private int value;
	
	/**
	 * Constructor.
	 */
	public AppView() {
		
		super("Sight Reading!");
		single = new JButton("One Note");
		four = new JButton("Four Notes");
		quit = new JButton("Quit");
		menuButton = new JButton("Return to menu");
		text = new JTextArea(2,30);
		picture = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\resource\\notes.png"));
		
		text.setText("Here is the range of notes which will be tested:");
		text.setBorder(BorderFactory.createEmptyBorder());
		text.setEditable(false);
		text.setFont(new Font("Courier", Font.ITALIC, 15));
		
		menu = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//Sets Text.
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		
		menu.add(text,c);
		
		//Sets Image.
		c.gridy = 1;
		
		menu.add(picture, c);
		
		//Sets single note button.
		c.gridy = 2;
		c.gridwidth = 1;
		c.weightx = 0.5;
		
		menu.add(single, c);
		
		//Sets 5 note button.
		c.gridx = 1;
		
		menu.add(four, c);
		
		//Sets quit button.
		c.gridx = 2;
		
		menu.add(quit, c);

		add(menu);
		
		setSize(900,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setVisible(true);
		
	}
	
	/**
	 * Displays the note to be tested with a countdown.
	 * @param note the note to be displayed.
	 */
	public void singlePane(int note) {
		
		value = 5;
		
		JPanel singleFirst = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel image = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\resource\\" + note + ".jpg"));
		JTextArea count = new JTextArea(1,1);
		
		count.setBorder(BorderFactory.createEmptyBorder());
		count.setEditable(false);
		count.setFont(new Font("Courier", Font.BOLD, 100));
		count.setText("" + value);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 3;
		c.gridwidth = 2;
		
		singleFirst.add(image,c);
		
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		
		singleFirst.add(count, c);
		
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(singleFirst);
		getContentPane().revalidate();
		super.update(this.getGraphics());
			
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subValue();
				count.setText("" + value);
				
				if(value == 0) {
					timer.stop();
				count.setText("0");
				singlePaneCheck(note);
				}
			}

		});
			
		timer.start();
		
	}
	
	/**
	 * Decreases the timer value by 1.
	 */
	private void subValue() {value--;}
	
	/**
	 * Displays correct notes.
	 * @param note the note to be displayed.
	 */
	public void singlePaneCheck(int note) {
		
		JPanel singleSecond = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JTextArea finish = new JTextArea(1,50);
		
		finish.setBorder(BorderFactory.createEmptyBorder());
		finish.setEditable(false);
		finish.setFont(new Font("Courier", Font.BOLD, 30));
		finish.setText("(WIP) The note was: note #" + note);

		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 3;
		
		singleSecond.add(finish, c);
		
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		
		singleSecond.add(menuButton, c);
		
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(singleSecond);
		getContentPane().revalidate();
		getContentPane().repaint();
		value = 5;
		
	}
	
	/**
	 * Displays 4 notes to be tested, along with a 10 second countdown timer.
	 * @param notes the notes to be displayed.
	 */
	public void fourPane(int [] notes) {
		
		value = 10;
		
		JPanel singleFirst = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel imageOne = new JLabel(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\resource\\" + notes[0] + ".jpg").getImage().getScaledInstance(200, 190, Image.SCALE_DEFAULT)));
		JLabel imageTwo = new JLabel(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\resource\\" + notes[1] + ".jpg").getImage().getScaledInstance(200, 190, Image.SCALE_DEFAULT)));
		JLabel imageThree = new JLabel(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\resource\\" + notes[2] + ".jpg").getImage().getScaledInstance(200, 190, Image.SCALE_DEFAULT)));
		JLabel imageFour = new JLabel(new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "\\resource\\" + notes[3] + ".jpg").getImage().getScaledInstance(200, 190, Image.SCALE_DEFAULT)));
		JTextArea count = new JTextArea(1,1);
		
		count.setBorder(BorderFactory.createEmptyBorder());
		count.setEditable(false);
		count.setFont(new Font("Courier", Font.BOLD, 100));
		count.setText("" + value);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		
		singleFirst.add(imageOne,c);
		
		c.gridwidth = 5;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		
		singleFirst.add(imageTwo,c);
		
		c.gridwidth = 5;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		
		singleFirst.add(imageThree,c);
		
		c.gridwidth = 5;
		c.weightx = 0.5;
		c.gridx = 3;
		
		singleFirst.add(imageFour,c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 2;
		
		singleFirst.add(count, c);
		
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(singleFirst);
		getContentPane().revalidate();
		super.update(this.getGraphics());
			
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subValue();
				count.setText("" + value);
				
				if(value == 0) {
					timer.stop();
				count.setText("0");
				fourPaneCheck(notes);
				}
			}

		});
			
		timer.start();
		
	}
	
	/**
	 * Check to see if the notes were played correctly. (WIP)
	 * @param notes the notes to be checked.
	 */
	public void fourPaneCheck(int [] notes) {
		
		JPanel fiveSecond = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JTextArea finish = new JTextArea(1,50);
		
		finish.setBorder(BorderFactory.createEmptyBorder());
		finish.setEditable(false);
		finish.setFont(new Font("Courier", Font.BOLD, 30));
		finish.setText("(WIP) The notes were: note #" + notes[0] + ", #" + notes[1] + ", #" + notes[2] + ", #" + notes[3]);

		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 3;
		
		fiveSecond.add(finish, c);
		
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		
		fiveSecond.add(menuButton, c);
		
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(fiveSecond);
		getContentPane().revalidate();
		getContentPane().repaint();
		value = 10;
		
	}
	
	public void singleListener(ActionListener e){
		single.addActionListener(e);
	}
	
	public void fourListener(ActionListener e){
		four.addActionListener(e);
	}
	
	public void quitListener(ActionListener e){
		quit.addActionListener(e);
	}
	
	public void menuListener(ActionListener e) {
		menuButton.addActionListener(e);
		
	}

	public JButton getSingle() {
		return single;
	}

	public void setSingle(JButton single) {
		this.single = single;
	}
	
	public JButton getFour() {
		return four;
	}

	public void setFour(JButton four) {
		this.four = four;
	}
	
	public JButton getQuit() {
		return quit;
	}

	public void setQuit(JButton quit) {
		this.quit = quit;
	}

	public JTextArea getText() {
		return text;
	}

	public void setText(JTextArea text) {
		this.text = text;
	}

	public JLabel getPicture() {
		return picture;
	}

	public void setPicture(JLabel picture) {
		this.picture = picture;
	}

	public JButton getMenuButton() {
		return menuButton;
	}

	public JPanel getMenu() {
		return menu;
	}

	
}
