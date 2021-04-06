/* autorka: Ola
 * panel centralny:
 * panel z tlem do animacji
 * panel z przyciskami kontrolujacymi AnimationControlPanel */

package package_symulacja;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AnimationPanel extends JPanel {

	private JPanel animationPanel;

	public AnimationPanel() {
		this.setLayout(new BorderLayout());
		animationPanel = new JPanel();
		animationPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		animationPanel.setBackground(Color.white);

		this.add(animationPanel,BorderLayout.CENTER);
	}
}
