
/**

This class is the basis for the UI. This is where the interface gets created and adjusted for the text
that we want printed in the "Box". The text that is shown is split by stats, team, and the players name.

@author Nico Gomez
*/
//here we will import ALL of the packages needed in creating a UI.
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UIPlayer extends JFrame {
	
	private String textToShow; // this is what the text area will show
	private JTextArea stats;
	private ArrayList<Player>players;
	/**
	@author Nico Gomez
	This method is the main part of the class. It sets up the entire UI and we call it WebScraper. In it 
	is a new Border Layout object, JPanel, ContentPane, FlowLayout, JTextField, and some JButtons. This was learned 
	in class and they are all necessary in creating a little window that looks like the output of the homework assignment. 
	3 buttons are created: Fetch, Save to txt, and Save to JSON, which all pretty much do what the name of their buttons are.
	*/

	public void setupUI() {
		textToShow = "                    Name           	Team	W	L	MP	PTS	FG	RB	AST	STL	BLK	TOV";
		setTitle("Web Scraper");
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panNorth = new JPanel();
		panNorth.setLayout(new FlowLayout());
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JLabel label = new JLabel("Enter URL:");
		JTextField txtTextToAdd = new JTextField(33);
		JButton btnAddFetch = new JButton("Fetch");
		JButton btnAddSaveToText = new JButton("Save to Text");
		JButton btnAddSaveToJson = new JButton("Save to Json");
		/*
		 * the JButton when clicked will take the text in the text field and add it to
		 * textToShow. Then it will to the text area to set its text to it.
		 */
		btnAddFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String URL= txtTextToAdd.getText();
			players= ScreenScraper.PlayerScraper(URL);
			for(Player player: players) {
				 textToShow= textToShow+"\n"+player.toString();
				 stats.setText(textToShow);
			}
			
			}
		});

		/**
		This method is used for creating a button object that allows the User to save the text in the UIPlayer as a JSON file
		@author Nico Gomez
		@param ActionEvent e. This creates/constructs an action event object with keys, which will used in created a button 
		that allows us to save as a JSON file
		@return void. Returns nothing
		*/

		btnAddSaveToJson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jfc = new JFileChooser(new File(getName()));
					if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
						if (PlayerWriter.writePlayersToJSON(jfc.getSelectedFile(), players)) {
							JOptionPane.showMessageDialog(null, "Players saved!");
						} else {
							JOptionPane.showMessageDialog(null, "Players could not be saved.");
						}
					}
				} catch (Exception ex) {
					System.out.println("Could not save the text file");
				}
			}
		});

		/**
		This method has a try catch block and nested if else statements that are used when trying to save the
		text to a JSON or txt file. If there is an error we throw the ex Exception. This method implements the ActionListener object for creating a file chooser.
		@param ActionEvent e is used for creating the new file to be saved as JSON or txt.
		@return none, this is a void method.
		*/

			btnAddSaveToText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jfc = new JFileChooser(new File(getName()));
					if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
						if (PlayerWriter.writePlayersToTextFile(jfc.getSelectedFile(), players)) {
							JOptionPane.showMessageDialog(null, "Players saved!");
						} else {
							JOptionPane.showMessageDialog(null, "Players could not be saved.");
						}
					}
				} catch (Exception ex) {
					System.out.println("Could not save the text file");
				}
			}
		});

		//here we will call the setupMenu() method as well as add all of the necessary buttons for the assignment.
		//we also create a new JTextArea object for where the stats of each player will reside. This will also lead to 
		//us being able to click on the buttons we made above that allow for the saving of the text to a JSON and txt file.
		
		setupMenu();

		panNorth.add(label);
		panNorth.add(txtTextToAdd);
		panNorth.add(btnAddFetch);
		panSouth.add(btnAddSaveToText);
		panSouth.add(btnAddSaveToJson);
		stats= new JTextArea();
		stats.setEditable(false);
		c.add(stats, BorderLayout.CENTER);
		c.add(panNorth, BorderLayout.NORTH);
		c.add(panSouth, BorderLayout.SOUTH);
		

	}

	/**
	This method is just to setup the main menu and the bar above it, which 
	we can click on Help, About, or Exit. We Use JMenu for most of the object creations, with
	the exception of the JOptionPane.  In this method is also an ActionListener that is put in the "help" 
	menu object that has all of the author's names, grades, and majors
	@author Nico Gomez
	@param n/a
	@return n/a
	*/

	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miExit = new JMenuItem("Exit");
		JMenu menuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Nicolas Gomez: Junior(Computer Engineering)\nColin McClintic: Junior(Computer Engineering) \nRobert Oliver: Senior(Computer Science)");

			}
		});
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		menuHelp.add(miAbout);
		mbar.add(menuHelp);
		setJMenuBar(mbar);
	}

	public UIPlayer() {
		setupUI();
	}
	/**
	@author Nico Gomez
	@param n/a
	@return void. Returns nothing.
	This method just creates the main class that allows for the creation of the UIPlayer ( it needs to be called somwhere!)
	*/
		public static void main(String[] args) {
		UIPlayer demo = new UIPlayer();
		demo.setVisible(true);
	}
}