/* autorka: Ola
 * panel centralny:
 * panel z tlem do animacji + absorbent
 * panel z przyciskami kontrolujacymi AnimationControlPanel */

package package_symulacja;

import java.awt.*;
import javax.swing.*;

public class AnimationPanel extends JPanel {

	JPanel animationPanel;
	Absorbent absorbent;

	public AnimationPanel() {
		this.setLayout(new BorderLayout());
		animationPanel = new JPanel();
		animationPanel.setLayout(new BorderLayout());
		animationPanel.setBackground(Color.white);
		
		absorbent = new Absorbent();
		animationPanel.add(absorbent);

		this.add(animationPanel,BorderLayout.CENTER);
	}
}
