package report;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CSVReport implements Report {


private static final String PATH = "medications.csv" ;
	
	public void generateReport(List<List<String>> list) {
		String csvFile = PATH;
		try {
	        FileWriter writer = new FileWriter(csvFile);
	        CSVOperations.writeLine(writer, Arrays.asList("Id", "Name", "Ingredients", "Manufacturer", "Price", "Quantity"));
	        for(List<String> data: list) { 
	            CSVOperations.writeLine(writer, data, '|');
	        }
	
	        writer.flush();
	        writer.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), "Error in writing the csv file");
			System.out.println(e.getMessage());
		}
	}
	
	
}
