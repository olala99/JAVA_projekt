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
	static AnimationPanel animationPanel;
	private JPanel northPanel;
	private JPanel rightPanel;
	private AbsorbtionCoefficientPanel absorbtionCoefficientPanel;
	private int absorbentButton;
	private Menu menuBar;
	static double absorbtionCoefficient = 0.13;
	boolean running = false;
	Random rand = new Random();
	Timer timer;
	boolean createNewParticles = true;
	Color backgroundColor;

	
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
				backgroundColor = JColorChooser.showDialog(getParent(), "background_color", Color.white);
				animationPanel.setBackground(backgroundColor);
				}		
		});
		this.add(rightPanel, BorderLayout.EAST);
		
		absorbentButtonsPanel.buttonAl.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				absorbtionCoefficient = 0.13;
//				wsp????czynnik dla 1,33 MeV = 0,13 1/cm
				
				animationPanel.absorbent.shading = 1;
				repaint();
			}
			
		});
		absorbentButtonsPanel.buttonCu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				absorbtionCoefficient = 0.43;
//				wsp????czynnik dla 1,33 MeV = 0,43 1/cm
//				N/N0 * 100 = 100 * exp(-u * d)
				
				animationPanel.absorbent.shading = 2;
				repaint();
			}
			
		});
		absorbentButtonsPanel.buttonPb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				absorbtionCoefficient = 0.61;
//				wsp????czynnik dla 1,33 MeV = 0,61 1/cm
				
				animationPanel.absorbent.shading = 3;
				repaint();
			}
			
		});
		
					
		animationControlPanel.ONButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if(createNewParticles == true) {
					int absorbentHeight = animationPanel.absorbent.getHeight();
					for (int i = 1; i < 1001; i++) animationPanel.addEnergyParticle( -500 + rand.nextInt(500), 20 + rand.nextInt(absorbentHeight-20) ,
								Color.black, sliderPanel.absorbentThicknessSlider.getValue(), absorbtionCoefficient,  6 + rand.nextInt(6));
					animationPanel.testParticle(20 + absorbentHeight-100 , backgroundColor);
				}	
				if(!running){
				
					animationPanel.moveParticles(false);
					createNewParticles = false;
					absorbtionCoefficientPanel.absorptionCoefficientValue.setText(" "+ absorbtionCoefficient + " /cm");
					System.out.println("wsp????czynnik: " + absorbtionCoefficient);
					System.out.println("N0 = 1000, N = " + animationPanel.licznik);
					System.out.println("N teoretyczne = " + 1000*Math.exp(-absorbtionCoefficient*sliderPanel.absorbentThicknessSlider.getValue()));
					System.out.println("N0 - N = "+ (1000 - animationPanel.licznik));
					System.out.println("grubo???? absorbentu = " + sliderPanel.absorbentThicknessSlider.getValue() +" cm");
					
				}
			}		
		});
		
		
		animationControlPanel.OFFButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				animationPanel.moveParticles(true);
				createNewParticles = false;
			}		
		});

		sliderPanel.absorbentThicknessSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int absorbentWidth = sliderPanel.absorbentThicknessSlider.getValue();
				animationPanel.absorbent.width = absorbentWidth * 14;
				repaint();
			}
			
		});
	
	}
}
