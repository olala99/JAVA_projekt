/* panel dolny:
 * ustawienie przycisków ON/OFF i "Kolor t³a ..." */

package package_symulacja;

import java.awt.*;
import javax.swing.*;

public class AnimationControlPanel extends JPanel {
	
	private JPanel buttonsPanel;
	private OnOffAnimationButton buttonOnOff;
	BackgroundColorButton buttonBGColor;
	
	public AnimationControlPanel() {
		this.setLayout(new FlowLayout());

		buttonOnOff = new OnOffAnimationButton();
		buttonBGColor = new BackgroundColorButton();
		
		this.add(buttonBGColor);
		this.add(Box.createRigidArea(new Dimension(200, 0)));
		this.add(buttonOnOff);
	}
}