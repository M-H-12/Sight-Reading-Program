import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * @since November 24, 2020
 * @author M-H-12
 * The view for the application (WIP).
 */
public class AppView extends JFrame{

	/**
	 * The single note button.
	 */
	private JButton single;
	/**
	 * The 5 note button.
	 */
	private JButton five;
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
	
	public AppView() {
		
		super("Sight Reading!");
		single = new JButton("One Note");
		five = new JButton("Five Notes");
		quit = new JButton("Quit");
		text = new JTextArea(2,30);
		picture = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\resource\\notes.png"));
		
		text.setText("Here is the range of notes which will be tested:");
		text.setBorder(BorderFactory.createEmptyBorder());
		text.setEditable(false);
		text.setFont(new Font("Courier", Font.ITALIC, 15));
		
		setLayout(new BorderLayout());
		JPanel centre = new JPanel();
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();
		
		add("Center", centre);
		add("North", top);
		add("South", bottom);
		bottom.add(single);
		bottom.add(five);
		bottom.add(quit);
		top.add(text);
		add(picture);
		
		setSize(700,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setVisible(true);
		
	}
	
	public void singleListener(ActionListener e){
		single.addActionListener(e);
	}
	
	public void fiveListener(ActionListener e){
		five.addActionListener(e);
	}
	
	public void quitListener(ActionListener e){
		quit.addActionListener(e);
	}

	public JButton getSingle() {
		return single;
	}

	public void setSingle(JButton single) {
		this.single = single;
	}
	
	public JButton getFive() {
		return five;
	}

	public void setFive(JButton five) {
		this.five = five;
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
	
}
