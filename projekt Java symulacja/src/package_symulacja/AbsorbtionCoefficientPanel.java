/* panel prawy boczny: 
 * etykieta "Wspolczynnik ..."
 * pole tekstowe na wspolczynnik*/

package package_symulacja;

import java.awt.*;
import javax.swing.*;

public class AbsorbtionCoefficientPanel extends JPanel {
	
	private JTextField absorptionCoefficientValue;
	private JLabel coefficientValueLabel;
	
	public AbsorbtionCoefficientPanel() {
		this.setLayout(new GridLayout(2,1));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		absorptionCoefficientValue = new JTextField(" ");
		coefficientValueLabel = new JLabel("Wspoczynnik oslabienia \n promieniowania:");
		
		this.add(coefficientValueLabel);
		this.add(absorptionCoefficientValue);
		
	}
}

