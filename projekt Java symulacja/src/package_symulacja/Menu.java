package package_symulacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileNotFoundException;

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
				try {
					FileWriter file = new FileWriter("C:\\Users\\Alina\\Desktop\\filename.txt");
					file.write(" Absorbent: " );
					if(AbsorbentButtonsPanel.buttonAl.isSelected() == true) {
						file.write("Al");
					}
					else if (AbsorbentButtonsPanel.buttonCu.isSelected() == true){
						file.write("Cu");
					}
					else {
						file.write("Pb");
					}
					file.write("\n Grubość absorbentu (absorbent's width): " + ThicknessSliderPanel.absorbentThicknessSlider.getValue() + " cm" );
					file.write("\n Współczynnik osłabienia (absorption coefficient): " + Frame.absorbtionCoefficient +" 1/cm");
					file.close();
				}
//				
				catch (IOException e2) {
				      System.out.println("An error occurred.");
				      e2.printStackTrace();
				}
			}
			});
		
		read.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				   try {
					      File file2 = new File("filename2.txt");
					      Scanner reader = new Scanner(file2);
					      while (reader.hasNextLine()) {
					        String data = reader.nextLine();
					        System.out.println(data);
					      }
					      reader.close();
					    } catch (FileNotFoundException e2) {
					      System.out.println("An error occurred.");
					      e2.printStackTrace();
					    }
			}
		});
	
		this.add(menu);
	}
}


