package finalexam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


public class data {
	
	private BufferedReader in = null;
	private PrintWriter out1 = null;
	private PrintWriter out2 = null;
	private final int speedCap = 120;
	
	public data(String in, String out1, String out2) throws IOException{//file could not be created or opened
		try{
			this.in = new BufferedReader(new FileReader(in));
		}
		catch(FileNotFoundException ex){
			JOptionPane.showMessageDialog(null,in + " could not be found.");
		}
		try{
			this.out1 = new PrintWriter(new BufferedWriter(new FileWriter(out1)));
		}
		catch(FileNotFoundException ex){
			JOptionPane.showMessageDialog(null,out1 + " could not be found.");
		}
		try{
			this.out2 = new PrintWriter(new BufferedWriter(new FileWriter(out2)));
		}
		catch(FileNotFoundException ex){
			JOptionPane.showMessageDialog(null,out2 + " could not be found.");
		}
	}
	
	public void writeData() throws IOException{
		String license;
		String speedStr;
		int speed;
		while((license = in.readLine()) != null && (speedStr = in.readLine()) != null)
			try{
				speed = Integer.parseInt(speedStr);
				if(speed > speedCap){
					out2.println(license);
					out2.println(speed);
				}
				if(speed <= speedCap){
					out1.println(license);
					out1.println(speed);
				}
			}
			catch(IllegalArgumentException e){
				JOptionPane.showMessageDialog(null, license + " speed was invalid.");;
			}
			
		}
			
	
	public void closeFiles(){
		if(in != null){
			try{
				in.close();
			}
			catch(IOException e){
				JOptionPane.showMessageDialog(null, in + " could not be closed.");
				e.printStackTrace();
			}
		}
		if(out1 != null){
			try{
				out1.close();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, out1 + " could not be closed.");
				e.printStackTrace();
			}
		}
		if(out2 != null){
			try{
				out2.close();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, out2 + " could not be closed.");
				e.printStackTrace();
			}
		}
	}
}

