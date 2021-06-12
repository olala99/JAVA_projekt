/* autorka: Alina
 * panel gorny: suwak ustawiajacy grubosc absorbentu */ 

package package_symulacja;


import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class ThicknessSliderPanel extends JPanel{
	
	public static JSlider absorbentThicknessSlider;
	private JLabel absorbentThicknessLabel;
	
	static final int SLIDER_MIN = 1; 
	static final int SLIDER_MAX = 10; 
	
	public ThicknessSliderPanel()
	{
		//absorbentThicknessLabel = new JLabel("thickness:");
		absorbentThicknessLabel = new JLabel(Menu.resBundle.getString("thickness"));
		
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
