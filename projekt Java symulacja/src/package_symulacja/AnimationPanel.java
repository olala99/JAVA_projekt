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
	private AnimationControlPanel animationControlPanel;
	private JPanel centerPanel;
	
	public AnimationPanel() {
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		centerPanel = new JPanel();
		animationPanel = new JPanel();
		animationControlPanel = new AnimationControlPanel();
		animationPanel.setBackground(Color.white);
		
		animationControlPanel.buttonBGColor.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Color backgroundColor = JColorChooser.showDialog(getParent(), "Wybierz kolor", Color.white);
				animationPanel.setBackground(backgroundColor);	
			}
			
		});
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(animationPanel,BorderLayout.CENTER);
		centerPanel.add(animationControlPanel, BorderLayout.SOUTH);
		this.add(centerPanel,BorderLayout.CENTER);
	}
}
