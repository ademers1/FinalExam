/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalexam;
//Alex Demers created this program Wednesday December 10th 2014
import java.io.IOException;


public class FinalExam {

	public static void main(String[] args) throws IOException {
		final String inputFile = "speeding.txt";
		final String outputFile1 = "output1.txt";
		final String outputFile2 = "output2.txt";
		
		
		data files = new data(inputFile,outputFile1,outputFile2);
		files.writeData();
		files.closeFiles();
	}

}

