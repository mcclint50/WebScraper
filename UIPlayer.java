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

	public static void main(String[] args) {
		UIPlayer demo = new UIPlayer();
		demo.setVisible(true);
	}
}
