package package_symulacja;


import javax.swing.*;

import java.awt.*;


public class Frame extends JFrame{
	
	private AbsorbentButtonsPanel panel1;
	private ThicknessSliderPanel panel2;
	
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem language;
	private JMenuItem read;
	private JMenuItem save;
	private JMenuItem clean;
	
	public Frame() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setSize(600,200);
    	
    	panel1 = new AbsorbentButtonsPanel();
    	panel2 = new ThicknessSliderPanel();
    	
    	this.setLayout(new GridLayout(2,1));
    	this.add(panel1);
    	this.add(panel2);
    	
    	menuBar = new JMenuBar();
		menu = new JMenu("MENU");
		menuBar.add(menu);
		
		language = new JMenuItem("Zmien jezyk");
		read = new JMenuItem("Wczytaj");
		save = new JMenuItem("Zapisz");
		clean = new JMenuItem("Wyczysc");
		
		menu.add(language);
		menu.add(read);
		menu.add(save);
		menu.add(clean);
		
		this.setJMenuBar(menuBar);
	}
}