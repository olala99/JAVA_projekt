package package_symulacja;




import javax.swing.*;
import java.awt.*;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class ThicknessSliderPanel extends JPanel{
	
	private JSlider absorbentThicknessSlider;
	private JLabel absorbentThicknessLabel;
	
	static final int SLIDER_MIN = 1; 
	static final int SLIDER_MAX = 10; 
	
	public ThicknessSliderPanel()
	{
		absorbentThicknessLabel = new JLabel("Grubosc plytki [mm]:");
		
		absorbentThicknessSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_MIN);
		
		absorbentThicknessSlider.setMajorTickSpacing(1);
		absorbentThicknessSlider.setMinorTickSpacing(10);
		absorbentThicknessSlider.setPaintTicks(true);
	    absorbentThicknessSlider.setPaintLabels(true);
	    
	    this.setLayout(new FlowLayout());
	    this.add(absorbentThicknessLabel);
	    this.add(absorbentThicknessSlider);
	}
}