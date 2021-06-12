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
	private JMenuItem english;
	private JMenuItem polish;
	
	public static Locale locale_en;
	public static Locale locale_pl;
	public static ResourceBundle resBundle; 

	//String bundleName;
	
	public Menu() {
		menu = new JMenu("MENU");

		locale_en = new Locale("en");
		locale_pl = new Locale("pl");
		resBundle = ResourceBundle.getBundle("res.bundle", locale_pl);
		
		language = new JMenu(resBundle.getString("language"));
		read = new JMenuItem(resBundle.getString("read"));
		save = new JMenuItem(resBundle.getString("save"));
		clean = new JMenuItem(resBundle.getString("clean"));
		english = new JMenuItem(resBundle.getString("en"));
		polish = new JMenuItem(resBundle.getString("pl"));
		
//		ResourceBundle resBundle = ResourceBundle.getBundle("res.bundle", locale_pl);
		
		menu.add(language);
		language.add(english);
		language.add(polish);
		menu.add(read);
		menu.add(save);
		menu.add(clean);
		
		english.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("zmiana na angielski");
				resBundle.clearCache();
				resBundle.getBundle("res.bundle_en", locale_en);
				System.out.println("zmiana na angielski??????");
			}
			});
			
		
		polish.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("zmiana na polski");
				resBundle.getBundle("res.bundle");
			}
			});
		
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Zapisz jako/Save as");
				int result = fileChooser.showDialog(null, "Zapisz/Save");
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
						bufferedWriter.write("\n Grubość absorbentu (absorbent's width): " + ThicknessSliderPanel.absorbentThicknessSlider.getValue() + " cm" );
						bufferedWriter.write("\n Współczynnik osłabienia (absorption coefficient): " + Frame.absorbtionCoefficient +" 1/cm");
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
							          //Absorbent.g2.setColor(Color.black);
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



