/* panel dolny:
 * ustawienie przycisków ON/OFF i "Kolor tła ..." */

package package_symulacja;

import java.awt.*;
import javax.swing.*;

public class AnimationControlPanel extends JPanel {
	
	OnOffAnimationButton ONButton;
	BackgroundColorButton buttonBGColor;
	JButton OFFButton;
//	JButton moveAgainButton;
	
	public AnimationControlPanel() {
		this.setLayout(new GridLayout(4,1));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		ONButton = new OnOffAnimationButton();
		buttonBGColor = new BackgroundColorButton();
		OFFButton = new JButton("OFF");
//		moveAgainButton= new JButton("Wznów");
		
		this.add(buttonBGColor);
		this.add(ONButton);
		this.add(OFFButton);
//		this.add(moveAgainButton);
		
	}
}
