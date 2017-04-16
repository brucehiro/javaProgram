package tw.edu.bio.thu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Class_Sequence extends JFrame{
	private JButton open, save, close;
	private JFileChooser fileInput = new JFileChooser();
	private JTextArea showFile = new JTextArea();
	private File file;
	private String input;
	
	Class_Sequence()
	{
		setLayout(new BorderLayout());
		
		open = new JButton("Open");
		open.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				fileInput.showOpenDialog(null);
				file = fileInput.getSelectedFile();
			
				try
				{
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
										
					while((input = br.readLine()) != null)
					{
						showFile.append(input + '\n');
					}
					
					fr.close();
									
				}
				catch(Exception ee)
				{
					System.out.println(ee.toString());
				}
							
			}			
		});
		
						
		save = new JButton("Save");
		close = new JButton("Close");
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(open); top.add(save); top.add(close);

		add(top, BorderLayout.NORTH);
		add(showFile,BorderLayout.CENTER);
	
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
}


