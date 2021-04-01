package package_symulacja;

import java.awt.*;
import javax.swing.*;

public class AnimationPanel extends JPanel {

	private JPanel animationPanel;
	private AnimationControlPanel animationControlPanel;
	
	public AnimationPanel() {
		this.setLayout(new BorderLayout());
		
		animationPanel = new JPanel();
		animationControlPanel = new AnimationControlPanel();
		
		animationPanel.setBackground(Color.white);
		
		this.add(animationPanel,BorderLayout.CENTER);
		this.add(animationControlPanel,BorderLayout.SOUTH);
	}
}