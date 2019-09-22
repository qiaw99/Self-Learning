package searcher;

import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MyFrame extends JFrame implements Display, ActionListener{
	private final JTextField textfield = new JTextField("word", 10);
	private final JButton button = new JButton("search");
	private final JTextArea textarea = new JTextArea(20, 30);
	private Searcher searcher = SearcherFactory.createSearcher();
	private final static String NEWLINE = System.getProperty("line.separator");
	// https://blog.csdn.net/BrotherDong90/article/details/49073941
	
	public MyFrame() {
		super("Active Object Sample");
		getContentPane().setLayout(new BorderLayout());
		
		//North
		JPanel north = new JPanel();
		north.add(new JLabel("search:"));
		north.add(textfield);
		north.add(button);
		button.addActionListener(this);
		
		//Center
		JScrollPane center = new JScrollPane(textarea);
		
		//Layout
		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(center, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}	
	
	public void actionPerformed(ActionEvent e) {
		searchWord(textfield.getText());
	}
	
	private void println(String line) {
		textarea.append(line + NEWLINE);
	}
	
	private void searchWord(String word) {
		searcher.search(word, this);
		println("Searching " + word + "...");
	}
	
	public void display(final String line) {
		SwingUtilities.invokeLater(
			new Runnable() {
				public void run() {
					MyFrame.this.println(line);
				}
			}
		);
	}
}
