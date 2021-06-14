package package_symulacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Menu extends JMenuBar {
	
	private JMenu menu;
	private JMenu language;
	private JMenuItem read;
	private JMenuItem save;
	private JMenuItem clean;

	
	public Menu() {
		menu = new JMenu("MENU");
		
		read = new JMenuItem("Wczytaj");
		save = new JMenuItem("Zapisz");
// 		clean = new JMenuItem("Wyczyść");
		
		menu.add(read);
		menu.add(save);
// 		menu.add(clean);
		
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Zapisz jako");
				int result = fileChooser.showDialog(null, "Zapisz");
				FileOutputStream outputStream = null;

				if (JFileChooser.APPROVE_OPTION == result) {
					if (result != JFileChooser.APPROVE_OPTION) {
						return;
					}
					try {
						File file = fileChooser.getSelectedFile();
						String fileName = fileChooser.getSelectedFile().getAbsolutePath();
						if (!fileName.endsWith(".txt")) {
							fileName += ".txt";
							file = new File(fileName);
						}
						outputStream = new FileOutputStream(file.getAbsolutePath()); 
						OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream, Charset.forName("UTF-8").newEncoder()); 
						BufferedWriter bufferedWriter = new BufferedWriter(streamWriter); 
						bufferedWriter.write(" Absorbent: ");
						
						if(AbsorbentButtonsPanel.buttonAl.isSelected() == true) {
							bufferedWriter.write("Al");
						}
						else if (AbsorbentButtonsPanel.buttonCu.isSelected() == true){
							bufferedWriter.write("Cu");
						}
						else {
							bufferedWriter.write("Pb");
						}
						bufferedWriter.write("\n Grubość absorbentu: " + ThicknessSliderPanel.absorbentThicknessSlider.getValue() + " cm" );
						bufferedWriter.write("\n Współczynnik osłabienia: " + Frame.absorbtionCoefficient +" 1/cm");
						bufferedWriter.close();
					}
					catch(IOException ex){
						   System.out.println("An error occurred.");
						}
					try {
						outputStream.close(); 
					} 
					catch (IOException e1) {
					   e1.printStackTrace();
					}
				}
			}
		});
					
		
		read.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				   try {
					   	  JFileChooser fileChooser = new JFileChooser();
					   	  int returnVal = fileChooser.showOpenDialog(getParent());
					   	if (returnVal == JFileChooser.APPROVE_OPTION) {
						       File file = fileChooser.getSelectedFile();
						       System.out.println("Selected file: " + file.getAbsolutePath());
						       
						       Scanner reader = new Scanner(file);
						       
						       while(reader.hasNext()) {
							    	  String[] tokens = reader.nextLine().split(";");
							          String first = tokens[0];
							          String second = tokens[1];
							          System.out.println("Grubość absorbentu: " + first);
							          System.out.println("Współczynnik: " + second);
							          int thickness = Integer.parseInt(first);
							          double coefficient =  Double.parseDouble(second);
							          ThicknessSliderPanel.absorbentThicknessSlider.setValue(thickness);
							          Frame.absorbtionCoefficient = coefficient;
							      }
						       reader.close();
						   }
					   	  
					    } 
				   	catch (FileNotFoundException e2) {
					      System.out.println("An error occurred.");
					      e2.printStackTrace();
					    }
			}
		});
	
		this.add(menu);
	}
}



