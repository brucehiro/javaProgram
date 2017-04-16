package tw.edu.bio.thu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Message extends JFrame{
	private JButton send;
	private JTextArea messageWindows = new JTextArea();
	private JTextField stringSend = new JTextField(40);
	
	public static void main(String[] args) {		
		new Message();
	}
	
	Message()
	{
		setLayout(new BorderLayout());
				
		send = new JButton("Send");
		send.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				new sendMessage(stringSend.getText());
			}
		});
		
		JPanel down = new JPanel(new FlowLayout());
		down.add(stringSend); down.add(send);
		
		add(down,BorderLayout.SOUTH);
		
		JPanel left = new JPanel(new FlowLayout());
		JPanel right = new JPanel(new FlowLayout());
		JPanel top = new JPanel(new FlowLayout());
		
		add(top, BorderLayout.NORTH);
		add(right, BorderLayout.WEST);
		add(left, BorderLayout.EAST);
		add(messageWindows,BorderLayout.CENTER);
		
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
			new getMessage();

	}
	
	private class sendMessage 
	{
		private byte[] sendingBuffer;
		private String sendMessage;

		public sendMessage()
		{
			this("");
		}
		public sendMessage(String sendMessage) {
			this.sendMessage = sendMessage;
			Socket ssocket;
			OutputStream oout;
			try
			{
				sendingBuffer = sendMessage.getBytes();
				
				File file = new File("./Members/Members.txt");
				BufferedReader buf = new BufferedReader(new FileReader(file));
				String[] IP = new String[(int)(file.length()/9)+1];
				int i = 0;
				while((IP[i] = buf.readLine()) != null)
				{
					i++;
				}
				buf.close();
							
				for(int j=0; j<i; j++)
				{
					if(!IP[j].equals(null))
					{
					ssocket = new Socket(InetAddress.getByName(IP[j]),4444);
					oout = ssocket.getOutputStream();
					oout.write(sendingBuffer);
					oout.flush();					
					oout.close();
					ssocket.close();
					System.out.println("ok");
					}
				}
				stringSend.setText(null);
				System.out.println("finish");
				
			}catch(Exception e)
			{
				System.out.println(e.toString());
			}
		}		
	}
	
	private class getMessage
	{
		getMessage()
		{
			while(true)
			{
				try
				{
					ServerSocket sgsocket = new ServerSocket(4444);
					Socket ssocket = sgsocket.accept();
					BufferedReader buf = new BufferedReader(new InputStreamReader(ssocket.getInputStream()));
					String gString;
					while((gString = buf.readLine()) != null)
					{
						String hostAddress = ssocket.getInetAddress().getHostAddress();
						Calendar time = Calendar.getInstance();
						int hh = time.get(Calendar.HOUR);
						int mm = time.get(Calendar.MINUTE);
						messageWindows.append(hostAddress + ":" + gString + " (" + hh + ":" + mm + ") " +'\n');
					}
					System.out.println("ok");
					ssocket.close();
					sgsocket.close();

				}catch(Exception e)
				{
					System.out.println(e.toString());
				}
			}
		}
	}
}
