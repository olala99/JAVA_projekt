/* panel dolny:
 * ustawienie przycisków ON/OFF i "Kolor t³a ..." */

package package_symulacja;

import java.awt.*;
import javax.swing.*;

public class AnimationControlPanel extends JPanel {
	
	private OnOffAnimationButton buttonOnOff;
	BackgroundColorButton buttonBGColor;
	
	public AnimationControlPanel() {
		this.setLayout(new GridLayout(2,1));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		buttonOnOff = new OnOffAnimationButton();
		buttonBGColor = new BackgroundColorButton();
		
		this.add(buttonBGColor);
		this.add(buttonOnOff);
		
	}
}