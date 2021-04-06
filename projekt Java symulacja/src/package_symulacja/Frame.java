/*uklad calej ramki + menu */

package package_symulacja;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame{
	
	private AbsorbentButtonsPanel absorbentButtonsPanel;
	private AnimationControlPanel animationControlPanel;
	private ThicknessSliderPanel sliderPanel;
	private AnimationPanel animationPanel;
	private JPanel northPanel;
	private JPanel rightPanel;
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
    	
    	animationControlPanel = new AnimationControlPanel();
    	northPanel = new JPanel();
    	rightPanel = new JPanel();
    	absorbentButtonsPanel = new AbsorbentButtonsPanel();
    	sliderPanel = new ThicknessSliderPanel();
    	absorbtionCoefficientPanel = new AbsorbtionCoefficientPanel();
    	animationPanel = new AnimationPanel();
    	this.add(animationPanel, BorderLayout.CENTER);
    	
    	northPanel.setLayout(new GridLayout(2,1));
    	northPanel.add(absorbentButtonsPanel);
    	northPanel.add(sliderPanel);
    	this.add(northPanel, BorderLayout.NORTH);
    	
    	rightPanel.setLayout(new GridLayout(2,1));
		rightPanel.add(absorbtionCoefficientPanel);
		rightPanel.add(animationControlPanel);
		animationPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		animationControlPanel.buttonBGColor.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Color backgroundColor = JColorChooser.showDialog(getParent(), "Wybierz kolor", Color.white);
				animationPanel.setBackground(backgroundColor);
				}		
		});
		
		this.add(rightPanel, BorderLayout.EAST);
		
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
