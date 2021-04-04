/*uklad calej ramki + menu */

package package_symulacja;

import javax.swing.*;

import java.awt.*;

public class Frame extends JFrame{
	
	private AbsorbentButtonsPanel absorbentButtonsPanel;
	private ThicknessSliderPanel sliderPanel;
	private AnimationPanel animationPanel;
	private JPanel northPanel;
	private AbsorbtionCoefficientPanel absorbtionCoefficientPanel;
	
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem language;
	private JMenuItem read;
	private JMenuItem save;
	private JMenuItem clean;
	
	public Frame() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setSize(800,500);
    	this.setLayout(new BorderLayout());
    	
    	northPanel = new JPanel();
    	absorbentButtonsPanel = new AbsorbentButtonsPanel();
    	sliderPanel = new ThicknessSliderPanel();
    	absorbtionCoefficientPanel = new AbsorbtionCoefficientPanel();
    	animationPanel = new AnimationPanel();
    	this.add(animationPanel, BorderLayout.CENTER);
    	
    	northPanel.setLayout(new GridLayout(2,1));
    	northPanel.add(absorbentButtonsPanel);
    	northPanel.add(sliderPanel);
    	this.add(northPanel, BorderLayout.NORTH);
    	
		this.add(absorbtionCoefficientPanel,BorderLayout.EAST);
    	
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