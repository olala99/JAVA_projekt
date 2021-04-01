package package_symulacja;

import java.awt.*;
import javax.swing.*;

public class AbsorbtionCoefficentPanel extends JPanel {
	
	private JTextField absorptionCoefficientValue;
	private JLabel coefficientValueLabel;
	
	public AbsorbtionCoefficentPanel() {
		this.setLayout(new GridLayout(9,1));
		
		absorptionCoefficientValue = new JTextField(" ");
		coefficientValueLabel = new JLabel("Wspoczynnik oslabienia promieniowania: ");
		
		this.add(coefficientValueLabel);
		this.add(absorptionCoefficientValue);
	
	}
}
