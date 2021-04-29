

/*uklad calej ramki + menu */

package package_symulacja;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Frame extends JFrame{
	
	private AbsorbentButtonsPanel absorbentButtonsPanel;
	private AnimationControlPanel animationControlPanel;
	private ThicknessSliderPanel sliderPanel;
	private AnimationPanel animationPanel;
	private JPanel northPanel;
	private JPanel rightPanel;
	private AbsorbtionCoefficientPanel absorbtionCoefficientPanel;
	private int absorbentButton;
	private Menu menuBar;
	private double absorbtionCoefficient;
	boolean running = false;
	Random rand = new Random();
	Timer timer;
	
	public Frame() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setSize(1000,600);
    	setLocationRelativeTo(null);
    	this.setLayout(new BorderLayout());
    	
    	menuBar = new Menu();
		this.setJMenuBar(menuBar);
		
    	
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
		
		absorbentButtonsPanel.buttonAl.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				absorbtionCoefficient = 0.13;
//				wspĂłĹ‚czynnik dla 1,33 MeV = 0,13 1/cm
				
			}
			
		});
		absorbentButtonsPanel.buttonCu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				absorbtionCoefficient = 0.43;
//				wspĂłĹ‚czynnik dla 1,33 MeV = 0,43 1/cm
//				N/N0 * 100 = 100 * exp(-u * d)
			}
			
		});
		absorbentButtonsPanel.buttonPb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				absorbtionCoefficient = 0.61;
//				wspĂłĹ‚czynnik dla 1,33 MeV = 0,61 1/cm
			}
			
		});
		
		animationControlPanel.buttonOnOff.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if(!running){
					for (int i = 1; i < 1001; i++) animationPanel.addEnergyParticle( -500 + rand.nextInt(500), 30+rand.nextInt(370),
							Color.black, sliderPanel.absorbentThicknessSlider.getValue(), absorbtionCoefficient);
					System.out.println(""+absorbtionCoefficient);
					animationPanel.moveParticles();	
					System.out.println(""+animationPanel.licznik);
					absorbtionCoefficientPanel.absorptionCoefficientValue.setText(" "+absorbtionCoefficient + " /cm");
				}
			
		
//				else if(running){
//					timer.stop();
//					running = false;
//				}
				}		
		});
		
		sliderPanel.absorbentThicknessSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int absorbentWidth = sliderPanel.absorbentThicknessSlider.getValue();
				animationPanel.absorbent.width = absorbentWidth * 10;
				repaint();
			}
			
		});
	
	}
}
