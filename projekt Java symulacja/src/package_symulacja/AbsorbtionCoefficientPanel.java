/* autorka: Ola
 * panel prawy boczny: 
 * etykieta "Wspolczynnik ..."
 * pole tekstowe na wspolczynnik*/

package package_symulacja;

import java.awt.*;
import javax.swing.*;

public class AbsorbtionCoefficientPanel extends JPanel {
	
	JTextField absorptionCoefficientValue;
	private JLabel coefficientValueLabel;
	public static String absorptionCoefficient;
	
	public AbsorbtionCoefficientPanel() {
		this.setLayout(new GridLayout(2,1));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		absorptionCoefficientValue = new JTextField();
		coefficientValueLabel = new JLabel();
		coefficientValueLabel.setText(Menu.resBundle.getString("coefficient_value"));
		
		this.add(coefficientValueLabel);
		this.add(absorptionCoefficientValue);
		
	}
	
	public void setText(String text) {
		this.absorptionCoefficient = text;
	}
}


