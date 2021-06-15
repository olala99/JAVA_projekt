/* panel dolny:
 * ustawienie przycisków ON/OFF i "Kolor tła ..." */

package package_symulacja;

import java.awt.*;
import javax.swing.*;

public class AnimationControlPanel extends JPanel {
	
	JButton ONButton;
	JButton OFFButton;
	JButton buttonBGColor;
	
	public AnimationControlPanel() {
		this.setLayout(new GridLayout(4,1));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		ONButton = new JButton("ON");
		OFFButton = new JButton("OFF");
		buttonBGColor = new JButton("Kolor tła");
		
		this.add(buttonBGColor);
		this.add(ONButton);
		this.add(OFFButton);
	}
}

