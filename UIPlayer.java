import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class UIPlayer extends JFrame {
    private String textToShow; // this is what the text area will show
    private JTextArea txaWords;  // known throughout the class
    public void setupUI() {
        textToShow = "";
        setTitle("Web Scraper");
        setBounds(100,100,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new FlowLayout());
        JPanel panSouth= new JPanel();
        panSouth.setLayout(new FlowLayout());
        JLabel label = new JLabel("Enter URL:");
        JTextField txtTextToAdd = new JTextField(29); // 30 lower-case m's
        JButton btnAddFetch = new JButton("Fetch");
        JButton btnAddSaveToText= new JButton("Save to Text");
        JButton btnAddSaveToJson= new JButton("Save to Json");
        
/* the JButton when clicked will take the text in the text field and
         * add it to textToShow. Then it will to the text area to set its 
         * text to it.
         */
        btnAddFetch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = txtTextToAdd.getText();
                textToShow = textToShow + "\n" + text;
                txaWords.setText(textToShow);
            }
        });
        btnAddSaveToJson.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        btnAddSaveToText.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        panNorth.add(label);
        panNorth.add(txtTextToAdd);
        panNorth.add(btnAddFetch);
        panSouth.add(btnAddSaveToText);
        panSouth.add(btnAddSaveToJson);
        c.add(panNorth,BorderLayout.NORTH);
        c.add(panSouth, BorderLayout.SOUTH);
        txaWords = new JTextArea();
        txaWords.setEditable(false);
        c.add(txaWords,BorderLayout.CENTER);
        
    }
    public UIPlayer() {
        setupUI();
    }
    public static void main(String[] args) {
        UIPlayer demo = new UIPlayer();
        demo.setVisible(true);
    }
}
