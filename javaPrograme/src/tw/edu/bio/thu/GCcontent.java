package tw.edu.bio.thu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class GCcontent extends JFrame{
	private JButton open, save, exit;
	private JFileChooser filechooser = new JFileChooser();
	private JTextArea showfile = new JTextArea();
	private File file;
	private GCanalysis simple;
	
	GCcontent()
	{
		setLayout(new BorderLayout());
		
		open = new JButton("open");
		open.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				filechooser.showOpenDialog(null);
				file = filechooser.getSelectedFile();
				simple = new GCanalysis(file);
			}
		});
		save = new JButton("save");
		exit = new JButton("exit");
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(open); top.add(save); top.add(exit);
		
		
		add(top, BorderLayout.NORTH);
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
class GCanalysis
{
	private byte[] buf;
	private List[] list;
	
	GCanalysis(File file)
	{
		try
		{
			FileInputStream inputFile = new FileInputStream(file);
			buf = new byte[(int)file.length()];
			int len = inputFile.read(buf);
			
			
			inputFile.close();
		}
		catch (FileNotFoundException ee)
		{
			System.out.println(ee.toString());
		}
		catch (IOException ee)
		{
			System.out.println(ee.toString());
		}
		
		GCdistribute(buf);
		
	}
	
	void GCdistribute(byte[] seqToByte)
	{
		for(int i = 0; i < seqToByte.length; i++)
		{
			System.out.printf("%d ",seqToByte[i]);
		}
	}
	
}

class List
{
	private int posi;
	private byte value;
}
	
	public static void main(String[] args)
	{
		GCcontent g1 = new GCcontent();
	}
	
	
}
