package package_symulacja;

import java.awt.*;
import javax.swing.*;

public class AnimationControlPanel extends JPanel {
	
	private OnOffAnimationButton buttonOnOff;
	private BackgroundColorButton buttonBGColor;
	
	public AnimationControlPanel() {
		this.setLayout(new FlowLayout());
		
		buttonOnOff = new OnOffAnimationButton();
		buttonBGColor = new BackgroundColorButton();
		
		this.add(buttonBGColor);
		this.add(buttonOnOff);
	}
}